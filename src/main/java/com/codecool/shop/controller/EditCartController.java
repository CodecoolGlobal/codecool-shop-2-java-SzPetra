package com.codecool.shop.controller;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/add-to-cart"})
public class EditCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getParameter("product_id");
        if(queryString != null){
            int productId = Integer.parseInt(queryString);
            System.out.println(productId);

            ProductDao productDataStore = ProductDaoMem.getInstance();
            CartDao cartDataStore = CartDaoMem.getInstance();

            Product productToAdd = productDataStore.find(productId);
        }

        resp.sendRedirect(req.getContextPath() + "/");
                
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartService cartService = new CartService(CartDaoMem.getInstance(),ProductDaoMem.getInstance());
        cartService.clearCart();
    }

}
