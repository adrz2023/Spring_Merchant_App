<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            
            margin: 0;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input,
        password {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<form:form modelAttribute="m" method="post" action="register">
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<form:label path="gst_number">GST Number</form:label>
		<form:input path="gst_number" />
		<br>
		<form:label path="phone">Phone Number</form:label>
		<form:input path="phone" />
		<br>
		<form:label path="email">Email Id</form:label>
		<form:input path="email" />
		<br>
		<form:label path="password">Password</form:label>
		<form:password path="password" />
		<br>
		<form:button>REGISTER</form:button>
	</form:form>
</body>
</html>