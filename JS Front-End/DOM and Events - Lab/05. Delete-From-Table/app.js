function deleteByEmail() {
    const input = document.querySelector('input[name="email"]').value;
    const result = document.getElementById('result');
    const email = Array.from(document.querySelectorAll('td:nth-child(even)'));

    // let inputValue = input.value;

    let foundElement = email.find((f) => f.textContent === input);

    if (foundElement){
        foundElement.parentElement.remove();
        result.textContent = 'Deleted.';
    }else{
        result.textContent = 'Not found.';
    }


}