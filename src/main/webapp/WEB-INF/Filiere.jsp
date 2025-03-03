<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des filieres</title>
</head>
<body>
	<h1 style="text-align: center;"> Gestion des filieres </h1>
	<hr />
	
	<div style="position: relative; width: 50%; left: 25%; margin-top: 30px" >
		<form method="post" action="filiere/save">
			<fieldset>
				<legend>${filiereBean.label} d'une filiere</legend>
				
				<table width="100%" cellpadding="5">
					<tr>
						<td> ID </td>
						<td> 
							<input type="text" 
								   name="id"
								   value="${filiereBean.filiere.id}"
								   style="background-color: silver; width: 100%;" 
								   readonly="readonly" /> 
						</td>
					</tr>
					
					<tr>
						<td> Code </td>
						<td> 
							<input type="text" 
								   name="code"
								   value="${filiereBean.filiere.code}"
								   style="width: 100%;" /> 
						</td>
					</tr>
					
					<tr>
						<td> Libelle </td>
						<td> 
							<input type="text" 
								   name="libelle"
								   value="${filiereBean.filiere.libelle}"
								   style="width: 100%;" /> 
						</td>
					</tr>
					
					
					<tr>
						<td colspan="2" style="text-align: right;"> 
							<input type="submit" 
								   value="${filiereBean.label}"/> 
						</td>
					</tr>
					
					
				</table>
				
			</fieldset>
		</form>
	</div>
	
	<div style="position: relative; width: 60%; left: 20%; margin-top: 30px" >
	
		<table border="1" width="100%" cellpadding="5" style="text-align: center;">
			<tr>
				<th>ID</th>
				<th>Code</th>
				<th>Libelle</th>
				<th>Modifier</th>
				<th>Supprimer</th>
			</tr>
		
		<c:forEach items="${filiereBean.filieres}" var="f">
			<tr>
				<td>${f.id}</td>
				<td>${f.code}</td>
				<td>${f.libelle}</td>
				<td>
					<a href="filiere/modifyContext?id=${f.id}">
						<img src="img/edit.png" />
					</a>
				</td>
				<td>
					<a href="filiere/delete?id=${f.id}"
					   onclick="return confirm('Are you sure ? ')">
						<img src="img/drop.png" />
					</a>
				</td>
			</tr>
		</c:forEach>
		
		<tfoot>
			<tr>
				<td colspan="5" style="text-align: center;">
				Nombre total des filieres est : ${filiereBean.filieres.size()}
				</td>
			</tr>
		</tfoot>
		</table>
	
	</div>
	
</body>
</html>