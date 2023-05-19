package com.exam2;

import java.util.Scanner;

public class Contact {
    private static int count = 0;
    private int id;
    private String name;
    private String company;
    private String email;
    private String phone;

    public Contact(int id, String name, String company, String email, String phone){
    this.id = id;
    this.name = name;
    this.company = company;
    this.email = email;
    this.phone = phone;
    }
    public Contact(){

    }
    public Contact(String name, String company, String email, String phone) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.phone = phone;
    } public void input(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name:");
        this.name = input.nextLine();
        System.out.println("Enter Company:");
        this.company = input.nextLine();
        System.out.println("Enter Email:");
        this.email = input.nextLine();
        System.out.println("Enter Phone:");
        this.phone = input.nextLine();
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCompany(){
        return company;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String toString(){
        return String.format("[id = %d, name = %s, company = %s, email = %s, phone = %s]", id,name,company,email,phone);
    }
}

