<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Adicionar Usuario</title>
  <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
  <!-- Link para o arquivo de estilo CSS -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
  <!-- Título da página -->
  <h1>Adicionar Usuario</h1>

  <!-- Formulário para adicionar um novo usuário -->
  <form action="${pageContext.request.contextPath}/adicionarUsuario" method="post">

    <!-- Campo de entrada para o nome do usuário -->
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para o sobrenome do usuário -->
    <label for="sobrenome">Sobrenome:</label>
    <input type="text" id="sobrenome" name="sobrenome" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para o telefone do usuário -->
    <label for="telefone">Telefone:</label>
    <input type="text" id="telefone" name="telefone" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para a senha do usuário -->
    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para o e-mail do usuário -->
    <label for="email">E-mail:</label>
    <input type="email" id="email" name="email" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para o CPF do usuário -->
    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" placeholder="xxx.xxx.xxx-xx"> <!-- Campo obrigatório -->

    <!-- Campo de entrada para a data de nascimento do usuário -->
    <label for="dt_nascimento">Data nascimento:</label>
    <input type="text" id="dt_nascimento" name="dt_nascimento" placeholder="yyyy-mm-dd" required> <!-- Campo obrigatório -->

    <!-- Campo de entrada para o ID do endereço (não obrigatório) -->
    <label for="idendereco">Endereço:</label>
    <input type="text" id="idendereco" name="idendereco">

    <!-- Botão de envio do formulário -->
    <input type="submit" value="Adicionar Usuario">
  </form>

  <!-- Link para voltar à lista de usuários -->
  <a href="${pageContext.request.contextPath}/usuario" class="btn-back">Voltar para a Lista de Usuários</a>
</div>
</body>
</html>
