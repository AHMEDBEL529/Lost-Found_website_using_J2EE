package com.mvc.controller;

import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mvc.bean.ItemBean;
import com.mvc.dao.ItemDao;

import java.sql.*;
import java.util.ArrayList;  

@WebServlet("/ShowFoundItemsServlet")
public class ShowFoundItemsServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
 
    public ShowFoundItemsServlet() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItemDao dao = new ItemDao();
         
        try {
        	ArrayList<ItemBean> items = dao.get();
             
            request.setAttribute("items", items);
            request.setAttribute("size", items.size());
             
            String page = "/index.jsp";
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
            requestDispatcher.forward(request, response);              
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
         
    }
}  
