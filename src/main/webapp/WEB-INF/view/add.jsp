<!DOCTYPE HTML>
<html>

<body>
  <%
    boolean status = (Boolean)request.getAttribute("status");
    if(status)
        out.println("Successfully Inserted");
    else
        out.println("Failed to Inser");
    %>

</body>
</html>