package ma.ensa.gestionproduitjavafxv2.dao.facade;

import ma.ensa.gestionproduitjavafxv2.model.Product;

import java.util.List;

public interface ProductDao {
    int save(Product product);
    List<Product> findAll();
}
