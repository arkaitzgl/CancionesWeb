<%@page import="com.ipartek.formacion.canciones.pojo.Cancion"%>

<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Modificar | Canciones Web</title>	
	<link rel="stylesheet" type="text/css" href="css/styles.css">	
</head>
<body>

<%Cancion c=(Cancion)request.getAttribute("cancion");%>

<form action="modificar" method="post">
 
 	<label for="id">Identificador:</label>
	<input
		   type="text" 
	       name="id" 
 	       value="<%=c.getId()%>" 
	       readonly>
	       
	<br>
	<br>
	<label for="nombre">Nombre:</label>
	<input type="text" 
	       name="nombre" 
	       value="<%= c.getNombre()%>"
	       required>
	
	<br>
	<br>
	<label for="artista">Artista:</label>
	<input type="text" 
	       name="artista" 
	       value="<%=c.getArtista()%>"
	       required>
	
	<br>
	<br>
	<label for="duracion">Duracion:</label>
	<input type="text" 
	       name="duracion" 
	       value="<%=c.getDuracion()%>"
	       required>
	
	<br>
	<br>
	<label for="cover">Carátula:</label>
	<input type="text" 
	       name="cover" 
	       value="<%=c.getCover()%>"
	       >
	
	<br>
	<br>


	<input type="submit" value="Modificar">

</body>
</html>