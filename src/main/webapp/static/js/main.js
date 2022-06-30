function init(){
    const addCartButtonContainers = document.querySelectorAll(".card-button-container");
    for(let container of addCartButtonContainers){
        let button = container.querySelector("a");
        button.addEventListener("click",addCartHandler);
    }
}

async function addCartHandler(e){
    const productId = e.currentTarget.id;
    const url = `/api/edit-cart?product_id=${productId}`
    console.log(url);
    const response = await getApiResponse(url);
    if (!response.ok){
        console.log("ERROR")
    }

}

async function getApiResponse(url){
    const response = await fetch(url);
    return response;
}

init();