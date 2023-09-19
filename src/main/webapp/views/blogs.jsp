<%@ page import="com.cms.util.Constants"%>
<%@ page import="com.cms.util.WebUrl"%>
<%@ page import="com.cms.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	User loginuser = (User) session.getAttribute("user");
%>

<jsp:include page="layout/header.jsp"></jsp:include>

<div role="main" class="main">

	<div class="container py-2">
		<div class="row">
			<div class="col pb-3 my-5">

				<h2 class="align-center"><span >Blog Posts</span></h2>

				<table class="table table-hover dataTables_wrapper" border="0" margin="0" padding="0" width="100%" id="blogsTable">
					<thead>
						<tr>
							<th>Image</th>
							<th>Content</th>
							<th>Publication </br> Status</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${blogs}" var="blog">
							<tr>
								<td>
									<img src="<c:url value='/public/front/img/${blog.imagepath}'/>" style="max-width: 200px;" />
									<h5><c:out value="${blog.title}" /></h5>
								</td>
								<td style="overflow-x: auto; max-width: 500px;">
									<c:out value="${blog.content}" />
								</td>
								<td>
									<c:choose>
									    <c:when test="${blog.status == 0}">
									        Draft
									        <br />
									    </c:when>    
									    <c:when test="${blog.status == 1}">
									        Published
									        <br />
									    </c:when>    
									</c:choose>
								</td>
								<td>
									<a href="#" class="editblog-btn mb-1 mt-1 me-1 btn btn-outline btn-info" data-blogid="${blog.id}"><i class="fas fa-edit"></i> </a>
									<a href="#" class="deleteblog-btn mb-1 mt-1 me-1 btn btn-outline btn-danger" data-blogid="${blog.id}"><i class="fas fa-trash-alt"></i> </a>
								</td>
							</tr>
					    </c:forEach>
					</tbody>
				</table>

			</div>

		</div>
	</div>

</div>
     
	<!-- Footer File Include -->
<jsp:include page="layout/footer.jsp"></jsp:include>

<script src="/public/front/pages/blogs.js"></script>
