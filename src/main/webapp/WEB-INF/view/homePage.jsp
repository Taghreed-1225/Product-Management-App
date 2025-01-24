 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <!-- to use foreach -->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <html>
<head>
    <%--        import Bootstrap--%>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">

</head>
 <body>
 <h2> Products date </h2>

  <div class="searchDiv">
   <form action="searchProduct" method="get">
       Search Product<input type="text" class="form-control" name="searchKey" placeholder="enter product name"/>
        <input type="submit" value="Search" class="btn btn-success">
   </form>
  </div>


        <div class="tbl-div">
       <table  class="table">
           <thead class="thead-dark">
               <tr>
                    <th scope="col">#</th>
                               <th scope="col">Name</th>
                               <th scope="col">Show Details</th>
                               <th scope="col">Add/Update</th>
                               <th scope="col">Delete</th>
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
                                                  <button type="submit" class="btn btn-primary">Show details</button>
                                              </form>
                                          </td>
                                            <td>
                                                        <!-- Button to update the product -->
                                                      <form action="updateProduct" modelAttribute="productDetails">
                                                           <input type="hidden" name="productId" value="${product.id}" />
                                                <button type="submit" class="btn btn-warning">update</button>
                                                       </form>
                                                 </td>

                                          <td>
                                              <!-- Button to delete the product -->
                                              <form action="deleteProduct" method="post">
                                                  <input type="hidden" name="Id" value="${product.id}" />
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
        <button type="submit" class="btn btn-success">Add new product</button>
        </form>
  </div>
 </body>
 </html>
