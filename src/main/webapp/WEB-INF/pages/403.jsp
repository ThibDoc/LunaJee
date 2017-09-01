<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Access Denied</title>
    </head>
    <body>
        <h1>Access Denied for ${pageContext.request.userPrincipal.name}!!!</h1>
        <a href="index">Back</a>
    </body>
</html>