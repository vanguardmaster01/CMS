package com.cms.util;

/**
@Developed By Anil Kumar
*/

public class WebUrl {
	
	public static final String Home="us";
	
	public static final String login = "/login";
	public static final String register = "/register";
	public static final String create = "/create";
	public static final String blogs = "/blogs";
	public static final String users = "/users";
	public static final String preview = "/preview";
	public static final String addUser="/addUser";
	public static final String updateUser="/updateUser";
	public static final String deleteUser="/deleteUser";
	
	public static final String createBlog ="/createBlog";
	public static final String publishBlog ="/publishBlog";
	public static final String getBlogs = "/getBlogs";
	public static final String deleteBlog ="/deleteBlog";
	
	
	public static final String sendmail = "api/sendmail/{name}/{email}/{message}"; 
	public static final String sendmailwithattachment = "api/sendmailwithattachment/{name}/{email}/{message}";
	public static final String sendmailfile = "api/sendmailfile/";
	
	public static final String success = "/success";
	public static final String failed = "/failed";
	
	public static final String verify="/verify";
	public static final String logout="/logout";
	public static final String dashboard="/dashboard";
	public static final String activeads="/activeads";
	public static final String profile="/profile";
	public static final String updatepassword="/updatepassword";
	public static final String thanku="/thanku"; 
	public static final String thankYou="/thank-you"; 
	public static final String checkout = "/checkout";
	public static final String app="/app"; 
	public static final String paymentform = "/payment-form/{userid}/{paymentamount}";
	public static final String paywithcard = "/paywithcard/{paymentId}/{adid}/{subscriptionid}/{transactionid}";
	public static final String addlisting="/addlisting";	
	public static final String updatelisting="/updatelisting";
	public static final String returnPage = "/return";
	public static final String error = "/page-not-found";

	public static final String details="/details";
	public static final String detailad="/details/{adsid}/{company}/{location}";
	public static final String favourites="/favourites";
	public static final String index="/index";
	
	public static final String listing="/listing";	
	public static final String list="/listing/{maincategoryid}/{categoryid}/{location}";
	
	public static final String payment="/payment";
	public static final String paymentad="/payment/{adid}";
	
	public static final String paymenthistory="/paymenthistory";
	public static final String plans="/plans";
	
	public static final String about="/about";
	public static final String contact="/contact";
	public static final String userQuery="/submit-query";
	public static final String previewad="/previewad";
	public static final String terms="/terms";
	public static final String policy="/policy";
	public static final String refundpolicy="/refundpolicy";
	public static final String blog="/blog";
	
	public static final String blog1="blog/fleet-maintenance";
	public static final String blog2="blog/24-hour-road-service";
	public static final String blog3="blog/safety-tips-for-truck-driving";
	/*public static final String blog4="blog/blog4";
	public static final String blog5="blog/blog5";
	public static final String blog6="blog/blog6";
	public static final String blog7="blog/blog7";
	public static final String blog8="blog/blog8";
	public static final String blog9="blog/blog9";
	public static final String blog10="blog/blog10";

	/************************* Admin ****************************/
	public static final String adminlogin="/admin/login"; 
	public static final String adminverify="/admin/verify";
	public static final String adminlogout="/admin/logout";
	public static final String admindashboard="/admin/dashboard";
	public static final String adminprofile="/admin/profile";
	public static final String adminupdatepassword="/admin/ResetPassword";
	public static final String admincreatelisting="/admin/createlisting";	
	public static final String adminupdatelisting="/admin/updatelisting";
	public static final String admindefaultads="/admin/defaultads";
	public static final String admincustomizeads="/admin/customizeads";
	public static final String adminupdatedefaultad="/admin/updatedefaultad";
	public static final String adminupdatecustomizead="/admin/updatecustomizead";
	public static final String adminsubscriptionlist="/admin/subscriptionlist";
	public static final String adminsubscriptionhistory="/admin/subscriptionhistory";
	public static final String adminuploaddata="/admin/uploaddata";
	public static final String adminassigndata="/admin/assigndata";
	public static final String adminmanageads="/admin/manageads";
	public static final String adminmanagependingads="/admin/managependingads";	
	public static final String adminnotification="/admin/notification";
	public static final String adminadinfo="/admin/adinfo";
	public static final String adminmsg="/admin/msg";
	public static final String adminreport="/admin/report";
	public static final String sendText="/admin/sendText";
	
	
	//public static final String updateUser="/updateUser";
	
	public static final String assignData="/admin/assignData";
	
	public static final String admincustomers="/admin/customers";
	//public static final String addCustomer="/admin/addCustomer";
	//public static final String updateCustomer="/admin/updateCustomer";
	
	public static final String adminmanagesaleusers="/admin/managesaleusers";
	public static final String addSaleUser="/admin/addSaleUser";
	public static final String updateSaleUser="/admin/updateSaleUser";
	
	public static final String adminmanagediscount="/admin/managediscount";
	public static final String addDiscount="/admin/addDiscount";
	public static final String updateDiscount="/admin/updateDiscount";
	
	public static final String adminmanagecategory="/admin/managecategory";	
	public static final String addCategory="/admin/addCategory";
	public static final String updateCategory="/admin/updateCategory";
	
	public static final String adminmanagedealer="/admin/managedealer";	
	public static final String addDealer="/admin/addDealer";
	public static final String updateDealer="/admin/updateDealer";
	
	public static final String adminmanageservices="/admin/manageservices";
	public static final String addService="/admin/addService";
	public static final String updateService="/admin/updateService";
	
	public static final String adminmanagelanguages="/admin/managelanguages";
	public static final String addLanguage="/admin/addLanguage";
	public static final String updateLanguage="/admin/updateLanguage";
		
	public static final String adminmanagemaincategory="/admin/managemaincategory";	
	public static final String addMaincategory="/admin/addMaincategory";
	public static final String updateMaincategory="/admin/updateMaincategory";
	
	public static final String adminmanageplan="/admin/manageplan";
	public static final String addPlan="/admin/addPlan";
	public static final String updatePlan="/admin/updatePlan";
	
	public static final String adminUser="/admin/**";
	
	
}	

