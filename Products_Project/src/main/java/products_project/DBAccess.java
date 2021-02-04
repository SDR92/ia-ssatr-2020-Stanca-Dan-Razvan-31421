package products_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBAccess {
    
    Connection conn;
    
    public DBAccess() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        conn = DriverManager.getConnection("jdbc:derby://localhost/products_db;create=false","APP","APP");
    }
    
    public void insertProduct(String name, String price, java.util.Date date, InputStream img) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("INSERT INTO products(name, price, adddate, image)"+ "values(?,?,?,?) ");
        
        ps.setString(1, name);
        ps.setString(2, price);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String addDate = dateFormat.format(date);
        ps.setString(3, addDate);

        
        ps.setBlob(4, img);
        ps.executeUpdate();
    }
    
    public void updateProduct (String name, String price, java.util.Date date, String id) throws SQLException {
        String updateQuery = "UPDATE products SET name= ?, price =?, adddate = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
                
        ps.setString(1, name);
        ps.setString(2, price);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String addDate = dateFormat.format(date);

        ps.setString(3, addDate);
        ps.setInt(4, Integer.parseInt(id));
        ps.executeUpdate();
        
    }
    
    public void updateProductImage (String name, String price, java.util.Date date, InputStream image, String id) throws SQLException {
        
                       
        String updateQuery = "UPDATE products SET name= ?, price =?, adddate = ?, image = ? WHERE id = ?";  

        PreparedStatement ps = conn.prepareStatement(updateQuery);

        ps.setString(1, name);
        ps.setString(2, price);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String addDate = dateFormat.format(date);

        ps.setString(3, addDate);

        ps.setBlob(4,image);

        ps.setInt(5, Integer.parseInt(id));

        ps.executeUpdate();
        
    }
    
    
    public void deleteProduct (String id) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE id = ?");
        ps.setInt(1, Integer.parseInt(id));
        ps.executeUpdate();
        
    }
    
    public ArrayList<Product> getProductList()
    {
        ArrayList<Product> productList = new ArrayList<>();
        
        String query = "SELECT * FROM products";
        
        Statement st;
        ResultSet rs;
        
        try
        {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Product product;
        
            while (rs.next())
            {
                product = new Product(rs.getInt("id"), rs.getString("name"), Float.parseFloat(rs.getString("price")), rs.getString("adddate"), rs.getBytes("image") );
                productList.add(product);
            }
        
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Main_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return productList;
    }
    
}
