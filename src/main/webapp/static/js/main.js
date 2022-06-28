function init(){
    const addCartButtonContainers = document.querySelectorAll(".card-button-container");
    for(let container of addCartButtonContainers){
        let button = container.querySelector("a");
        button.addEventListener("click", (e)=>{console.log(e.currentTarget.id)});
    }
}



init();