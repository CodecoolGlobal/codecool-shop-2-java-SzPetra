export let dataHandler = {
    getCartContent: async function(){
        const url = "/api/edit-cart"
        return await apiGet(url);
    },
    deleteLineItem: async function(id){
        const url = `/api/edit-item?product_id=${id}`
        await apiDelete(url);
    },
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
