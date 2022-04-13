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
						<title>Craig Burke - Rendering Books-home</title>
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
						<div class="container">
							<p class="w-100 mt-5"></p>
							<h1 class="text-success w-75">All Books:
							</h1>


							<p class="w-100"></p>
							<!-- == table == -->
							<div class="container bg-primary text-dark rounded-3">
								<table class="table table-striped p-5 border border-2" id="fruit_table">
									<thead>
										<tr>
											<th scope="col" class="h4 text-center">ID</th>
											<th scope="col" class="h4 text-center">Title</th>
											<th scope="col" class="h4 text-center">Description</th>
											<th scope="col" class="h4 text-center"># Pages</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="book" items="${books}">
											<tr>
												<td scope="row">
													<p class="text-center">
														<c:out value="${book.id}"></c:out>
													</p>
												</td>
												<td scope="row">
													<p class="text-center">
														<a href="/show/${book.id}">
															<c:out value="${book.title}"></c:out>
														</a>
													</p>
												</td>
												<td scope="row">
													<p class="text-center">
														<c:out value="${book.language}"></c:out>
													</p>
												</td>
												<td scope="row">
													<p class="text-center">
														<c:out value="${book.numberOfPages}"></c:out>
													</p>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
						<p class="w-100"></p>
						<!-- End of Container -->
					</body>

					</html>