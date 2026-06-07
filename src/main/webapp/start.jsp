<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

${sceneText}
<c:if test="${showQuestion}">
     ${question}
</c:if>

<ul>
     <c:forEach items="${choices}" var="choice">
         <li>
             <a href="${choice.value}">${choice.key}</a>
         </li>
     </c:forEach>
 </ul>