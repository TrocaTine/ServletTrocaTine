document.addEventListener("DOMContentLoaded", () => {
    const phoneLeft = document.querySelector(".phoneLeft");
    const phoneMiddle = document.querySelector(".phoneMiddle");
    const phoneRight = document.querySelector(".phoneRight");
    const container = document.querySelector(".phoneContainer");
    const header = document.querySelector(".header"); 
    const headerImg = document.getElementById("img-banner");

    const initialRotations = {
        phoneLeft: 7.5,
        phoneMiddle: 0,
        phoneRight: -7.5
    };

    function animatePhones() {
        const scrollY = window.scrollY;
        const containerTop = container.getBoundingClientRect().top + scrollY;
        const scrollProgress = Math.min(1, Math.max(0, (scrollY - containerTop + 835) / 600));

        phoneLeft.style.top = `${-715 + scrollProgress * 715}px`;
        phoneLeft.style.right = `${-50 + scrollProgress * 200}px`;
        phoneLeft.style.transform = `rotate(${initialRotations.phoneLeft - scrollProgress * initialRotations.phoneLeft}deg)`;

        phoneMiddle.style.top = `${-700 + scrollProgress * 700}px`;

        phoneRight.style.top = `${-715 + scrollProgress * 715}px`;
        phoneRight.style.right = `${50 - scrollProgress * 200}px`;
        phoneRight.style.transform = `rotate(${initialRotations.phoneRight + scrollProgress * -initialRotations.phoneRight}deg)`;
        
        if (scrollY >= 1000) {
            phoneLeft.classList.add('scale-for-hover');
            phoneMiddle.classList.add('scale-for-hover');
            phoneRight.classList.add('scale-for-hover');
        }

        if (scrollY < 1000 || scrollY > 1250) {
            phoneLeft.classList.remove('scale-for-hover');
            phoneMiddle.classList.remove('scale-for-hover');
            phoneRight.classList.remove('scale-for-hover');
        }

        if (scrollY > 0) {
            header.style.backgroundColor = '#373a37f7';
            header.style.height = '90px';
            headerImg.src = "Assets/TrocatineLogo.png"
        } else {
            header.style.backgroundColor = '#00000000'; 
            header.style.height = '150px';
            headerImg.src = "Assets/TrocatineLogoBranca.png"
        }
    }

    window.addEventListener("scroll", animatePhones);
});



document.addEventListener('gesturestart', function(e) {
    e.preventDefault(); 
});