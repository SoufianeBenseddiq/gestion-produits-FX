package ma.ensa.gestionproduitjavafxv2.model;

public class Product {
    private String ref;
    private String name;
    private Double price;
    public Product(String id, String name, Double price) {
        this.ref = id;
        this.name = name;
        this.price = price;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
