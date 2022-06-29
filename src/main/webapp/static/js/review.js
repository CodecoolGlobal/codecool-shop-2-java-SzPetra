function init(){
    const quantityChangeButtons = document.querySelectorAll(".button-quantity-change")
    const deleteButtons = document.querySelectorAll(".button-delete")
    addEventHandlers(quantityChangeButtons, quantityChangeHandler)
    addEventHandlers(deleteButtons, deleteHandler)
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

init()