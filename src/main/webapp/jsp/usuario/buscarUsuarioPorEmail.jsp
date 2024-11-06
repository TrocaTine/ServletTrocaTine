<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Usuario" %> <!-- Importe a classe Usuario -->
<%@ page import="java.util.List" %> <!-- Importe List caso seja necessário -->

<html>
<head>
    <title>Buscar Usuário por E-mail</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
    <style>
        /* Estilos para o corpo da página */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            padding: 50px;
        }

        /* Estilos para o título */
        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        /* Estilos para o formulário */
        form {
            margin-bottom: 30px;
        }

        /* Estilos para o campo de entrada de texto */
        input[type="text"] {
            padding: 10px;
            font-size: 16px;
            width: 300px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        /* Estilos para o botão de envio */
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Efeito hover para o botão de envio */
        input[type="submit"]:hover {
            background-color: #ffa201;
        }

        /* Estilos para a tabela */
        table {
            width: 60%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* Estilos para as células da tabela */
        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        /* Estilos para os cabeçalhos da tabela */
        th {
            background-color: #55aca0;
            color: white;
        }

        /* Estilos para as linhas alternadas da tabela */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        /* Efeito hover para as linhas da tabela */
        tr:hover {
            background-color: #ffa201;
            cursor: pointer;
        }

        /* Estilos para o botão de voltar */
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
<!-- Título principal -->
<h1>Buscar Usuário por E-mail</h1>

<!-- Formulário para buscar usuário pelo e-mail -->
<form action="${pageContext.request.contextPath}/buscarUsuarioPorEmail" method="GET">
    <input type="text" name="email" placeholder="Digite o e-mail do usuário" required>
    <input type="submit" value="Buscar Usuario">
</form>

<%
    // Recupera o usuário buscado da requisição
    Usuario usuario = (Usuario) request.getAttribute("usuario");

    // Se o usuário for encontrado, exibe os dados
    if (usuario != null) {
%>
<!-- Tabela para exibir as informações do usuário -->
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
    </tr>
    <tr>
        <td><%= usuario.getId() %></td>
        <td><%= usuario.getNome() %></td>
        <td><%= usuario.getSobrenome() %></td>
        <td><%= usuario.getTelefone() %></td>
        <td><%= usuario.getSenha() %></td>
        <td><%= usuario.getTrocadinhas() %></td>
        <td><%= usuario.getEmail() %></td>
        <td><%= usuario.getCpf() %></td>
        <td><%= usuario.getDtNascimento() %></td>
    </tr>
</table>
<%
} else {
%>
<!-- Mensagem caso nenhum usuário seja encontrado -->
<p>Nenhum usuário encontrado com o e-mail informado.</p>
<%
    }
%>

<br>
<!-- Link para voltar à lista de usuários -->
<a href="${pageContext.request.contextPath}/usuario" class="btn-back">Voltar para a Lista de Usuários</a>

</body>
</html>
