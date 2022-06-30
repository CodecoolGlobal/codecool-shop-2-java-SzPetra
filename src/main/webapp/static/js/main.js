function init(){
    const addCartButtonContainers = document.querySelectorAll(".card-button-container");
    for(let container of addCartButtonContainers){
        let button = container.querySelector("a");
        button.addEventListener("click",addCartHandler);
    }
}

async function addCartHandler(e){
    const productId = e.currentTarget.id;
    const url = `/api/edit-cart?product_id=${productId}`;
    const payload = {id:productId}
    await putApi(url, payload);

}

async function putApi(url){
    const response = await fetch(url, {method:"PUT"});
    if (!response.ok){
        console.log("ERROR")
    }
}

init();