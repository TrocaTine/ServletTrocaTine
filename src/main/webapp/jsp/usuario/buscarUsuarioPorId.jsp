<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Usuario" %> <!-- Importe a classe correta para Usuario -->
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Buscar Usuário por E-mail</title>
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
        form {
            margin-bottom: 30px;
        }
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #ffa201;
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
        input[type="submit"], .btn-back {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }
    </style>
</head>
<body>
<h1>Buscar Usuário por ID</h1>

<!-- Formulário de busca -->
<form action="${pageContext.request.contextPath}/buscarUsuarioPorId" method="GET">
    <input type="text" name="id" placeholder="Digite o ID do usuário" required>
    <input type="submit" value="BuscarUsuarioPorId">
</form>

<%
    // Recupera o usuário buscado do atributo da requisição
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario != null) {
%>
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
</table>
<%
} else {
%>
<p>Nenhum usuário encontrado com o ID informado.</p>
<%
    }
%>

<br>
<!-- Botão para voltar à lista de usuários -->
<a href="${pageContext.request.contextPath}/usuario" class="btn-back">Voltar para a Lista de Usuários</a>

</body>
</html>
