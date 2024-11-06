<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Excluir Administrador</title>
    <style>
        /* Estilos para o corpo da página */
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
        /* Estilos para os campos de entrada */
        input[type="text"], input[type="number"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 10px;
        }
        /* Estilos para os botões */
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
        /* Estilo para o botão de voltar */
        .btn-back {
            display: inline-block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h1>Excluir Usuário</h1>

<!-- Formulário para excluir um administrador -->
<form action="${pageContext.request.contextPath}/excluirAdm" method="post">
    <!-- Campo para inserir o ID do administrador a ser excluído -->
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br>

    <!-- Botão para enviar a requisição de exclusão -->
    <input type="submit" value="Excluir Usuário">
</form>

<!-- Link para voltar à lista de administradores -->
<a href="${pageContext.request.contextPath}/adms" class="btn-back">Voltar para a Lista de Administradores</a>

</body>
</html>
