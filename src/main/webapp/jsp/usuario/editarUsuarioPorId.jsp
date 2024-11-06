<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Usuário</title>
    <!-- Link para o arquivo de estilo -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
    <!-- Título da página -->
    <h1>Editar Usuário</h1>

    <!-- Formulário para editar usuário -->
    <form action="${pageContext.request.contextPath}/editarUsuarioPorId" method="post">

        <!-- Campo para o ID do usuário -->
        <label for="id">Id do Usuário:</label>
        <input type="text" id="id" name="id" required>

        <!-- Campo para o nome do usuário -->
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <!-- Campo para o sobrenome do usuário -->
        <label for="sobrenome">Sobrenome:</label>
        <input type="text" id="sobrenome" name="sobrenome" required>

        <!-- Campo para o telefone do usuário -->
        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" required>

        <!-- Campo para a senha do usuário -->
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>

        <!-- Campo para o e-mail do usuário -->
        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" required>

        <!-- Campo para o CPF do usuário -->
        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required>

        <!-- Campo para a data de nascimento do usuário -->
        <label for="dt_nascimento">Data nascimento:</label>
        <input type="text" id="dt_nascimento" name="dt_nascimento" placeholder="yyyy-mm-dd" required>

        <!-- Campo para o endereço do usuário -->
        <label for="idendereco">Endereço:</label>
        <input type="text" id="idendereco" name="idendereco" required>

        <!-- Botão para enviar o formulário -->
        <input type="submit" value="Editar Usuario">
    </form>

    <!-- Link para voltar à lista de usuários -->
    <a href="${pageContext.request.contextPath}/usuario" class="btn-back">Voltar para a Lista de Usuários</a>
</div>
</body>
</html>
