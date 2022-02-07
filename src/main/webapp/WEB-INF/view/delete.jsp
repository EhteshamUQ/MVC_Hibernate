<!DOCTYPE HTML>
<html>

<body>
  <%
    boolean status = (Boolean)request.getAttribute("status");
    if(status)
        out.println("Successfully Deleted");
    else
        out.println("Failed to delete");
    %>

</body>
</html>