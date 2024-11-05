<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Adicionar Categoria</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <h1>Adicionar Categoria</h1>
  <form action="${pageContext.request.contextPath}/adicionarPorID" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required>

    <input type="submit" value="Adicionar">
  </form>

  <!-- Botão para voltar à lista de categorias -->
  <a href="${pageContext.request.contextPath}/categoria" class="btn-back">Voltar para a Lista de Categorias</a>
</div>
</body>
</html>
