package ma.ensa.gestionproduitjavafxv2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import ma.ensa.gestionproduitjavafxv2.model.Product;
import ma.ensa.gestionproduitjavafxv2.service.facade.ProductService;
import ma.ensa.gestionproduitjavafxv2.service.impl.ProductServiceImpl;

public class ProductController {
    @FXML private TextField ref;
    @FXML private TextField name;
    @FXML private TextField price;

//    Table columns
    @FXML private TableView<Product> table;
    @FXML private TableColumn<Product, String> colRef;
    @FXML private TableColumn<Product, String> colName;
    @FXML private TableColumn<Product, Double> colPrice;
    @FXML private TableColumn<Product, Void> colAction;

    private Product selectedProduct;

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
            clearFields();
        }
    }

    private void initActionColumn() {
        colAction.setCellFactory(col -> new TableCell<>() {

            private final Button btnEdit = new Button("Edit");
            private final Button btnDelete = new Button("Delete");

            {
                btnEdit.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                btnDelete.setStyle("-fx-background-color: #E53935; -fx-text-fill: white;");

                btnEdit.setOnAction(e -> {
                    Product p = getTableView().getItems().get(getIndex());
                    handleEdit(p);
                });

                btnDelete.setOnAction(e -> {
                    Product p = getTableView().getItems().get(getIndex());
                    handleDelete(p);
                });
            }

            private void handleEdit(Product product) {
                selectedProduct = product;

                ref.setText(product.getRef());
                name.setText(product.getName());
                price.setText(String.valueOf(product.getPrice()));
            }
            private void handleDelete(Product product) {
                selectedProduct = product;
                ref.setText(product.getRef());
                name.setText(product.getName());
                price.setText(String.valueOf(product.getPrice()));
            }



            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(10, btnEdit, btnDelete);
                    setGraphic(box);
                }
            }
        });
    }


    @FXML
    public void initialize(){
        colRef.setCellValueFactory(new PropertyValueFactory<>("ref"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        table.getItems().setAll(productService.findAll());
    }

    private void clearFields() {
        ref.clear();
        name.clear();
        price.clear();
    }

}
