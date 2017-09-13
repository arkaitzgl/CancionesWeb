<%@page import="com.ipartek.formacion.canciones.pojo.Cancion"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Canciones web</title>
	
	<link rel="stylesheet" type="text/css" href="css/styles.css">
	
</head>
<body>

<% 
	//gestion de los mensajes para el Usuario
	String mensaje=(String)request.getAttribute("mensaje");
	if (mensaje!=null){
		out.print("<p>"+mensaje+"</p>");
	}

%>

<h1>Listado Canciones</h1>

<ol>
	<%
		//recorrer el ArrayList
		ArrayList<Cancion> canciones = (ArrayList<Cancion>)request.getAttribute("listado"); 
		if (canciones.size()==0){
			String mensa="No hay m�s canciones";
			out.print("<p>"+mensa+"</p>");
		}else{
		for( Cancion c : canciones){		
	%>
		<li><img src="<%=c.getCover() %>" alt="Imagen de la portada Album" class="cover" />
		<%=c.getNombre()%> - <%=c.getArtista()%> <b><%=c.getDuracion()%>
		 </b><a href="eliminar?id=<%=c.getId()%>">Eliminar</a></li>
		
	<% }} %>
</ol>
	

<h2>Crear Cancion</h2>


<form action="crear" method="post">

	<input type="text" 
	       name="nombre" 
	       placeholder="Nombre de la Cancion" 
	       required>
	
	<br>
	<br>
	<input type="text" 
	       name="artista" 
	       placeholder="Artista de la Cancion" 
	       required>
	
	<br>
	<br>
	<input type="text" 
	       name="duracion" 
	       placeholder="00:00" 
	       required>
	
	<br>
	<br>
	<input type="text" 
	       name="cover" 
	       placeholder="https://s.discogs.com/images/default-release-cd.png" 
	       >
	
	<br>
	<br>
	

	<input type="submit" value="Crear Cancion Nueva">

</form>
</body>