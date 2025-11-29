module ma.ensa.gestionproduitjavafxv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens ma.ensa.gestionproduitjavafxv2 to javafx.fxml;
    exports ma.ensa.gestionproduitjavafxv2;
}