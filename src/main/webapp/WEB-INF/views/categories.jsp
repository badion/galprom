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
        <%--<div class="banner">--%>
            <%--<h1>Macenas Conte hendrit </h1>--%>
            <%--<h2>lorem quis orcitor</h2>--%>
        <%--</div>--%>
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
                               <a class="btn btn-default" href="categories/${categ.link}">${categ.name}</a>
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
    </jsp:body>
</t:genericpage>