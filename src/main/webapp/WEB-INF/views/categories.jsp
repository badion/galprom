<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="clearing"></div>
        <div class="header">
            <div class="logo">
                <h1 style="margin-top: 42px;">ГАЛПРОМ<span>ГАРАНТ</span></h1>
            </div>
            <div class="social">
                <ul>
                    <li><a href="#"><img src="<c:url value="/static/images/aim.png" />" alt="">
                    <li><a href="#"><img src="<c:url value="/static/images/facebook.png" />" alt="">
                    <li><a href="#"><img src="<c:url value="/static/images/twwtter.png" />" alt="">
                    <li><a href="#"><img src="<c:url value="/static/images/linkedin.png" />" alt="">
                </ul>
            </div>
        </div>
        <!--------header wrap ends--------->
        <div class="banner">
            <h1>Macenas Conte hendrit </h1>
            <h2>lorem quis orcitor</h2>
        </div>
        <div class="page">
        <div class="primary-col">
            <c:forEach var="categ" items="${category}" varStatus="myIndex">
                <c:if test="${myIndex.index < 2}">
                    <div class="block float-left mar-top30">
                        <div class=" panel">
                            <div class="title">
                                <h1>${categ.name}</h1>
                            </div>
                            <div class="content">
                                <img style="width: 250px;
                                            height: 200px;"
                                     src="<c:url value="/static/images/${categ.imgFN}" />" alt="">
                                <h2>${categ.subtitle}</h2>

                                <button type="button" class="btn btn-default"> <a href="categories/${categ.link}">${categ.name}</a></button>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
        <div class="side-bar">
            <div class="search" style="margin-top: 30px;">
                <div class="title">
                    <h1>Пошук</h1>
                </div>
                <ul>
                    <li>
                        <input name="" type="text" class="textfiled"/>
                    </li>
                    <li>
                        <img src="<c:url value="/static/images/search-icon.jpg" />" alt="search">
                    </li>
                </ul>
            </div>
            <div class="panel">
                <div class="title"><span>
                 <img src="<c:url value="/static/images/icon1.jpg" />" alt="icon">
                </span>
                    <h1>Категорії</h1>
                </div>
                <div class="content">
                    <ul>
                        <c:forEach var="categ" items="${category}">
                            <li><a href="/galprom/categories/${categ.link}">${categ.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>


        <%--  <div class="container">
              <div class="bannner-section">
                  <div class="banner-title-section">
                      <div class="banner-title">
                          <c:forEach var="categ" items="${category}">
                              <div class="panel">
                                  <h1>${categ.name}</h1>
                              </div>
                          </c:forEach>
                      </div>
                  </div>
                  <div class="clear"></div>
                  <div class="banner-row">
                      <div class="banner">
                          <c:forEach var="categ" items="${category}">
                          <a href="categories/${categ.link}">
                              <div class="panel"><img src="<c:url value="/static/images/${categ.imgFN}" />"
                                                      alt="">
                          </a></div>
                      </c:forEach>
                  </div>
                  <div class="clear"></div>
              </div>
              <div class="banner-content">
                  <div class="row">
                      <c:forEach var="categ" items="${category}">
                          <div class="panel">
                              <div class="title">
                                  <h1>${categ.name}</h1>
                              </div>
                              <div class="content">
                                  <p>${categ.subtitle}</p>
                              </div>
                              <div class="controller">
                                  <div class="button"><a href="#">More Info</a></div>
                              </div>
                          </div>
                      </c:forEach>
                  </div>
                  <div class="clear"></div>
              </div>
              <div class="clear"></div>
          </div>

          <!--------------banner-section----------->
          <div class="page-section">
              <div class="page">
                  <div class="right-section">


                      <table class="controller">
                          <tr>
                              <th><p>Ім'я</p></th>
                              <th><p>Ширина ячейки</p></th>
                              <th><p>Висота ячейки</p></th>
                              <th><p>Діаметер ячейки</p></th>
                              <th><p>Довжина рулону</p></th>
                              <th><p>Ширина рулону</p></th>
                              <th><p>Ціна</p></th>
                          </tr>
                          <c:forEach var="grid" items="${grids}">
                              <tr>
                                  <td><p>${grid.name}</p></td>
                                  <td><p>${grid.cell_w}</p></td>
                                  <td><p>${grid.cell_h}</p></td>
                                  <td><p>${grid.diametr}</p></td>
                                  <td><p>${grid.roll_length}</p></td>
                                  <td><p>${grid.roll_width}</p></td>
                                  <td><p>${grid.price}</p></td>
                                  <td>
                                      <div class="button">
                                          <a href="<c:url value='/categories/grid/${grid.id}'/>"
                                             class="secondary-content">Більше</a></p>

                                              &lt;%&ndash;<a href="#">More Info</a>&ndash;%&gt;
                                      </div>
                                  </td>
                                  <td>
                                      <form:form method="POST" action="/categories/grid/${grid.id}">
                                          <input type="submit" value="Видалити" class="btn btn-primary btn-sm"/>
                                      </form:form></td>
                              </tr>
                          </c:forEach>
                      </table>


                  </div>
                  <!--------------------right-section------------>
              </div>
              <div class="clear"></div>
          </div>--%>


        <%--
                    <div class="row">
                        <c:forEach var="categ" items="${category}">
                            <div class="col m6 l4">
                                <header>
                                    <h4>${categ.name}</h4>
                                </header>
                                <p class="subtitle">${categ.subtitle} </p>
                                <p>
                                    <a href="categories/${categ.link}">
                                        <img class="responsive-img" src="<c:url value="/static/images/${categ.imgFN}" />"
                                             alt=""></a>
                                </p>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="container" name="grid_table">
                        <c:forEach var="grid" items="${grids}">
                            <ul class="collection">
                                <li class="collection-item avatar">
                                        &lt;%&ndash;<img src="images/yuna.jpg" alt="" class="circle">&ndash;%&gt;
                                    <i class="material-icons circle green">insert_chart</i>
                                    <span class="title">${grid.name}</span>
                                    <p>Висота/Ширина ячейки: ${grid.cell_h}
                                        / ${grid.cell_w}<br>
                                        Ціна: ${grid.price}
                                        <a style="margin-top: 30px;" href="<c:url value='/categories/grid/edit/${grid.id}'/>"
                                           class="secondary-content"><i class="material-icons">mode_edit</i></a>
                                    </p>

                                    <a href="#modal${grid.id}" class="secondary-content modal-trigger"><i
                                            class="material-icons">delete</i></a>


                                    <div id="modal${grid.id}" class="modal bottom-sheet">
                                        <div class="modal-content">
                                            <h4>Видалення сітки</h4>
                                            <p>Ви дійсно хочете видалити елемент?</p>
                                        </div>
                                        <div class="modal-footer">
                                            <c:url var="deleteGrid" value="/categories/grid/${grid.id}"/>
                                            <form:form method="POST" action="${deleteGrid}">
                                                <input type="submit" value="Видалити" class="btn btn-primary btn-sm"/> or <a
                                                    href="<c:url value='/categories/grid' />">Відмінити</a>
                                            </form:form>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </c:forEach>
                    </div>
                    <div class="container" name="torsion_table">
                        <div class="row">
                            <c:forEach var="torsion" items="${torsions}">
                                <div class="collection">
                                    <a href="#!" class="collection-item">${torsion.name}, лівий(${torsion.code_left}),
                                        правий(${torsion.code_right}), ${torsion.price} грн.</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>--%>
    </jsp:body>
</t:genericpage>