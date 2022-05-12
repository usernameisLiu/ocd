package com.Dao;

import com.Bean.StudentInfomation;
import com.DataBase.DBLink;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.Random;

public class StudentDao {

    /**
     * 判断用户名和密码是否正确
     */
    public boolean isUserPwd(StudentInfomation studentInfomation) {
        boolean flag = false;
        String sql = "select * from student where student_id='" + studentInfomation.getStudent_id() +
                "' and student_name='" + studentInfomation.getStudent_name() + "'";
        System.out.println(sql);
        DBLink dbLink = new DBLink();
        try {
            ResultSet rs = dbLink.doQuery(sql);
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 从数据库读取当前学生信息表数据到前端表格
     */
    public StudentInfomation readDataTable(String id, PrintWriter printWriter) {
        StudentInfomation studentInfomation = new StudentInfomation();
        String sql = "SELECT * FROM student where student_id='" + id + "'";
        DBLink dbLink = new DBLink();
        try {
            ResultSet resultSet = dbLink.doQuery(sql);
            if (resultSet.next()) {
                studentInfomation.setStudent_id(id);
                studentInfomation.setStudent_name(resultSet.getString(2));
                studentInfomation.setStudent_sex(resultSet.getString(3));
                studentInfomation.setStudent_age(resultSet.getString(4));
                studentInfomation.setStudent_class(resultSet.getString(5));
                studentInfomation.setStudent_major(resultSet.getString(6));
                studentInfomation.setStudent_faculty(resultSet.getString(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentInfomation;
    }

    /**
     * 生成验证码
     */
    public void VerificationCode(HttpServletRequest request, HttpServletResponse response, HttpSession session)
            throws IOException {
        int charNum = 4;
        int width = 20 * 4;
        int height = 28;
        //1.创建一张内存图片
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //2.获取绘图对象
        Graphics graphics = bufferedImage.getGraphics();
        //3.绘制背景颜色
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, width, height);
        //4.绘制图片边框
        graphics.setColor(Color.GRAY);
        graphics.drawRect(0, 0, width - 1, height - 1);
        //5.输出验证码内容
        graphics.setColor(Color.RED);
        graphics.setFont(new Font("宋体", Font.BOLD, 22));
        //随机输出四个字符
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        //session中要用到
        String msg = "";
        int x = 5;
        for (int i = 0; i < charNum; i++) {
            int index = random.nextInt(36);
            String content = String.valueOf(s.charAt(index));
            msg += content;
            graphics.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            graphics.drawString(content, x, 22);
            x += 20;
        }
        request.getSession().setAttribute("sessionYzm", msg);
        //6.绘制干扰线
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 5; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, x2, y1, y2);
        }
        //释放资源
        graphics.dispose();
        //图片输出
        ImageIO.write(bufferedImage, "jpg", response.getOutputStream());

    }

}
