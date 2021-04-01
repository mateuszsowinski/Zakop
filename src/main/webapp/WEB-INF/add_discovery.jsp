<%@ include file="/WEB-INF/header.jsp" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/styles/add-discovery-form.css">

<form action="/app/add/discovery" method="post" class="discovery-form">
    <h2 class="discovery-form-title"> Dodaj </h2>
    <input name="title" placeholder="Tytuł" required>
    <input name="url" placeholder="Adres URL" required>
    <select name="categoryId">
        <c:forEach items="${categories}" var="categoryId">
            <option value="${categoryId.id}">${categoryId.name}</option>
        </c:forEach>
    </select>
    <textarea name="text" placeholder="Opis" required></textarea>
    <button class="discovery-form-button" type="submit">Dodaj</button>

</form>


<%@ include file="/WEB-INF/footer.jsp" %>
