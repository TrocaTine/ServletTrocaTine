<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Adicionar Categoria</title>
  <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
  <!-- Link para o arquivo CSS de estilização da página -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <!-- Título da página -->
  <h1>Adicionar Categoria</h1>

  <!-- Formulário para adicionar uma nova categoria -->
  <form action="${pageContext.request.contextPath}/adicionarPorID" method="post">
    <!-- Campo para inserir o nome da categoria -->
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <!-- Botão para submeter o formulário -->
    <input type="submit" value="Adicionar">
  </form>

  <!-- Link para voltar à lista de categorias -->
  <a href="${pageContext.request.contextPath}/categoria" class="btn-back">Voltar para a Lista de Categorias</a>
</div>
</body>
</html>
