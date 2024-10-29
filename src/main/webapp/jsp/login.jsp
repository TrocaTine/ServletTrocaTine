<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"
    ></script>
    <title>Login - Área Restrita</title>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg bg-body-tertiary" style="padding:0;">
        <div class="container-fluid" style="background-color: #55aca0; padding: 10px">
            <img src="../Assets/Logo-nuvem.png" class="navbar-brand logo" alt="" />
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
            <div class="collapse navbar-collapse myFlexEnd" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link link-light ancora" href="#">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link link-light ancora" href="#">Landing Page</a>
                    </li>
                </ul>
                <a href="../index.html" class="btn btn-outline-light">Sair</a> <!-- Botão de Sair -->
            </div>
        </div>
    </nav>
</header>

<main>
    <div class="container">
        <h1 class="text-center mt-4">Login da Área Restrita</h1>
        <div class="d-flex justify-content-center">
            <!-- Formulário de login -->
            <form class="forms" action="../VerificarAdms" method="post" style="margin-top: 30px">
                <div class="mb-3">
                    <label for="user" class="form-label">Nome do Usuário</label>
                    <!-- Campo de texto para o usuário -->
                    <input type="text" class="form-control" id="user" name="user" required pattern="^[A-Z][a-z]+ [A-Z][a-z]+$" title="O nome deve ser no formato: Nome Sobrenome (ex: João Silva)">
                </div>
                <div class="mb-3">
                    <label for="senha" class="form-label">Senha</label>
                    <!-- Campo de senha -->
                    <input type="password" class="form-control" id="senha" name="senha" required>
                </div>

                <!-- Mensagem de erro em vermelho, se existir -->
                <div class="text-center" style="color: red;">
                    <%
                        String erroLogin = (String) request.getAttribute("erroLogin");
                        if (erroLogin != null) {
                    %>
                    <p><%= erroLogin %></p>
                    <%
                        }
                    %>
                </div>

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
