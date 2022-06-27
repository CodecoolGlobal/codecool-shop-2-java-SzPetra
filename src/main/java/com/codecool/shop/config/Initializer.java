package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier pappCompany = new Supplier("Papp Co.", "Dreamin' about a family? A perfect relationship? Or just a wonderful life as an independent being? What job is your dream job? Let me make it come true, you can trust me with your life!");
        supplierDataStore.add(pappCompany);
        Supplier petraCompany = new Supplier("Petrus Zrt.", "Do you feel like you are living someone else's life? Ready to start a new one, but don't want to be far away from your family? Let me give you a whole new life inside your own boundaries, and make your dreams come true!");
        supplierDataStore.add(petraCompany);
        Supplier daniCompany = new Supplier("Dani Inc.", "Do your dreams take you far from home? There are no boundaries in dreams! Join me on the journey of you life.");
        supplierDataStore.add(daniCompany);

        //setting up a new product category
        ProductCategory withKids = new ProductCategory("with Kids", "Family Edition by Papp Co.", "A whole new life with kids you've been dreaming about");
        productCategoryDataStore.add(withKids);
        ProductCategory single = new ProductCategory("Single", "Single Edition by Papp Co.", "A happy independent life, with a stable job and a lot of adventures");
        productCategoryDataStore.add(single);
        ProductCategory inRelationship = new ProductCategory("in Relationship", "in a Relationship Edition by Papp Co.", "The perfect relationship, the perfect couple, the perfect partner you've been dreaming about");
        productCategoryDataStore.add(inRelationship);
        ProductCategory abroad = new ProductCategory("Abroad", "Abroad Edition by Dani Inc.", "Start fresh, live a life that you've always wanted, WHERE you've always wanted");
        productCategoryDataStore.add(abroad);
        ProductCategory inland = new ProductCategory("Inland", "Inland Edition by Petrus Zrt.", "You don't have to drop your friends and family, you don't have to change your neighbourhood to start a new life");
        productCategoryDataStore.add(inland);


        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", new BigDecimal("49.9"), "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", family, dani));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", new BigDecimal("479"), "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", family, petra));
        productDataStore.add(new Product("Amazon Fire HD 8", new BigDecimal("89"), "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", family, dani));
    }
}
