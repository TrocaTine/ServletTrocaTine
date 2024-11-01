<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Tag" %>
<html>
<head>
    <title>Listar Todas as Tags</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Lista de Todas as Tags</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Gênero</th>
        <th>Cor</th>
        <th>Tamanho</th>
        <th>Qualidade</th>
        <th>ID Categoria</th>
    </tr>
    <%
        List<Tag> tags = (List<Tag>) request.getAttribute("tags");
        if (tags != null && !tags.isEmpty()) {
            for (Tag tag : tags) {
    %>
    <tr>
        <td><%= tag.getId() %></td>
        <td><%= tag.getGenero() %></td>
        <td><%= tag.getCor() %></td>
        <td><%= tag.getTamanho() %></td>
        <td><%= tag.getQualidade() %></td>
        <td><%= tag.getIdTipo_produto() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="6" class="no-data">Nenhuma tag encontrada.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/tag/inserirTag.jsp'">Adicionar Tag</button>
    <button class="button" onclick="location.href='jsp/tag/excluirTagPorId.jsp'">Excluir Tag</button>
    <button class="button" onclick="location.href='jsp/tag/buscarTag.jsp'">Buscar Tag por ID</button>
    <button class="button" onclick="location.href='jsp/tag/editarTagPorId.jsp'">Editar Tag</button>
    <br>
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
