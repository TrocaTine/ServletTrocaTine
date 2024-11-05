<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
    <h1>Editar Usuário</h1>
    <form action="${pageContext.request.contextPath}/editarUsuarioPorId" method="post">
        <label for="id">Id do Usuário:</label>
        <input type="text" id="id" name="id" required>

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="sobrenome">Sobrenome:</label>
        <input type="text" id="sobrenome" name="sobrenome" required>

        <label for="telefone">Telefone:</label>
        <input type="text" id="telefone" name="telefone" required>

        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>

        <label for="email">E-mail:</label>
        <input type="email" id="email" name="email" required>

        <label for="cpf">CPF:</label>
        <input type="text" id="cpf" name="cpf" required>

        <label for="dt_nascimento">Data nascimento:</label>
        <input type="text" id="dt_nascimento" name="dt_nascimento" placeholder="yyyy-mm-dd" required>

        <label for="idendereco">Endereço:</label>
        <input type="text" id="idendereco" name="idendereco">

        <input type="submit" value="Editar Usuario">
    </form>

    <!-- Botão para voltar à lista de usuários -->
    <a href="${pageContext.request.contextPath}/usuario" class="btn-back">Voltar para a Lista de Usuários</a>
</div>
</body>
</html>
