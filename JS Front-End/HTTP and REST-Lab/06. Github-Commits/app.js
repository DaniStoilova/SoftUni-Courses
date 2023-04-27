function loadCommits() {
    const URL = 'https://api.github.com/repos/';
    const username = document.getElementById('username');
    const repo = document.getElementById('repo');
    const commits = document.getElementById('commits');
    let usernameV = username.value;
    let repoV = repo.value;
    fetch(`${URL}${usernameV}/${repoV}/commits`)
    .then((res)=>res.json())
    .then((data)=>{
        data.forEach(({commit}) => {
            const li = document.createElement('li');
            li.textContent = `${commit.author.name}:${commit.message}`;
            commits.appendChild(li);
            
        });
    })
    .catch((err)=>{
        console.log(err);
    })


    console.log('TODO...');
}