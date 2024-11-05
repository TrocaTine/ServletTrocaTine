<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Adicionar Tag</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <h1>Adicionar Tag</h1>
  <form action="${pageContext.request.contextPath}/inserirTag" method="post">
    <label for="cor">Cor:</label>
    <input type="text" id="cor" name="cor" required>
    <label for="genero">Genero:</label>
    <input type="text" id="genero" name="genero" placeholder="Menino ou Menina ou Unissex" required>
    <label for="tamanho">Tamanho:</label>
    <input type="text" id="tamanho" name="tamanho" placeholder="P, G, GG, U" required>
    <label for="qualidade">Qualidade:</label>
    <input type="text" id="qualidade" name="qualidade" required>
    <label for="idcategoria">Id Categoria:</label>
    <input type="number" id="idcategoria" name="idcategoria" required>
    <input type="submit" value="Adicionar">
  </form>
  <a href="${pageContext.request.contextPath}/tags" class="btn-back">Voltar para a Lista de Tags</a>
</div>
</body>
</html>
