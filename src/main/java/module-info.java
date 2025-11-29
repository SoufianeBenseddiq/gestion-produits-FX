module ma.ensa.gestionproduitjavafxv2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.j;

    opens ma.ensa.gestionproduitjavafxv2 to javafx.fxml;
    exports ma.ensa.gestionproduitjavafxv2;
    opens ma.ensa.gestionproduitjavafxv2.controller to javafx.fxml;
    exports ma.ensa.gestionproduitjavafxv2.controller;
    opens ma.ensa.gestionproduitjavafxv2.model to javafx.base;
}