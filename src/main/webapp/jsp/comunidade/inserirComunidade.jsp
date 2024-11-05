<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Inserir Comunidade</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <h1>Inserir Comunidade</h1>
  <form action="${pageContext.request.contextPath}/inserirComunidade" method="post" enctype="multipart/form-data">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome">

    <label for="criador">Criador:</label>
    <input type="text" name="criador" id="criador">

    <label for="descricao">Descrição:</label>
    <input type="text" name="descricao" id="descricao">

    <label for="qntIntegrantes">Quantidade de integrantes:</label>
    <input type="number" name="qntIntegrantes" id="qntIntegrantes">

    <label for="foto">Foto do Perfil:</label>
    <input type="text" name="foto" id="foto">

    <input type="submit" value="Inserir">
  </form>

  <!-- Botão para voltar à lista de comunidades -->
  <a href="${pageContext.request.contextPath}/comunidade" class="btn-back">Voltar para a Lista de Comunidades</a>
</div>
</body>
</html>
