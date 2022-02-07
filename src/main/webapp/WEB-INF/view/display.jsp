<!DOCTYPE HTML>
<%@ page import="java.util.*"  %>
<html>

<body>
  <%
   List studentList= (ArrayList)request.getAttribute("studentList");
   for(Object student : studentList)
    out.println(student + "<br />");
  %>

</body>
</html>