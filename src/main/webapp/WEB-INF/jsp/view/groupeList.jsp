<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <title>Groupes</title>

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

        a {
            color: white;
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
    <form action="/groupes/findGroupe" method="post">
        <div class="row">
            <div class="col-5">
                <input class="form-control col-5 " type="text" name="searchValue" placeholder="Groupe Name">
            </div>
            <button class="btn btn-primary col-1" type="submit">Search</button>
        </div>
    </form>
    <c:choose>
        <c:when test="${fn:length(groupes) eq 0}">
            <h3 class="text-center">No groupe yet</h3>
        </c:when>
        <c:otherwise>
            <f:form>
                <div class="col-9">
                    <table class="table table-bordered">
                        <tr>
                            <th class="col-1">Name</th>
                            <th class="col-3">Members</th>
                            <th class="col-2">Action</th>
                        </tr>


                        <!-- have to add controller for groupe entity -->
                        <!--  in forEach loop , have to add a checkbox behind every contact , if is checked,
                              then i have to add it to the groupe  -->
                        <c:forEach var="groupe" items="${groupes}">
                            <tr>
                                <td class="col-1">${groupe.name}</td>
                                <td class="col-3">
                                    <c:choose>
                                    <c:when test="${fn:length(groupe.contacts) eq 0}">
                                    <h5>No member yet</h5>
                                    </c:when>
                                    <c:otherwise>
                                    <c:forEach var="contact" items="${groupe.contacts}">
                                        ${contact.firstName} ${contact.lastName} ,
                                    </c:forEach>
                                    </c:otherwise>
                                    </c:choose>

                                <td class="col-2">
                                    <button class="btn btn-primary "
                                            href="${pageContext.request.contextPath}/groupes/modify/${groupe.id}"><a
                                            href="${pageContext.request.contextPath}/groupes/modify/${groupe.id}">Modify</a>
                                    </button>
                                    <button class="btn btn-danger"
                                            href="${pageContext.request.contextPath}/groupes/delete/${groupe.id}"><a
                                            href="${pageContext.request.contextPath}/groupes/delete/${groupe.id}">Delete</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </f:form>
        </c:otherwise>
    </c:choose>


</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
