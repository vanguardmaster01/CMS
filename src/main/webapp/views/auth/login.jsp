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
        <title>Login</title>
        <meta name="login">
        <link rel="stylesheet" type="text/css" href="/public/front/css/login.css">
        <link
        id="skinCSS"
        rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
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
                <main
                    id="main"
                    tabindex="-1"
                    class="container pt-10 pt-md-30 auth-growable-flex">
                    <div
                        class="col-md-8 col-md-offset-2 col-lg-6 col-lg-offset-3 px-0 px-md-15 auth-growable-flex">
                        <div></div>
                        <div
                            id="main-auth-card"
                            class="up-card py-0 my-0 mt-md-30 px-0 px-md-30 auth-growable-flex">
                            <form
                                id="loginForm"
                                novalidate="novalidate"
                                method="post"
                                class="form auth-growable-flex text-center username auth-growable-flex auth-card-top-padding" >
                                <div class="up-loader-container auth-growable-flex">
                                    <div class="col-md-10 col-md-offset-1 auth-growable-flex">
                                        <div>
                                            <div class="m-xs-top d-none d-md-block"></div>
                                            <div class="m-sm-top d-block d-md-none"></div>
                                            <div class="d-none d-block-mobile-app login-mobile-logo mb-20 pb-5">
                                                <span class="visually-hidden">CMS</span>
                                            </div>
                                            <h1 class="text-center m-0">
                                                <span>Log in to CMS</span></h1>
                                        </div>
                                        <div class="mb-10 pb-10 d-block d-md-none"></div>
                                        <div class="mb-30 d-none d-md-block"></div>
                                        <!---->
                                        <div>
                                            <div class="up-form-group mb-20" >
                                                <!---->
                                                <div class="up-input-group">
                                                    <div class="up-input-group-append">
                                                        <div class="up-icon">
                                                            <svg
                                                                xmlns="http://www.w3.org/2000/svg"
                                                                aria-hidden="true"
                                                                viewbox="0 0 14 14"
                                                                role="img">
                                                                <path
                                                                    fill-rule="evenodd"
                                                                    d="M7 8c-3.314 0-6 1.85-6 3.297v2.027c0 .373.358.676.8.676h10.4c.442 0 .8-.303.8-.676v-2.027C13 9.85 10.314 8 7 8zm3-5a3 3 0 11-6 0 3 3 0 016 0z"></path>
                                                            </svg>
                                                        </div>
                                                    </div>
                                                    <input
                                                        id="email"
                                                        name="email"
                                                        placeholder="email"
                                                        aria-label="email"
                                                        inputmode="email "
                                                        aria-required="true"
                                                        type="text"
                                                        class="up-input">
                                                </div>
                                                <!---->
                                                <!---->
                                            </div>
                                            <div >
                                                <div  class="up-input-group mt-10 mt-md-20 mb-20">
                                                    <input                                                
                                                    id="pwd"
                                                    name="pwd"
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
                                        </div>
                                        <button
                                            id="loginBtn"
                                            class="up-btn mr-0 full-width mb-0 up-btn-primary"
                                            target-form="username">Login</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
        <script language="javascript">
            let redirectUrl = '<%=WebUrl.create%>';
        </script>
        <script src="/public/front/pages/login.js"></script>
    </body>
</html>