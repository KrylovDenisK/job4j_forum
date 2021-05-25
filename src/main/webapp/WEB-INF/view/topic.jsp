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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Форум job4j</title>
    <script>
        function createTopic() {
            window.location.href = '<c:url value="/topics/create?pId=${pId}"/>';
        }
    </script>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-light" style="background-color: #e3f2fd;">
    <a href="<c:url value="/"/>" class="navbar-brand">Forum</a>
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="<c:url value="/logout"/>" id="user">ВЫЙТИ: ${user}</a>
    </div>
</nav>
<div class="container mt-3">
    <div class="row">
        <div class="col text-center">
            <h4>Раздел: ${postName}</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-3">
            <input type="button" class="btn btn-success" onclick="createTopic()" value="Создать тему"/>
        </div>
        <br>
    </div>
    <br>
    <div class="row">
        <table class="table table-bordered">
            <thead class="text-center">
            <tr>
                <th>Тема</th>
                <th>Описание</th>
                <th>Владелец</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${topics}" var="topic">
                <tr>
                    <td>
                        <a href="<c:url value="/topics/edit?tId=${topic.id}"/>">
                            <i class="fa fa-edit mr-3"></i></a>
                        <a href="<c:out value="/comments/comments?tId=${topic.id}"/>">${topic.name}</a>
                    </td>
                    <td class="text-center">${topic.desc}</td>
                    <td class="text-center">${topic.author.username}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>