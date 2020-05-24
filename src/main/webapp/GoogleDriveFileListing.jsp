<%@include file="includes/header.jsp"%>

<h1>Archivos en tu Google Drive</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="files">
        <tr>
            <th>Nombre</th>
            <th>Tamaño</th>
            <th>Última modificación</th>
            <th>Editar</th>
            <th>Borrar</th>
        </tr>
        <c:forEach items="${requestScope.files.items}" var="file">
            <tr>
                <td><c:out value="${file.title}"/></td>
                <td><c:out value="${file.fileSize}"/></td>
                <td><c:out value="${file.modifiedDate}"/></td>
                <td>
                    <a href="/googleDriveFileUpdate?id=${file.id}"><img src="./images/edit.png" width="30px"></a>
                </td>
                <td>
                    <a href="/googleDriveFileDelete?id=${file.id}"><img src="./images/delete.png" width="30px"></a>
                </td>
            </tr>
        </c:forEach>			
    </table>
    <p>
        <a href="/googleDriveFileEdit.jsp" class="button">Crear nuevo archivo con películas</a>
		<input class="button" type="button" onClick="history.back()" name="Volver" value="Volver">
</div>

<%@include file="includes/footer.jsp"%>
