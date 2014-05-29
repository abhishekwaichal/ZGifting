<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% session.invalidate(); %>
<!-- 

VIEW
index.jsp:

Welcome screen.
 
-->


 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zappos Gifting</title>
<script type="text/javascript">
	function ValidateLookUpForm() {
		var id = document.lookupForm.qty;
		var pass = document.lookupForm.amt;

		if (id.value == "") {
			window.alert("Please enter a valid qty.");
			id.focus();
			return false;
		}

		if (pass.value == "") {
			window.alert("Please enter a valid amt.");
			pass.focus();
			return false;
		}

		return true;
	}
	
</script>

</head>
<br><br>
<div align="center"><h1>Zappos Gifting</h1></div>
<br><br>

<body>
	<p>${errMsg}</p>
	<div align="center">
	<form method = "POST" name="lookupForm" action="Gifting" onsubmit="return ValidateLookUpForm();" > 
		<br/><b>Quantity:<b><p><input type="text" name="qty" placeholder="desired # of products"/></p>
		<br/><b>Amount:<b><p><input  type="text"  name="amt" placeholder="desired dollar amount"/></p>
		<br/><p><input type="submit" name= "submit" value="LookUp" /></p>
	</form>
	</div>
</body>
</html>