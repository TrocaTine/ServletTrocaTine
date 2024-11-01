<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Comunidade" %>
<!-- Importe a classe correta para Comunidade -->
<html>
<head>
    <title>Listar Comunidade</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Listar Comunidade</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Criador</th>
        <th>Descrição</th>
        <th>Quantidade de Integrantes</th>
        <th>Foto de Perfil</th>
    </tr>
    <%
        // Recupera a lista de categorias do atributo da requisição
        List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades");
        if (comunidades != null && !comunidades.isEmpty()) {
            for (Comunidade comunidade : comunidades) {
    %>
    <tr>
        <td><%= comunidade.getId()%></td>
        <td><%= comunidade.getNome()%></td>
        <td><%= comunidade.getCriador()%></td>
        <td><%= comunidade.getDescricao()%></td>
        <td><%= comunidade.getQntIntegrantes()%></td>
        <td><%= comunidade.getFotoPerfil()%></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Nenhuma comunidade encontrada.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/comunidade/inserirComunidade.jsp'">Inserir Comunidade</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorID.jsp'">Excluir Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorNome.jsp'">Excluir Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorID.jsp'">Buscar Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorNome.jsp'">Buscar Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/editarComunidadePorId.jsp'">Editar Comunidade por ID</button>
    <br>
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>

</div>
</body>
</html>
