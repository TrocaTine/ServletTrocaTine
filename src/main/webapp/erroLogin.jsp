<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Erro - Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .error-message {
            color: red;
            font-weight: bold;
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center mt-4">Erro de Login</h1>

    <!-- Exibe a mensagem de erro -->
    <div class="error-message">
        <p>Usuário ou senha incorretos.</p>
    </div>

    <!-- Botão para voltar ao login -->
    <div class="text-center">
        <a href="login.jsp" class="btn btn-primary mt-4">Tentar novamente</a>
    </div>
</div>
</body>
</html>
