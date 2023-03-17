function calc() {
    const first = document.getElementById('num1');
    const second = document.getElementById('num2');
    const sumInput = document.getElementById('sum');

    let firstNum = Number(first.value);
    let secondNum = Number(second.value);

    let sum = firstNum + secondNum;

    sumInput.value = sum;


}

