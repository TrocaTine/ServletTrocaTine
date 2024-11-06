<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Categoria" %> <!-- Importe a classe correta para Categoria -->
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Comunidade" %> <!-- Importe a classe correta para Comunidade -->

<html>
<head>
    <title>Buscar Categoria por ID</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->
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

<h1>Buscar Categoria por ID</h1>

<!-- Formulário de busca -->
<form action="${pageContext.request.contextPath}/buscarComunidadePorID" method="GET">
    <input type="text" name="id" placeholder="Digite o ID da comunidade" required>
    <input type="submit" value="Buscar">
</form>

<%
    // Recupera a comunidade buscada do atributo da requisição
    Comunidade comunidade = (Comunidade) request.getAttribute("comunidades");

    // Se a comunidade foi encontrada, exibe os dados dela
    if (comunidade != null) {
%>
<!-- Exibe os dados da comunidade em uma tabela -->
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Criador</th>
        <th>Descrição</th>
        <th>Quantidade de Integrantes</th>
        <th>Foto de Perfil</th>
    </tr>
    <tr>
        <td><%= comunidade.getId() %></td>
        <td><%= comunidade.getNome() %></td>
        <td><%= comunidade.getCriador() %></td>
        <td><%= comunidade.getDescricao() %></td>
        <td><%= comunidade.getQntIntegrantes() %></td>
        <td><%= comunidade.getFotoPerfil() %></td>
    </tr>
</table>
<%
} else {
%>
<!-- Caso não seja encontrada nenhuma comunidade, exibe uma mensagem -->
<p>Nenhuma comunidade encontrada com o ID informado.</p>
<%
    }
%>
<!-- Botão de voltar -->
<a href="${pageContext.request.contextPath}/comunidade" class="btn-back">Voltar para a Lista de Adms</a>
</body>
</html>
