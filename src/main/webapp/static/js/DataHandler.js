export let dataHandler = {
    getCartContent:"",
    deleteLineItem:"",
    clearCart:"",
    changeLineItemQuantity:""

}


async function apiDelete(url){
    const response = await fetch(url, { method:'DELETE'})
    if (!response.ok) {
        console.log("DELETE not ok")
    }

}

async function apiGet(url){
    const response = await fetch(url);
    if(response.ok){
        return await response.json();
    }
}

async function putApi(url){
    const response = await fetch(url, {method:"PUT"});
    if (!response.ok){
        console.log("ERROR")
    }
}
