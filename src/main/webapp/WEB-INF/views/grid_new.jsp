<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <div class="container">
            <div class="well lead">Форма для додавання сітки</div>
            <form:form method="POST" modelAttribute="grid" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="name">Назва</label>
                        <div class="col-md-7">
                            <form:input type="text" path="name" id="name" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="name" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="cell_w">Ширина ячейки</label>
                        <div class="col-md-7">
                            <form:input type="text" path="cell_w" id="cell_w" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="cell_w" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="cell_h">Висота ячейки</label>
                        <div class="col-md-7">
                            <form:input type="text" path="cell_h" id="cell_h" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="cell_h" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="diametr">Діаметр</label>
                        <div class="col-md-7">
                            <form:input type="text" path="diametr" id="diametr" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="diametr" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="roll_length">Довжина рулону</label>
                        <div class="col-md-7">
                            <form:input type="text" path="roll_length" id="roll_length" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="roll_length" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="roll_width">Ширина рулону</label>
                        <div class="col-md-7">
                            <form:input type="text" path="roll_width" id="roll_width" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="roll_width" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label class="col-md-3 control-lable" for="price">Ціна(грн.)</label>
                        <div class="col-md-7">
                            <form:input type="text" path="price" id="price" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="price" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="Модифікувати" class="btn btn-primary btn-sm"/> or <a
                                    href="<c:url value='/categories/grid' />">Відмінити</a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="Додати" class="btn btn-primary btn-sm"/> or <a
                                    href="<c:url value='/categories/grid' />">Відмінити</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
        </div>
    </jsp:body>
</t:genericpage>