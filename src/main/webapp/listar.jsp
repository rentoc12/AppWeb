<%@ page import="java.util.List" %>
<%@ page import="model.Produto" %>
<%
  List<Produto> lista = (List<Produto>) request.getAttribute("lista"); 
%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Lista</title></head>
<body>
  <h2>Produtos cadastrados</h2>
  <table border="1">
    <tr><th>ID</th><th>Nome</th><th>Preço</th></tr>
    <% if (lista != null && !lista.isEmpty()) {
         for (Produto p : lista) { %>
           <tr>
             <td><%=p.getId()%></td>
             <td><%=p.getNome()%></td>
             <td><%=p.getPreco()%></td>
           </tr>
    <%   } } else { %>
           <tr><td colspan="3">Nenhum produto cadastrado</td></tr>
    <% } %>
  </table>
  <a href="index.jsp">Voltar</a>
</body>
</html>
