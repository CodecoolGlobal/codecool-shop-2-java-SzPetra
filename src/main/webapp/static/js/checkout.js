function init() {

    let checkoutButton = document.getElementById("checkout-btn");
    checkoutButton.addEventListener("click", handleCheckoutData);
}

async function handleCheckoutData() {

    alert("working");
}

init()