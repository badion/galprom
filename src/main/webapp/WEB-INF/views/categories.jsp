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
                <h1 style="margin-top: -144px;">ГАЛПРОМ<span>ГАРАНТ</span></h1>
            </div>
            <div class="social">
                <ul>
                    <li><a href="#"><img src="<c:url value="/static/images/facebook.png" />" alt="">
                </ul>
            </div>
        </div>
        <div class="page">
            <div class="primary-col">
                <c:forEach var="category" items="${categoryList}" varStatus="myIndex">
                    <c:if test="${myIndex.index < 2}">
                        <div class="block float-left mar-top30">
                            <div class=" panel">
                                <div class="title">
                                    <h1>${category.name}</h1>
                                </div>
                                <form method="POST"
                                      action="<c:url value='/categories/img/upload/${category.id}?${_csrf.parameterName}=${_csrf.token}' />"
                                      name="imgUploadForm${category.id}"
                                      enctype="multipart/form-data">
                                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                                        <label for="files${category.id}">
                                            <span class="btn btn-success">Виберіть зображення</span>
                                        </label>
                                    </c:if>
                                    <input style="visibility: hidden; position: absolute;" id="files${category.id}"
                                           class="form-control"
                                           type="file" name="file" onchange="this.form.submit()">
                                </form>
                                <a href="<c:url value='/categories/img/${category.id}' />"><img
                                        style="width: 250px;height: 200px;"
                                        src="<c:url value='/categories/img/${category.id}' />" alt=""></a>
                                <h2>${category.subtitle}</h2>
                                <a class="btn btn-default"
                                   href="<c:url value='/categories/${category.link}' />">${category.name}</a>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <div class="side-bar">
                <div class="panel">
                    <div class="title"><span>
                 <img src="<c:url value="/static/images/icon1.jpg" />" alt="icon">
                </span>
                        <h1>Категорії</h1>
                    </div>
                    <div class="content">
                        <ul>
                            <c:forEach var="category" items="${categoryList}">
                                <li><a href="<c:url value='/categories/${category.link}' />">${category.name}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>