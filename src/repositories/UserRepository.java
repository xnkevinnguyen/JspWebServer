package repositories;
/*
 * Credit https://github.com/iluwatar/java-design-patterns/tree/master/unit-of-work
 * Started looking into the unit of work design pattern, really cool but is not asked for this 
 * assignment ...
 *
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.UserDatabase;
import model.UserModel;
import uow.IUnitOfWork;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * {@link StudentRepository} Student database repository.
 * supports unit of work for student data.
 */
public class UserRepository implements IUnitOfWork<UserModel> {
  private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

  private Map<String, List<UserModel>> context;
  private UserDatabase userDatabase;

  /**
   * @param context         set of operations to be perform during commit.
   * @param studentDatabase Database for student records.
   */
  public UserRepository(Map<String, List<UserModel>> context, UserDatabase userDatabase) {
    this.context = context;
    this.userDatabase = userDatabase;
  }

  @Override
  public void registerNew(UserModel user) {
    LOGGER.info("Registering {} for insert in context.", user.getFirst_name());
    register(user, IUnitOfWork.INSERT);
  }

  @Override
  public void registerModified(UserModel user) {
    LOGGER.info("Registering {} for modify in context.", user.getFirst_name());
    register(user, IUnitOfWork.MODIFY);

  }

  @Override
  public void registerDeleted(UserModel user) {
    LOGGER.info("Registering {} for delete in context.", user.getFirst_name());
    register(user, IUnitOfWork.DELETE);
  }

  private void register(UserModel user, String operation) {
    List<UserModel> userToOperate = context.get(operation);
    if (userToOperate == null) {
    	userToOperate = new ArrayList<>();
    }
    userToOperate.add(user);
    context.put(operation, userToOperate);
  }

  /**
   * All UnitOfWork operations are batched and executed together on commit only.
   */
  @Override
  public void commit() {
    if (context == null || context.size() == 0) {
      return;
    }
    LOGGER.info("Commit started");
    if (context.containsKey(IUnitOfWork.INSERT)) {
      commitInsert();
    }

    if (context.containsKey(IUnitOfWork.MODIFY)) {
      commitModify();
    }
    if (context.containsKey(IUnitOfWork.DELETE)) {
      commitDelete();
    }
    LOGGER.info("Commit finished.");
  }

  private void commitInsert() {
    List<UserModel> userToBeInserted = context.get(IUnitOfWork.INSERT);
    for (UserModel user : userToBeInserted) {
      LOGGER.info("Saving {} to database.", user.getFirst_name());
//      userDatabase.insert(user);
    }
  }

  private void commitModify() {
    List<UserModel> modifiedUsers = context.get(IUnitOfWork.MODIFY);
    for (UserModel user : modifiedUsers) {
      LOGGER.info("Modifying {} to database.", user.getFirst_name());
//      userDatabase.modify(user);
    }
  }

  private void commitDelete() {
    List<UserModel> deletedUsers = context.get(IUnitOfWork.DELETE);
    for (UserModel user : deletedUsers) {
      LOGGER.info("Deleting {} to database.", user.getFirst_name());
//      userDatabase.delete(user);
    }
  }
}
