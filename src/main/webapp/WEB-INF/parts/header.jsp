<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}

</script>

<div class="header-section">
    <div class="header">
        <div class="logo">
            <h1>ГАЛПРОМ</h1>
        </div>
        <div class="menu">
            <ul>
                <li><a href="/galprom" class="active">Домашня </a></li>
                <li><a href="/about">Про нас  </a></li>
                <li><a href="/categories">Категорії </a></li>
            </ul>
        </div>
    </div>
</div>
<!---------end-of-header--------->



<%--<div id="header">
    <nav class="light-blue lighten-1" role="navigation">
        <div class="container">
            <div class="nav-wrapper">
                <a id="logo-container" href="/galprom/" class="brand-logo">ГАЛПРОМ</a>
                <ul class="right hide-on-med-and-down">
                    <li class="active"><a href="/galprom/ ">Домашня сторінка</a></li>
                    <li><a href="/galprom">Категорії</a></li>
                    <li><a href="#">Залогінитись</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>Welcome : ${pageContext.request.userPrincipal.name} | <a
                                href="javascript:formSubmit()"> Розлогінитись</a>
                        </li>
                        <c:url value="/logout" var="logoutUrl"/>
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </c:if>
                </ul>
                <ul id="nav-mobile" class="side-nav">
                    <li class="active"><a href="//galprom/">Домашня сторінка</a></li>
                    <li><a href="/galprom">Категорії</a></li>
                    <li><a href="#">Залогінитись</a></li>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <li>Welcome : ${pageContext.request.userPrincipal.name} | <a
                                href="javascript:formSubmit()"> Logout</a>
                        </li>
                        <c:url value="/logout" var="logoutUrl"/>
                        <form action="${logoutUrl}" method="post" id="logoutForm">
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}"/>
                        </form>
                    </c:if>
                </ul>
                <a href="#" data-activates="nav-mobile" class="button-collapse"><i
                        class="mdi-navigation-menu"></i></a>
            </div>
        </div>
    </nav>
</div>--%>
<script>

</script>
