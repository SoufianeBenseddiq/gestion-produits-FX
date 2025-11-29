package ma.ensa.gestionproduitjavafxv2.service.facade;

import ma.ensa.gestionproduitjavafxv2.model.Product;

import java.util.List;

public interface ProductService {
    int save(Product product);

    List<Product> findAll();
}
