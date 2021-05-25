<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Форум job4j</title>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #e3f2fd;">
    <a href="" class="navbar-brand">Forum</a>
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="<c:url value="/logout"/> " id="user">ВЫЙТИ: ${user}</a>
    </div>
</nav>

<div class="container mt-3">
    <div class="row сol-12 text-center">
        <h4>Тема: ${topic}</h4>
    </div>
    <br>
    <table class="table table-bordered">
        <thead class="text-center">
        <tr>
            <th>Комментарий</th>
            <th>Автор</th>
            <th>Дата создания</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${comments}" var="comment">
            <tr>
                <td>${comment.text}</td>
                <td class="text-center">${comment.author.username}</td>
                <td class="text-center">${comment.getCreatedFormat()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <div class="row justify-content-center text-center">
        <div class="col-6">
            <form action="<c:url value="/comments/save?tId=${tId}"/>" method="POST">
                <div class="form-group">
                    <textarea class="form-control" id="text" name="text" placeholder="Введите комментарий"></textarea>
                </div>
                <div class="form-group text-center">
                    <input type="submit" class="btn btn-primary" name="create" value="Отправить"/>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>