<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
           prefix="springForm" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<t:genericpage>
	<jsp:attribute name="header">
		<jsp:include page="../parts/header.jsp"/>
    </jsp:attribute>
	<jsp:attribute name="footer">
  	 	<jsp:include page="../parts/footer.jsp"/>
    </jsp:attribute>
    <jsp:body>
        <script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}

        </script>
        <div class="container">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <div id="mainlogin">
                    <h1>Login with username or password 122</h1>
                    <form name="loginForm" action="<c:url value='login' />" method="POST">
                        <input type="text" class="form-control" style="    width: 300px;" name="name"
                               placeholder="username or email"
                               value="" required> <input class="form-control" style="    width: 300px;" type="password"
                                                         name="password"
                                                         placeholder="password" value="" required>
                        <button style="    width: 300px;" class="btn btn-lg btn-primary btn-block" type="submit">
                            <i class="fa fa-arrow-right">Залогінитись</i>
                        </button>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                    </form>
                    <div id="error_message">
                        <c:if test="${not empty error}">
                            <div class="error">${error}</div>
                        </c:if>
                        <c:if test="${not empty msg}">
                            <div class="msg">${msg}</div>
                        </c:if>
                    </div>
                </div>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div class="logined">
                    <h2>
                        Welcome : ${pageContext.request.userPrincipal.name} | <a
                            href="javascript:formSubmit()"> Logout</a>
                    </h2>
                    <c:url value="/logout" var="logoutUrl"/>
                    <form action="${logoutUrl}" method="post" id="logoutForm">
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>
                    </form>
                </div>
            </c:if>
        </div>

        <%--<form:form id="loginForm" method="post" action="login" modelAttribute="user">--%>
        <%--<h2 class="form-signin-heading">Будь-ласка залогіньтесь</h2>--%>
        <%--<form:label path="username">Введіть ваш логін</form:label>--%>
        <%--<form:input class="form-control" style="    width: 300px;" id="username" name="username"--%>
        <%--path="username"/><br>--%>
        <%--<form:label path="username">Введіть ваш пароль</form:label>--%>
        <%--<form:password class="form-control" style="    width: 300px;" id="password" name="password"--%>
        <%--path="password"/><br>--%>
        <%--<input type="submit" style="    width: 300px;" class="btn btn-lg btn-primary btn-block"/>--%>
        <%--</form:form>--%>
        <%--</div>--%>
        <p>${message}</p>
    </jsp:body>
</t:genericpage>
