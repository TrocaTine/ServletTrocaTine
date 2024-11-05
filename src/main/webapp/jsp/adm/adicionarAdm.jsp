<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Categoria</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css">
</head>
<body>
<div class="container">
    <h1>Adicionar Administrador</h1>
    <form action="${pageContext.request.contextPath}/inserirAdm" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
        <label for="senha">Senha:</label>
        <input type="password" id="senha" name="senha" required>
        <label for="idUsuario">idUsuario:</label>
        <input type="number" id="idUsuario" name="idUsuario" required>
        <input type="submit" value="Adicionar">
    </form>
    <a href="${pageContext.request.contextPath}/adms" class="btn-back">Voltar para a Lista de Administradores</a>
</div>
</body>
</html>
