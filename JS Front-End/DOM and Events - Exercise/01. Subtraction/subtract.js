function subtract() {
    const first = document.getElementById('firstNumber').value;
    const second = document.getElementById('secondNumber').value;
    const result = document.getElementById('result');

    let sub = Number(first) - Number(second);

    result.textContent = sub;





}