<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Título da página -->
    <title>Editar Tag</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->

    <!-- Estilo da página -->
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
<!-- Contêiner principal -->
<div class="container">
    <h1>Editar Tag</h1>

    <!-- Formulário para editar tag -->
    <form action="${pageContext.request.contextPath}/editarTagPorId" method="post">
        <!-- Campo para ID -->
        <label for="id">ID:</label>
        <input type="number" id="id" name="id" required>

        <!-- Campo para Cor -->
        <label for="cor">Cor:</label>
        <input type="text" id="cor" name="cor" required>

        <!-- Campo para Gênero -->
        <label for="genero">Genero:</label>
        <input type="text" id="genero" name="genero" placeholder="Menino, Menina ou Unissex" required>

        <!-- Campo para Tamanho -->
        <label for="tamanho">Tamanho:</label>
        <input type="text" id="tamanho" name="tamanho" placeholder="P, M, G, GG, U" required>

        <!-- Campo para Qualidade -->
        <label for="qualidade">Qualidade:</label>
        <input type="text" id="qualidade" name="qualidade" required>

        <!-- Campo para ID Categoria -->
        <label for="idcategoria">Id Categoria:</label>
        <input type="number" id="idcategoria" name="idcategoria" required>

        <!-- Botão de envio -->
        <input type="submit" value="Adicionar">
    </form>

    <!-- Botão para voltar à lista de tags -->
    <a href="${pageContext.request.contextPath}/tags" class="btn-back">Voltar para a Lista de Tags</a>
</div>
</body>
</html>
