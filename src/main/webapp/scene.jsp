<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
<head>
    <title>NLO Choice Game</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">
<div class="container mt-5 text-center">

    <p class="lead">${sceneText}</p>

    <c:if test="${not empty choices}">
        <div class="d-grid gap-2 col-6 mx-auto">
            <c:forEach items="${choices}" var="choice">
                <a class="btn btn-outline-light"
                   href="${pageContext.request.contextPath}/game?scene=${choice.nextQuestionId}">
                    ${choice.text}
                </a>
            </c:forEach>
        </div>
    </c:if>

    <c:if test="${isEnding}">
        <form action="${pageContext.request.contextPath}/" method="get" class="mt-4">
            <button class="btn btn-danger" type="submit">Restart Game</button>
        </form>
    </c:if>

</div>
</body>
</html>