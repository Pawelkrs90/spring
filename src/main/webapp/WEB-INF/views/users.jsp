<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html><html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
     
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/css/body.css" />" rel="stylesheet">
        
        <title>Spring-Index</title>
    </head>

    <body>
    
       
        <jsp:include page='navbar.jsp' />
  
        <section class="container" >
            <div class="row">
                <div class="panel panel-default" style="background-color:#f2f2f2">
                       
                    <div class="panel-heading">
                        <h3 class="panel-title"> Lista userów</h3>  
                        <a href="<spring:url value='/Users/addUser' />" >  
                            <span class="glyphicon glyphicon-plus"></span>

                        </a>
                    </div>
                            
                    <div class="panel-body">
                
                        <c:forEach items="${userList}" var="user">
                            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px" >
                                <div class="thumbnail">

                                    <div class="caption">

                                        <h3>Identyfikator: ${user.id}</h1>
                                        <h5>Imie: ${user.firstName}</h3>
                                        <h5>Nazwisko: ${user.lastName}PLN</h3>

                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                            
                </div>
            </div>
        </section>
     
         
    </body>

</html>
