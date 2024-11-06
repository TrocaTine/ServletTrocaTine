<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Título da página -->
    <title>Excluir Comunidade</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <style>
        /* Estilo geral do corpo da página */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            padding: 50px;
        }

        /* Estilo do título principal */
        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        /* Estilo para o formulário */
        form {
            margin-bottom: 30px;
        }

        /* Estilo para campos de texto e número */
        input[type="text"], input[type="number"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }

        /* Estilo para os botões de envio e voltar */
        input[type="submit"], .btn-back {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        /* Efeito de hover nos botões */
        input[type="submit"]:hover, .btn-back:hover {
            background-color: #ffa201;
        }

        /* Estilo para o botão de voltar */
        .btn-back {
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<!-- Cabeçalho principal da página -->
<h1>Excluir Comunidade</h1>

<!-- Formulário para excluir a comunidade pelo nome -->
<form action="${pageContext.request.contextPath}/excluirComunidadePorNome" method="post">
    <!-- Campo para o nome da comunidade -->
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br>

    <!-- Botão para enviar o formulário -->
    <input type="submit" value="Excluir Comunidade">
</form>

<!-- Link para voltar à lista de comunidades -->
<a href="${pageContext.request.contextPath}/comunidade" class="btn-back">Voltar para a Lista de Comunidades</a>

</body>
</html>
