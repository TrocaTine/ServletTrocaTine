<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <!-- Definições de meta tags para codificação e responsividade -->
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Editar Categoria</title>
  <style>
    /* Estilo para o corpo da página */
    body {
      font-family: Arial, sans-serif;
      background-color: #f0f0f0;
      color: #333;
      text-align: center;
      padding: 50px;
    }

    /* Estilo para o título */
    h1 {
      color: #4CAF50;
      margin-bottom: 20px;
    }

    /* Estilo para o parágrafo */
    p {
      font-size: 18px;
      margin: 20px 0;
    }

    /* Estilo para a mensagem de sucesso */
    .message {
      background-color: #fff;
      border-radius: 8px;
      box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
      padding: 20px;
      display: inline-block;
    }

    /* Estilo para o link de retorno */
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

    /* Efeito de hover no link */
    a:hover {
      background-color: #45a049;
    }
  </style>
  <script>
    /* Redirecionamento automático após 3 segundos */
    setTimeout(function() {
      window.location.href = '../../categoria'; // URL para voltar ao CRUD de Categoria
    }, 3000);
  </script>
</head>
<body>
<!-- Caixa de mensagem de sucesso -->
<div class="message">
  <h1>Categoria excluída com sucesso!</h1>
  <p>Você será redirecionado para o CRUD de CATEGORIA em breve.</p>
  <!-- Link manual para voltar ao CRUD de Categoria -->
  <a href="../../categoria">Voltar para o CRUD de CATEGORIA</a>
</div>
</body>
</html>
