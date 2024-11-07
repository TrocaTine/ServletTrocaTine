<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error Page</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <style>
        * {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            background-color: #f2f2f2;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
            color: #333;
        }
        .container {
            display: flex;
            background-color: #ffffff;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            overflow: hidden;
            width: 70vw;
            max-width: 1200px;
            min-height: 500px;
        }
        #imagem {
            background-color: #55ACA0;
            width: 40%;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
        }
        #logo {
            width: 150px;
            opacity: 0.9;
        }
        .error-content {
            width: 60%;
            padding: 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: flex-start;
            position: relative;
            color: #333;
        }
        h1 {
            font-size: 3em;
            color: #e74c3c;
            margin-bottom: 10px;
        }
        p {
            font-size: 1.2em;
            color: #555;
            margin-bottom: 30px;
        }
        .return-button {
            padding: 15px 30px;
            background-color: #e74c3c;
            color: #ffffff;
            text-decoration: none;
            font-size: 1em;
            border-radius: 8px;
            transition: background-color 0.3s;
            text-align: center;
        }
        .return-button:hover {
            background-color: #c0392b;
        }
        .images {
            position: absolute;
            bottom: -10px;
            right: -10px;
            width: 300px;
        }
        .images img {
            width: 50px;
            margin: 0 5px;
            opacity: 0.8;
            transform: rotate(-15deg);
            transition: transform 0.3s;
        }
        .images img:hover {
            transform: rotate(0deg) scale(1.1);
        }
    </style>
</head>
<body>
<div class="container">
    <div id="imagem">
        <img src="Assets/logo.png" alt="Logo" id="logo">
    </div>
    <div class="error-content">
        <h1>Erro</h1>
        <p><%= request.getAttribute("erro") %></p>
        <a href="javascript:history.back()" class="return-button">Retornar para a tela anterior</a>
        <div class="images">
            <img src="${pageContext.request.contextPath}/Assets/camisa.png" alt="Camisa">
            <img src="${pageContext.request.contextPath}/Assets/Cabide.png" alt="Cabide">
            <img src="${pageContext.request.contextPath}/Assets/botao.png" alt="Botão">
            <img src="${pageContext.request.contextPath}/Assets/urso.png" alt="Urso">
            <img src="${pageContext.request.contextPath}/Assets/macacao.png" alt="Macacão">
        </div>
    </div>
</div>
</body>
</html>
