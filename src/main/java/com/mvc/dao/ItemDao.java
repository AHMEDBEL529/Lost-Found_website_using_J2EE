package com.mvc.dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import com.mvc.bean.ItemBean ;
import com.mvc.util.DBConnection;
 
public class ItemDao {
    Connection connection = null;
    PreparedStatement statement = null;
     
    public ArrayList<ItemBean> get() throws SQLException, IOException {
        String sql = "SELECT * FROM founditems";
        ArrayList<ItemBean> items = new ArrayList<ItemBean>();
        try {
        	connection = DBConnection.createConnection();
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            ItemBean item = null;
       
            while (result.next()) {
                item = new ItemBean();
                String category = result.getString("category");
                String description = result.getString("description");
                Blob blob = result.getBlob("image");
                 
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                 
                inputStream.close();
                outputStream.close();
                 
                item.setDescription(description);
                item.setCategory(category);
                item.setBase64Image(base64Image);
                items.add(item);
                
            }          
             
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return items;
    }
}