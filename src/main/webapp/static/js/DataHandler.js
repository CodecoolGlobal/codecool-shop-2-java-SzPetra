export let dataHandler = {
    getCartContent: async function(){
        const url = "/api/edit-cart"
        return await apiGet(url);
    },
    deleteLineItem: async function(id){
        const url = `/api/edit-item?product_id=${id}`
        await apiDelete(url);
    },
    clearCart:async function(){
        const url = "/api/edit-cart";
        await apiDelete(url);
    },
    changeLineItemQuantity:async function(id, change){
        const url = `/api/edit-item?product_id=${id}&quantity_change=${change}`
        await apiPut(url);
    },
    getLineItem: async function(id){
        const url = `/api/edit-item?product_id=${id}`
        return await apiGet()
    }

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

async function apiPut(url){
    const response = await fetch(url, {method:"PUT"});
    if (!response.ok){
        console.log("ERROR")
    }
}
