<!DOCTYPE HTML>
<html>

<body>
  <%
    boolean status = (Boolean)request.getAttribute("status");
    if(status)
        out.println("Successfully Updated");
    else
        out.println("Failed to Update");
    %>

</body>
</html>