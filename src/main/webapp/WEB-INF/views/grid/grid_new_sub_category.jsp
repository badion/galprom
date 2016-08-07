<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../../parts/header.jsp"/>
    </jsp:attribute>
    <jsp:attribute name="footer">
  	 	<jsp:include page="../../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
        <h4>Форма для виду сітки</h4>
        <div class="row">
            <form method="POST"
                  action="<c:url value='/categories/newGridSubCategory?${_csrf.parameterName}=${_csrf.token}' />"
                  enctype="multipart/form-data"
                  accept-charset="UTF-8">

                <!-- Назва -->
                <div class="row">
                    <div class="input-field col s6">
                        <label for="name">Назва</label>
                        <input class="form-control" type="text" id="name" name="name"/>
                    </div>
                </div>

                <!-- Опис -->
                <div class="row">
                    <div class="input-field col s6">
                        <label for="description">Опис</label>
                        <input class="form-control" type="text" id="description" name="description"/>

                    </div>
                </div>

                <!-- Зображення -->
                <div class="row">
                    <div class="file-field col s6">
                        <label for="image">
                            <span class="btn btn-success">Виберіть зображення</span>
                        </label>
                        <input style="visibility: hidden; position: absolute;" id="image" class="form-control"
                               type="file" name="image">
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="Додати" class="btn btn-primary btn-sm"/> <a
                            href="<c:url value='/categories/grid' />">Відмінити</a>
                    </div>
                </div>
            </form>
        </div>
    </jsp:body>
</t:genericpage>