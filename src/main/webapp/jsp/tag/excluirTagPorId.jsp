<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Título da página -->
    <title>Excluir Tag</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->

    <!-- Estilos da página -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        form {
            margin-bottom: 30px;
        }
        input[type="text"], input[type="number"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
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
        input[type="submit"]:hover, .btn-back:hover {
            background-color: #ffa201;
        }
        .btn-back {
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<!-- Cabeçalho da página -->
<h1>Excluir Tag</h1>

<!-- Formulário para excluir tag -->
<form action="${pageContext.request.contextPath}/excluirTag" method="post">
    <!-- Campo para ID da tag -->
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br>

    <!-- Botão de envio para excluir a tag -->
    <input type="submit" value="Excluir Tag">
</form>

<!-- Botão para voltar à lista de tags -->
<a href="${pageContext.request.contextPath}/tags" class="btn-back">Voltar para a Lista de Tags</a>
</body>
</html>
