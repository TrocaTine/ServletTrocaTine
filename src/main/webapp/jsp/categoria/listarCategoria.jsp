<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Categoria" %> <!-- Importe a classe correta para Categoria -->
<html>
<head>
    <title>Listar Categoria</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Listar Categoria</h1>
<table>
    <tr>
        <th>Nome</th>
        <th>ID</th>
    </tr>
    <%
        // Recupera a lista de categorias do atributo da requisição
        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
        if (categorias != null && !categorias.isEmpty()) {
            for (Categoria categoria : categorias) {
    %>
    <tr>
        <td><%= categoria.getTipoProduto() %></td>
        <td><%= categoria.getId() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Nenhuma categoria encontrada.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/categoria/adicionarCategoria.jsp'">Adicionar Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/excluirCategoria.jsp'">Excluir Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/buscarCategoria.jsp'">Buscar Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/editarCategoria.jsp'">Editar Categoria</button>
    <br>
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
