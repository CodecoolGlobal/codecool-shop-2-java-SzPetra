function init(){
    const decreaseButtons = document.querySelectorAll(".button-decrease")
    const increaseButtons = document.querySelectorAll(".button-increase")
    const deleteButtons = document.querySelectorAll(".button-delete")
    addEventHandlers(decreaseButtons, (e)=>{console.log(e.currentTarget)})
    addEventHandlers(increaseButtons, (e)=>{console.log(e.currentTarget)})
    addEventHandlers(deleteButtons, (e)=>{console.log(e.currentTarget)})
}

function addEventHandlers(buttons, eventHandler){
    for(let button of buttons){
        button.addEventListener("click", eventHandler);
    }
}

init()