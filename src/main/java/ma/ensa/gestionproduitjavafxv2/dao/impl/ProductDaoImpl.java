package ma.ensa.gestionproduitjavafxv2.dao.impl;

import ma.ensa.gestionproduitjavafxv2.dao.ConnectionDB;
import ma.ensa.gestionproduitjavafxv2.dao.facade.ProductDao;
import ma.ensa.gestionproduitjavafxv2.model.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDaoImpl implements ProductDao {
    @Override
    public int save(Product product) {
        String sql = "INSERT INTO product(ref, name, price) VALUES(?,?,?)";
        try {
            ConnectionDB conn = new ConnectionDB();
            PreparedStatement ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, product.getRef());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            int saved = ps.executeUpdate();
            conn.getCon().close();
            return saved;
        }catch (SQLException | ClassNotFoundException e){
            e.fillInStackTrace();
        }
        return 0;
    }
}
