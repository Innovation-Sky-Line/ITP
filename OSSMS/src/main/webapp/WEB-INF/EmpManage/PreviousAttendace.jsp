<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Employee Name</td>
			<td><input type="text" value="${employee.firstName }" readonly id="readonly"></td>
			
			<td>Attendance</td>
			<td><input type="text" value="${attendance.monthId }" readonly id="readonly"></td>
		</tr>
	</table>
</body>
</html>