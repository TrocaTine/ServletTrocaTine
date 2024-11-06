<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Título da página -->
  <title>Inserir Comunidade</title>

  <!-- Link para o arquivo CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<!-- Container para o formulário -->
<div class="container">
  <!-- Cabeçalho da página -->
  <h1>Inserir Comunidade</h1>

  <!-- Formulário para inserção de dados da comunidade -->
  <form action="${pageContext.request.contextPath}/inserirComunidade" method="post" enctype="multipart/form-data">

    <!-- Campo para o nome da comunidade -->
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome">

    <!-- Campo para o criador da comunidade -->
    <label for="criador">Criador:</label>
    <input type="text" name="criador" id="criador">

    <!-- Campo para a descrição da comunidade -->
    <label for="descricao">Descrição:</label>
    <input type="text" name="descricao" id="descricao">

    <!-- Campo para a quantidade de integrantes -->
    <label for="qntIntegrantes">Quantidade de integrantes:</label>
    <input type="number" name="qntIntegrantes" id="qntIntegrantes">

    <!-- Campo para a foto do perfil da comunidade -->
    <label for="foto">Foto do Perfil:</label>
    <input type="text" name="foto" id="foto">

    <!-- Botão para enviar o formulário -->
    <input type="submit" value="Inserir">
  </form>

  <!-- Link para voltar à lista de comunidades -->
  <a href="${pageContext.request.contextPath}/comunidade" class="btn-back">Voltar para a Lista de Comunidades</a>
</div>
</body>
</html>
