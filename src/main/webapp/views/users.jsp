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

				<h2 class="align-center"><span >User List</span></h2>

				<div class="card-body">
					<div class="row">
						<div class="col-sm-6">
							<div class="mb-3">
								<button id="addToTable" class="btn btn-primary"
									data-bs-toggle="modal" data-bs-target="#registerModal">
								Add <i class="fas fa-plus"></i></button>
							</div>
						</div>
					</div>
					<table class="table table-bordered table-striped" id="user_table" >
						<thead>
							<tr>
								<th>No</th>
							<th>Username</th>
							<th>Email</th>
							<th>Action</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>cheerup</td>
								<td>Szepan.semon@outlook.com</td>
								<td>
									<button  class="delete mb-1 mt-1 me-1 btn btn-outline btn-info"><i class="fas fa-edit"></i> </button>
									<button  class="edit mb-1 mt-1 me-1 btn btn-outline btn-danger">
											<i class="fas fa-trash-alt"></i> </button>
								</td>
							</tr>                                    
						</tbody>
					</table>
				</div>
				
			</div>

		</div>
	</div>

	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="registerModalLabel">Register</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<form id="register_form" class="mb-4" novalidate="novalidate">
						<div class="form-group row align-items-center">
							<label class="col-sm-3 text-start text-sm-end mb-0">Email</label>
							<div class="col-sm-9">
								<input type="email" id="register_email" name="register_email" class="form-control" placeholder="Type your email..." aria-required="true" />
							</div>
						</div>
						<div class="form-group row align-items-center">
							<label class="col-sm-3 text-start text-sm-end mb-0">Password</label>
							<div class="col-sm-9">
								<input type="password" id="register_password" name="register_password" class="form-control" placeholder="Type your password..." required/>
							</div>
						</div>
					<input type="hidden" id="update_userid">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-light" data-bs-dismiss="modal">Cancel</button>
					<button type="button" id="register" class="btn btn-primary">Register</button>
				</div>
			</form>

			</div>
		</div>
	</div>
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="updateModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="updateModalLabel">Update</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<form id="update_form" class="mb-4" novalidate="novalidate">
						<div class="form-group row align-items-center">
							<label class="col-sm-3 text-start text-sm-end mb-0">Email</label>
							<div class="col-sm-9">
								<input type="email" id="update_email" name="update_email" class="form-control" placeholder="Type your email..." required/>
							</div>
						</div>
						<div class="form-group row align-items-center">
							<label class="col-sm-3 text-start text-sm-end mb-0">Password</label>
							<div class="col-sm-9">
								<input type="password" id="update_password" name="update_password" class="form-control" placeholder="Type your password..." required/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-light" data-bs-dismiss="modal">Cancel</button>
					<button type="button" id="update" class="btn btn-primary">Update</button>
				</div>
			</div>
		</div>
	</div>

</div>
     
	<!-- Footer File Include -->
<jsp:include page="layout/footer.jsp"></jsp:include>

<!-- <script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script type="text/javascript" charset="utf8"
	src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap5.min.js"></script>  -->

	
<script src="/public/front/pages/users.js"></script>