<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Usuario" %> <!-- Importe a classe correta para Usuario -->
<html>
<head>
    <title>Listar Usuário</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Listar Usuário</h1>
<table>
    <tr>
        <th>Nome</th>
        <th>Telefone</th>
        <th>Senha</th>
        <th>Trocadinhas</th>
        <th>E-mail</th>
        <th>CPF</th>
        <th>Data nascimento</th>
        <th>ID</th>
    </tr>
    <%
        // Recupera a lista do usuarios do atributo da requisição
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        if (usuarios != null && !usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
    %>
    <tr>
        <td><%= usuario.getNome() %></td>
        <td><%= usuario.getTelefone() %></td>
        <td><%= usuario.getSenha() %></td>
        <td><%= usuario.getTrocadinhas() %></td>
        <td><%= usuario.getEmail() %></td>
        <td><%= usuario.getCpf() %></td>
        <td><%= usuario.getDtNascimento() %></td>
        <td><%= usuario.getId() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Nenhum usuário encontrado.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/usuario/adicionarUsuario.jsp'">Adicionar Usuário</button>
    <button class="button" onclick="location.href='jsp/usuario/excluirUsuarioPorId.jsp'">Excluir Usuário</button>
    <button class="button" onclick="location.href='jsp/usuario/buscarUsuarioPorId.jsp'">Buscar por ID</button>
    <button class="button" onclick="location.href='jsp/usuario/buscarUsuarioPorEmail.jsp'">Buscar por E-mail</button>
    <button class="button" onclick="location.href='jsp/usuario/editarUsuarioPorId.jsp'">Editar Usuário</button>
    <!-- Botão para voltar à página do CRUD -->
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
