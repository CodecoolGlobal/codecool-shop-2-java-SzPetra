export let contentBuilder = {
    updateItem : function(item){
                    const lineItem = document.querySelector(`#${item["id"]}`);
                    lineItem.querySelector(".quantity item-info").textContent = item["quantity"];

                },

    updateCart : function(Cart) {

                },

    deleteCart : function() {
                    const cartContainer = document.querySelectorAll(".cart-items" );
                    for(let lineItem of cartContainer){
                        lineItem.innerHTML = "";
                    }
                },
    updateTotalPrice: function(newPrice){

                }
}