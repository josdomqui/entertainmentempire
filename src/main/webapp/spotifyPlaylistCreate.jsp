<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="includes/header.jsp"%>
<link href="css/pruebas.css" rel="stylesheet">
<c:if test='${empty sessionScope["Spotify-token"]}'>
    <c:redirect url = "/AuthController/Spotify"/>
</c:if>

<h1>Creacion de playlist</h1>
<div class="container">

    <p class="message"></p>

    <form action="/spotifyPlaylistNew" method="post">

        <label for="name">Nombre:</label>
        <textarea id="name" name="name"></textarea>

        <label for="description">Descripción:</label>
        <textarea id="description" name="description"></textarea>

        <div class="bottom_links">
            <button type="submit" class="button">Crear playlist en Spotify</button>
			<input class="button" type="button" onClick="history.back()" name="Volver" value="Volver">
        </div>
    </form>
</div>

<%@include file="includes/footer.jsp"%>
