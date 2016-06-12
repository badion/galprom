<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/style.css" rel="stylesheet">


    <%--<script src="<%=request.getContextPath()%>/static/js/jquery.validate.min.js"></script>--%>
    <%--<script src="<%=request.getContextPath()%>/static/js/custom_js/category_validation.js"></script>--%>
    <%--<script src="<%=request.getContextPath()%>/static/js/custom_js/good_validation.js"></script>--%>
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.96.1/js/materialize.min.js"></script>--%>
</head>
<body>
<div id="pageheader">
    <jsp:invoke fragment="header"/>
</div>
<div id="body">
    <jsp:doBody/>
</div>
<div id="pagefooter">
    <jsp:invoke fragment="footer"/>
</div>
</body>
</html>