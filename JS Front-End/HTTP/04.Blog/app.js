function attachEvents() {
 const BASE_URL = 'http://localhost:3030/jsonstore/blog/posts/';
 const Comments_URL = 'http://localhost:3030/jsonstore/blog/comments/';
 const btnLoadPosts = document.getElementById('btnLoadPosts');
 const posts = document.getElementById('posts');
 const btnViewPost = document.getElementById('btnViewPost');
 const postTitle = document.getElementById('post-title');
 const postBody = document.getElementById('post-body');
 const postComments = document.getElementById('post-comments');

 let post = {};

 btnLoadPosts.addEventListener('click', postHandler)
 btnViewPost.addEventListener('click',commentsHandler)

 async function postHandler(){
    const res = await fetch(BASE_URL);
    const data = await res.json();
  
    const values = Object.values(data);
  
    for (let index = 0; index < values.length; index++) {
        const arr = values[index];
        let option = document.createElement('option');
        option.value = arr.id;
        const title = arr.title;
        option.textContent = arr.title;
        post[title] = { postId: arr.id, content: arr.body };
        posts.appendChild(option);
        
    }

 
 }
 async function commentsHandler(){
    const resComments = await fetch(Comments_URL);
    const dataComments = await resComments.json();

    const optionInfo = posts.options[posts.selectedIndex];
  

    postTitle.textContent = optionInfo.textContent;
    postBody.textContent = post[optionInfo.text].content;

      for (const key in dataComments) {
        if (dataComments[key].postId === post[optionInfo.text].postId ) {
        const li = document.createElement('li');
        li.textContent = dataComments[key].text;
        postComments.appendChild(li);
        
        }
      }
 }
}
attachEvents();