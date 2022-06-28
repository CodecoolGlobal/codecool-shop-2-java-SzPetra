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
        productDataStore.add(new Product("Cozy Family Life in Hawaii", new BigDecimal("2000"), "USD", "3 wonderful blonde and blue eyed kids and a husband with surfing abilities. Living a relaxing and cozy life on the beautiful beach of Hawaii USA. The kids are 2, 4 and 5 years old. Brody is a very helpful and loving husband, who loves his family.", withKids, pappCompany));
        productDataStore.add(new Product("La petite mort", new BigDecimal("800"), "EUR", "Croissants for breakfast, cheese with wine for lunch, living by the Eiffel Tower. High fashioned people, culture and a very opened-mindset. Enjoy all that Paris can offer you.", abroad, daniCompany));
        productDataStore.add(new Product("be the Sound of Balaton", new BigDecimal("500.000"), "HUF", "If you've always loved music, this is the perfect opportunity for you. Now you can be the Sound of Balaton. Living in a mansion by the hungarian sea. As a very famous producer, you have studios in the basement and a pool in the garden. Living your best life.", inland, petraCompany));
        productDataStore.add(new Product("Do I call Hollywood or do they call me?", new BigDecimal("4000"), "USD", "Ever dreamed of being a famous actress/actor living in Hollywood? Ready to be the next Zendaya or DiCaprio? Spend your days in a huge but private mansion in the heart of Hollywood with your own pool and gym in the basement. Bedroom view at the Hollywood sign and shower under the stars with glass roof over the bathroom. Luxury is assured.", abroad, daniCompany));
        productDataStore.add(new Product("Where to be in love if not in the city of love?", new BigDecimal("500"), "EUR", "Perfect dates, french kissing, city of love. If all you need is a perfect relationship, let Alexandre work his magic on you. His apartment's view is at the one and only Eiffel Tower. Loves dates, good vines and he's funny. Speaks 3 languages and is looking for a partner, who he can lean on. Stable and strong relationship is right in the corner for you, buy it now!", inRelationship, pappCompany));
        productDataStore.add(new Product("to be Single and Mingle New York Edition", new BigDecimal("700"), "USD", "Start fresh and single in the city that never sleeps. Always something to do, get to know a lot of cultures, make new friends and Mingle in. It is not abandoned to Mingle up with someone throughout your journey in New York. Live right next to Central park, start your everyday with a run and a coffee. Get lost in the countless avenues and shop up. Challenge yourself and try new things to get to know who you really are. This is the city where everything is possible!", single, pappCompany));
        productDataStore.add(new Product("Have you ever Googled Google?", new BigDecimal("3000"), "USD", "Be a programmer at Google and enjoy the advantages that comes with it. Did you know there is a huge slide inside the Google department? Or the big variety of food you can get at the buffet? It also comes with a mansion in Silicone Valley payed by your company. If you can dream it, you can Code IT!", abroad, daniCompany));
    }
}
