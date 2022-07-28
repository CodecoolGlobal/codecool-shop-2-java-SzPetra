package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.jdbc.UserDaoJdbc;
import com.codecool.shop.model.User;
import com.codecool.shop.service.UserService;
import org.postgresql.ds.PGSimpleDataSource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("login.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String psw = request.getParameter("password");

        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setDatabaseName("codecool_shop");
        ds.setPassword("sql27petrusblue");
        ds.setUser("petrus_blue");
        UserService uService = new UserService(new UserDaoJdbc(ds));

        if (uService.checkPassword(email, psw)) {
            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            response.sendRedirect("/");
        } else {
            response.sendRedirect("/login");
        }
    }
}
