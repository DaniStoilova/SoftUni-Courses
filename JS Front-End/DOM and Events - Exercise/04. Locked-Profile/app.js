function lockedProfile() {
    const buttons =  Array.from(document.getElementsByTagName('button'));

    for (const button of buttons) {
        button.addEventListener('click', func);
    }


    function func(e){

        let btn = e.target;
        const profile = btn.parentElement;
        const unLocked = profile.querySelector('input:checked').value;
        const field = profile.querySelector('.profile div');

        if (unLocked === 'unlock'){
            if (btn.textContent === 'Show more') {
               field.style.display = 'inline-block';
                btn.textContent = 'Hide it';
            } else if (btn.textContent === 'Hide it') {
                field.style.display = 'none';
                btn.textContent = 'Show more';
            }
    }
    }
    
 
}


