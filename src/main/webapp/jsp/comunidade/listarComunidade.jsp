<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Comunidade" %>
<!-- Importe a classe correta para Comunidade -->
<html>
<head>
    <title>Listar Comunidade</title>
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
<h1>Listar Comunidade</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Criador</th>
        <th>Descrição</th>
        <th>Quantidade de Integrantes</th>
        <th>Foto de Perfil</th>
    </tr>
    <%
        // Recupera a lista de categorias do atributo da requisição
        List<Comunidade> comunidades = (List<Comunidade>) request.getAttribute("comunidades");
        if (comunidades != null && !comunidades.isEmpty()) {
            for (Comunidade comunidade : comunidades) {
    %>
    <tr>
        <td><%= comunidade.getId()%></td>
        <td><%= comunidade.getNome()%></td>
        <td><%= comunidade.getCriador()%></td>
        <td><%= comunidade.getDescricao()%></td>
        <td><%= comunidade.getQntIntegrantes()%></td>
        <td><%= comunidade.getFotoPerfil()%></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="2">Nenhuma comunidade encontrada.</td>
    </tr>
    <%
        }
    %>
</table>
<div class="button-container">
    <button class="button" onclick="location.href='jsp/comunidade/inserirComunidade.jsp'">Inserir Comunidade</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorID.jsp'">Excluir Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/excluirComunidadePorNome.jsp'">Excluir Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorID.jsp'">Buscar Comunidade por ID</button>
    <button class="button" onclick="location.href='jsp/comunidade/buscarComunidadePorNome.jsp'">Buscar Comunidade por Nome</button>
    <button class="button" onclick="location.href='jsp/comunidade/editarComunidadePorId.jsp'">Editar Comunidade por ID</button>

</div>
</body>
</html>
