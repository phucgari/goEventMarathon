<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Event List</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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

        body {
            font-family: Lato;
            font-weight: 600;
        }

        h1 {
            padding-left: 120px;
            color: #043e46;
            font-size: 2.2em;
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

        body {
            margin-top: 20px;
        }


        .p-table th,
        .p-table td {
            vertical-align: middle !important;
        }


        .p-team img {
            width: 35px;
            height: 35px;
            border-radius: 4px;
        }

        .p-progress .progress {
            margin-bottom: 5px;
        }

        .p-name a {
            font-size: 14px;
            /*font-weight:bold;*/
        }


        .p-details .bio-row p span {
            width: auto;
        }

        .p-details .bio-row p span.bold {
            width: 100px;
        }

        .p-team a {
            display: inline-block;
        }

        .p-files li a {
            margin-bottom: 10px;
            color: #949494;
            display: block;
        }

        .p-files li i {
            padding-right: 10px;
            width: 20px;
        }

        .p-tag-list li {
            display: inline-block;
            margin: 0 5px 7px 0;
        }

        .p-tag-list li a {
            display: inline-block;
            border: 1px solid #ddd;
            padding: 3px 10px;
            color: #797979;
            border-radius: 4px;
            font-size: 12px;
        }

        .p-tag-list li a:hover {
            background: #ff6c60;
            border-color: #ff6c60;
            color: #fff;
        }

        .m-thumb img {
            width: 100%;
            border: 1px solid #ddd;
        }

        #time {
            margin-bottom: 10px;
        }

        /*general styles*/

        body {
            padding: 3em;
            background-color: #ccc;
        }

        html {
            box-sizing: border-box;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }


        /*slideshow styles*/

        .slideshow {
            width: 625px;
            margin: 0 auto;
            overflow: hidden;
            border: solid 1px white;
        }

        .slideshow-container {
            width: 2500px;
            font-size: 0;
            transition: 1s ease;
            height: 225px;
        }

        .slideshow-container:hover {
            animation-play-state: paused;
        }

        .text-container {
            height: 225px;
            position: relative;
        }


        p {
            position: relative;
            top: -45%;
            padding: 5px;
        }

        .slide {
            animation: slide 24s ease infinite;
        }

        @keyframes slide {
            0% {
                transform: translateX(0%);
            }

            12.5% {
                transform: translateX(0%);
            }

            25% {
                transform: translateX(-25%);
            }

            37.5% {
                transform: translateX(-25%);
            }

            50% {
                transform: translateX(-50%);
            }

            62.5% {
                transform: translateX(-50%);
            }

            75% {
                transform: translateX(-75%);
            }

            87.5% {
                transform: translateX(-75%);
            }

            99% {
                transform: translateX(-75%);
            }

            100% {
                transform: translateX(0);
            }
        }

        .p {
            margin-top: 140px;
            text-align: center;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
    <a href="#" class="navbar-brand"><i class="fa fa-cube"></i>Event <b></b></a>
    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <!-- Collection of nav links, forms, and other content for toggling -->
    <div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
        <div class="navbar-nav ml-auto">
            <div class="nav-item dropdown">
                <a data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action"><img
                        src="${requestScope["user"].getAvatar()}" class="avatar" alt="Avatar">
                    ${requestScope["user"].getFullName()}</a>
                <div class="dropdown-menu">
                    <a href="nUser/action=edit" class="dropdown-item"><i class="fa fa-user-o"></i> Profile</a>
                    <div class="divider dropdown-divider"></div>
                    <a href="http://localhost:8080/" class="dropdown-item"><i class="material-icons">&#xE8AC;</i>
                        Logout</a>
                </div>
            </div>
        </div>
    </div>
</nav>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="http://localhost:8080/">Home</a></li>
                        <li class="breadcrumb-item"><a href="http://localhost:8080/user?action=show_all_event">Event
                            list</a></li>
                        <li class="breadcrumb-item active" aria-current="page">show event</li>
                    </ol>
                </nav>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="${requestScope['event'].getProfilePic()}" alt="avatar"
                             class="rounded-circle img-fluid" style="width: 150px;">
                        <h2 class="my-3">${requestScope['event'].getEventName()}</h2>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0"></p>
                            </div>
                            <div style="height: 215px">
                                <h3 class="text-muted mb-0">${requestScope['event'].getDescription()}</h3>
                            </div>
                        </div>
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <c:forEach items="${requestScope['event'].getPictures()}" var="e">
            <img height="300px" width="406px" src="${e}" alt="event img"/>
        </c:forEach>
    </div>
    <div align="center">
        <c:if test="${requestScope['registerStatus']}">
            <form method="post">
                <input type="hidden" name="event_id" value="${requestScope['event'].getEventId()}">
                <input type="hidden" name="req" value="false">
                <button style="color: red">Unregister event</button>
            </form>
        </c:if>

        <c:otherwise>
            <form method="post">
                <input type="hidden" name="event_id" value="${requestScope['event'].getEventId()}">
                <input type="hidden" name="req" value="true">
                <button style="color: #2fff00">Register this event</button>
            </form>
        </c:otherwise>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<script>
    const pickerInline = document.querySelector('.timepicker-inline-24');
    const timepickerMaxMin = new mdb.Timepicker(pickerInline, {format24: true, inline: true});
</script>
</body>
</html>
