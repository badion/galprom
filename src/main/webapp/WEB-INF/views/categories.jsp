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
							<c:set var="categoryName" value="${categ.name}"/>
							<c:if test="${fn:contains(categoryName, 'Сітка')}">
								<a href="categories/grid"><img class="responsive-img" src="<c:url value="/static/images/${categ.imgFN}" />" alt=""></a>
							</c:if>
							<c:if test="${fn:contains(categoryName, 'Реставрація')}">
								<a href="#restavraciya"><img class="responsive-img" src="<c:url value="/static/images/${categ.imgFN}" />" alt=""></a>
							</c:if><c:if test="${fn:contains(categoryName, 'Торсіони')}">
								<a href="#torsion_table"><img class="responsive-img" src="<c:url value="/static/images/${categ.imgFN}" />" alt=""></a>
							</c:if>

						</p>
					</div>
				</c:forEach>
			</div>
            <div class="container" name="grid_table">
                <div class="row">
                    <c:forEach var="grid" items="${grids}">
                        <div class="collection">
                            <a href="#!" class="collection-item">${grid.name}, ${grid.cell_h} / ${grid.cell_w}, ${grid.price} грн.</a>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="container" name="torsion_table">
                <div class="row">
                    <c:forEach var="torsion" items="${torsions}">
                        <div class="collection">
                            <a href="#!" class="collection-item">${torsion.name}, лівий(${torsion.code_left}), правий(${torsion.code_right}), ${torsion.price} грн.</a>
                        </div>
                    </c:forEach>
                </div>
		    </div>
        </div>
	</jsp:body>
</t:genericpage>