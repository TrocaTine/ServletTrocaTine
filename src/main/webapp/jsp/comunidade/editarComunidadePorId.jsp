<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Título da página -->
  <title>Editar Comunidade</title>
  <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
  <style>
    /* Estilos gerais do corpo da página */
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      text-align: center;
      padding: 50px;
    }

    /* Estilo do título principal */
    h1 {
      color: #333;
      margin-bottom: 30px;
    }

    /* Estilo do formulário */
    form {
      margin-bottom: 30px;
    }

    /* Estilo para campos de texto e número */
    input[type="text"], input[type="number"] {
      padding: 10px;
      font-size: 16px;
      width: 300px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 10px;
    }

    /* Estilo para os botões de envio e voltar */
    input[type="submit"], .btn-back {
      padding: 10px 20px;
      font-size: 16px;
      background-color: #55aca0;
      color: white;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      text-decoration: none;
    }

    /* Efeito de hover nos botões */
    input[type="submit"]:hover, .btn-back:hover {
      background-color: #ffa201;
    }

    /* Estilo para o botão de voltar */
    .btn-back {
      display: inline-block;
      margin-top: 20px;
    }
  </style>
</head>
<body>

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

</body>
</html>
