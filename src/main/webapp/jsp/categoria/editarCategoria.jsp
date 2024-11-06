<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Categoria</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloInserir.css"> <!-- CSS -->
</head>
<body>
<div class="container">
<h1>Editar Categoria</h1>

<!-- Formulário de edição da categoria -->
<form action="${pageContext.request.contextPath}/editarCatPorId" method="post">
    <!-- Campo para inserir o novo nome da categoria -->
    <label for="nome">Nome novo:</label>
    <input type="text" id="nome" name="nome" required><br>

    <!-- Campo para inserir o ID da categoria a ser editada -->
    <label for="id">ID:</label>
    <input type="number" id="id" name="id" required><br>

    <!-- Botão para submeter o formulário -->
    <input type="submit" value="Editar">
</form>

<!-- Link para voltar à lista de categorias -->
<a href="${pageContext.request.contextPath}/categoria" class="btn-back">Voltar para a Lista de Categorias</a>
</div>
</body>
</html>
