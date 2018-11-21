package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: dtvikey
 * @Date: 21/11/18 上午 10:46
 * @Version 1.0
 */
@WebServlet("/updateusers")
public class UsersUpdateServlet extends HttpServlet {

    private UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户要更新的数据
        String id = req.getParameter("id");
        String nickname = req.getParameter("nickname");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String remark = req.getParameter("remark");

        //创建用户对象

        Users user = new Users(Integer.parseInt(id),nickname,Integer.parseInt(age),gender,email,phone,new Date(),remark);


        //提交更新

        usersDao.updateUsers(user);

        //查看更新后的用户数据

        resp.sendRedirect("/detail?id="+user.getId());

    }
}
