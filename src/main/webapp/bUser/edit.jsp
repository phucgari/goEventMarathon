<%--
  Created by IntelliJ IDEA.
  User: Nam
  Date: 3/18/2023
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <style>
        body {
            background: rgb(172, 220, 209)
        }

        .form-control:focus {
            box-shadow: none;
            border-color: #e9d9ec
        }

        .profile-button {
            background: rgb(205, 182, 216);
            box-shadow: none;
            border: none
        }

        .profile-button:hover {
            background: #d5c2da
        }

        .profile-button:focus {
            background: #cdb2d0;
            box-shadow: none
        }

        .profile-button:active {
            background: #c7afca;
            box-shadow: none
        }

        .back:hover {
            color: #cab0ce;
            cursor: pointer
        }

        .labels {
            font-size: 11px
        }

        .add-experience:hover {
            background: #d3b7d7;
            color: #fff;
            cursor: pointer;
            border: solid 1px #d6bcda
        }
    </style>
</head>
<body>
<div class="container rounded bg-white mt-5 mb-5">
    <div class="row">
        <div class="col-md-3 border-right">
            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                <img class="rounded-circle mt-5" width="150px"
                     src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"><span
                    class="font-weight-bold">Edogaru</span><span
                    class="text-black-50">edogaru@mail.com.my</span><span> </span></div>
        </div>
        <div class="col-md-5 border-right">
            <div class="p-3 py-5">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Profile Settings</h4>
                </div>

                <div class="row mt-3">

                    <div class="col-md-12"><label class="labels">Password</label>
                        <input type="text" class="form-control" name="password" placeholder="enter phone number"
                               value=""></div>
                    <div class="col-md-12"><label class="labels">Name</label>
                        <input type="text" class="form-control" name="name" placeholder="enter address line 1" value="">
                    </div>
                    <div class="col-md-12"><label class="labels">Avatar</label>
                        <input type="text" class="form-control" name="avatar" placeholder="enter address line 2" value="">
                    </div>
                    <div class="col-md-12"><label class="labels">Phone</label>
                        <input type="text" class="form-control" name="phone" placeholder="enter address line 2" value="">
                    </div>

                </div>
                <div class="mt-5 text-center">
                    <button class="btn btn-primary profile-button" type="button">Save Profile</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
