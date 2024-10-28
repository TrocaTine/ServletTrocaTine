<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Categoria</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
            text-align: left;
        }
        h1 {
            color: #444;
            margin-bottom: 20px;
            text-align: center;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            font-size: 14px;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="number"], input[type="email"], input[type="password"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
            width: calc(100% - 22px);
        }
        input[type="submit"], .btn-back {
            padding: 12px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
            text-decoration: none;
            width: 100%;
            text-align: center;
            margin-top: 10px;
        }
        input[type="submit"]:hover, .btn-back:hover {
            background-color: #ffa201;
        }
        .btn-back {
            display: block;
            margin: 20px auto 0; /* Centraliza o botão e adiciona margem superior */
            background-color: #6c757d;
            padding: 12px 20px;
            font-size: 16px;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
            width: fit-content; /* Ajusta a largura do botão ao conteúdo */
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Adicionar Administrador</h1>
    <form action="${pageContext.request.contextPath}/inserirAdm" method="post">
        <label for="id">ID:</label>
        <input type="number" id="id" name="id" required>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>
        <label for="idUsuario">idUsuario:</label>
        <input type="number" id="idUsuario" name="idUsuario" required>
        <input type="submit" value="Adicionar">
    </form>
    <a href="${pageContext.request.contextPath}/adms" class="btn-back">Voltar para a Lista de Administradores</a>
</div>
</body>
</html>
