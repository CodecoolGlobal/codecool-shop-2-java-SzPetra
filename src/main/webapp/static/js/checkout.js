function init() {

    let checkoutButton = document.getElementById("checkout-btn");
    checkoutButton.addEventListener("click", handleCheckoutData);
}

async function handleCheckoutData() {

    //checkout form datas
    let userName = document.getElementById("fname").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("adr").value;
    let city = document.getElementById("city").value;
    let state = document.getElementById("state").value;
    let zipCode = document.getElementById("zip").value;
    let cardName = document.getElementById("cname").value;
    let cardNumber = document.getElementById("ccnum").value;
    let expMonth = document.getElementById("expmonth").value;
    let expYear = document.getElementById("expyear").value;
    let cvv = document.getElementById("cvv").value;
}

init()