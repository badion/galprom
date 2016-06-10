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
        <div class="container">

            <form:form id="loginForm" method="post" action="login" modelAttribute="user">
                <h2 class="form-signin-heading">Будь-ласка залогіньтесь</h2>
                <form:label path="username">Введіть ваш логін</form:label>
                <form:input class="form-control" style="    width: 300px;" id="username" name="username"
                            path="username"/><br>
                <form:label path="username">Введіть ваш пароль</form:label>
                <form:password class="form-control" style="    width: 300px;" id="password" name="password"
                               path="password"/><br>
                <input type="submit" style="    width: 300px;" class="btn btn-lg btn-primary btn-block"></input>
            </form:form>
        </div>
        <p>${message}</p>
    </jsp:body>
</t:genericpage>
