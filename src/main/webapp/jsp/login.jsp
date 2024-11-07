<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" href="../Assets/logo.png"> <!-- Favicon -->
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

    <title>TrocaTine | Área Restrita - Login</title>
</head>
<body>
<header>
    <!-- Barra de navegação -->
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding:0;">
        <div class="container-fluid" style="background-color: #55aca0; padding: 10px">
            <!-- Logo do site -->
            <img src="../Assets/TrocatineLogoBranca.png" style="margin: 0 50px 0 50px; height: 65px;" class="navbar-brand logo" alt="" />

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
                <!-- Link de Sair -->
                <a href="../index.html" class="btn btn-outline-light" style="margin-right: 15px;">Sair</a>
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <!-- Título da página -->
        <h1 class="text-center mt-4">Login da Área Restrita</h1>

        <div class="d-flex justify-content-center">
            <!-- Formulário de login -->
            <form class="forms" action="..//VerificarAdms" method="post" style="margin-top: 30px">

                <!-- Campo de entrada para o nome do usuário -->
                <div class="mb-3">
                    <label for="user" class="form-label">Nome do Usuário</label>
                    <input
                            type="text"
                            class="form-control"
                            id="user"
                            name="user"
                            title="O nome deve ser no formato: Nome Sobrenome (ex: João Silva)">
                </div>

                <!-- Campo de entrada para a senha -->
                <div class="mb-3">
                    <label for="senha" class="form-label">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" required>
                </div>

                <!-- Exibe uma mensagem de erro caso ocorra algum problema no login -->
                <div class="text-center" style="color: red;">
                    <%
                        String ErroLogin = (String) request.getAttribute("ErroLogin");
                        if (ErroLogin != null) {
                    %>
                    <p><%= ErroLogin %></p>
                    <%
                        }
                    %>
                </div>

                <!-- Botão para submeter o formulário -->
                <div class="text-center">
                    <button type="submit" class="btn btn-forms" style="background-color: #55aca0; color: white;">
                        Login
                    </button>
                </div>
            </form>
        </div>
    </div>
</main>

<footer></footer>

</body>
</html>
