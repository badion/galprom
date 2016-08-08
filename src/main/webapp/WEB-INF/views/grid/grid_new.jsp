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
		<jsp:include page="../../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>

<script>
    (function($,W,D)
    {
        var JQUERY4U = {};

        JQUERY4U.UTIL =
        {
            setupFormValidation: function()
            {
                //form validation rules
                $("#new_grid").validate({
                    rules: {
                        cell_w: {
                            number: true
                        },
                        cell_h: {
                            number: true
                        },
                        roll_length: {
                            number: true
                        },
                        roll_width: {
                            number: true
                        },
                        diametr: {
                            number: true
                        },
                        price: {
                            number: true
                        },
                    },
                    messages: {
                        cell_w: "Поле може містити тільки цифри",
                        cell_h: "Поле може містити тільки цифри",
                        roll_length: "Поле може містити тільки цифри",
                        roll_width: "Поле може містити тільки цифри",
                        diametr: "Поле може містити тільки цифри",
                        price: "Поле може містити тільки цифри",
                    },
                    submitHandler: function(form) {
                        form.submit();
                    }
                });
            }
        }

        //when the dom has loaded setup form validation rules
        $(D).ready(function($) {
            JQUERY4U.UTIL.setupFormValidation();
        });

    })(jQuery, window, document);

</script>

        <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <div class="container">
        <h4>Форма для додавання сітки</h4>
        <div class="row">
            <form:form id="new_grid" method="POST"  modelAttribute="grid" class="col s12">
                <form:input type="hidden" path="id" id="id"/>
                <form:input type="hidden" path="subcategory" id="subcategory"/>

                <!-- Ширина довжина ячейки -->
                <div class="row">
                    <div class="input-field col s6">
                        <label for="cell_w">Ширина ячейки</label>
                        <form:input class="form-control validate" type="text" name="cell_w" path="cell_w" id="cell_w"/>
                        <div class="has-error">
                            <form:errors path="cell_w" class="help-inline"/>
                        </div>
                    </div>
                    <div class="input-field col s6">
                        <label for="cell_h">Висота ячейки</label>
                        <form:input type="text" path="cell_h" id="cell_h" name="cell_h" class="form-control validate"/>
                        <div class="has-error">
                            <form:errors path="cell_h" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <!-- Довжина ширина рулону -->
                <div class="row">
                    <div class="input-field col s6">
                        <label for="roll_length">Довжина рулону</label>
                        <form:input  type="text" path="roll_length" id="roll_length" name="roll_length" class="form-control validate"/>
                        <div class="has-error">
                            <form:errors path="roll_length" class="help-inline"/>
                        </div>
                    </div>
                    <div class="input-field col s6">
                        <label for="roll_width">Ширина рулону</label>
                        <form:input type="text" path="roll_width" id="roll_width" name="roll_width" class="form-control validate"/>
                        <div class="has-error">
                            <form:errors path="roll_width" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <!-- Діаметр, ціна-->
                <div class="row">
                    <div class="input-field col s6">
                        <label for="diametr">Діаметр</label>
                        <form:input type="text" path="diametr" id="diametr" name="diametr" class="form-control validate"/>
                        <div class="has-error">
                            <form:errors path="diametr" class="help-inline"/>
                        </div>
                    </div>
                    <div class="input-field col s6">
                        <label for="price">Ціна</label>
                        <form:input type="text" path="price" id="price" name="price" class="form-control validate"/>
                        <div class="has-error">
                            <form:errors path="price" class="help-inline"/>
                        </div>
                    </div>
                </div>

                <p>Поля з * обов'язкові</p>

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