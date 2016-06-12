<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
<div class="menu-wrap">
    <div class="menu">
        <ul>
            <li><a href="/galprom" class="active">Домашня </a></li>
            <li><a href="/galprom/about">Про нас </a></li>
            <li><a href="/galprom/categories">Категорії </a></li>
            <c:if test="${loggedInUser == null}">
                <li><a href="/galprom/login">Логін</a></li>
            </c:if>
            <c:if test="${loggedInUser != null}">
                <li><a>${loggedInUser}</a></li>
                <li><a href="/galprom/logout">Вийти</a></li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li><a>${pageContext.request.userPrincipal.name}</a></li>
                <c:url value="/logout" var="logoutUrl" />
                <li><a href="javascript:formSubmit()"> Logout</a></li>
                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />
                </form>
            </c:if>
        </ul>
    </div>

</div>

