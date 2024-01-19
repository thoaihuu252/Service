package com.example.service.DAO;


import java.util.Properties;

public class DBProperties {
    private static Properties pro = new Properties();
    static {
       try{
           pro.load( DBConnect.class.getClassLoader().getResourceAsStream("db.properties"));
       }catch (Exception e){
           e.printStackTrace();
           throw new RuntimeException(e);
       }
    }
    public static String host(){
        return pro.getProperty("db.host").toString();
    }
    public static String port(){
        return pro.getProperty("db.port").toString();
    }
    public static String pass(){
        return pro.getProperty("db.pass").toString();
    }
    public static String user(){
        return pro.getProperty("db.user").toString();
    }
    public static String name(){
        return pro.getProperty("db.name").toString();
    }

    public static void main(String[] args) {
        System.out.println(DBProperties.host());
    }
}
