function addItem() {
    const item = document.getElementById('items');
    const text = document.getElementById('newItemText').value;

    let newLi = document.createElement('li');
    newLi.textContent = text;
    item.appendChild(newLi);
    text.value = '';

    const anchor = document.createElement('a');
    anchor.textContent = '[Delete]';
    anchor.addEventListener('click',deleteAnchor)
    anchor.href = "#";
    newLi.appendChild(anchor);
   

    function deleteAnchor(e){
        let aTag = e.currentTarget;
        aTag.parentElement.remove();
    }

}