function addItem() {
    const select = document.getElementById('menu');
    const itemText = document.getElementById('newItemText');
    const itemValue = document.getElementById('newItemValue');

    const option = document.createElement('option');

    let itemTextContent = itemText.value;
    let itemV = itemValue.value;
    
    option.textContent = itemTextContent;
    option.value= itemV;
    select.appendChild(option);

    itemText.value = '';
    itemValue.value = '';

}