function colorize() {
     let color = document.querySelectorAll('table tr:nth-child(even)');

    for (const c of color) {
        c.style.background = "teal";
        
    }
}