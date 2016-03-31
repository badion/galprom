<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
		   prefix="springForm"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp" />
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp" />
    </jsp:attribute>
	<jsp:body>
		<div class="container">
			<div class="row">
				<c:forEach var="categ" items="${category}">
					<div class="col m6 l4">
						<header>
							<h4>${categ.name}</h4>
						</header>
						<p class="subtitle">${categ.subtitle} </p>
						<p>
							<a href="#"><img class="responsive-img" src="<c:url value="/static/images/${categ.imgFN}" />" alt=""></a>
						</p>
					</div>
				</c:forEach>
			</div>
		</div>
		<%--		<div class="center-btn">
                 <a href="<c:url value='/categories/add'/>"
                              class="btn-floating btn-large waves-effect waves-light red"><i
                    class="material-icons">add</i></a>
                </div>--%>
	</jsp:body>
</t:genericpage>