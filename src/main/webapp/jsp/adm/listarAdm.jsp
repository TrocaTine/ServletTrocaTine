<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Adm" %>
<html>
<head>
    <title>Listar Adm</title>
    <!-- Link para o arquivo CSS de estilização da página -->
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Listar Adm</h1>

<!-- Tabela para exibir os administradores cadastrados -->
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Senha</th>
        <th>Id do Usuario</th>
    </tr>

    <%
        // Recupera a lista de administradores do atributo da requisição
        List<Adm> adms = (List<Adm>) request.getAttribute("adms");

        // Verifica se a lista de administradores não está vazia
        if (adms != null && !adms.isEmpty()) {
            // Loop para exibir cada administrador na tabela
            for (Adm adm : adms) {
    %>
    <tr>
        <td><%= adm.getId() %></td>
        <td><%= adm.getNome() %></td>
        <td><%= adm.getEmail() %></td>
        <td><%= adm.getSenha() %></td>
        <td><%= adm.getIdUsuario() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="5">Nenhum administrador cadastrado.</td>
    </tr>
    <%
        }
    %>
</table>

<!-- Botões para navegação entre as páginas -->
<div class="button-container">
    <button class="button" onclick="location.href='jsp/adm/adicionarAdm.jsp'">Adicionar Administrador</button>
    <button class="button" onclick="location.href='jsp/adm/excluirAdm.jsp'">Excluir Administrador</button>
    <button class="button" onclick="location.href='jsp/adm/buscarAdm.jsp'">Buscar Administrador</button>
    <button class="button" onclick="location.href='jsp/adm/editarAdm.jsp'">Editar Administrador</button>
    <br>
    <!-- Link para voltar à página principal do CRUD -->
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
