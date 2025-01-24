<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <head>
     <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
     <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

 </head>
 <body>

         <h2>Update product</h2>
         <form:form action="test" modelAttribute="productDetails" >
             <h4>update product</h4>

              <h4>id</h4>
               <form:input type="int"  path="id" class="form-control" readonly="true"/>


                 <h4>name</h4>
             <form:input type="text" placeholder="Enter product name" path="name" class="form-control"/>

             <br><br>
             <h4>Expiration Date </h4>
             <form:input type="date" placeholder="dd/mm/yyyy" path="expirationDate" class="form-control"/>

             <br><br>
             <h4>Manufacture</h4>
             <form:input type="text" placeholder="Manufacture" path="manufacturer" class="form-control"/>

             <br><br>
             <h4>price</h4>
             <form:input type="number" placeholder="price" path="price" class="form-control"/>


             <br><br>
              <br><br>
                <h4>available</h4>

                               <form:select path="available" class="form-control">
                                   <form:option value="true" label="Yes" />
                                   <form:option value="false" label="No" />
                               </form:select>
                               <br><br>
   <!-- Button to delete the product -->

         <button type="submit" class="btn btn-danger">submit</button>
          </form>

         </form:form>
     </div>
 </body>
 </html>
