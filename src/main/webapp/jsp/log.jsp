<%@ page import="java.util.List" %>
<%@ page import="com.example.servlettrocatine.model.Log" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Relatorio</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estiloListar.css">
</head>
<body>
<h1>Relatório</h1>
<table>
    <tr>
        <th>Query</th>
        <th>Operacao</th>
        <th>Data</th>
        <th>Tabela</th>
        <th>Id do Admin</th>

    </tr>
    <%
        // Recupera a lista de adms do atributo da requisição
        List<Log> logs = (List<Log>) request.getAttribute("log");
        if (logs != null && !logs.isEmpty()) {
            for (Log log : logs) {
    %>
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
    <tr>
        <td colspan="2">Nenhuma query feita.</td>
    </tr>
    <%
        }
    %>
</table>
    <a href="${pageContext.request.contextPath}/jsp/pagCrud.jsp" class="btn-back">Voltar para à página do CRUD</a>
</body>
</html>
