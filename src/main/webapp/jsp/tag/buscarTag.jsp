<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Tag" %>
<html>
<head>
    <!-- Título da página -->
    <title>Buscar Admin por ID</title>
    <link rel="icon" href="${pageContext.request.contextPath}/Assets/logo.png"> <!-- Favicon -->

    <!-- Estilo da página -->
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
<!-- Cabeçalho -->
<h1>Buscar Tag por ID</h1>

<!-- Formulário de busca -->
<form action="${pageContext.request.contextPath}/buscarTagPorId" method="GET">
    <input type="text" name="id" placeholder="Digite o ID do tag" required>
    <input type="submit" value="BuscarTag">
</form>

<%
    // Recupera a tag buscada do atributo da requisição
    Tag tag = (Tag) request.getAttribute("tag");
    String errorMessage = (String) request.getAttribute("errorMessage");

    // Verifica se uma tag foi encontrada
    if (tag != null) {
%>

<!-- Exibe os detalhes da tag -->
<table>
    <tr>
        <th>ID</th>
        <th>Cor</th>
        <th>Genero</th>
        <th>Qualidade</th>
        <th>Tamanho</th>
        <th>ID Categoria</th>
    </tr>
    <tr>
        <td><%= tag.getId() %></td>
        <td><%= tag.getCor() %></td>
        <td><%= tag.getGenero() %></td>
        <td><%= tag.getQualidade() %></td>
        <td><%= tag.getTamanho() %></td>
        <td><%= tag.getIdCategoria() %></td>
    </tr>
</table>

<%
} else if (errorMessage != null) {
%>

<!-- Exibe uma mensagem de erro caso a tag não tenha sido encontrada -->
<p class="error-message"><%= errorMessage %></p>

<%
    }
%>

<!-- Botão de voltar -->
<a href="${pageContext.request.contextPath}/adms" class="btn-back">Voltar para a Lista de Adms</a>
</body>
</html>
