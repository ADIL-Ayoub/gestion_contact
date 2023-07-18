<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <title>Edit groupe</title>
    <!--
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
    -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <style>
        form {
            margin-bottom: 60px;
            margin-top: 10px;
            padding: 10px;
        }

        h3 {
            margin-top: 20px;
        }
    </style>


</head>

<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mt-3">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page"
                                            href="/">Contacts</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="/showForm">Add contact</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="/findContact">Find contact</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="/groupes">Groupes</a></li>
                    <li class="nav-item"><a class="nav-link"
                                            href="/groupes/showMembers">Add Groupe</a></li>

                </ul>
            </div>
        </div>
    </nav>
    <div>
        <h3 class="ms-4">Modify Groupe</h3>
    </div>

    <form action="/groupes/modifyGroupe" method="POST" >
        <div class="row">
            <div class="col-6 m-3">
                <label>Groupe Name</label>
                <input name="name" type="text" class="form-control" required
                         placeholder="New groupe's name" />
            </div>



        </div>
        <div class="col-6">
            <h3 class="text-center my-5">Modify old contacts</h3>
            <table class="table table-bordered mt-5">
            <tr>
                <th>First name</th>
                <th>Last name</th>

                <th>Add</th>
            </tr>
            <c:forEach var="contact" items="${oldContacts}">
            <tr>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>

                <td>
                    <input type="checkbox" name="chosenOldContacts" checked value="${contact.id}"/>
                </td>
            </tr>
        </c:forEach>
        </table>
        </div>
        <div class="col-6">
            <h3 class="text-center my-5">Add new contacts to the groupe</h3>
            <table class="table table-bordered ">
            <tr>
                <th>First name</th>
                <th>Last name</th>

                <th>Add</th>
            </tr>
            <c:forEach var="contact" items="${notInGroupeContacts}">
            <tr>
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>

                <td>
                    <input type="checkbox" name="chosenNewContacts" value="${contact.id}"/>
                </td>
            </tr>
        </c:forEach>
        </table>
        </div>

        <div class="row mt-5">
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Edit</button>
            </div>
        </div>

    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
