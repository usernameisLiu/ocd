<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background-image: linear-gradient(to right top, #8fb2e5, #9fb9e8,
            #aec0eb, #bcc8ed, #c9d0f0);
        }

        .font1 input {
            width: 80px;
            height: 30px;
            background-color: #1e9eff;
            color: aliceblue;
            border: 0;

        }

        .font2 {
            border: 50px solid #c1d8ea;
            width: 500px;
            margin-left: auto;
            margin-right: auto;
            margin-top: 150px;
            background-color: #c1d8ea;
        }

        .font3, .font4, .font5 {
            margin-left: 70px;
        }

        .font3 {
            margin-top: 20px;
        }

        .font4, .font5 {
            margin-top: 15px;
        }
    </style>
</head>
<body>
<form action="LoginServlet" method="post">
    <div class="font2">
        <div class="font3">
            <label for="username">学号:&nbsp</label>
            <input type="text" name="student_id" id="username" placeholder="请输入用户名">
        </div>
        <div class="font4">
            <label for="inputPassword3">&nbsp&nbsp&nbsp姓名:&nbsp</label>
            <input type="text" name="student_name" id="inputPassword3" placeholder="请输入密码">
        </div>
        <div class="font5">
            <label for="inputPassword3">验证码:&nbsp</label>
            <input type="text" name="yzm" id="inputPassword" placeholder="请输入验证码">
            <img src="YzmServlet" alt="">
        </div>
        <br>


        <div class="font1"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
                                                                                                      value="登录"
                                                                                                      name="submit">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" width="200" value="注册" name="submit">

        </div>
    </div>
</form>
</body>
</html>