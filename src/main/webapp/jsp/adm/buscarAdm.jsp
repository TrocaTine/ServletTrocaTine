<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Adm" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Buscar Admin por ID</title>
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
        .error-message {
            color: red;
            margin-top: 20px;
        }
    </style>
</head>
<body>
<h1>Buscar Administrador por ID</h1>

<!-- Formulário de busca -->
<form action="${pageContext.request.contextPath}/buscarAdm" method="GET">
    <input type="text" name="id" placeholder="Digite o ID do admin" required>
    <input type="submit" value="BuscarAdm">
</form>

<%
    // Recupera o administrador buscado do atributo da requisição
    Adm adm = (Adm) request.getAttribute("adm");
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (adm != null) {
%>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Email</th>
        <th>Senha</th>
        <th>ID do Usuário</th>
    </tr>
    <tr>
        <td><%= adm.getId() %></td>
        <td><%= adm.getNome() %></td>
        <td><%= adm.getEmail() %></td>
        <td><%= adm.getSenha() %></td>
        <td><%= adm.getIdUsuario() %></td>
    </tr>
</table>
<%
} else if (errorMessage != null) {
%>
<p class="error-message"><%= errorMessage %></p>
<%
    }
%>
</body>
</html>
