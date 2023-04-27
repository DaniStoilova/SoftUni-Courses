function loadRepos() {
   const URL = 'https://api.github.com/users/testnakov/repos';
   const div = document.getElementById('res');
   fetch(URL,{ method:'GET'})
   .then((res)=> res.json())
   .then((data)=>{
      div.textContent = data;
      console.log(data[0]);
   }
   )
   .catch((err) => {
      console.error(Error);
   });
}