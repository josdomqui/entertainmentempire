<%@include file="includes/header.jsp"%>
<link href="css/pruebas.css" rel="stylesheet">
<h1>Spotify playlists</h1>

<div class="container">

    <p class="message">${message}</p>

    <table id="listas">
        <tr>
            <th>Nombre</th>				
        </tr>
        <c:forEach items="${playlists.items}" var="playlist">
            <tr>
                <td><c:out value="${playlist.name}"/></td>										
            </tr>
        </c:forEach>			
    </table>
    <p>
        <a href="/spotifyPlaylistNew" class="button">Crear playlist en Spotify</a>
		<input class="button" type="button" onClick="history.back()" name="Volver" value="Volver">
</div>

<%@include file="includes/footer.jsp"%>
