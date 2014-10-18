<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="java.util.List"%>
<%@page import="com.dgti.modelo.Usuario"%>
<%@page import="com.dgti.ejb.session.interfaces.ManejaUsuarioLocal"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Llamando a un ejb desde un jsp</title>
</head>
<body>
<%! 
private Context getContext() throws NamingException{
	java.util.Properties props = new java.util.Properties();
	props.put(Context.INITIAL_CONTEXT_FACTORY,
			"org.jnp.interfaces.NamingContextFactory");
	props.put(Context.PROVIDER_URL, "jnp://localhost:1099");
	props.put(InitialContext.URL_PKG_PREFIXES,
			"org.jboss.naming:org.jnp.interfaces");
	Context ctx = new InitialContext(props);
	return ctx;
}
%> 
<%
try{
	// Generar contexto con Jboss
	Context context = getContext();
	// Enlazar la interfaz ManejaUsuarioLocal
	ManejaUsuarioLocal manejaUsuario = (ManejaUsuarioLocal)context.lookup("ManejaUsuarioLocal");
	// Generar al menos tres usuarios y ejecutar los métodos de insertar
	Usuario usuario1 = new Usuario();
		// asignar sus atributos
		usuario1.setCuenta("32908716");
	Usuario usuario2 = new Usuario();
		// asignar sus atributos
		usuario2.setCuenta("eloiza23");
	Usuario usuario3 = new Usuario();
		// asignar sus atributos
		usuario3.setCuenta("cafaray@gmail.com");
	manejaUsuario.registrar(usuario1);
	manejaUsuario.registrar(usuario2);
	manejaUsuario.registrar(usuario3);		
	// Imprimir la lista de usuarios generada
	List<Usuario> usuarios = manejaUsuario.listado();
	int x = 0;
	for(Usuario usuario:usuarios){
		out.println(String.format("Usuario %d: %s%n", ++x, usuario.getCuenta()));
	}
	// ?? Eliminar el ejb de sesion con estado
	manejaUsuario.remove();
	
	}catch(NamingException e){
		out.println(e);
		e.printStackTrace(System.out);
	}

%>
</body>
</html>