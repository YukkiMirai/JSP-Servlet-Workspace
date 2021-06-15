<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h2>Thêm danh mục sản phẩm</h2>
		</div>
	</div>


	<div id="container">
		<h3>ADD CATEGORY</h3>

		<form action="AdminController" method="get">
			<input type="hidden" name="command" value="ADDCATE" />
			<table>
				<tbody>
					<tr>
						<td><label>ID</label></td>
						<td><input type="text" name="categoryId" /></td>
					</tr>
					<tr>
						<td><label>Tên nhóm sản phẩm</label></td>
						<td><input type="text" name="categoryName" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>

			</table>
		</form>


	</div>
	<div style="clear: both;"></div>
	<p>
		<a href="AdminController">Back to home</a>
	</p>
</body>


</html>








