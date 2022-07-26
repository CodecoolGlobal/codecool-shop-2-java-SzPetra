package com.codecool.shop.controller;

import com.codecool.shop.config.DataSourceFactory;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.jdbc.UserDaoJdbc;
import com.codecool.shop.model.User;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.service.UserService;
import org.postgresql.ds.PGSimpleDataSource;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;

@WebServlet(urlPatterns = {"/registration"})
public class RegistrationController extends HttpServlet {

    private DataSource source = DataSourceFactory.createDataSource();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, response, request.getServletContext());

        engine.process("product/registration.html", context, response.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("f-name");
        String lastName = req.getParameter("l-name");
        String email = req.getParameter("email");
        String psw = req.getParameter("password");

        User newUser = new User(firstName, lastName, email);
        UserService uService = new UserService(new UserDaoJdbc(source));

        if (uService.registerNewUser(newUser, psw)) {
            resp.sendRedirect("/");
        } else {
            resp.sendRedirect("/registration");
        }
    }
}
