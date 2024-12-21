<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <!-- to use foreach -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

</head>
<body>
    <div class="container">
        <h2>Hello to show details </h2>
        <div class="info">
            <h3>name is: ${productDetails.name}</h3>
        </div>

         <div class="info">
                    <h3>price is: ${productDetails.price}</h3>
                </div>

                 <div class="info">
                            <h3>manufacturer is: ${productDetails.manufacturer}</h3>
                        </div>



                         <div class="info">
                                                    <h3>available is: ${productDetails.available}</h3>
                                                </div>

   <div class="info">
                                                     <h3>expirationDate is: ${productDetails.expirationDate}</h3>
                                                 </div>

    </div>
</body>
</html>
