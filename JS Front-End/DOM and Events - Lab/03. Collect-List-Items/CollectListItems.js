function extractText() {
const elements = Array.from(document.getElementsByTagName('li'));
const textArea = document.getElementById('result');

for (const li of elements) {
    textArea.value += li.textContent + "\n";
}

// elements.forEach(li => textArea.value += li.textContent + "\n"
// );
}