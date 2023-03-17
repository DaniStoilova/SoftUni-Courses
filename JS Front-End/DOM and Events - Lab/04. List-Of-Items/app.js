function addItem() {
    const item = document.getElementById('items');
    const text = document.getElementById('newItemText').value;
    let newLi = document.createElement('li');
    newLi.textContent = text;
    item.appendChild(newLi);
    text.value = '';

}