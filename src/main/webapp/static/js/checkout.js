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

    //payload
    let payload = {"userName":userName, "email":email, "address":address, "city":city, "state":state, "zipCode":zipCode,
    "cardName":cardName, "cardNumber":cardNumber, "expMonth":expMonth, "expYear":expYear, "cvv":cvv};
    let url = "/api/save/order";
    const response = await apiPost(url, payload);
}

async function apiPost(url, payload) {

    let response = await fetch(url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
        },
        body: JSON.stringify(payload)
    });

    return response;
}

init()