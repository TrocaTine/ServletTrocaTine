<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        * {
            font-family: Arial, Helvetica, sans-serif;
            color: white;
            font-size: 1.1em;
            margin-top: 0;
        }
        body {
            overflow: hidden;
            background-color: white;
            opacity: 1.1;
        }
        h1 {
            font-size: 4.5em;
            margin-bottom: 0;
            margin-left: 50px;
        }
        #cabide {
            width: 230px;
            right: 70px;
            top: 530px;
            transform: rotate(-10deg);
            box-shadow: 1px solid black;
            position: absolute;
        }
        #botao {
            width: 230px;
            left: 800px;
            transform: rotate(13deg);
            top: 540px;
            position: absolute;
        }
        #urso {
            width: 230px;
            right: 0;
            transform: rotate(13deg);
            top: -30px;
            box-shadow: 1px solid black;
            position: absolute;
        }
        #macacao {
            width: 180px;
            right: 10px;
            transform: rotate(-20deg);
            top: 300px;
            box-shadow: 1px solid black;
            position: absolute;
        }
        #camisa {
            width: 190px;
            right: 550px;
            transform: rotate(-30deg);
            top: 100px;
            box-shadow: 1px solid black;
            position: absolute;
        }
        #logo {
            opacity: 1;
            width: 300px;
            position: absolute;
            top: 210px;
            left: 1005px;
        }
        #imagem {
            margin-top: 0;
            background-color: #55ACA0;
            height: 100vh;
            width: 60vw;
        }
        #information {
            position: absolute;
            font-size: 2.3em;
            top: 120px;
            left: 150px;
        }
        a {
            position: absolute;
            top: 500px;
            left: 200px;
            border: 2px solid black;
            background-color: white;
            color: black;
            padding: 30px 50px;
            text-decoration: none;
            border-radius: 10px;
            justify-content: center;
        }
    </style>
</head>
<body>
<img src="Assets/camisa.png" alt="Camisa" id="camisa">
<img src="Assets/Cabide.png" alt="Cabide" id="cabide">
<img src="Assets/botao.png" alt="Botão" id="botao">
<img src="Assets/urso.png" alt="Urso" id="urso">
<img src="Assets/macacao.png" alt="Macacão" id="macacao">

<div id="information">
    <h1>Erro</h1>
    <p><%=request.getAttribute("erro")%></p>
</div>
<div id="imagem">
    <img src="Assets/logo.png" alt="Logo" id="logo">
</div>
<a href="javascript:history.back()">Retornar para a tela inicial</a>
</body>
</html>
