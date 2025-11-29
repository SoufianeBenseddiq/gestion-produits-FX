package ma.ensa.gestionproduitjavafxv2.service.impl;

import ma.ensa.gestionproduitjavafxv2.dao.facade.ProductDao;
import ma.ensa.gestionproduitjavafxv2.dao.impl.ProductDaoImpl;
import ma.ensa.gestionproduitjavafxv2.model.Product;
import ma.ensa.gestionproduitjavafxv2.service.facade.ProductService;

public class ProductServiceImpl implements ProductService {
    @Override
    public int save(Product product) {
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        return productDao.save(product);
    }

    private final ProductDao productDao = new ProductDaoImpl();
}
