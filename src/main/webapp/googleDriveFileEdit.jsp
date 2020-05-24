<%@include file="includes/header.jsp"%>

<% String controller = "/googleDriveFileNew"; %>

<c:if test="${not empty file}">
    <% controller = "/googleDriveFileUpdate";%>
</c:if>

<div class="container">

    <p class="message">${message}</p>

    <form action="<%= controller%>" method="post">
        <c:if test="${not empty file}">
            <input type="hidden" name="id" value="${file.id}">
        </c:if>
        <p class="letras"><label for="title">Nombre de mi lista:</label></p>
        <input type="text" name="title" id="title"
               <c:if test="${not empty file}">
                   disabled="true" 
                   value="${file.title}"
               </c:if>
               />
        <p class="letras"><label for="content">Películas que quiero ver:</label></p>
        <textarea id="content" name="content" style="margin: 0px; height: 433px; width: 492px;">${content}</textarea>

        <div class="bottom_links">
            <button type="submit" class="button">Guardar</button>
			<input class="button" type="button" onClick="history.back()" name="Volver" value="Volver">
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp"%>
