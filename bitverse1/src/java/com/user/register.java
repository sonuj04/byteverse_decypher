/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
/**
 *
 * @author vansh
 */
@MultipartConfig
public class register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            
            
            
            //getting details
            
            String username=request.getParameter("user_name");
            String firstname=request.getParameter("first_name");
            String lastname=request.getParameter("last_name");
            String pass=request.getParameter("user_pass");
            String phone=request.getParameter("user_phone");
            String address=request.getParameter("user_address");
            Part part = request.getPart("image");
            String filename=part.getSubmittedFileName();
            //out.println(filename);
            //connection
            try
            {
                Thread.sleep(3000);
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/decypher","root","root");
                //query
                String q="insert into farmers(username,firstname,lastname,password,phone,address,imagefile)values(?,?,?,?,?,?,?)";
                PreparedStatement pstmt=con.prepareStatement(q);
                pstmt.setString(1,username);
                pstmt.setString(2,firstname);
                pstmt.setString(3,lastname);
                pstmt.setString(4,pass);
                pstmt.setString(5,phone);
                pstmt.setString(6,address);
                pstmt.setString(7,filename);
                pstmt.executeUpdate();
                //upload
                InputStream is=part.getInputStream();
                byte []data=new byte[is.available()];
                is.read(data);
                String path=request.getRealPath("/")+"img"+File.separator+filename;
                //out.println(path);
                FileOutputStream fos=new FileOutputStream(path);
                fos.write(data);
                fos.close();
                out.println("done");
            }catch(Exception e){
               e.printStackTrace();
               out.println("error");
            }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
