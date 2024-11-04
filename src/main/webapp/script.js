document.addEventListener("DOMContentLoaded", () => {
    const phoneLeft = document.querySelector(".phoneLeft");
    const phoneMiddle = document.querySelector(".phoneMiddle");
    const phoneRight = document.querySelector(".phoneRight");
    const container = document.querySelector(".phoneContainer");
    const header = document.querySelector(".header"); 
    const headerImg = document.getElementById("img-banner");
    const footer = document.querySelector('footer');
    const nuvemFooter = document.getElementById('nuvemFooter');
    const knowUs = document.getElementById('knowUs');
    const team = document.getElementById('team');
    const signInButtom = document.getElementById('signIn');
    var r = document.querySelector(':root');


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
            headerImg.src = "Assets/TrocatineLogo.png";
            signInButtom.classList.add('signIn-active');
            signInButtom.classList.remove('signIn-unactive');
            
            header.classList.add = 'blur3px';
        } else {
            header.style.backgroundColor = '#00000000'; 
            header.style.height = '150px';
            headerImg.src = "Assets/TrocatineLogoBranca.png";
            signInButtom.classList.remove('signIn-active');
            signInButtom.classList.add('signIn-unactive');
            
            header.classList.remove = 'blur3px';
        }


        if (scrollY > 3500) {
            document.documentElement.style.setProperty('--color-body', '#55aca0', 'important');
            footer.style.backgroundColor = "#55aca0";
            knowUs.style.color = "white";
            team.style.color = 'white';

            document.querySelectorAll('.nome').forEach(nome => {
                nome.style.color = 'white';
            });
            document.querySelectorAll('.cargo').forEach(cargo => {
                cargo.style.color = 'white';
            });

            nuvemFooter.src = "Assets/nuvens.png"
        } else if (scrollY < 3800) {
            document.documentElement.style.setProperty('--color-body', 'white', 'important');
            footer.style.backgroundColor = "white";
            knowUs.style.color = "var(--color-lightgray)";
            team.style.color = 'var(--color-blue)';

            document.querySelectorAll('.nome').forEach(nome => {
                nome.style.color = '#55aca0';
            });
            document.querySelectorAll('.cargo').forEach(cargo => {
                cargo.style.color = 'var(--color-midgray)';
            });

            nuvemFooter.src = "Assets/footer.png"
        }

    }

    window.addEventListener("scroll", animatePhones);
});

document.addEventListener('gesturestart', function(e) {
    e.preventDefault(); 
});