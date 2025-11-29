package ma.ensa.gestionproduitjavafxv2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

//    Table columns
    @FXML private TableView<Product> table;
    @FXML
    private TableColumn<Product, String> colRef;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Double> colPrice;


    private final ProductService productService = new ProductServiceImpl();

    @FXML
    public void add(){
        String ref = this.ref.getText();
        String name = this.name.getText();
        Double price = Double.parseDouble(this.price.getText());
        Product product = new Product(ref, name, price);
        int saved = productService.save(product);
        if(saved > 0 ){
            table.getItems().add(product);
            this.ref.clear();
            this.name.clear();
            this.price.clear();
        }
    }

    @FXML
    public void initialize(){
        colRef.setCellValueFactory(new PropertyValueFactory<>("ref"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getItems().setAll(productService.findAll());
    }
}
