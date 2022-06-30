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

function quantityChangeHandler(e){
    const changeValue = e.currentTarget.value;
    const id = e.currentTarget.parentElement.parentElement.id;
    console.log(id);
    console.log(changeValue);
}

function deleteHandler(e){
    const id = e.currentTarget.parentElement.parentElement.id;
}

async function clearCartHandler(e){
    const url = "/api/edit-cart";
    await apiDelete(url);

}

async function apiDelete(url){
    const response = await fetch(url, { method:'DELETE'})
    if (!response.ok) {
        console.log("DELETE not ok")
    }

}

async function apiGet(url){
    const response = await fetch(url);
    return await response.json();
}

init()