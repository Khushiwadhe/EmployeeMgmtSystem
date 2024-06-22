<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<p>
	<% 
		String message = request.getParameter("message");
		if(message!=null){
			out.print(message);			
		}
	%>
</p>