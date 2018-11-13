(function () {
	axios({
	  url: 'ListGames',
	}).then((res)=>{
		console.log(res);
		let root = document.getElementById("root");
		
		let container = document.createElement("div");
		container.style.display = "flex";
		container.style.alignItems = "center";
		container.style.justifyContent = "center";
		container.style.flexDirection = "column";
		
		let spacer = document.createElement("div");
		spacer.style.height = "100px";
		spacer.style.width = "100vw"
		res.data.map((game)=>{
			
			let playerContainer = document.createElement("div");
			
			playerContainer.style.display = "flex";
			playerContainer.style.alignItems = "center";
			playerContainer.style.justifyContent = "center";
			playerContainer.style.flexDirection = "row";
			playerContainer.style.width = "80vw";
			playerContainer.style.boxShadow = "0 0 3px";
			playerContainer.style.margin = "20px";
			playerContainer.style.borderRadius = "3px";
			playerContainer.style.padding = "10px";
			
			
			let playerDetails = document.createElement("div");
			
			playerDetails.style.display = "flex";
			playerDetails.style.alignItems = "center";
			playerDetails.style.justifyContent = "center";
			playerDetails.style.flexDirection = "column";
			playerDetails.style.padding = "10px";
		
			let NameTitle = document.createElement("span");
			NameTitle.style.fontFamily = 'Montserrat';
			NameTitle.style.fontSize = "18px";
			NameTitle.style.margin = '10px';
			NameTitle.style.fontWeight = 'bold';
			NameTitle.innerHTML = "Player Name"
			
			let playerName = document.createElement("span");
			playerName.style.fontFamily = 'Montserrat'
			playerName.style.fontFamily = 'Montserrat'
				
			let EmailTitle = document.createElement("span");
			EmailTitle.style.fontFamily = 'Montserrat';
			EmailTitle.style.fontSize = "18px";
			EmailTitle.style.margin = '10px';
			EmailTitle.style.fontWeight = 'bold';
			EmailTitle.innerHTML = "Player Email"
				
				
				
			let playerEmail = document.createElement("span");
			
			
//			playerName.innerHTML = player.username;
//			playerEmail.innerHTML = player.email;
			
			playerDetails.appendChild(NameTitle);
			playerDetails.appendChild(playerName);
			playerDetails.appendChild(EmailTitle);
			playerDetails.appendChild(playerEmail);
			
				
			let GameDetails = document.createElement("div");
			
			GameDetails.style.display = "flex";
			GameDetails.style.alignItems = "center";
			GameDetails.style.justifyContent = "center";
			GameDetails.style.flexDirection = "column";
			GameDetails.style.padding = "10px";
			
			let GameTitle = document.createElement("span");
			GameTitle.style.fontFamily = 'Montserrat';
			GameTitle.style.fontSize = "18px";
			GameTitle.style.margin = '10px';
			GameTitle.style.fontWeight = 'bold';
			GameTitle.innerHTML = "Game ID"
			
			let ChallengerDeckTitle = document.createElement("span");
			ChallengerDeckTitle.style.fontFamily = 'Montserrat';
			ChallengerDeckTitle.style.fontSize = "18px";
			ChallengerDeckTitle.style.margin = '10px';
			ChallengerDeckTitle.style.fontWeight = 'bold';
			ChallengerDeckTitle.innerHTML = "Challenger Deck ID"
				
			let ChallengeeDeckTitle = document.createElement("span");
			ChallengeeDeckTitle.style.fontFamily = 'Montserrat';
			ChallengeeDeckTitle.style.fontSize = "18px";
			ChallengeeDeckTitle.style.margin = '10px';
			ChallengeeDeckTitle.style.fontWeight = 'bold';
			ChallengeeDeckTitle.innerHTML = "Challengee Deck ID"
				
			let GameID = document.createElement("span");
			GameID.style.fontFamily = 'Montserrat'
			GameID.style.fontFamily = 'Montserrat'
			GameID.innerHTML = game.game_id;
			
			let GameChallengerDeckID = document.createElement("span");
			GameChallengerDeckID.style.fontFamily = 'Montserrat'
			GameChallengerDeckID.style.fontFamily = 'Montserrat'
			GameChallengerDeckID.innerHTML = game.challenger_deck_id;
			
			let GameChallengeeDeckID = document.createElement("span");
			GameChallengeeDeckID.style.fontFamily = 'Montserrat'
			GameChallengeeDeckID.style.fontFamily = 'Montserrat'
			GameChallengeeDeckID.innerHTML = game.challengee_deck_id;
			
				
			GameDetails.appendChild(GameTitle);
			GameDetails.appendChild(GameID);
			GameDetails.appendChild(ChallengerDeckTitle);
			GameDetails.appendChild(GameChallengerDeckID);
			GameDetails.appendChild(ChallengeeDeckTitle);
			GameDetails.appendChild(GameChallengeeDeckID);
			
			
			let playerOptions = document.createElement("div");
			
			playerOptions.style.display = "flex";
			playerOptions.style.alignItems = "center";
			playerOptions.style.justifyContent = "center";
			playerOptions.style.flexDirection = "column";
			playerOptions.style.padding = "10px";
			
			let optionTitle = document.createElement("span");
			optionTitle.style.fontFamily = 'Montserrat';
			optionTitle.style.fontSize = "18px";
			optionTitle.style.margin = '10px';
			optionTitle.style.fontWeight = 'bold';
			optionTitle.innerHTML = "Options"
			
			
			playerOptions.appendChild(optionTitle);
			
			// if currently logged in user is challenger
			let WithdrawChallengeButton = document.createElement("button");
			let WaitingOnChallengee = document.createElement("span");
			// if currently logged in user is challengee
			let AcceptChallengeButton = document.createElement("button");
			let RefuseChallengeButton = document.createElement("button");
				
			axios({
				method: 'post',
				url: 'playerDetailsPC',
				data : {
					deck_id: game.challenger_deck_id
				}
			}).then((res)=>{
				if(res.data.currentlyLoggedIn){
					WithdrawChallengeButton.innerHTML = "Withdraw Challenge"
					WaitingOnChallengee.innerHTML = 'waiting on challengee to respond'
					WithdrawChallengeButton.addEventListener("click",()=>{
						withdrawChallengeTap(game.challenge_id);
					});
					playerOptions.appendChild(WithdrawChallengeButton);
					playerOptions.appendChild(WaitingOnChallengee);
					
				}
				console.log(res)
				axios({
					method: 'post',
					url: 'playerDetailsPC',
					data : {
						deck_id: game.challengee_deck_id
					}
				}).then((res)=>{
					if(res.data.currentlyLoggedIn){
						AcceptChallengeButton.innerHTML = "Accept Challenge"
						AcceptChallengeButton.addEventListener("click",()=>{
							acceptChallengeTap();
						});
						RefuseChallengeButton.innerHTML = "Refuse Challenge"
						RefuseChallengeButton.addEventListener("click",()=>{
							refuseChallengeTap();
						});
						playerOptions.appendChild(AcceptChallengeButton);
						playerOptions.appendChild(RefuseChallengeButton);
					}
					
				}).catch((err)=>{
					console.log(err)
				});
			}).catch((err)=>{
				console.log(err)
			});
			
			
			
			playerContainer.appendChild(GameDetails);
			playerContainer.appendChild(playerDetails);
			playerContainer.appendChild(playerOptions);
		
			container.appendChild(playerContainer);
			
		})
		root.appendChild(spacer);
		root.appendChild(container);
	}).catch((err)=>{
		console.log(err)
	});

	const withdrawChallengeTap = (challenge_id) => {
		axios({
			method: 'post',
			url: 'WithdrawChallenge',
			data: {
				challengeId: challenge_id
			}
		}).then((res)=>{
			alert(`success :${res.data.success}, ${res.data.message}`)
		}).catch((err)=>{
			console.log(err)
		})
	}
	
	const acceptChallengeTap = (challenge_id) => {
		axios({
			method: 'post',
			url: 'AcceptChallenge',
			data: {
				challengeId: challenge_id
			}
		}).then((res)=>{
			alert(`success :${res.data.success}, ${res.data.message}`)
		}).catch((err)=>{
			console.log(err)
		})
	}
	
	const refuseChallengeTap = (challenge_id) => {
		axios({
			method: 'post',
			url: 'RefuseChallenge',
			data: {
				challengeId: challenge_id
			}
		}).then((res)=>{
			alert(`success :${res.data.success}, ${res.data.message}`)
		}).catch((err)=>{
			console.log(err)
		})
	}
})();
