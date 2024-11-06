<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Categoria</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            color: #333;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #4CAF50;
            margin-bottom: 20px;
        }
        p {
            font-size: 18px;
            margin: 20px 0;
        }
        .message {
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            display: inline-block;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #fff;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #45a049;
        }
    </style>
    <script>
        // Redireciona automaticamente após 3 segundos
        setTimeout(function() {
            window.location.href = '../../comunidade'; // URL do CRUD de Categoria
        }, 3000);
    </script>
</head>
<body>
<div class="message">
    <h1>Comunidade excluída com sucesso!</h1>
    <p>Você será redirecionado para o CRUD de COMUNIDADE em breve.</p>
    <!-- Link para voltar ao CRUD de Comunidade -->
    <a href="../../comunidade">Voltar para CRUD de Comunidade</a>
</div>
</body>
</html>
