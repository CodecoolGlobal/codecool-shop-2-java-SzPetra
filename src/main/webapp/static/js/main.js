import {dataHandler} from "./DataHandler";

function init(){
    const addCartButtonContainers = document.querySelectorAll(".card-button-container");
    for(let container of addCartButtonContainers){
        let button = container.querySelector("a");
        button.addEventListener("click",addCartHandler);
    }
}

async function addCartHandler(e){
    const productId = e.currentTarget.id;
    await dataHandler.addToCart(productId);

}


init();