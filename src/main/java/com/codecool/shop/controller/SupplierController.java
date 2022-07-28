package com.codecool.shop.controller;

import com.codecool.shop.config.DataSourceFactory;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.dao.jdbc.ProductCategoryDaoJdbc;
import com.codecool.shop.dao.jdbc.ProductDaoJdbc;
import com.codecool.shop.dao.jdbc.SupplierDaoJdbc;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.service.SupplierService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = {"/supplier/"})
public class SupplierController extends HttpServlet {

    private DataSource source = DataSourceFactory.createDataSource();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int supplierId = Integer.parseInt(request.getParameter("supplier"));

        ProductCategoryDao productCategoryDao = new ProductCategoryDaoJdbc(source);
        SupplierDao supplierDao = new SupplierDaoJdbc(source);
        ProductDao productDataStore = new ProductDaoJdbc(source, productCategoryDao, supplierDao);

        SupplierService supplierService = new SupplierService(productDataStore, supplierDao);

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(request.getServletContext());
        WebContext context = new WebContext(request, resp, request.getServletContext());

        context.setVariable("products", supplierService.getProductsBySupplier(supplierId));

        engine.process("product/index.html", context, resp.getWriter());
    }
}
