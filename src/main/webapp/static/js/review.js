import {dataHandler} from "./DataHandler.js";
import {contentBuilder} from "./contentBuilder.js";

function init(){
    const increaseQuantityButtons = document.querySelectorAll(".button-increase");
    const decreaseQuantityButtons = document.querySelectorAll(".button-decrease");
    const deleteButtons = document.querySelectorAll(".button-delete");
    addEventHandlers(increaseQuantityButtons, quantityChangeHandler);
    addEventHandlers(decreaseQuantityButtons, quantityChangeHandler);
    addEventHandlers(deleteButtons, deleteHandler);
    const clearCartButton = document.querySelector("#clear-button");
    clearCartButton.addEventListener("click", clearCartHandler);
}

function addEventHandlers(buttons, eventHandler){
    for(let button of buttons){
        button.addEventListener("click", eventHandler);
    }
}

async function quantityChangeHandler(e){
    const changeValue = e.currentTarget.value;
    console.log(changeValue);
    const id = e.currentTarget.parentElement.id;
    console.log(id);
    await dataHandler.changeLineItemQuantity(id, changeValue);
    const changedItem = await dataHandler.getLineItem(id);
    console.log(changedItem);
}

async function deleteHandler(e) {
    const id = e.currentTarget.parentElement.id;
    await dataHandler.deleteLineItem(id);
    const updatedCart = await dataHandler.getCartContent();
    console.log(updatedCart);
}

async function clearCartHandler(e){
    await dataHandler.clearCart();
    const cart = await dataHandler.getCartContent();
    contentBuilder.deleteCart();
    console.log(cart);
}



init()