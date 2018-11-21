package com.damu.servlet;

import com.damu.dao.UsersDao;
import com.damu.entity.Users;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: dtvikey
 * @Date: 18-11-16 下午5:20
 * @Version 1.0
 */
@WebServlet("/detail")
public class UsersFindByIdServlet extends HttpServlet {

    /**
     * 创建对应的日志记录对象
     * 通过不同的级别记录日志[DEBUG\WARN\INFO\LOG]
     */
    private Logger log = Logger.getLogger(UsersFindByIdServlet.class);

    private UsersDao usersDao = new UsersDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        log.info("获取到查询参数id--》"+id);

        Users user = usersDao.findById(Integer.parseInt(id));

        log.info("查询数据完成,查询到的数据: "+user);

        req.setAttribute("user",user);
        req.getRequestDispatcher("detail.jsp").forward(req,resp);
    }
}
