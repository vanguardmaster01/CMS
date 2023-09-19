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

	<section
		class="section section-with-shape-divider section-parallax bg-tertiary border-0 m-0"
		style="position: relative; overflow: hidden;">
		<div class="parallax-background fadeIn animated"
			style="background-size: cover; position: absolute; top: 0px; left: 0px; width: 100%; height: 110%; transform: translate3d(0px, 103.375px, 0px); background-position-x: 50%;">
		</div>
		<div class="shape-divider shape-divider-bottom" style="height: 576px;">
			<svg
				version="1.1"
				xmlns="http://www.w3.org/2000/svg"
				xmlns:xlink="http://www.w3.org/1999/xlink"
				x="0px"
				y="0px"
				viewbox="0 0 1920 576"
				preserveaspectratio="xMinYMin">
				<path
					class="custom-svg-fill-color-tertiary"
					d="M-12,66c13.35,40.03,28.35,72.62,41,97c12.78,24.63,30.56,58.44,62,97c19.57,24,36.66,40.31,49,52
					c41.02,38.87,77.1,62.82,85,68c53.78,35.23,100.92,51.3,148,67c87.6,29.21,158.49,37.98,201,43c63.9,7.55,112.08,7.78,160,8
					c16.52,0.08,84.41,0.17,181-8c98.88-8.36,172.43-20.7,233-31c42.88-7.29,141.31-24.85,267-56c127.06-31.5,220.66-61.69,296-86
					c89.27-28.8,159.58-54.68,174-60c16.6-6.13,30.39-11.34,40-15c0,113.33,0,226.67,0,340c-644.33,0-1288.67,0-1933,0
					C-9.33,410-10.67,238-12,66z"></path>
				<path
					fill="#FFF"
					d="M-5,3c1.21,5.32,2.98,13.29,5,23c4.38,21.08,6.71,34.95,8,42c7.08,38.6,19.7,71.54,26,88
					c8.52,22.26,16.34,38.54,19,44c5.4,11.07,16.38,32.61,33,58c28.88,44.11,57.48,73.41,64,80c6.89,6.97,38.98,38.97,91,72
					c57.09,36.25,106.11,53.37,143,66c66.98,22.93,119.93,31.44,162,38c81,12.63,143.81,13.53,189,14c62.45,0.65,109.33-2.68,156-6
					c35.74-2.54,89.63-7.16,155-16c68.17-9.22,117.88-18.83,170-29c110.32-21.52,194.58-42.54,224-50c131.43-33.34,227.73-64.9,286-84
					c93.88-30.77,155.18-54.57,184-66c6.29-2.49,11.48-4.58,15-6c0,102.67,0,205.33,0,308c-643.33,0-1286.67,0-1930,0C-5,387-5,195-5,3z
					"></path>
			</svg>
		</div>
		<div class="container position-relative z-index-1 pb-5 my-5">
			<div
				class="appear-animation animated fadeIn appear-animation-visible"
				data-appear-animation="fadeIn"
				data-appear-animation-delay="1000"
				style="animation-delay: 1000ms;">
				<div class="custom-svg-stars clean-animation-1">
					<svg
						version="1.1"
						xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink"
						x="0px"
						y="0px"
						viewbox="0 0 277 276">
						<g>
							<path
								fill="none"
								stroke="#FFF"
								stroke-width="9"
								stroke-miterlimit="10"
								d="M51.5,165.5c-0.63,0.07,0.16,5.68-1,13c-0.52,3.27-1.5,9.11-5,15c-4.06,6.82-9.54,10.42-12,12
								c-12.69,8.13-27.06,7.5-27,8c0.03,0.27,4.14-0.53,9,0c8.58,0.93,14.62,5.47,18,8c8.89,6.67,12.94,14.76,14,17
								c5.46,11.56,4.6,23.03,5,23c0.34-0.03-1.45-7.91,1-17c0.41-1.53,2.71-9.63,10-17c6.11-6.18,12.65-8.73,16-10
								c8.91-3.37,16.02-3.09,16-4c-0.03-1.04-9.22,0.41-19-4c-2.2-0.99-10.87-5.04-16-14c-3.08-5.38-4.54-11.95-7-23
								C52.78,169.26,52.02,165.44,51.5,165.5z"></path>
						</g>
						<g>
							<path
								fill="none"
								stroke="#FFF"
								stroke-width="9"
								stroke-miterlimit="10"
								d="M188.8,77.92c-1.01,0.11,0.26,9.06-1.6,20.74c-0.83,5.22-2.39,14.53-7.98,23.93
								c-6.47,10.89-15.22,16.63-19.15,19.15C139.83,154.71,116.9,153.7,117,154.5c0.05,0.43,6.61-0.84,14.36,0
								c13.68,1.49,23.33,8.72,28.72,12.76c14.18,10.64,20.65,23.55,22.34,27.12c8.7,18.45,7.34,36.75,7.98,36.7
								c0.54-0.04-2.32-12.62,1.6-27.12c0.66-2.44,4.32-15.36,15.96-27.12c9.75-9.86,20.18-13.93,25.53-15.96
								c14.22-5.38,25.56-4.92,25.53-6.38c-0.04-1.66-14.71,0.65-30.31-6.38c-3.51-1.58-17.35-8.04-25.53-22.34
								c-4.91-8.59-7.24-19.06-11.17-36.7C190.84,83.92,189.63,77.83,188.8,77.92z"></path>
						</g>
						<g>
							<path
								fill="none"
								stroke="#FFF"
								stroke-width="9"
								stroke-miterlimit="10"
								d="M90.5,10.5c-0.63,0.07,0.16,5.68-1,13c-0.52,3.27-1.5,9.11-5,15c-4.06,6.82-9.54,10.42-12,12
								c-12.69,8.13-27.06,7.5-27,8c0.03,0.27,4.14-0.53,9,0c8.58,0.93,14.62,5.47,18,8c8.89,6.67,12.94,14.76,14,17
								c5.46,11.56,4.6,23.03,5,23c0.34-0.03-1.45-7.91,1-17c0.41-1.53,2.71-9.63,10-17c6.11-6.18,12.65-8.73,16-10
								c8.91-3.37,16.02-3.09,16-4c-0.03-1.04-9.22,0.41-19-4c-2.2-0.99-10.87-5.04-16-14c-3.08-5.38-4.54-11.95-7-23
								C91.78,14.26,91.02,10.44,90.5,10.5z"></path>
						</g>
					</svg>
				</div>
			</div>
			<div class="row justify-content-center justify-content-lg-start pb-5 mb-5">
				<div class="col-md-10 col-lg-6 text-center text-lg-end pe-lg-4 pb-5 mb-5">
					<h1
						class="text-color-light font-weight-medium line-height-4 text-10 mb-2 appear-animation animated fadeInUpShorter appear-animation-visible"
						data-appear-animation="fadeInUpShorter"
						data-appear-animation-delay="300"
						style="animation-delay: 300ms;">
						<span
							class="font-weight-extra-bold custom-highlight-1 ws-nowrap p-1 customHighlightAnim customHighlightAnimDelay">Create a Blog</span>
					</h1>
					<div
						class="appear-animation animated fadeInUpShorter appear-animation-visible"
						data-appear-animation="fadeInUpShorter"
						data-appear-animation-delay="500"
						style="animation-delay: 500ms;">
						<p
							class="custom-font-secondary font-weight-light custom-font-size-1 text-color-light opacity-6 mb-4"></p>
					</div>
					<div class="spacer pt-5 my-5"></div>
				</div>
			</div>
		</div>
	</section>

	<div class="container position-relative z-index-1" style="margin-top: -388px;">
		<div class="row align-items-end pb-4 mb-4 mb-lg-5">
			<div class="col-lg-12 pe-lg-8 mb-5 mb-lg-0">
				<div
					class="card border-0 custom-border-radius-1 box-shadow-1 appear-animation animated fadeInUpShorter appear-animation-visible"
					data-appear-animation="fadeInUpShorter"
					data-appear-animation-delay="900"
					style="animation-delay: 900ms;">
					<div class="card-body p-5">
						<h2 class="text-color-secondary font-weight-bold text-7 line-height-1 mb-1">Blog</h2>
						<p class="custom-font-secondary text-4 pb-1 mb-4">Enter blog details in the form.</p>
						<form
							id="create_form"
							class="contact-form custom-form-style-1"
							novalidate="novalidate" enctype="multipart/form-data">
							<div class="contact-form-success alert alert-success d-none mt-4">
								<strong>Success!</strong>
								Your request has been sent to us.
							</div>

							<div class="contact-form-error alert alert-danger d-none mt-4">
								<strong>Error!</strong>
								There was an error sending your request.
								<span class="mail-error-message text-1 d-block"></span>
							</div>

							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Sites</label>
									<div class="position-relative">
										<select id='target' classe='form-control py-2' >
											<option value="<%=Constants.Utahtruckdrivingschool%>" ><%=Constants.Utahtruckdrivingschool%></options>
											<option value="<%=Constants.truckcity%>" ><%=Constants.truckcity%></options>
											<option value="<%=Constants.towing%>" ><%=Constants.towing%></options>
											<option value="<%=Constants.ors%>" ><%=Constants.ors%></options>
											<option value="<%=Constants.nflfreight%>" ><%=Constants.nflfreight%></options>
											<option value="<%=Constants.itruckdispatch%>" ><%=Constants.itruckdispatch%></options>
											<option value="<%=Constants.cdl%>" ><%=Constants.cdl%></options>
											<option value="<%=Constants.ecdl%>" ><%=Constants.ecdl%></options>
											<option value="<%=Constants.paultruckline%>" ><%=Constants.paultruckline%></options>
											<option value="<%=Constants.fresnotruckline%>" ><%=Constants.fresnotruckline%></options>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Post Title</label>
									<div class="position-relative">
										<input type="text" value="" data-msg-required="Please enter a title." 
											maxlength="100" class="form-control text-3 h-auto py-2" id="title" name="title" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Post Content</label>
									
									<!-- <div class="position-relative" id="summernote" name="summernote" data-msg-required="Please enter Post Content." required="">
									</div> -->
									
									<textarea data-msg-required="Please enter content"
										 rows="6" class="form-control text-3 h-auto py-2" id="content" name="content" required=""></textarea>

								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-12">
									<label class="form-label mb-1 text-2">Upload Image</label>
									<input class="d-block" type="file" name="attachment" id="attachment">
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Meta Tags</label>
									<div class="position-relative">
										<input type="text" value="" data-msg-required="Please enter meta tags."
										 maxlength="100" class="form-control text-3 h-auto py-2" id="metatags" name="metaTags" required="">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Alt Tags</label>
									<div class="position-relative">
										<input type="text" value="" data-msg-required="Please enter alt tags."
										 maxlength="100" class="form-control text-3 h-auto py-2" id="alttags" name="altTags" required="">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Meta Description</label>
									<div class="position-relative">
										<textarea data-msg-required="Please enter meta description."
										rows="6" class="form-control text-3 h-auto py-2" id="metadescription" name="meta_desc" required=""></textarea>
										<!-- <input type="text" value="" data-msg-required="Please enter meta description."
										 maxlength="100" class="form-control text-3 h-auto py-2" name="meta_desc" required=""> -->
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">Slug</label>
									<div class="position-relative">
										<input type="text" value="" data-msg-required="Please enter slug."
										 maxlength="100" class="form-control text-3 h-auto py-2" id="slug" name="slug" required="">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<label class="form-label mb-1 text-2">tags</label>
									<div class="position-relative">
										<input type="text" value="" data-msg-required="Please enter tags."
										 maxlength="100" class="form-control text-3 h-auto py-2" id="tags" name="tags" required="">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group col">
									<button
										id="create"
										type="submit"
										class="btn btn-primary btn-modern font-weight-bold text-3 px-5 py-3"
										data-loading-text="Loading...">CREATE A BLOG</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>
     
	<!-- Footer File Include -->
<jsp:include page="layout/footer.jsp"></jsp:include>
<script src="/public/front/pages/create.js"></script>