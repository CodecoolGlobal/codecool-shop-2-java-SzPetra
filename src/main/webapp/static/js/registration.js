function init() {
    let submitBtn = document.getElementById("btn");
    submitBtn.addEventListener("click", registerNewUser);
}

function registerNewUser() {
    let psw1 = document.getElementById("password");
    console.log(psw1);
    let psw2 = document.getElementById("psw");
    console.log(psw2);
}

init();