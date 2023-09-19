<%@ page import="com.cms.util.Constants"%>
<%@ page import="com.cms.util.WebUrl"%>
<%@ page import="com.cms.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%
	User loginuser = (User) session.getAttribute("user");
%>

<!doctype html>
<html lang="en">
    <head>
        <title>Sign up</title>
        <meta name="login">
        <link rel="stylesheet" type="text/css" href="/public/front/css/login.css">
    </head>
    <body>
        <div class="layout-container">
            <div class="layout">
                <div design-system="air-3-0" class="nav-v2 nav-visitor-skinny">
                    <header data-cy="nav" class="nav-wrapper">
                        <div class="nav-container visitor-container">
                            <div class="nav-header-wrapper">
                                <div data-cy="header" class="nav-header nav-d-flex align-items-center">
                                    <a href="/" target="_self" class="up-n-link nav-brand nav-d-flex">
                                        <span class="sr-only">CMS</span>

                                    </a>
                                </div>
                            </div>
                            <div id="nav-main" data-cy="collapse" class="nav-collapse">
                                <div data-cy="nav-left" class="nav-left nav-align nav-d-flex flex-1"></div>
                                <nav aria-label="Primary" class="nav-d-flex">
                                    <ul
                                        data-cy="nav-right"
                                        class="nav-right nav-align nav-d-flex align-items-center">
                                        <div></div>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </header>
                </div>
                <!---->
                <main id="main" tabindex="-1">
                    <div >
                        <!---->
                        <!---->
                        <!---->
                        <div class="container"
                            id="signup-redesigned-form">
                            <div class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-12">
                                <!---->
                                <div class="up-card mt-0 mt-md-30 mb-0 mb-md-30 py-0 py-md-30">
                                    <!---->
                                    <h2  class="text-center display-rebrand my-20">
                                        <div >
                                            <span >
                                                Register
                                            </span>
                                        </div>
                                    </h2>
                                    <div  class="text-center">
                                        <!---->
                                    </div>
                                    <form  id="signupForm-redesigned">
                                        <!---->
                                        <div >
                                            <!-- <div  class="col-12 mt-10 col-md-6 pl-0">
                                                <div  class="up-input-group">
                                                    <input                                                    
                                                    id="first-name-input"
                                                    type="text"
                                                    aria-label="First name"
                                                    aria-required="true"
                                                    aria-describedby="first-name-validation-messages"
                                                    placeholder="First name"
                                                    autocomplete="given-name"
                                                    class="up-input"></div>
                                            </div> -->
                                            <div  class="up-input-group  mt-10 mt-md-20">
                                                <div  class="up-input-group">
                                                    <input                                                    
                                                    id="last-name-input"
                                                    type="text"
                                                    aria-required="true"
                                                    aria-describedby="last-name-validation-messages"
                                                    placeholder="Username"
                                                    class="up-input"></div>
                                                <!---->
                                            </div>
                                        </div>
                                        <div >
                                            <div  class="up-input-group mt-10 mt-md-20">
                                                <input                                                
                                                id="redesigned-input-email"
                                                type="email"
                                                placeholder="Email"
                                                aria-label="Email"
                                                aria-describedby="email-validation-messages"
                                                aria-required="true"
                                                autocomplete="email"
                                                class="up-input"></div>
                                            <!---->
                                            <!---->
                                        </div>
                                        <div >
                                            <div  class="up-input-group mt-10 mt-md-20">
                                                <input                                                
                                                id="password-input"
                                                placeholder="Password (8 or more characters)"
                                                aria-label="Password (8 or more characters)"
                                                aria-required="true"
                                                aria-describedby="password-validation-messages"
                                                autocomplete="new-password"
                                                type="password"
                                                class="up-input">
                                                <button                                                    
                                                    type="button"
                                                    class="up-input-group-append show-hide-password">
                                                    <div  class="up-icon sm">
                                                        <svg
                                                            xmlns="http://www.w3.org/2000/svg"
                                                            aria-hidden="true"
                                                            data-name="Layer 1"
                                                            viewbox="0 0 14 14"
                                                            role="img">
                                                            <path
                                                                d="M7 3.2a3.23 3.23 0 013.19 3.34A3.59 3.59 0 0110 7.68l1.93 1.93A7.79 7.79 0 0014 6.54a7.49 7.49 0 00-7-5 7.2 7.2 0 00-2.63.51l1.4 1.41A3 3 0 017 3.2zm3.87 7.2L9.31 8.84l-.92-.91-2.77-2.78-.92-.92-1.56-1.56L.92.45 0 1.37l2.09 2.1A7.85 7.85 0 000 6.54a7.53 7.53 0 007 5A7 7 0 009.63 11l2.54 2.54.92-.92-2.23-2.22zM7 9.87a3.23 3.23 0 01-3.18-3.33A3.5 3.5 0 014 5.4l1.1 1.08v.06a1.93 1.93 0 001.9 2h.14l1.09 1.07A3.11 3.11 0 017 9.87z"></path>
                                                            <path d="M6.86 4.55L8.91 6.6v-.06a1.91 1.91 0 00-1.91-2z"></path>
                                                        </svg>
                                                    </div>
                                                </button>
                                            </div>
                                            <!---->
                                        </div>
                                        <div >
                                            <div  class="up-input-group mt-10 mt-md-20">
                                                <input                                                
                                                id="password-input"
                                                placeholder="Confirm Password (8 or more characters)"
                                                aria-label="Password (8 or more characters)"
                                                aria-required="true"
                                                aria-describedby="password-validation-messages"
                                                autocomplete="new-password"
                                                type="password"
                                                class="up-input">
                                                <button                                                    
                                                    type="button"
                                                    class="up-input-group-append show-hide-password">
                                                    <div  class="up-icon sm">
                                                        <svg
                                                            xmlns="http://www.w3.org/2000/svg"
                                                            aria-hidden="true"
                                                            data-name="Layer 1"
                                                            viewbox="0 0 14 14"
                                                            role="img">
                                                            <path
                                                                d="M7 3.2a3.23 3.23 0 013.19 3.34A3.59 3.59 0 0110 7.68l1.93 1.93A7.79 7.79 0 0014 6.54a7.49 7.49 0 00-7-5 7.2 7.2 0 00-2.63.51l1.4 1.41A3 3 0 017 3.2zm3.87 7.2L9.31 8.84l-.92-.91-2.77-2.78-.92-.92-1.56-1.56L.92.45 0 1.37l2.09 2.1A7.85 7.85 0 000 6.54a7.53 7.53 0 007 5A7 7 0 009.63 11l2.54 2.54.92-.92-2.23-2.22zM7 9.87a3.23 3.23 0 01-3.18-3.33A3.5 3.5 0 014 5.4l1.1 1.08v.06a1.93 1.93 0 001.9 2h.14l1.09 1.07A3.11 3.11 0 017 9.87z"></path>
                                                            <path d="M6.86 4.55L8.91 6.6v-.06a1.91 1.91 0 00-1.91-2z"></path>
                                                        </svg>
                                                    </div>
                                                </button>
                                            </div>
                                            <!---->
                                        </div>
                                        <!---->
                                        <a                                            
                                            id="button-submit-form"
                                            href="./login.html"
                                            class="up-btn up-btn-primary up-btn-block mt-10 mt-md-20 mb-20">
                                            <div  class="up-icon sm" style="display: none;">
                                                <svg xmlns="http://www.w3.org/2000/svg" viewbox="25 25 50 50" class="spinner">
                                                    <circle cx="50" cy="50" r="20" stroke-width="4" stroke-miterlimit="10"></circle>
                                                </svg>
                                            </div>
                                            Create my account
                                        </a>
                                        <!---->
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    </body>
</html>