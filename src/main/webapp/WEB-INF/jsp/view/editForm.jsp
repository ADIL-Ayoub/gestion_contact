<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <title>Edit contact</title>
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
        <h3 class="ms-4">Modify contact</h3>
    </div>

    <c:if test="${infoMsg!=null}">
        <div class="alert alert-success" role="alert">${infoMsg}</div>
    </c:if>
    <c:if test="${errorMsg!=null}">
        <div class="alert alert-danger" role="alert">${errorMsg}</div>
    </c:if>

    <f:form action="/modifyContact" method="POST" modelAttribute="contactModel">
        <div >
            <f:hidden path="id"/>
        </div>
        <div class="row">
            <div class="col-6 m-3">
                <label>First Name</label>
                <f:input path="firstName" type="text" class="form-control"
                         placeholder="Your first name" />

            </div>

            <div class="col-6 m-3">
                <label>LastName</label>
                <f:input path="lastName" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
            <div class="col-6 m-3">
                <label>Personnal Number</label>
                <f:input path="personnalNumber" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
            <div class="col-6 m-3">
                <label>Professional Number</label>
                <f:input path="professionalNumber" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
            <div class="col-6 m-3">
                <label>Address</label>
                <f:input path="address" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
            <div class="col-6 m-3">
                <label>Personnal Email</label>
                <f:input path="personnalEmail" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
            <div class="col-6 m-3">
                <label>Professional Email</label>
                <f:input path="professionalEmail" type="text" class="form-control"
                         placeholder="Your last name" />

            </div>
        </div>
        <div class="col-6 m-3">
            <f:select path="gender" items="${genders}" class="form-control"/>
            <f:errors path="gender" class="text-danger"/>
        </div>
        <!--
        <div class="form-check">
        <input type="radio" class="form-check-input" id="radio1"  path="gender" />
        <label class="form-check-label" for="radio1">Male</label>
        </div>
        <div class="form-check">
        <input type="radio" class="form-check-input" id="radio2" name="optradio"  value="F">Female
        <label class="form-check-label" for="radio2"></label>
        </div>
        -->
        <div class="row mt-5">
            <div style="text-align: right">
                <button type="submit" class="btn btn-primary">Edit</button>
            </div>
        </div>

    </f:form>
</div>
<!--
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
