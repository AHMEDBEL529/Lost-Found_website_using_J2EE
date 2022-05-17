package com.mvc.controller;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mvc.util.DBConnection;

@WebServlet("/DeclareFoundItemServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class DeclareFoundItemServlet extends HttpServlet {
 
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeclareFoundItemServlet() {
     }
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/DeclareFoundItem.jsp").forward(request, response);
     }
 
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Copying all the input parameters in to local variables
         String category = request.getParameter("category");
         String description = request.getParameter("description");
         InputStream inputStream = null; // input stream of the upload file
         Part filePart = request.getPart("image");
         inputStream = filePart.getInputStream();
         
         Connection con = null;
         PreparedStatement preparedStatement = null;         
         try
         {
             con = DBConnection.createConnection();
             String query = "insert into founditems(FoundItemId,UserId,Category,Description,image) values (NULL,?,?,?,?)"; //Insert user details into the table 'USERS'
             preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
             HttpSession session = request.getSession();
             preparedStatement.setInt(1, Integer.parseInt((String)session.getAttribute("userId")));
             preparedStatement.setString(2, category);
             preparedStatement.setString(3, description);
             preparedStatement.setBlob(4, inputStream);
             
             int i= preparedStatement.executeUpdate();
             
             if(i!=0)   //On success, you can display a message to user on Home page
             {
            	 request.setAttribute("Message", "INSERTED SUCCESSFULLY");
                request.getRequestDispatcher("/DeclareFoundItem.jsp").forward(request, response);
             }
             else   //On Failure, display a meaningful message to the User.
             {
            	 request.setAttribute("Message", "ERROR HAS OCCURED");
                 request.getRequestDispatcher("/DeclareFoundItem.jsp").forward(request, response);
             }
             
             
         }
         catch(SQLException e)
         {
            e.printStackTrace();
         }       
   
        
     }
}