// Evento disparado quando o conteúdo da página é completamente carregado
document.addEventListener("DOMContentLoaded", () => {
    // Elementos para manipulação (estilo)
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

    // Ativando inicialmente o menu
    headerImg.src = "Assets/TrocaTineLogoBranca.png";
    header.style.height = '150px';
    headerImg.src = "Assets/TrocaTineLogoBranca.png";
    signInButtom.classList.remove('signIn-active');
    signInButtom.classList.add('signIn-unactive');

    // Definindo as rotações iniciais dos celulares
    const initialRotations = {
        phoneLeft: 7.5,
        phoneMiddle: 0,
        phoneRight: -7.5
    };

    // Função que anima os celulares durante o scroll
    function animatePhones() {
        // Obtendo a posição do scroll na página
        const scrollY = window.scrollY;
        // Posição do container de telefones em relação ao topo da página
        const containerTop = container.getBoundingClientRect().top + scrollY;
        // Progresso da rolagem entre 0 e 1 (usado para determinar os efeitos de animação)
        const scrollProgress = Math.min(1, Math.max(0, (scrollY - containerTop + 835) / 600));

        // Animando o telefone à esquerda
        phoneLeft.style.top = `${-715 + scrollProgress * 715}px`;
        phoneLeft.style.right = `${-50 + scrollProgress * 200}px`;
        phoneLeft.style.transform = `rotate(${initialRotations.phoneLeft - scrollProgress * initialRotations.phoneLeft}deg)`;

        // Animando o telefone do meio
        phoneMiddle.style.top = `${-700 + scrollProgress * 700}px`;

        // Animando o telefone à direita
        phoneRight.style.top = `${-715 + scrollProgress * 715}px`;
        phoneRight.style.right = `${50 - scrollProgress * 200}px`;
        phoneRight.style.transform = `rotate(${initialRotations.phoneRight + scrollProgress * -initialRotations.phoneRight}deg)`;

        // Adicionando animação de escala nos celulares quando o scroll atingir uma determinada posição
        if (scrollY >= 1000) {
            phoneLeft.classList.add('scale-for-hover');
            phoneMiddle.classList.add('scale-for-hover');
            phoneRight.classList.add('scale-for-hover');
        }

        // Removendo animação de escala se o scroll sair da faixa de animação
        if (scrollY < 1000 || scrollY > 1250) {
            phoneLeft.classList.remove('scale-for-hover');
            phoneMiddle.classList.remove('scale-for-hover');
            phoneRight.classList.remove('scale-for-hover');
        }

        // Mudando o cabeçalho quando o scroll chegar ao topo da página
        if (scrollY > 0) {
            header.style.backdropFilter = "blur(5px)";
            header.style.backgroundColor = '#373a37f7';
            header.style.height = '90px';
            headerImg.src = "Assets/TrocaTineLogo.png";
            signInButtom.classList.add('signIn-active');
            signInButtom.classList.remove('signIn-unactive');
        } else {
            header.style.backdropFilter = "blur(0px)";

            header.style.backgroundColor = '#00000000';
            header.style.height = '150px';
            headerImg.src = "Assets/TrocaTineLogoBranca.png";
            signInButtom.classList.remove('signIn-active');
            signInButtom.classList.add('signIn-unactive');
        }

        // Mudando o estilo do corpo e do rodapé com base na rolagem
        if (scrollY > 3500) {
            // Mudando a cor de fundo para uma cor personalizada
            document.documentElement.style.setProperty('--color-body', '#55aca0', 'important');
            footer.style.backgroundColor = "#55aca0";
            knowUs.style.color = "white";
            team.style.color = 'white';

            // Mudando a cor dos nomes e cargos
            document.querySelectorAll('.nome').forEach(nome => {
                nome.style.color = 'white';
            });
            document.querySelectorAll('.cargo').forEach(cargo => {
                cargo.style.color = 'white';
            });

            // Mudando a imagem da nuvem no rodapé
            nuvemFooter.src = "Assets/nuvens.png";
        } else if (scrollY < 3800) {
            // Voltando ao estilo original quando a rolagem estiver dentro do intervalo
            document.documentElement.style.setProperty('--color-body', 'white', 'important');
            footer.style.backgroundColor = "white";
            knowUs.style.color = "var(--color-lightgray)";
            team.style.color = 'var(--color-blue)';

            // Revertendo as cores dos nomes e cargos
            document.querySelectorAll('.nome').forEach(nome => {
                nome.style.color = '#55aca0';
            });
            document.querySelectorAll('.cargo').forEach(cargo => {
                cargo.style.color = 'var(--color-midgray)';
            });

            // Revertendo a imagem do rodapé
            nuvemFooter.src = "Assets/footer.png";
        }
    }

    // Adicionando o evento de scroll para acionar a animação
    window.addEventListener("scroll", animatePhones);
});

// Prevenção de gestos de zoom no dispositivo (como em dispositivos móveis)
document.addEventListener('gesturestart', function(e) {
    e.preventDefault();  // Previne a ação de zoom no conteúdo
});
