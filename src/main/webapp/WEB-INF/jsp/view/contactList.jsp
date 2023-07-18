<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>

<head>
    <title>Contacts</title>
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
    <c:choose>
        <c:when test="${fn:length(contactList) eq 0}">
            <h3 class="text-center">No contact yet</h3>
        </c:when>
        <c:otherwise>
            <f:form>
                <table class="table table-bordered">
                    <tr>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th>Personnal Email</th>
                        <th>Professional Email</th>
                        <th>Personnal number</th>
                        <th>Professional number</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="contact" items="${contactList}">
                        <tr>
                            <td>${contact.firstName}</td>
                            <td>${contact.lastName}</td>
                            <td>${contact.gender}</td>
                            <td>${contact.address}</td>
                            <td>${contact.personnalEmail}</td>
                            <td>${contact.professionalEmail}</td>
                            <td>${contact.personnalNumber}</td>
                            <td>${contact.professionalNumber}</td>
                            <td>
                                <button class="btn btn-primary "
                                        href="${pageContext.request.contextPath}/modify/${contact.id}"><a
                                        href="${pageContext.request.contextPath}/modify/${contact.id}">Modify</a>
                                </button>
                                <button class="btn btn-danger"
                                        href="${pageContext.request.contextPath}/delete/${contact.id}"><a
                                        href="${pageContext.request.contextPath}/delete/${contact.id}">Delete</a>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </f:form>
        </c:otherwise>
    </c:choose>

</div>
<!--
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
