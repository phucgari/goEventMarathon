<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/18/2023
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background: rgb(99, 39, 120)
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #BA68C8
        }

        .profile-button {
            background: rgb(99, 39, 120);
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #682773
        }

        .profile-button:focus {
            background: #682773;
            box-shadow: none
        }

        .profile-button:active {
            background: #682773;
            box-shadow: none
        }

        .back:hover {
            color: #682773;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #BA68C8;
            color: #fff;
            cursor: pointer;
            border: solid 1px #BA68C8
        }
    </style>
</head>
<body>
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5"
                                                                                         width="150px"
                                                                                         src="${requestScope["avatar"]}"><span
                    class="font-weight-bold">Edogaru</span><span
                    class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>
                <form action="edit" method="post">
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Full Name</label><input type="text"
                                                                                             class="form-control"
                                                                                             value="${requestScope["normalUser"].getFullName()}">
                        </div>
                        <div class="col-md-12"><label class="labels">Avatar</label><input type="text"
                                                                                          class="form-control"
                                                                                          value="${requestScope["normalUser"].getAvatar()}">
                        </div>
                        <div class="col-md-12"><label class="labels">Phone</label><input type="text"
                                                                                         class="form-control"
                                                                                         value="${requestScope["normalUser"].getPhone()}">
                        </div>
                        <input type="hidden" class="form-control" value="${requestScope["normalUser"].getNormalUserId()}">
                    </div>
                    <div class="col-md-12"><label class="labels">Age</label><input type="text" class="form-control"
                                                                                   value="${requestScope["normalUser"].getAge()}">
                    </div>
                    <div class="col-md-12"><label class="labels">Gender</label><input type="text" class="form-control"
                                                                                      value="${requestScope["normalUser"].getGender()}">
                    </div>
                    <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control"
                                                                                       value="${requestScope["normalUser"].getAddress()}">
                    </div>
                    <div class="col-md-12"><label class="labels">Email</label><input type="text" class="form-control"
                                                                                     value="${requestScope["normalUser"].getEmail()}">
                    </div>
                    <div class="col-md-12"><label class="labels">Password</label><input type="text"
                                                                                        class="form-control"
                                                                                        value="${requestScope["normalUser"].getPassword()}">
                    </div>
                    <div class="mt-5 text-center">
                        <button class="btn btn-primary profile-button" type="button">Save Profile</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
