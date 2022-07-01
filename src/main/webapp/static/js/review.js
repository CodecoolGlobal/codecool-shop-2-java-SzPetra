import {dataHandler} from "./DataHandler";

function init(){
    const quantityChangeButtons = document.querySelectorAll(".button-quantity-change")
    const deleteButtons = document.querySelectorAll(".button-delete")
    addEventHandlers(quantityChangeButtons, quantityChangeHandler)
    addEventHandlers(deleteButtons, deleteHandler)
    const clearCartButton = document.querySelector("#clear-button");
    clearCartButton.addEventListener("click", clearCartHandler)
}

function addEventHandlers(buttons, eventHandler){
    for(let button of buttons){
        button.addEventListener("click", eventHandler);
    }
}

async function quantityChangeHandler(e){
    const changeValue = e.currentTarget.value;
    const id = e.currentTarget.parentElement.parentElement.id;
    await dataHandler.changeLineItemQuantity(id, changeValue);
    const changedItem = dataHandler.getLineItem(id);
    console.log(changedItem);
}

function deleteHandler(e){
    const id = e.currentTarget.parentElement.parentElement.id;
}

async function clearCartHandler(e){
    await dataHandler.clearCart();
    const cart = dataHandler.getCartContent();
    console.log(cart);
}



init()