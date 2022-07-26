package com.codecool.shop.service;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.Supplier;

import java.util.List;

public class SupplierService {

    private ProductDao productDao;
    private SupplierDao supplierDao;

    public SupplierService(ProductDao productDao, SupplierDao supplierDao) {
        this.productDao = productDao;
        this.supplierDao = supplierDao;
    }

    public List<Product> getProductsBySupplier(int supplierId) {
        Supplier supplier = supplierDao.find(supplierId);
        return productDao.getBy(supplier);
    }
}
