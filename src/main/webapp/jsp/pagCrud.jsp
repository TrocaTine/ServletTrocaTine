<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud TrocaTIne</title>
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
        .button-container {
            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 15px;
        }
        .button-container a {
            background-color: #55aca0;
            color: white;
            padding: 15px 30px;
            text-decoration: none;
            border-radius: 8px;
            font-size: 16px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            width: 250px;
            text-align: center;
        }
        .button-container a:hover {
            background-color: #ffa201;
            transform: translateY(-5px);
        }
        .button-container a:active {
            background-color: #ff8800;
            transform: translateY(2px);
        }
    </style>
</head>
<body>
<h1>Bem-vindo ao CRUD do TrocaTine!</h1>
<h1>Escolha qual tabela você quer acessar:</h1>
<div class="button-container">
    <a href="../categoria" >Categoria</a>
    <a href="adm" >Administrador</a>
    <a href="comunidade" >Comunidade</a>
    <a href="tag" >Tag</a>
    <a href="cadastro" >Cadastro</a>
</div>
</body>
</html>
