function init(){
    const addCartButtonContainers = document.querySelectorAll(".card-button-container");
    for(let container of addCartButtonContainers){
        let button = container.querySelector("a");
        button.addEventListener("click", (e)=>{console.log(e.currentTarget.id)});
    }
}

async function addCartHandler(e){
    const productId = e.currentTarget.id;
    const url = `/add-to-cart?product_id=${productId}`
    const response = await getApiResponse();
    if (!response.ok){
        console.log("ERROR")
    }

}

async function getApiResponse(url){
    const response = await fetch(url);
    return response;
}

init();