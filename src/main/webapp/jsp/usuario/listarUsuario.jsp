<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Usuario" %> <!-- Importe a classe correta para Usuario -->
<html>
<head>
    <title>Listar Usuário</title>
    <!-- Estilo da página -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<!-- Título da página -->
<h1>Listar Usuário</h1>

<!-- Tabela para exibição dos usuários -->
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Sobrenome</th>
        <th>Telefone</th>
        <th>Senha</th>
        <th>Trocadinhas</th>
        <th>E-mail</th>
        <th>CPF</th>
        <th>Data nascimento</th>
        <th>ID do Endereço</th>
    </tr>
    <%
        // Recupera a lista de usuários do atributo da requisição
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        // Verifica se a lista não está vazia
        if (usuarios != null && !usuarios.isEmpty()) {
            // Itera sobre a lista de usuários
            for (Usuario usuario : usuarios) {
    %>
    <tr>
        <!-- Exibe os dados do usuário -->
        <td><%= usuario.getId() %></td>
        <td><%= usuario.getNome() %></td>
        <td><%= usuario.getSobrenome() %></td>
        <td><%= usuario.getTelefone() %></td>
        <td><%= usuario.getSenha() %></td>
        <td><%= usuario.getTrocadinhas() %></td>
        <td><%= usuario.getEmail() %></td>
        <td><%= usuario.getCpf() %></td>
        <td><%= usuario.getDtNascimento() %></td>
        <td><%= usuario.getIdEndereco() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <!-- Mensagem caso não haja usuários -->
        <td colspan="10">Nenhum usuário encontrado.</td>
    </tr>
    <%
        }
    %>
</table>

<!-- Botões para ações de CRUD -->
<div class="button-container">
    <button class="button" onclick="location.href='jsp/usuario/adicionarUsuario.jsp'">Adicionar Usuário</button>
    <button class="button" onclick="location.href='jsp/usuario/excluirUsuarioPorId.jsp'">Excluir Usuário</button>
    <button class="button" onclick="location.href='jsp/usuario/buscarUsuarioPorId.jsp'">Buscar por ID</button>
    <button class="button" onclick="location.href='jsp/usuario/buscarUsuarioPorEmail.jsp'">Buscar por E-mail</button>
    <button class="button" onclick="location.href='jsp/usuario/editarUsuarioPorId.jsp'">Editar Usuário</button>

    <!-- Link para voltar à página do CRUD -->
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</div>
</body>
</html>
