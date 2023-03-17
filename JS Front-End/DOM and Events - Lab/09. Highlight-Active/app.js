function focused() {
  const input = document.querySelectorAll('div div input');

  for (let element of input) {
      element.addEventListener('focus', (e) => {
          e.target.parentElement.classList.add('focused');            
      });

      element.addEventListener('blur', (e) => {
          e.target.parentElement.classList.remove('focused');
      });
  }


}