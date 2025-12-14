package ma.ensa.gestionproduitjavafxv2.dao.impl;

import ma.ensa.gestionproduitjavafxv2.dao.ConnectionDB;
import ma.ensa.gestionproduitjavafxv2.dao.facade.ProductDao;
import ma.ensa.gestionproduitjavafxv2.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public int update(Product product) {
        String sql = "UPDATE product SET name="+product.getRef()+", description="+product.getName()+", price="+product.getPrice()+" WHERE ref="+product.getRef();
        try {
            ConnectionDB db = new ConnectionDB();
            int i = db.getSt().executeUpdate(sql);
            return i;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(String ref) {
        String sql = "DELETE FROM product WHERE ref = ?";

        try {
            ConnectionDB conn = new ConnectionDB();
            PreparedStatement ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, ref);

            int deleted = ps.executeUpdate();
            conn.getCon().close();

            return deleted;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }

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
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM product";
        List<Product> products = new ArrayList<>();
        try {
            ConnectionDB conn = new ConnectionDB();
            PreparedStatement ps = conn.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                products.add(
                        new Product(
                                rs.getString("ref"),
                                rs.getString("name"),
                                rs.getDouble("price")
                        )
                );
            }
            return products;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Product findByRef(String ref) {
        String sql = "SELECT * FROM product WHERE ref = ?";

        try {
            ConnectionDB conn = new ConnectionDB();
            PreparedStatement ps = conn.getCon().prepareStatement(sql);
            ps.setString(1, ref);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Product(
                            rs.getString("ref"),
                            rs.getString("name"),
                            rs.getDouble("price")
                    );
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

}
