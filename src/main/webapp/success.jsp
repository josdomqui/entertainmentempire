<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/searchstyle.css">

<title>Entertainment · Empire</title>
</head>
<body>

  <header class="masthead mb-auto">
    <div class="inner">
      <h3 class="masthead-brand">Enternainment Empire</h3>
     	<br> </br>
     	<br> </br>
        <li> <a class="nav-link active" href="/index.html">Home </a></li>
        <br> </br>

        <li> <a class="nav-link" href="/QueSomos.html">¿Que somos?</a></li>
        <br> </br>
        <li> <a class="nav-link" href="/docs/api.html">API Rest</a></li>
      	<br> </br>
      	<li> <a class="nav-link" href="/googleDriveFileEdit.jsp">Crear Títulos</a></li>
      	<br> </br>
      	<li> <a class="nav-link" href="/googleDriveFileList">Mis Titulos</a></li>
      	<br> </br>
      	<li> <a class="nav-link" href="/spotifyPlaylistsGet">Mis Playlists</a></li>
      	
    </div>
  </header>
  
<fieldset id="tmdb">
<legend>Resultados de   <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.movies}" var="movie">
	<div><img src="https://image.tmdb.org/t/p/w185/${movie.posterPath}" 
	alt="Esta serie o pelicula no tiene imagen de portada disponible"/></div>
	<span>Titulo: <c:out value="${movie.title},${movie.name}"/></span><br/>
	<span>Sinopsis: <c:out value="${movie.overview}"/></span><br/>
	<br/>
</c:forEach>
</fieldset>

<fieldset id="youtube">
<legend>Trailers de <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.videos}" var="video">
<iframe id="ytplayer" type="text/html" width="640" height="360"
  src="https://www.youtube.com/embed/<c:out value="${video.id.videoId}"/>?autoplay=0"
  frameborder="0"/></iframe>	
</c:forEach>
</fieldset>

<fieldset id="spotify">
<legend>Banda sonora de  <c:out value="${param.searchQuery}"/></legend>
<c:forEach items="${requestScope.playlists}" var="playlist">
	
	<iframe src="https://open.spotify.com/embed/playlist/<c:out value="${playlist.id}"/>" width="300" height="380" frameborder="0" allowtransparency="true" allow="encrypted-media"></iframe>

	<div class="container">

    <p class="message"></p>

    <form action="/FollowController" method="put">

        <label for="id">Id:</label>
        <input id="id" name="id" value="${playlist.id}" ></input>


        <div class="bottom_links">
            <button type="submit" class="button">Seguir</button>
        </div>
    </form>
</div>
	
</c:forEach>
</fieldset>

</body>
</html>
















