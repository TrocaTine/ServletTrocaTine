<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Título da página -->
  <title>Editar Comunidade</title>
  <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css"> <!-- Estilo -->
</head>
<body>

<div class="container">
<!-- Cabeçalho principal da página -->
<h1>Editar Comunidade</h1>

<!-- Formulário para editar a comunidade -->
<form action="${pageContext.request.contextPath}/editarComunidadePorID" method="post">

  <!-- Campo para o ID da comunidade -->
  <label for="id">ID:</label>
  <input type="number" name="id" id="id" required><br>

  <!-- Campo para o nome da comunidade -->
  <label for="nome">Nome:</label>
  <input type="text" name="nome" id="nome" required><br>

  <!-- Campo para o nome do criador da comunidade -->
  <label for="criador">Criador:</label>
  <input type="text" name="criador" id="criador" required><br>

  <!-- Campo para a descrição da comunidade -->
  <label for="descricao">Descrição:</label>
  <input type="text" name="descricao" id="descricao" required><br>

  <!-- Campo para a quantidade de integrantes -->
  <label for="qntIntegrantes">Quantidade de Integrantes:</label>
  <input type="number" name="qntIntegrantes" id="qntIntegrantes" required><br>

  <!-- Campo para a foto do perfil da comunidade -->
  <label for="fotoPerfil">Foto de Perfil:</label>
  <input type="number" name="fotoPerfil" id="fotoPerfil" required><br>

  <!-- Botão de envio do formulário -->
  <input type="submit" value="Editar">
</form>

<!-- Link para voltar à lista de comunidades -->
<a href="${pageContext.request.contextPath}/comunidade" class="btn-back">Voltar para a Lista de Comunidades</a>
</div>
</body>
</html>
