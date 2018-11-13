(function () {
	document.getElementById("logout").addEventListener("click",()=>{
		axios({
			method: 'POST',
			url: 'Logout'
		})
	})
})();
