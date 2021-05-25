<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="ru">
<head>
    <title>Sign up</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<header class="header">
    <div class="overlay">
        <div class="container">
            <div class="card mx-auto mb-5 my-5" style="max-width: 40%;">
                <div class="card-header text-center">
                    <h2>Sign up</h2>
                </div>
                <div class="card-body">
                    <c:if test="${not empty errorMessage}">
                        <div style="color:red; font-weight: bold; margin: 30px 0px;">
                                ${errorMessage}
                        </div>
                    </c:if>
                    <form action="<c:url value="/reg"/>" method="POST">
                        <div class="form-group">
                            <label for="username" class="control-label">Login:</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="Enter login">
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-xs-2 control-label">Password:</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-xs-2 control-label">Email:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter email">
                        </div>
                        <div class="form-group text-center">
                            <input type="submit" class="btn btn-primary" name="Sign up" value="Sign up"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>