<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/18/2023
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <style>
        body {
            color: #566787;
            background: #f5f5f5;
            font-family: 'Varela Round', sans-serif;
            font-size: 13px;
        }

        .table-wrapper {
            background: #fff;
            padding: 20px 25px;
            margin: 30px 0;
            border-radius: 3px;
            box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
        }

        .table-title {
            padding-bottom: 15px;
            background: #926DDE;
            color: #fff;
            padding: 16px 30px;
            margin: -20px -25px 10px;
            border-radius: 3px 3px 0 0;
        }

        .table-title h2 {
            margin: 5px 0 0;
            font-size: 24px;
        }

        .table-title .btn-group {
            float: right;
        }

        .table-title .btn {
            color: #fff;
            float: right;
            font-size: 13px;
            border: none;
            min-width: 50px;
            border-radius: 2px;
            border: none;
            outline: none !important;
            margin-left: 10px;
        }

        .table-title .btn i {
            float: left;
            font-size: 21px;
            margin-right: 5px;
        }

        .table-title .btn span {
            float: left;
            margin-top: 2px;
        }

        table.table tr th, table.table tr td {
            border-color: #e9e9e9;
            padding: 12px 15px;
            vertical-align: middle;
        }

        table.table tr th:first-child {
            width: 60px;
        }

        table.table tr th:last-child {
            width: 100px;
        }

        table.table-striped tbody tr:nth-of-type(odd) {
            background-color: #fcfcfc;
        }

        table.table-striped.table-hover tbody tr:hover {
            background: #f5f5f5;
        }

        table.table th i {
            font-size: 13px;
            margin: 0 5px;
            cursor: pointer;
        }

        table.table td:last-child i {
            opacity: 0.9;
            font-size: 22px;
            margin: 0 5px;
        }

        table.table td a {
            font-weight: bold;
            color: #566787;
            display: inline-block;
            text-decoration: none;
            outline: none !important;
        }

        table.table td a:hover {
            color: #2196F3;
        }

        table.table td a.edit {
            color: #FFC107;
        }

        table.table td a.delete {
            color: #F44336;
        }

        table.table td i {
            font-size: 19px;
        }

        table.table .avatar {
            border-radius: 50%;
            vertical-align: middle;
            margin-right: 10px;
        }

        .pagination {
            float: right;
            margin: 0 0 5px;
        }

        .pagination li a {
            border: none;
            font-size: 13px;
            min-width: 30px;
            min-height: 30px;
            color: #999;
            margin: 0 2px;
            line-height: 30px;
            border-radius: 2px !important;
            text-align: center;
            padding: 0 6px;
        }

        .pagination li a:hover {
            color: #666;
        }

        .pagination li.active a, .pagination li.active a.page-link {
            background: #03A9F4;
        }

        .pagination li.active a:hover {
            background: #0397d6;
        }

        .pagination li.disabled i {
            color: #ccc;
        }

        .pagination li i {
            font-size: 16px;
            padding-top: 6px
        }

        .hint-text {
            float: left;
            margin-top: 10px;
            font-size: 13px;
        }

        /* Custom checkbox */
        .custom-checkbox {
            position: relative;
        }

        .custom-checkbox input[type="checkbox"] {
            opacity: 0;
            position: absolute;
            margin: 5px 0 0 3px;
            z-index: 9;
        }

        .custom-checkbox label:before {
            width: 18px;
            height: 18px;
        }

        .custom-checkbox label:before {
            content: '';
            margin-right: 10px;
            display: inline-block;
            vertical-align: text-top;
            background: white;
            border: 1px solid #bbb;
            border-radius: 2px;
            box-sizing: border-box;
            z-index: 2;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            content: '';
            position: absolute;
            left: 6px;
            top: 3px;
            width: 6px;
            height: 11px;
            border: solid #000;
            border-width: 0 3px 3px 0;
            transform: inherit;
            z-index: 3;
            transform: rotateZ(45deg);
        }

        .custom-checkbox input[type="checkbox"]:checked + label:before {
            border-color: #03A9F4;
            background: #03A9F4;
        }

        .custom-checkbox input[type="checkbox"]:checked + label:after {
            border-color: #fff;
        }

        .custom-checkbox input[type="checkbox"]:disabled + label:before {
            color: #b8b8b8;
            cursor: auto;
            box-shadow: none;
            background: #ddd;
        }

        /* Modal styles */
        .modal .modal-dialog {
            max-width: 400px;
        }

        .modal .modal-header, .modal .modal-body, .modal .modal-footer {
            padding: 20px 30px;
        }

        .modal .modal-content {
            border-radius: 3px;
        }

        .modal .modal-footer {
            background: #ecf0f1;
            border-radius: 0 0 3px 3px;
        }

        .modal .modal-title {
            display: inline-block;
        }

        .modal .form-control {
            border-radius: 2px;
            box-shadow: none;
            border-color: #dddddd;
        }

        .modal textarea.form-control {
            resize: vertical;
        }

        .modal .btn {
            border-radius: 2px;
            min-width: 100px;
        }

        .modal form label {
            font-weight: normal;
        }
    </style>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Beautiful Bootstrap Navbar with Menu Icons</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            background: #eeeeee;
            font-family: 'Varela Round', sans-serif;
        }

        .navbar {
            color: #fff;
            background: #926dde !important;
            padding: 5px 16px;
            border-radius: 0;
            border: none;
            box-shadow: 0 0 4px rgba(0, 0, 0, .1);
        }

        .navbar img {
            border-radius: 50%;
            width: 36px;
            height: 36px;
            margin-right: 10px;
        }

        .navbar .navbar-brand {
            color: #efe5ff;
            padding-left: 0;
            padding-right: 50px;
            font-size: 24px;
        }

        .navbar .navbar-brand:hover, .navbar .navbar-brand:focus {
            color: #fff;
        }

        .navbar .navbar-brand i {
            font-size: 25px;
            margin-right: 5px;
        }

        .search-box {
            position: relative;
        }

        .search-box input {
            padding-right: 35px;
            min-height: 38px;
            border: none;
            background: #faf7fd;
            border-radius: 3px !important;
        }

        .search-box input:focus {
            background: #fff;
            box-shadow: none;
        }

        .search-box .input-group-addon {
            min-width: 35px;
            border: none;
            background: transparent;
            position: absolute;
            right: 0;
            z-index: 9;
            padding: 10px 7px;
            height: 100%;
        }

        .search-box i {
            color: #a0a5b1;
            font-size: 19px;
        }

        .navbar .nav-item i {
            font-size: 18px;
        }

        .navbar .nav-item span {
            position: relative;
            top: 3px;
        }

        .navbar .navbar-nav > a {
            color: #efe5ff;
            padding: 8px 15px;
            font-size: 14px;
        }

        .navbar .navbar-nav > a:hover, .navbar .navbar-nav > a:focus {
            color: #fff;
            text-shadow: 0 0 4px rgba(255, 255, 255, 0.3);
        }

        .navbar .navbar-nav > a > i {
            display: block;
            text-align: center;
        }

        .navbar .dropdown-item i {
            font-size: 16px;
            min-width: 22px;
        }

        .navbar .dropdown-item .material-icons {
            font-size: 21px;
            line-height: 16px;
            vertical-align: middle;
            margin-top: -2px;
        }

        .navbar .nav-item.open > a, .navbar .nav-item.open > a:hover, .navbar .nav-item.open > a:focus {
            color: #fff;
            background: none !important;
        }

        .navbar .dropdown-menu {
            border-radius: 1px;
            border-color: #e5e5e5;
            box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
        }

        .navbar .dropdown-menu a {
            color: #777 !important;
            padding: 8px 20px;
            line-height: normal;
            font-size: 15px;
        }

        .navbar .dropdown-menu a:hover, .navbar .dropdown-menu a:focus {
            color: #333 !important;
            background: transparent !important;
        }

        .navbar .navbar-nav .active a, .navbar .navbar-nav .active a:hover, .navbar .navbar-nav .active a:focus {
            color: #fff;
            text-shadow: 0 0 4px rgba(255, 255, 255, 0.2);
            background: transparent !important;
        }

        .navbar .navbar-nav .user-action {
            padding: 9px 15px;
            font-size: 15px;
        }

        .navbar .navbar-toggle {
            border-color: #fff;
        }

        .navbar .navbar-toggle .icon-bar {
            background: #fff;
        }

        .navbar .navbar-toggle:focus, .navbar .navbar-toggle:hover {
            background: transparent;
        }

        .navbar .navbar-nav .open .dropdown-menu {
            background: #faf7fd;
            border-radius: 1px;
            border-color: #faf7fd;
            box-shadow: 0 2px 8px rgba(0, 0, 0, .05);
        }

        .navbar .divider {
            background-color: #e9ecef !important;
        }

        @media (min-width: 1200px) {
            .form-inline .input-group {
                width: 350px;
                margin-left: 30px;
            }
        }

        @media (max-width: 1199px) {
            .navbar .navbar-nav > a > i {
                display: inline-block;
                text-align: left;
                min-width: 30px;
                position: relative;
                top: 4px;
            }

            .navbar .navbar-collapse {
                border: none;
                box-shadow: none;
                padding: 0;
            }

            .navbar .navbar-form {
                border: none;
                display: block;
                margin: 10px 0;
                padding: 0;
            }

            .navbar .navbar-nav {
                margin: 8px 0;
            }

            .navbar .navbar-toggle {
                margin-right: 0;
            }

            .input-group {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
    <a href="#" class="navbar-brand"><i class="fa fa-cube"></i>Brand<b>Name</b></a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
        <form class="navbar-form form-inline">
            <div class="input-group search-box">
                <input type="text" id="search" class="form-control" placeholder="Search here...">
                <span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
            </div>
        </form>
        <div class="navbar-nav ml-auto">
            <a href="#" class="nav-item nav-link active"><i class="fa fa-home"></i><span>Home</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-gears"></i><span>Projects</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-users"></i><span>Team</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-pie-chart"></i><span>Reports</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-briefcase"></i><span>Careers</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-envelope"></i><span>Messages</span></a>
            <a href="#" class="nav-item nav-link"><i class="fa fa-bell"></i><span>Notifications</span></a>
            <div class="nav-item dropdown">
                <a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img
                        src="https://www.tutorialrepublic.com/examples/images/avatar/3.jpg" class="avatar" alt="Avatar">
                    Antonio Moreno <b class="caret"></b></a>
                <div class="dropdown-menu">
                    <a href="#" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a>
                    <a href="#" class="dropdown-item"><i class="fa fa-calendar-o"></i> Calendar</a>
                    <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Settings</a>
                    <div class="divider dropdown-divider"></div>
                    <a href="#" class="dropdown-item"><i class="material-icons">&#xE8AC;</i> Logout</a>
                </div>
            </div>
        </div>
    </div>
</nav>
</body>
</html>
<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Normal <b>Management</b></h2>
                </div>
                <div class="col-sm-6">
                    <a href="bUser/create.jsp" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i>
                        <span>Add New Event</span></a>
                </div>
            </div>
        </div>
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>age</th>
                <th>gender</th>
                <th>address</th>
                <th>email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="n" items="${requestScope.normal}">
                <tr>
                    <td><c:out value="${n.normalUserId}"/></td>
                    <td><c:out value="${n.age}"/></td>
                    <td><c:out value="${n.gender}"/></td>
                    <td><c:out value="${n.address}"/></td>
                    <td><c:out value="${n.email}"/></td>
                    <td>
                        <a href="bUser/edit.jsp" class="edit" data-toggle="modal"><i class="material-icons"
                                                                                     data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                        <a href="bUser/view.jsp" class="edit" data-toggle="modal"><i title="view" data-toggle="tooltip"
                                                                                     class="material-icons">assignment</i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="clearfix">
            <div class="hint-text">Showing <b>5</b> out of <b>25</b> entries</div>
            <ul class="pagination">
                <li class="page-item disabled"><a href="#">Previous</a></li>
                <li class="page-item"><a href="#" class="page-link">1</a></li>
                <li class="page-item"><a href="#" class="page-link">2</a></li>
                <li class="page-item active"><a href="#" class="page-link">3</a></li>
                <li class="page-item"><a href="#" class="page-link">4</a></li>
                <li class="page-item"><a href="#" class="page-link">5</a></li>
                <li class="page-item"><a href="#" class="page-link">Next</a></li>
            </ul>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
