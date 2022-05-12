<%@ page contentType="text/html; charset=utf-8" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <title>main</title>
</head>
<frameset cols="15%,*" frameborder="NO" border="0" framespacing="0">
    <frame src="student_main_fun.jsp" name="leftFrame" frameborder="NO" scrolling="NO" noresize bordercolor="#006699">
    <frameset rows="90%,*">
        <frameset rows="15%,*" framespacing="1" frameborder="NO" border="1" bordercolor="#000099">
            <frame src="student_main_img.jsp" name="topFrame" scrolling="NO" noresize>
            <frame src="stduent_main_con.jsp" name="mainFrame">
        </frameset>
        <frame src="student_main_pf.jsp" name="">
    </frameset>
</frameset>
<noframes>
    <body>
    </body>
</noframes>
</html>