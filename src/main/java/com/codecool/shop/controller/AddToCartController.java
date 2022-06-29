package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-to-cart"})
public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("product_id"));
        System.out.println(productId);

        ProductDao productDataStore = ProductDaoMem.getInstance();
        CartDao cartDataStore = CartDaoMem.getInstance();

        Product productToAdd = productDataStore.find(productId);

        cartDataStore.addProduct(productToAdd);


        resp.sendRedirect(req.getContextPath() + "/");
                
    }
}
