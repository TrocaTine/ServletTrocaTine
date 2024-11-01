<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Usuario" %> <!-- Importe a classe correta para Usuario -->
<html>
<head>
    <title>Listar Usuário</title>
    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            padding: 50px;
        }
        h1 {
            color: #333;
            margin-bottom: 30px;
        }
        table {
            width: 60%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #55aca0;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ffa201;
            cursor: pointer;
        }
        .button-container {
            margin-top: 20px; /* Espaçamento acima dos botões */
            display: flex; /* Exibe os botões em linha */
            justify-content: center; /* Centraliza os botões horizontalmente */
        }
        .button {
            background-color: #55aca0; /* Cor do botão */
            color: white; /* Cor do texto */
            border: none; /* Sem borda */
            padding: 10px 20px; /* Espaçamento interno */
            text-align: center; /* Centraliza o texto */
            text-decoration: none; /* Remove o sublinhado */
            display: inline-block; /* Faz o botão se comportar como um bloco */
            font-size: 16px; /* Tamanho da fonte */
            margin: 0 10px; /* Margens entre os botões */
            cursor: pointer; /* Muda o cursor para indicar que é clicável */
            border-radius: 5px; /* Cantos arredondados */
            transition: background-color 0.3s; /* Efeito de transição */
        }
        .button:hover {
            background-color: #ffa201; /* Cor do botão ao passar o mouse */
        }
        .btn-back {
            display: inline-block;
            background-color: #f0f0f0;
            color: #ffa201;
            text-decoration: none;
            padding: 10px 20px;
            border: 1px solid #ffa201;
            border-radius: 5px;
            font-size: 16px;
            margin-top: 10px;
            transition: background-color 0.3s, color 0.3s;
        }
        .btn-back:hover {
            background-color: #ffa201;
            color: #fff;
        }
    </style>
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
