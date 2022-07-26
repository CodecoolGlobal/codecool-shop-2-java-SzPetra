package com.codecool.shop.controller.api;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.service.CartService;
import com.codecool.shop.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/edit-cart"})
public class EditCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartService cartService = new CartService( CartDaoMem.getInstance(), ProductDaoMem.getInstance());
        String content = cartService.getCartContentAsJson();
        resp.setContentType("application/json");
        resp.getWriter().print(content);

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getParameter("product_id");
        if(queryString != null){
            int productId = Integer.parseInt(queryString);
            CartService cartService = new CartService( CartDaoMem.getInstance(), ProductDaoMem.getInstance());
            cartService.addProductToCart(productId);
            resp.setStatus(200);
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartService cartService = new CartService(CartDaoMem.getInstance(),ProductDaoMem.getInstance());
        cartService.clearCart();
        resp.setStatus(200);
    }

}
