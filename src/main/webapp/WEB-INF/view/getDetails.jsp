<html>
<body>
<h2> Edit Student Details </h2>
<form action="update">
    <input type = "text" name="firstName" value=<%= request.getAttribute("firstName") %> /> <br />
    <input type = "text" name="lastName" value= <%= request.getAttribute("lastName") %> /> <br />
    <input type = "text" name="email"  value=<%= request.getAttribute("email") %> /> <br />
    <input type = "number" name="id"   value= <%= request.getAttribute("id") %> readonly /> <br />
    <input type = "submit" /> <br />
</form>
</body>
</html>
