<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Categoria" %> <!-- Importe a classe correta para Categoria -->
<html>
<head>
    <title>Listar Categoria</title>
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
    </style>
</head>
<body>
<h1>Listar Categoria</h1>
<table>
    <tr>
        <th>Nome</th>
        <th>ID</th>
    </tr>
    <%
        // Recupera a lista de categorias do atributo da requisição
        List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");
        if (categorias != null && !categorias.isEmpty()) {
            for (Categoria categoria : categorias) {
    %>
    <tr>
        <td><%= categoria.getTipoProduto() %></td>
        <td><%= categoria.getId() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Nenhuma categoria encontrada.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/categoria/AdicionarCategoria.jsp'">Adicionar Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/ExcluirCategoria.jsp'">Excluir Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/BuscarCategoria.jsp'">Buscar Categoria</button>
    <button class="button" onclick="location.href='jsp/categoria/EditarCategoria.jsp'">Editar Categoria</button>
</div>
</body>
</html>
