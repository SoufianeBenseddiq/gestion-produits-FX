package ma.ensa.gestionproduitjavafxv2.service.impl;

import ma.ensa.gestionproduitjavafxv2.dao.facade.ProductDao;
import ma.ensa.gestionproduitjavafxv2.dao.impl.ProductDaoImpl;
import ma.ensa.gestionproduitjavafxv2.model.Product;
import ma.ensa.gestionproduitjavafxv2.service.facade.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public int save(Product product) {
        if (product.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        return productDao.save(product);
    }

    @Override
    public List<Product> findAll() {
        List<Product> all = productDao.findAll();
        if (all == null) {
            throw new IllegalArgumentException("error in findAll");
        }
        return all;
    }

    @Override
    public int update(Product product) {
        return productDao.update(product);
    }

    @Override
    public int delete(String ref) {
        return productDao.delete(ref);
    }

    private final ProductDao productDao = new ProductDaoImpl();
}
