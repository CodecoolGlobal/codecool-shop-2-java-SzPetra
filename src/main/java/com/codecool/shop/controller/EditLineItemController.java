package com.codecool.shop.controller;


import com.codecool.shop.dao.implementation.CartDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api/edit-item"})
public class EditLineItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getParameter("product_id");
        if(queryString != null){
            int productId = Integer.parseInt(queryString);
            CartService cartService = new CartService( CartDaoMem.getInstance(), ProductDaoMem.getInstance());
            String jsonItem = cartService.getLintItemByIdAsJson(productId);
            resp.setStatus(200);
            resp.setContentType("application/json");
            resp.getWriter().print(jsonItem);
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idString = req.getParameter("product_id");
        String quantityString = req.getParameter("quantity_change");
        if(idString != null && quantityString != null){
            int productId = Integer.parseInt(idString);
            int quantityChange = Integer.parseInt(quantityString);
            CartService cartService = new CartService( CartDaoMem.getInstance(), ProductDaoMem.getInstance());
            cartService.changeLineItemQuantityBy(productId,quantityChange);
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getParameter("product_id");
        if(queryString != null){
            int productId = Integer.parseInt(queryString);
            CartService cartService = new CartService( CartDaoMem.getInstance(), ProductDaoMem.getInstance());
            cartService.removeProductFromCart(productId);
            resp.setStatus(200);
        }else{
            resp.sendRedirect(req.getContextPath() + "/");
        }
    }
}
