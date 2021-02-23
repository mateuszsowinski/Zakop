
    <%@ include file="/header.jsp" %>
    <main>
        <c:forEach items="${discoveries}" var="discovery">
            <article class="discovery">
                <h2 class="discovery-header"> ${discovery.title}</h2>
                <p class="discovery-details">Dodane przez:
                    Mietek, ${discovery.dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"))}</p>
                <a href="<c:out value="${discovery.url}"/>" target="_blank" class="discovery-link"><c:out
                        value="${discovery.url}"/></a>
                <p>${discovery.description}</p>
                <section class="discovery-bar">
                    <a href="#" class="discovery-link upvote">
                        <i class="fas fa-arrow-alt-circle-up discovery-upvote"></i>
                    </a>
                    <p class="discovery-votes">32</p>
                    <a href="#" class="discovery-link downvote">
                        <i class="fas fa-arrow-alt-circle-down discovery-downvote"></i>
                    </a>
                </section>
            </article>
        </c:forEach>

        <%@ include file="/footer.jsp" %>


