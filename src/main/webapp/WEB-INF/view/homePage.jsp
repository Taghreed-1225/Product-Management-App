 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <!-- to use foreach -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <html>
 <head>
     <link rel="stylesheet" type="text/css" href="/resources/css/style.css">
     <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css">

 </head>
 <body>


      <h2> Products date </h2>



       <table>
           <thead>
               <tr>
                    <th>#</th>
                   <th>Name</th>
                    <th>show Details</th>
                    <th>Update</th>
                    <th>Delete</th>
               </tr>
           </thead>
           <tbody>
               <!-- Loop through productList -->
                          <c:forEach var="product" items="${productList}">
                              <tr>
                                  <td>${product.id}</td>

                                  <td>${product.name}</td>

                                            <td>
                                              <!-- Button to show the product -->
                                              <form action="showProduct" method="post">
                                                  <input type="hidden" name="productId" value="${product.id}" />
                                                  <button type="submit" class="btn btn-danger">Show details</button>
                                              </form>
                                          </td>
                                            <td>
                                                        <!-- Button to update the product -->
                                                      <form action="updateProduct" modelAttribute="productDetails">
                                                           <input type="hidden" name="productId" value="${product.id}" />
                                                <button type="submit" class="btn btn-danger">update</button>
                                                       </form>
                                                 </td>

                                          <td>
                                              <!-- Button to delete the product -->
                                              <form action="deleteProduct" method="post">
                                                  <input type="hidden" name="productId" value="${product.id}" />
                                                  <button type="submit" class="btn btn-danger">Delete</button>
                                             </form>
                                          </td>

                              </tr>
                          </c:forEach>

           </tbody>
       </table>
        <!-- Check if the list is empty -->
           <c:if test="${empty productList}">
               <p style="text-align: center;">No products found.</p>
           </c:if>



  <br><br>

         <!-- Button to add the product -->
          <form action="addProduct"   modelAttribute="productDetails">
        <button type="submit" class="btn btn-danger">Add new product</button>
        </form>
 </body>
 </html>
