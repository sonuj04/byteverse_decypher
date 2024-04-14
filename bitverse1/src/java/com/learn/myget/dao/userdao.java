/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.myget.dao;
//import org.hibernate.SessionFactory;
import com.mysql.cj.Query;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;
import org.apache.catalina.User;

public class userdao {
    private SessionFactory factory;

    public userdao(SessionFactory factory) {
        this.factory = factory;
    }

    //get user by username and password
    public decypher getUserByusernameAndPassword(String username,String password){
        User user=null;
        
        try{
           
            String query="from User where username=: e and userpasswor=: p";
            Session session;
            session = this.factory.openSession();
            Query createQuery = session.createQuery(query);
            session.close();
            
        }catch(Exception e){
           e.printStackTrace();
        }
        
        return user;
    }
    
}
