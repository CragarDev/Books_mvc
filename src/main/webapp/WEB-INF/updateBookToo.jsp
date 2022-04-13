<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
	<!-- Here we have to import the Date class. -->
	<!-- You will put the import in the first line of the jsp tag. Use the import attribute -->

	<!-- c:out ; c:forEach ; c:if -->
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!-- Formatting (like dates) -->
		<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
			<!-- form:form -->
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
				<!-- for rendering errors on PUT routes -->
				<%@ page isErrorPage="true" %>

					<!DOCTYPE html>

					<html>

					<head>
						<meta charset="UTF-8" />
						<title>Craig Burke - Books - Update Book Too
						</title>
						<!-- Bootstrap -->
						<!-- CSS only -->
						<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
							rel="stylesheet"
							integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
							crossorigin="anonymous" />
						<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
							integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
							crossorigin="anonymous"></script>
						<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
							integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
							crossorigin="anonymous"></script>
						<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
						<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
					</head>

					<body>
						<!-- Beginning of Container -->
						<div class="container w-50">
							<p class="w-100"></p>
							<!-- == Home button == -->
							<a class="btn btn-primary float-end mb-3" href="/books">Back</a>
							<p class="w-100"></p>
							<p class="w-100 mt-5"></p>
							<h2 class="text-success text-center">Update a book too!</h2>
							<br />
							<p class="w-100"></p>
							<!-- == form == -->
							<div class="container bg-secondary text-light rounded-3 w-50">
								<form:form action="/books/updateToo/process/${book.id}" method="post" modelAttribute="book">

									<div class="mb-3">
										<p>
											<form:label path="title">Title</form:label>
											<form:errors path="title" class="text-danger h5" />
											<form:input path="title" class="form-control" value="${book.title}" />

										</p>
									</div>

									<div class="mb-3">
										<p>
											<form:label path="description">Description</form:label>
											<form:errors path="description" class="text-danger h5" />
											<form:textarea path="description" class="form-control"
												value="${book.description}" />
										</p>
									</div>

									<div class="mb-3">
										<p>
											<form:label path="language">Language</form:label>
											<form:errors path="language" class="text-danger h5" />
											<form:input path="language" class="form-control" value="${book.language}" />
										</p>
									</div>

									<div class="mb-3">
										<p>
											<form:label path="numberOfPages">Pages</form:label>
											<form:errors path="numberOfPages" class="text-danger h5" />
											<form:input type="number" path="numberOfPages" class="form-control w-25"
												value="${book.numberOfPages}" />
										</p>
									</div>

									<input type="submit" value="Update Book Too"
										class="btn btn-info text-black float-start" />

								</form:form>
								<!-- New form:form items -->
							</div>

							<p class="w-100"></p>

							<p class="w-100"></p>
							<!-- == Delete button == -->
							<a class="btn btn-danger float-end ms-4 mb-3" href="/books/delete/${book.id}">Delete</a>
							<p class="w-100"></p>



						</div>
						<p class="w-100"></p>
						<!-- End of Container -->
					</body>

					</html>