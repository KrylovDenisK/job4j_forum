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
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<nav class="navbar navbar-fixed-top navbar-dark bg-dark">
    <a href="" class="navbar-brand">Forum</a>
    <div class="navbar-nav">
        <a class="nav-item nav-link" href="/" id="user">Выйти: ${user}</a>
    </div>
</nav>
<div class="container">
    <div class="card mx-auto mb-5 my-5" style="max-width: 40%;">
        <div class="card-header text-center">
            <h2>Создание темы</h2>
        </div>
        <div class="card-body">
            <form action="<c:url value="/topics/save?pId=${pId}"/>" method="POST">
                <div class="form-group">
                    <label for="name" class="control-label">Название:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Введите название">
                </div>
                <div class="form-group">
                    <label for="desc" class="col-form-label">Описание:</label>
                    <textarea class="form-control" id="desc" name="desc" placeholder="О чем тема???"></textarea>
                </div>
                <div class="form-group text-center">
                    <input type="submit" class="btn btn-primary" name="create" value="Создать новую тему"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>