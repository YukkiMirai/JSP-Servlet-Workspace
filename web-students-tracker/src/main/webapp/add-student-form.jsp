<!DOCTYPE html>
<html>

<head>
<title>Add Student</title>
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/add-student-style.css" rel="stylesheet" type="text/css">
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>


	<div id="container">
		<h3>Add Student</h3>

		<form action="StudentControllerServlet" method="get">
			<input type="hidden" name="command" value="ADD" />
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>

			</table>
		</form>


	</div>
	<div style="clear:both;"></div>
	<p>
		<a href="StudentControllerServlet">Back to list</a>
	</p>
</body>


</html>








