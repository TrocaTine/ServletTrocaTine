<%@ page import="java.util.List" %> <!-- Importa a classe List para manipulação de listas -->
<%@ page import="com.example.servlettrocatine.model.Log" %> <!-- Importa a classe Log do pacote especificado -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <!-- Define o tipo de conteúdo da página e a codificação de caracteres -->

<html>
<head>
    <title>Relatorio</title>
    <!-- Link para o arquivo de estilos CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
    <link rel="icon" href="../Assets/logo.png"> <!-- Favicon -->
</head>
<body>

<h1>Relatório</h1>
<!-- Tabela que exibirá os dados do log -->
<table>
    <tr>
        <!-- Cabeçalhos das colunas da tabela -->
        <th>Query</th>
        <th>Operacao</th>
        <th>Data</th>
        <th>Tabela</th>
        <th>Id do Admin</th>
    </tr>

    <%
        // Recupera a lista de logs do atributo da requisição
        List<Log> logs = (List<Log>) request.getAttribute("log");

        // Verifica se a lista de logs não é nula e contém elementos
        if (logs != null && !logs.isEmpty()) {
            // Itera sobre a lista de logs para exibir os dados
            for (Log log : logs) {
    %>
    <!-- Exibe uma linha para cada log com os dados respectivos -->
    <tr>
        <td><%= log.getData() %></td>
        <td><%= log.getOperacao() %></td>
        <td><%= log.getQuery() %></td>
        <td><%= log.getTabela() %></td>
        <td><%= log.getIdadm() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <!-- Caso a lista de logs esteja vazia ou nula, exibe uma mensagem indicando que não há logs -->
    <tr>
        <td colspan="5">Nenhuma query feita.</td>
    </tr>
    <%
        }
    %>
</table>

<!-- Link para voltar à página de CRUD -->
<a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>

</body>
</html>
