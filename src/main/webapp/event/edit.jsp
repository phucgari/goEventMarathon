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
                    <h4 class="text-right">Event Update</h4>
                </div>

                <div class="row mt-3">

                    <form method="post" action="">
                        <div class="col-md-12">
                            <label class="labels">Hold Time</label>
                            <input type="datetime-local" class="form-control" name="password" placeholder="Enter Hold Time"
                                   value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Event Name</label>
                            <input type="text" class="form-control" name="name" placeholder="Enter Event Name" value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Fee</label>
                            <input type="number" class="form-control" name="avatar" placeholder="Enter Fee"
                                   value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Profile Picture</label>
                            <input type="text" class="form-control" name="prof_picture"
                                   placeholder="Enter Profile Picture Link"
                                   value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Description</label>
                            <input type="text" class="form-control" name="description" placeholder="Enter Description"
                                   value="">
                        </div>
                        <div class="col-md-12">
                            <label class="labels">Address</label>
                            <input type="text" class="form-control" name="address" placeholder="Enter Address"
                                   value="">
                        </div>

                        <div class="col-md-12">
                            <label class="labels">Tags</label>
                            <select name="tags">
                                <c:forEach var="option" items="${tags}">
                                    <option value="${option.tag_id}">${option.tag_name}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-12">
                            <label class="labels"></label>
                        </div>
                        <div class="mt-5 text-center">
                            <input class="btn btn-primary profile-button" type="submit" value="Save"></input>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
