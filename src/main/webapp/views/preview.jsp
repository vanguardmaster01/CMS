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

	<div class="container py-4">
		<div class="row">
			<div class="col">
				<article class="post post-large">
					<div class="post-image">
						<img src="\public\front\img/${image}"  class="img-fluid img-thumbnail img-thumbnail-no-borders rounded-0" alt="">					</div>

					<div class="post-content">

						<h2 class="font-weight-semibold text-6 line-height-3 mb-3">
							<c:choose>
							    <c:when test="${type == 0}">
							        ${title}
							        <input id="title" type="hidden" value="${title}" class="form-control text-3 h-auto py-2" />
							    </c:when>    
							    <c:when test="${type == 1}">
							        <input id="title" type="text" value="${title}" class="form-control text-3 h-auto py-2" />
							    </c:when>   
							</c:choose>
						</h2>
						<p>
							<c:choose>
							    <c:when test="${type == 0}">
							        ${content}
							        <input id="content" type="hidden" value="${content}" class="form-control text-3 h-auto py-2" />
							    </c:when>    
							    <c:when test="${type == 1}">
							        <textarea data-msg-required="Please enter content"
										 rows="6" class="form-control text-3 h-auto py-2" id="content" name="content" required="">${content}</textarea>
							    </c:when>   
							</c:choose>
							
						 </p>

					</div>
					
					<div class="post-date">
						<span class="day"><c:out value="${createdat}" /></span>
					</div>
					
					<button type="button" id="publish" data-blogid="${id}" class="btn btn-primary btn-modern font-weight-bold text-3 px-5 py-3">Publish</button>
					<button type="button" id="cancel" class="btn btn-primary btn-modern font-weight-bold text-3 px-5 py-3">Cancel</button>
				</article>
			</div>    
		</div>
	</div>

</div>
     
	<!-- Footer File Include -->
<jsp:include page="layout/footer.jsp"></jsp:include>
<script src="/public/front/pages/publish.js"></script>
