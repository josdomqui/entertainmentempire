<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <title>Tokens</title>
        <link href="css/pruebas.css" rel="stylesheet">
    </head>

    <body>
        <h2> Tokens de OAuth </h2>
        <ul>
            <li><strong>Google Drive:</strong>
                <ul>
                    <li><c:out value='${sessionScope["GoogleDrive-token"]}' /> </li>
                </ul>
            </li>
            <li><strong>Spotify:</strong>
                <ul>
                    <li><c:out value='${sessionScope["Spotify-token"]}' /> </li>
                </ul>
            </li>
        </ul>
    </body>
</html>
