<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Tag" %>
<html>
<head>
    <!-- Título da página -->
    <title>Listar Todas as Tags</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->

    <!-- Link para o arquivo de CSS para estilização -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>

<!-- Cabeçalho da página -->
<h1>Lista de Todas as Tags</h1>

<!-- Tabela para exibir as tags -->
<table>
    <!-- Cabeçalho da tabela -->
    <tr>
        <th>ID</th>
        <th>Gênero</th>
        <th>Cor</th>
        <th>Tamanho</th>
        <th>Qualidade</th>
        <th>ID Categoria</th>
    </tr>

    <%
        // Recupera a lista de tags da requisição
        List<Tag> tags = (List<Tag>) request.getAttribute("tags");

        // Verifica se a lista de tags não está vazia
        if (tags != null && !tags.isEmpty()) {
            // Itera sobre a lista de tags e exibe cada uma na tabela
            for (Tag tag : tags) {
    %>
    <!-- Linha da tabela para cada tag -->
    <tr>
        <td><%= tag.getId() %></td>
        <td><%= tag.getGenero() %></td>
        <td><%= tag.getCor() %></td>
        <td><%= tag.getTamanho() %></td>
        <td><%= tag.getQualidade() %></td>
        <td><%= tag.getIdCategoria() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <!-- Caso não haja tags, exibe uma mensagem informando -->
    <tr>
        <td colspan="6" class="no-data">Nenhuma tag encontrada.</td>
    </tr>
    <%
        }
    %>
</table>

<!-- Botões para ações relacionadas às tags -->
<div class="button-container">
    <!-- Botão para adicionar uma nova tag -->
    <button class="button" onclick="location.href='jsp/tag/inserirTag.jsp'">Adicionar Tag</button>

    <!-- Botão para excluir uma tag -->
    <button class="button" onclick="location.href='jsp/tag/excluirTagPorId.jsp'">Excluir Tag</button>

    <!-- Botão para buscar uma tag por ID -->
    <button class="button" onclick="location.href='jsp/tag/buscarTag.jsp'">Buscar Tag por ID</button>

    <!-- Botão para editar uma tag -->
    <button class="button" onclick="location.href='jsp/tag/editarTagPorId.jsp'">Editar Tag</button>

    <br>

    <!-- Link para voltar à página do CRUD -->
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>

</body>
</html>
