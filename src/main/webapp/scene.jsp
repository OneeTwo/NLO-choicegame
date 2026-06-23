<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<p>${sceneText}</p>

<ul>
    <c:forEach items="${choices}" var="choice">
        <li>
            <a href="${choice.value}">${choice.key}</a>
        </li>
    </c:forEach>
</ul>

<c:if test="${isEnding}">
    <form action="${pageContext.request.contextPath}/" method="get">
        <button type="submit">Restart Game</button>
    </form>
</c:if>