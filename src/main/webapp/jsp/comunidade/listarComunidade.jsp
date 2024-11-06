<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Comunidade" %>
<!-- Importe a classe correta para Comunidade -->
<html>
<head>
    <!-- Título da página -->
    <title>Listar Comunidade</title>

    <!-- Link para o arquivo CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<!-- Cabeçalho da página -->
<h1>Listar Comunidade</h1>

<!-- Tabela para exibir as comunidades -->
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
        // Recupera a lista de comunidades do atributo da requisição
        List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades");

        // Verifica se a lista de comunidades não está vazia
        if (comunidades != null && !comunidades.isEmpty()) {
            // Itera sobre a lista de comunidades para exibir os dados
            for (Comunidade comunidade : comunidades) {
    %>

    <!-- Exibe cada comunidade em uma linha da tabela -->
    <tr>
        <td><%= comunidade.getId() %></td>
        <td><%= comunidade.getNome() %></td>
        <td><%= comunidade.getCriador() %></td>
        <td><%= comunidade.getDescricao() %></td>
        <td><%= comunidade.getQntIntegrantes() %></td>
        <td><%= comunidade.getFotoPerfil() %></td>
    </tr>

    <%
        }
    } else {
    %>

    <!-- Caso não haja comunidades, exibe uma mensagem -->
    <tr>
        <td colspan="6">Nenhuma comunidade encontrada.</td>
    </tr>

    <%
        }
    %>
</table>

<!-- Botões de ação -->
<div class="button-container">
    <button class="button" onclick="location.href='jsp/comunidade/inserirComunidade.jsp'">Inserir Comunidade</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorID.jsp'">Excluir Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorNome.jsp'">Excluir Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorID.jsp'">Buscar Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorNome.jsp'">Buscar Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/editarComunidadePorId.jsp'">Editar Comunidade por ID</button>
    <br>

    <!-- Link para voltar à página do CRUD -->
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
