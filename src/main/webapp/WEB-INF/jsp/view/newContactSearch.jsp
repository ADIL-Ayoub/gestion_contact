<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <title>Search contact</title>
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
        <h3 class="ms-4">Find contact by : </h3>
    </div>

    <form action="/newFind" method="POST"  >
        <div class="col-6 m-3">
            <select name="type"  class="form-control my-4">
                <option value="name">Name</option>
                <option value="professional">Professional number</option>
                <option value="personnal">Personnal number</option>
            </select>
            <input class="form-control" name="searchValue" type="text" placeholder="Search">
        </div>
        <div class="m-3 mt-5">
            <button class ="btn btn-primary" type="submit">Search</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
