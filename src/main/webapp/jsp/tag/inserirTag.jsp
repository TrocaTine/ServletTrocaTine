<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Título da página -->
  <title>Adicionar Tag</title>
  <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->

  <!-- Link para o arquivo de CSS para estilização -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <!-- Cabeçalho principal da página -->
  <h1>Adicionar Tag</h1>

  <!-- Início do formulário para adicionar uma nova tag -->
  <form action="${pageContext.request.contextPath}/inserirTag" method="post">

    <!-- Campo para inserir a cor da tag -->
    <label for="cor">Cor:</label>
    <input type="text" id="cor" name="cor" required>

    <!-- Campo para inserir o gênero da tag -->
    <label for="genero">Genero:</label>
    <input type="text" id="genero" name="genero" placeholder="Menino ou Menina ou Unissex" required>

    <!-- Campo para inserir o tamanho da tag -->
    <label for="tamanho">Tamanho:</label>
    <input type="text" id="tamanho" name="tamanho" placeholder="P, G, GG, U" required>

    <!-- Campo para inserir a qualidade da tag -->
    <label for="qualidade">Qualidade:</label>
    <input type="text" id="qualidade" name="qualidade" required>

    <!-- Campo para inserir o ID da categoria da tag -->
    <label for="idcategoria">Id Categoria:</label>
    <input type="number" id="idcategoria" name="idcategoria" required>

    <!-- Botão de envio para adicionar a tag -->
    <input type="submit" value="Adicionar">
  </form>

  <!-- Link para voltar para a lista de tags -->
  <a href="${pageContext.request.contextPath}/tags" class="btn-back">Voltar para a Lista de Tags</a>
</div>
</body>
</html>
