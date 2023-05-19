package com.exam2;

import com.exam2.Util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Management {
    public void addContact(Contact contact) throws Exception{
        try {
            Connection connect = com.exam2.Util.DBConnection.getConnection();
            PreparedStatement ps = connect.prepareStatement(
                    "INSERT INTO addressbook(name,company, email,phone) VALUES (?,?,?,?)");
            ps.setString(1,contact.getName());
            ps.setString(2,contact.getCompany());
            ps.setString(3,contact.getEmail());
            ps.setString(4,contact.getPhone());

            int updated = ps.executeUpdate();
            if(updated > 0) {
                System.out.println("Insert Contact success!!!");
            }

            ps.close();
            connect.close();
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Contact getContactByname(int ID) throws Exception {

        Contact ct = null;

        try {
            Connection conn =  DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT ID, name, company, email,phone FROM addressbook WHERE ID = ?");
            ps.setInt(1, ID);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                ct = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return ct;
    }




    public void getContact() throws Exception{
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT ID, name,company, email, phone FROM addressbook");

            while(rs.next()) {
                Contact ct = new Contact(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

                System.out.println(ct.toString());
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}