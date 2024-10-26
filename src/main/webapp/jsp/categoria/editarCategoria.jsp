<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Categoria</title>
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
<h1>Editar Categoria</h1>
<form action="${pageContext.request.contextPath}/EditarPorID" method="post">
    <label for="nome">Nome novo:</label>
    <input type="text" id="nome" name="nome" required><br>
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br>
    <input type="submit" value="Editar">
</form>

<!-- Botão para voltar à lista de categorias -->
<a href="${pageContext.request.contextPath}/categoria" class="btn-back">Voltar para a Lista de Categorias</a>

</body>
</html>
