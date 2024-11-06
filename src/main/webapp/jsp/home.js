const dash = document.getElementById("dash");
const serv = document.getElementById("serv");


dash.addEventListener("click", () => {
    window.location.href = "../dashboard/dashboard.html";
});
serv.addEventListener("click", () => {
    window.location.href = "../servlet.html";
});
const dashImg = document.getElementById("dashImg")
const dashVideo = document.getElementsByTagName("video")[0]
dash.addEventListener("mouseenter", () => {
    dashImg.classList.add("invisible")
    dashVideo.classList.remove("invisible")

});
dash.addEventListener("mouseleave", () => {
    dashImg.classList.remove("invisible")
    dashVideo.classList.add("invisible")
})

const servImg = document.getElementById("servImg")
const servVideo = document.getElementsByTagName("video")[0]
serv.addEventListener("mouseenter", () => {
    servImg.classList.add("invisible")
    servVideo.classList.remove("invisible")

});
serv.addEventListener("mouseleave", () => {
    servImg.classList.remove("invisible")
    servVideo.classList.add("invisible")
})