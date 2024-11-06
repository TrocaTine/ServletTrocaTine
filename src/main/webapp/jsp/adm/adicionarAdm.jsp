<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Administrador</title>
    <!-- Estilo CSS para a página -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
    <h1>Adicionar Administrador</h1>

    <!-- Formulário para adicionar o administrador -->
    <form action="${pageContext.request.contextPath}/inserirAdm" method="post">
        <!-- Campo para o nome do administrador -->
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <!-- Campo para o e-mail do administrador -->
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <!-- Campo para a senha do administrador -->
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>

        <!-- Campo para o idUsuario, que pode ser um número -->
        <label for="idUsuario">ID do Usuário:</label>
        <input type="number" id="idUsuario" name="idUsuario" required>

        <!-- Botão de envio do formulário -->
        <input type="submit" value="Adicionar">
    </form>

    <!-- Link para voltar à lista de administradores -->
    <a href="${pageContext.request.contextPath}/adms" class="btn-back">Voltar para a Lista de Administradores</a>
</div>
</body>
</html>
