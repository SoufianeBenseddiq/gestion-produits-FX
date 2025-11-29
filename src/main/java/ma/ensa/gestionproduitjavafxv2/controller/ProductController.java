package ma.ensa.gestionproduitjavafxv2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ma.ensa.gestionproduitjavafxv2.model.Product;
import ma.ensa.gestionproduitjavafxv2.service.facade.ProductService;
import ma.ensa.gestionproduitjavafxv2.service.impl.ProductServiceImpl;

public class ProductController {
    @FXML
    private TextField ref;
    @FXML
    private TextField name;
    @FXML
    private TextField price;

    private final ProductService productService = new ProductServiceImpl();

    @FXML
    public void add(){
        String ref = this.ref.getText();
        String name = this.name.getText();
        Double price = Double.parseDouble(this.price.getText());
        Product product = new Product(ref, name, price);
        productService.save(product);
        this.ref.clear();
        this.name.clear();
        this.price.clear();
    }

}
