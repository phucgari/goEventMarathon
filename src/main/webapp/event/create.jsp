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
        <div class="col-md-5 border-right">
            <div align="center">
                <div class="d-flex justify-content-between align-items-center mb-3">
                    <h4 class="text-right">Create New Event</h4>
                </div>

                <form method="post">
                    <input type="hidden" value="create" name="action">
                    <div class="col-md-12">
                        <label class="labels">Hold Time</label>
                        <input type="datetime-local" class="form-control" name="hold_time" placeholder="Enter Hold Time"
                               value="">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Event Name</label>
                        <input type="text" class="form-control" name="event_name" placeholder="Enter Event Name"
                               value="">
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Fee</label>
                        <input type="number" class="form-control" name="fee" placeholder="Enter Fee"
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
                        <textarea type="text" class="form-control" name="tag_name"
                                  placeholder="Tag, down the line to add more tags"></textarea>
                    </div>

                    <div class="col-md-12">
                        <label class="labels">Photos</label>
                        <textarea type="text" class="form-control" name="src"
                                  placeholder="IMG Link, down the line to add more photos."></textarea>
                    </div>


                    <div class="mt-5 text-center">
                        <input class="btn btn-primary profile-button" type="submit" value="Save"></input>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
