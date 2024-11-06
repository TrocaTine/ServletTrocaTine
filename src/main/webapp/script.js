// Evento disparado quando o conteúdo da página é completamente carregado
document.addEventListener("DOMContentLoaded", () => {
    // Selecionando os elementos da página que serão manipulados
    const phoneLeft = document.querySelector(".phoneLeft");  // Referência para o telefone à esquerda
    const phoneMiddle = document.querySelector(".phoneMiddle");  // Referência para o telefone no meio
    const phoneRight = document.querySelector(".phoneRight");  // Referência para o telefone à direita
    const container = document.querySelector(".phoneContainer");  // Referência para o container que envolve os telefones
    const header = document.querySelector(".header");  // Referência para o cabeçalho da página
    const headerImg = document.getElementById("img-banner");  // Referência para a imagem do logo no cabeçalho
    const footer = document.querySelector('footer');  // Referência para o rodapé da página
    const nuvemFooter = document.getElementById('nuvemFooter');  // Referência para a imagem de nuvem no rodapé
    const knowUs = document.getElementById('knowUs');  // Referência para o título de "Conheça-nos"
    const team = document.getElementById('team');  // Referência para o título da "Equipe"
    const signInButtom = document.getElementById('signIn');  // Referência para o botão de "Cadastre-se"
    var r = document.querySelector(':root');  // Referência para o elemento raiz do documento (útil para alterar variáveis CSS)

    // Definindo a imagem do logo no cabeçalho
    headerImg.src = "Assets/TrocaTineLogoBranca.png";

    // Definindo as rotações iniciais dos telefones
    const initialRotations = {
        phoneLeft: 7.5,  // Rotações iniciais para o telefone à esquerda
        phoneMiddle: 0,  // Rotações iniciais para o telefone do meio
        phoneRight: -7.5  // Rotações iniciais para o telefone à direita
    };

    // Função que anima os telefones durante o scroll
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

        // Adicionando animação de escala nos telefones quando o scroll atingir uma determinada posição
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

        // Mudando o cabeçalho quando o scroll ultrapassar o topo da página
        if (scrollY > 0) {
            header.style.backgroundColor = '#373a37f7';  // Mudando a cor de fundo do cabeçalho
            header.style.height = '90px';  // Diminuindo a altura do cabeçalho
            headerImg.src = "Assets/TrocaTineLogo.png";  // Mudando o logo do cabeçalho
            signInButtom.classList.add('signIn-active');  // Ativando o estilo para o botão de cadastro
            signInButtom.classList.remove('signIn-unactive');  // Removendo a classe que torna o botão inativo
        } else {
            header.style.backgroundColor = '#00000000';  // Cor de fundo transparente
            header.style.height = '150px';  // Altura original do cabeçalho
            headerImg.src = "Assets/TrocatineLogoBranca.png";  // Mudando o logo para a versão branca
            signInButtom.classList.remove('signIn-active');  // Removendo o estilo de botão ativo
            signInButtom.classList.add('signIn-unactive');  // Adicionando a classe de botão inativo
        }

        // Mudando o estilo do corpo e do rodapé com base na rolagem
        if (scrollY > 3500) {
            // Mudando a cor de fundo para uma cor personalizada
            document.documentElement.style.setProperty('--color-body', '#55aca0', 'important');
            footer.style.backgroundColor = "#55aca0";  // Mudando a cor do rodapé
            knowUs.style.color = "white";  // Mudando a cor do texto "Conheça-nos"
            team.style.color = 'white';  // Mudando a cor do texto "Equipe"

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
            footer.style.backgroundColor = "white";  // Cor do rodapé voltando para branco
            knowUs.style.color = "var(--color-lightgray)";  // Cor do texto "Conheça-nos"
            team.style.color = 'var(--color-blue)';  // Cor do texto "Equipe"

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
