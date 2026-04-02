<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page isELIgnored="false" %>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- <title>${curpage}</title>  -->
    <title> <c:out value="${curpage}"></c:out></title>
  </head>
  <body>

<!-- style="background-color:green" -->

    <h1>${curpage}</h1>
    <h1> ${todo}</h1>

    <div class="container-lg mt-3">
      <h1 class="text-center">Welcome to ToDo Manager</h1>

      <c:if test="${not empty msg}">
        <div class="alert alert-success">
           <c:out value="${msg}"> </c:out>
        </div>
      </c:if>

        <div class="row mt-5">
            <div class="col-md-2 text-center" >
                <div class="list-group">
                  <button type="button" class="list-group-item list-group-item-action active">Menu</button>
                  <a href="<c:url value='/add'></c:url>" class="list-group-item list-group-item-action">Add Todo</a>
                  <a href="home" class="list-group-item list-group-item-action">View Todo</a>
                </div>
            </div>

<!-- in below code, ${curpage eq 'home' } is Expression language -->

            <div class="col-md-10">

                <c:if test="${curpage eq 'home' }">
                    <h1>All Todos</h1>

                    <c:forEach items="${todos}" var="t">
                        <div class="card">
                            <div class="card-body">
                                <h3>
                                    <c:out value="${t.todoTitle}"></c:out>
                                </h3>

                                <p>
                                    <c:out value="${t.todoContent}"></c:out>
                                </p>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>

                <c:if test="${curpage eq 'add' }">
                    <h1>Add Todo</h1>

                    <form:form modelAttribute="todo" action="submitForm" method="post">
                        <div class="form-group">
                            <form:input path="todoTitle" cssClass="form-control" placeholder="Enter your todo title"/>
                            <form:errors path="todoTitle" cssClass="text-danger"/>
                        </div>

                        <div class="form-group mt-3 mb-2">
                             <form:textarea path="todoContent" cssClass="form-control" cssStyle="height:200px" placeholder="Enter your todo content"/>
                             <form:errors path="todoContent" cssClass="text-danger"/>
                        </div>

                        <div class="container text-center">
                            <button class="btn btn-outline-success" type="submit">Spring Form Register</button>
                        </div>
                    </form:form>
                </c:if>

            </div>
        </div>
    </div>


    <!-- Optional JavaScript; choose one of the two! -->
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>