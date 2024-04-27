<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Popins', sans-serif; 
    		font-size: 16px; 
		    margin: 0;
		    display: flex;
		    flex-direction: column;
		    min-height: 100vh;
        }

        #header {
            background-color: #004E4E;
            padding: 10px;
            text-align: center;
            flex-grow: 0;
            flex-shrink: 0;
            height: 70px
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            height: 70px
        }

        .logo img {
            height: 70px;
        }

        .main-nav {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 10px;
            flex-grow: 1;
            flex-shrink: 0;
            height: 70px
        }
        
      .main-nav ul {
		    display: flex;
		    justify-content: center; /* Center align the navigation links */
		    padding: 0; /* Remove default padding */
		    margin: 0; /* Remove default margin */
		    height: 100%; /* Fill the entire height of the .main-nav */
		}
		
		.main-nav li {
		    list-style: none;
		    height: 100%; /* Fill the entire height of the .main-nav */
		}
		
		
		
		.main-nav a {
		    text-decoration: none;
		    color: white;
		    display: flex;
		    align-items: center;
		    height: 100%; /* Fill the entire height of the .main-nav */
		    padding: 0 15px; /* Add padding to create button-like appearance */
		    border-radius: 5px; /* Add rounded corners */
		    transition: background-color 0.3s; /* Smooth transition for hover effect */
		}
		
		.main-nav a {
		    /* Existing styles */
		    padding: 0 15px; /* Add padding to create button-like appearance */
		    /* New style */
		    padding-right: 20px; /* Add padding to the right side */
		    border-radius: 5px; /* Add rounded corners */
		    transition: background-color 0.3s; /* Smooth transition for hover effect */
			}
			
		.login-signup input[type="submit"] {
		    /* Existing styles */
		    padding: 0 15px; /* Add padding to match the navigation links */
		    /* New style */
		    padding-right: 20px; /* Add padding to the right side */
		    cursor: pointer;
		    color: white; /* Match text color with navigation links */
		}
				
		.login-signup input[type="submit"] {
			background-color: transparent;
			border: none;
			padding: 0 25px; /* Add padding to match the navigation links */
			cursor: pointer;
			color: white; /* Match text color with navigation links */
		}
		
		.login-signup input[type="submit"]:hover {
		    background-color: transparent; /* No background color on hover */
		}



        /* Add styles for the icons here */
        .icon-container {
		    display: flex;
		    align-items: center;
		    gap: 10px;
		    height:70px;
		    /* New style */
		    padding-right: 20px; /* Add padding to the right side */
		}
        }
    </style>
</head>
<body>

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession();
    String currentUser = (String) userSession.getAttribute("username");
    String contextPath = request.getContextPath();
%>

<div id="header">
    <header class="header">
        <h1 class="logo"><a href=""><img src="${pageContext.request.contextPath}/images/logo.png"/></a></h1>
        <ul class="main-nav" style="padding-left:200px;">
            <li><a href="#">HOME</a></li>
            <li><a href="#">PRODUCTS</a></li>
            <li><a href="#">ABOUT US</a></li>
            <li><a href="#">ORDERS</a></li>
        </ul>
        <div class="login-signup" style="display: flex;align-items: center; margin-left: auto;">
            <form action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + "/LogoutServlet");
                    } else {
                        out.print(contextPath + "/pages/login.jsp");
                    }
                %>" method="post">
                <input type="submit" style="font-size:16px;" class="poppins-regular" value="<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print("LOGOUT");
                        } else {
                            out.print("LOGIN");
                        }
                    %>"/>
            </form>
            <form action="<%= contextPath %>/pages/register.jsp" method="post">
                <input type="submit" value="SIGNUP" style="font-size:16px; padding-left:0px" class="poppins-regular">
            </form>
        </div>
        <div class="icon-container">
            <!-- Icon 1 -->
            <img src="${pageContext.request.contextPath}/images/Vector.png" alt="Icon 1">
            <!-- Icon 2 -->
            <img src="${pageContext.request.contextPath}/images/search.png" alt="Icon 2">
            <!-- Icon 3 -->
            <img src="${pageContext.request.contextPath}/images/shop.png" alt="Icon 3">
        </div>
    </header>
</div>

</body>
</html>
