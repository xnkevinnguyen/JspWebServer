(function () {
	axios({
	  url: 'ListPlayers',
	}).then((res)=>{
		let root = document.getElementById("root");
		
		let container = document.createElement("div");
		container.style.display = "flex";
		container.style.alignItems = "center";
		container.style.justifyContent = "center";
		container.style.flexDirection = "column";
		
		let spacer = document.createElement("div");
		spacer.style.height = "100px";
		spacer.style.width = "100vw"
		res.data.map((player)=>{
			
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
			
			playerName.innerHTML = player.username;
			playerEmail.innerHTML = player.email;
			
			playerDetails.appendChild(NameTitle);
			playerDetails.appendChild(playerName);
			playerDetails.appendChild(EmailTitle);
			playerDetails.appendChild(playerEmail);
			
			
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
			
			let challengeButton = document.createElement("button");
			challengeButton.addEventListener("click",()=>{
				challengeTap(player);
			})
			challengeButton.innerHTML = "Challenge"
			
			playerOptions.appendChild(optionTitle);
			playerOptions.appendChild(challengeButton);
			
			
			
			
			playerContainer.appendChild(playerDetails);
			playerContainer.appendChild(playerOptions);
		
			container.appendChild(playerContainer);
			
		})
		root.appendChild(spacer);
		root.appendChild(container);
	}).catch((err)=>{
		console.log(err)
	});

	const challengeTap = (player) => {
		axios({
			method: 'post',
			url: 'ChallengePlayer',
			data: {
				challengeeId: player.user_id
			}
		}).then((res)=>{
			
			alert(`success :${res.data.success}, ${res.data.message}`)
		}).catch((err)=>{
			console.log(err)
		})
	}
})();
