package com.servlet;

import com.Bean.StudentInfomation;
import com.Dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class StudentServlet_Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String student_id = request.getParameter("student_id");
        String student_name = request.getParameter("student_name");
        StudentInfomation studentInfomation = new StudentInfomation();
        studentInfomation.setStudent_id(student_id);
        studentInfomation.setStudent_name(student_name);
        StudentDao studentDao = new StudentDao();
        if (studentDao.isUserPwd(studentInfomation)) {
            response.sendRedirect("student_main.jsp");
        } else {
            out.println("404 NOT FIND");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
