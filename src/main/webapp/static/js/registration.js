function init() {
    let psw1 = document.getElementById("password");
    let psw2 = document.getElementById("psw");

    psw1.addEventListener("input", checkIfEqual);
    psw2.addEventListener("input", checkIfEqual);
}

function checkIfEqual(e) {
    let psw1 = document.getElementById("password").value;
    let psw2 = document.getElementById("psw").value;

    let submitBtn = document.getElementById("btn");
    if (psw1 == psw2) {
        submitBtn.disabled = false;
    } else {
        submitBtn.disabled = true;
    }
}

init();