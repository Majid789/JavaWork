<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login And Registration Form</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="hero">
    <div class="form-box">
        <div class="button-box">
            <div id="btn"></div>
            <button type="button" class="toggle-btn" onclick="Login()">Log In</button>
            <button type="button" class="toggle-btn" onclick="Register()">Register</button>
        </div>
        <div class="social-icons">
            <img src="Files/fb.png" alt="">
            <img src="Files/tw.png" alt="">
            <img src="Files/gp.png" alt="">
        </div>
        <form id="login" class="input-group" method="get">
            <input type="hidden" name="command" value="LogIn">
            <input type="text" name="ID" class="input-field" placeholder="User Id" required>
            <input type="text" name="Password" class="input-field" placeholder="Password" required>
            <input type="checkbox" class="chech-box"><span>Remember Password</span>
            <button type="submit" class="submit-btn">Log in</button>
        </form>
        <form id="register" class="input-group" name="command" value="Register" method="get">
            <input type="hidden" name="command" value="Register">
            <input type="text" name="ID" class="input-field" placeholder="User Id" required>
            <input type="text" name="Password" class="input-field" placeholder="Password" required>
            <input type="text" name="Email" class="input-field" placeholder="Email" required>
            <input type="text" name="Phone" class="input-field" placeholder="Phone No" required>
            <input type="text" name="Address" class="input-field" placeholder="Address" required>
            <br>
            <%--<input type="text" class="input-field" placeholder="Country">--%> <span2>Country   <select name="Country">
            <option>Pakistan</option>
            <option>India</option>
            <option>Afghanistan</option>
            <option>Turkey</option>
            <option>Canada</option>
        </select></span2>
            <br>
            <input type="checkbox" class="chech-box" required><span>I agree to the term & Conditions</span>
            <button type="submit" class="submit-btn">Register</button>
        </form>
    </div>
</div>
<%--<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>--%>
<script>
    var x=document.getElementById("login");
    var y=document.getElementById("register");
    var z=document.getElementById("btn");

    function Register(){
        x.style.left="-400px";
        y.style.left="50px"
        z.style.left="110px";
    }
    function Login()
    {
        x.style.left="50px";
        y.style.left="450px"
        z.style.left="0";
    }


</script>
</body>
</html>