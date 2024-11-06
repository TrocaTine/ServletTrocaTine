<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Área Restrita | CRUD</title>

    <!-- Link para o Bootstrap CSS -->
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />

    <!-- Link para o Bootstrap JS -->
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
    ></script>

    <!-- Estilos personalizados -->
    <style>
        /* Estilo para a área principal da página */
        main {
            margin: 50px 75px 0 75px;
        }

        /* Estilo para o título de escolha de tabela */
        .choose {
            margin-bottom: 65px;
        }

        /* Linha de separação */
        .line {
            border: 1px solid rgba(255, 141, 34, 0.4);
            opacity: 1;
        }

        /* Estilo para o container de botões */
        .container {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            margin-top: 25px;
            margin-bottom: 25px;
        }

        /* Estilo para os botões de navegação */
        a.buttons {
            border: 2px solid #FF8D22;
            border-radius: 5px;
            padding: 10px 25px 10px 25px;
            align-items: center;
            background-color: white;
            font-weight: bolder;
            color: #FF8D22;
            transition: 0.1s;
            box-shadow: 1px 1px #FF8D22;
            text-decoration: none;
            margin: 25px 10px 25px 10px;
        }

        /* Efeito de hover nos botões */
        a.buttons:hover {
            box-shadow: #FF8D22;
            box-shadow: 5px 5px #FF8D22;
            transition: 0.1s;
            position: relative;
            left: -2px;
            top: -2px;
        }

        /* Efeito de clique nos botões */
        a.buttons:active {
            position: relative;
            left: 0;
            top: 0;
            box-shadow: none;
            box-shadow: 1px 1px #FF8D22;
        }
    </style>
</head>
<body>
<!-- Barra de navegação -->
<nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding: 0; margin: 0; width: 100%;">
    <div class="container-fluid" style="background-color: #55aca0; padding: 10px">
        <!-- Logo do site -->
        <img src="../Assets/TrocatineLogoBranca.png" style="height: 65px; margin: 0 50px 0 50px" class="navbar-brand logo" alt="" />

        <!-- Botão para toggle da navegação em telas menores -->
        <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false"
                aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Itens do menu de navegação -->
        <div class="collapse navbar-collapse myFlexEnd" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link link-light ancora" aria-current="page" href="dashboard.html">Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link link-light ancora" href="#" onclick="mostrarAlerta()">CRUD</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link link-light ancora" aria-disabled="true" href="../index.html">Landing Page</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Conteúdo principal -->
<main>
    <h1>CRUD</h1>
    <p class="choose">Escolha uma tabela:</p>
    <hr class="line">

    <!-- Botões para acessar as tabelas -->
    <div class="container">
        <a class="buttons" href="../adms">ADM</a>
        <a class="buttons" href="../categoria">Categoria</a>
        <a class="buttons" href="../comunidade">Comunidade</a>
        <a class="buttons" href="../tags">Tag</a>
        <a class="buttons" href="../usuario">Usuario</a>
        <a class="buttons" href="../log">Log</a>
    </div>
    <hr class="line">
</main>

<!-- Função para mostrar um alerta ao clicar em "CRUD" -->
<script>
    function mostrarAlerta() {
        alert("Você já está nessa página!"); // Exibe o alerta
    }
</script>
</body>
</html>
