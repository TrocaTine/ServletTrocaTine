<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crud TrocaTIne</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/pagCrud.css">
</head>
<a href="${pageContext.request.contextPath}/jsp/login.jsp" class="btn-back">Voltar</a>

<body>
<h1>Bem-vindo ao CRUD do TrocaTine!</h1>
<h1>Escolha qual tabela você quer acessar:</h1>
<div class="button-container">
    <a href="../adms" >Administrador</a>
    <a href="../categoria" >Categoria</a>
    <a href="../comunidade" >Comunidade</a>
    <a href="../tags" >Tag</a>
    <a href="../usuario" >Usuário</a>
    <a href="../log" >Relatório</a>
</div>
</body>
</html>
