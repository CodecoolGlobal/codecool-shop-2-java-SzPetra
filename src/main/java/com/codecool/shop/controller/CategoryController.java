package com.codecool.shop.controller;

import com.codecool.shop.config.DataSourceFactory;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.jdbc.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.jdbc.ProductDaoJdbc;
import com.codecool.shop.dao.jdbc.SupplierDaoJdbc;
import com.codecool.shop.service.ProductService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = {"/category/"})
public class CategoryController extends HttpServlet {

    private DataSource source = DataSourceFactory.createDataSource();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int categoryId = Integer.parseInt(req.getParameter("category_id"));

        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc(source);
        SupplierDao supplierDao = new SupplierDaoJdbc(source);
        ProductDao productDataStore = new ProductDaoJdbc(source, productCategoryDao, supplierDao);
        ProductService productService = new ProductService(productDataStore,productCategoryDao);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("category", productService.getProductCategory(categoryId));
        context.setVariable("products", productService.getProductsForCategory(categoryId));

        engine.process("product/index.html", context, resp.getWriter());
    }

}
