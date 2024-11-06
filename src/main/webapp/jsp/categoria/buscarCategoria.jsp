<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlettrocatine.model.Categoria" %> <!-- Importe a classe correta para Categoria -->
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Buscar Categoria por ID</title>
    <style>
        /* Estilos para o corpo da página */
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            padding: 50px;
        }

        /* Estilo para o título */
        h1 {
            color: #333;
            margin-bottom: 30px;
        }

        /* Estilos para o formulário */
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

        /* Estilo para o botão de submit */
        input[type="submit"] {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #55aca0;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* Efeito de hover no botão de submit */
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

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        /* Estilo para o cabeçalho da tabela */
        th {
            background-color: #55aca0;
            color: white;
        }

        /* Estilos para as linhas da tabela */
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ffa201;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Buscar Categoria por ID</h1>

<!-- Formulário de busca -->
<form action="${pageContext.request.contextPath}/buscarPorID" method="GET">
    <!-- Campo para inserir o ID da categoria -->
    <input type="text" name="id" placeholder="Digite o ID da categoria" required>
    <!-- Botão para submeter o formulário -->
    <input type="submit" value="Buscar">
</form>

<%
    // Recupera a categoria buscada do atributo da requisição
    Categoria categoria = (Categoria) request.getAttribute("categoria");

    // Verifica se a categoria foi encontrada
    if (categoria != null) {
%>
<!-- Exibe a categoria encontrada em uma tabela -->
<table>
    <tr>
        <th>Nome</th>
        <th>ID</th>
    </tr>
    <tr>
        <!-- Exibe os dados da categoria -->
        <td><%= categoria.getTipoProduto() %></td>
        <td><%= categoria.getId() %></td>
    </tr>
</table>
<%
} else {
%>
<!-- Mensagem caso nenhuma categoria seja encontrada -->
<p>Nenhuma categoria encontrada com o ID informado.</p>
<%
    }
%>
</body>
</html>
