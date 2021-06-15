<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Admin 's Yukki</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
</head>
<body>
	<!-- Navigation-->
	ADMIN HOME
	<!-- Page Content-->
	<div class="container">
		<div class="row">
			<!-- menu -->
			<div class="col-lg-3">
				<h1 class="my-4">
					<a href="AdminController">MiniShop</a>
				</h1>
				<div class="list-group">
					<c:forEach var="tempCategory" items="${list_categorys }">
						<c:url var="tempLink" value="AdminController">
							<c:param name="command" value="GETPRODUCT_byCATE" />
							<c:param name="categoryId" value="${tempCategory.categoryId}" />
						</c:url>
						<c:url var="deleteLink" value="AdminController">
							<c:param name="command" value="DELETECATE" />
							<c:param name="categoryId" value="${tempCategory.categoryId}" />
						</c:url>
						<c:url var="updateLink" value="AdminController">
							<c:param name="command" value="LOADCATE" />
							<c:param name="categoryId" value="${tempCategory.categoryId}" />
						</c:url>
						<a class="list-group-item" href="${tempLink}">${tempCategory.categoryName}</a>
						<a href="${updateLink }">Update</a>
						<a href="${deleteLink }"
							onclick="if(!(confirm('Are you sure'))) return false">Del</a>
					</c:forEach>
					<a class="list-group-item" href="add-category-form.jsp">Thêm
						danh mục</a>
				</div>
			</div>
			<!-- end menu -->
			<div class="col-lg-9">
				<div class="row">
					<c:forEach var="tempProduct" items="${list_products}">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<c:url var="productLink" value="AdminController">
									<c:param name="command" value="ITEM"></c:param>
									<c:param name="productId" value="${tempProduct.productId }"></c:param>
								</c:url>
								<a href="${productLink }"><img class="card-img-top"
									src="picture/${tempProduct.productPicture}" alt="..." /></a>
								<div class="card-body">
									<h4 class="card-title">
										<a href="${productLink }">${tempProduct.productName}</a>
									</h4>
									<h5>${tempProduct.productPrice}</h5>
									<p class="card-text">${tempProduct.productDescription}</p>
								</div>
								<div class="card-footer">
									<small class="text-muted">★ ★ ★ ★ ☆</small>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- end content -->
			</div>
		</div>
	</div>
	<!-- Footer-->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
