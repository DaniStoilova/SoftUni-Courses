function sumTable() {
    const sumInput = document.getElementById('sum'); 
    let product = document.querySelectorAll
        ('table tr td:nth-child(2)');
       
        let result = 0;
        for (const p of product) {
            result += Number(p.textContent);   
        }
        sumInput.textContent = result;

      

    // let result = 0;
    // for (let i = 0; i < product.length-1; i++) {
    //     result += Number(product[i].textContent);
    // }
    // document.getElementById('sum').textContent = result;

}


   
