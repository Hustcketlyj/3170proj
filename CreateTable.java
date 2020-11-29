/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj170;
import java.sql.*;
import java.util.*;
/**
 *
 * @author luyij
 */
public class CreateTable {
    public static void create(Connection con){
        try{
                    Statement stmt=con.createStatement();
                   int rs=stmt.executeUpdate("DROP TABLE IF EXISTS DRIVER,VEHICLE,PASSENGER,REQUEST,TRIP,TAXI_STOP;");
                   String sql="CREATE TABLE DRIVER "+
                        "(id INTEGER, "+
                        "name VARCHAR(30) NOT NULL,"+
                        "vehicle_id VARCHAR(6) NOT NULL,"+
                         "driving_years INTEGER," +
                          "PRIMARY KEY (id));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables driver result info:"+(0==rs));
                    sql="CREATE TABLE VEHICLE "+
                        "(id VARCHAR(6) NOT NULL, "+
                        "model VARCHAR(30) NOT NULL,"+
                        "seats INTEGER,"+
                          "PRIMARY KEY (id));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables vehicle result info:"+(0==rs));
                    sql="CREATE TABLE PASSENGER "+
                        "(id INTEGER, "+ 
                        "name VARCHAR(30) NOT NULL,"+
                          "PRIMARY KEY (id));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables passenger result info:"+(0==rs));
                    sql="CREATE TABLE REQUEST "+
                        "(id INTEGER, "+
                        "passenger_id INTEGER,"+
                        "start_location VARCHAR(20) NOT NULL,"+
                        "destination VARCHAR(20) NOT NULL,"+
                        "model VARCHAR(30) NOT NULL,"+
                        "passengers INTEGER,"+
                        "taken BOOLEAN DEFAULT FALSE,"+
                        "driving_years INTEGER,"+
                          "PRIMARY KEY (id));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables request result info:"+(0==rs));
                    sql="CREATE TABLE TRIP "+
                        "(id INTEGER, "+
                        "driver_id INTEGER,"+
                        "passenger_id INTEGER,"+
                        "start_time DATETIME,"+
                        "end_time DATETIME,"+
                        "start_location VARCHAR(20) NOT NULL,"+
                        "destination VARCHAR(20) NOT NULL,"+
                        "fee INTEGER,"+
                          "PRIMARY KEY (id));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables trip result info:"+(0==rs));
                    sql="CREATE TABLE TAXI_STOP "+
                        "(name VARCHAR(20) NOT NULL, "+
                        "location_x INTEGER,"+
                        "location_y INTEGER,"+
                        "PRIMARY KEY (name));";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("create tables trip result info:"+(0==rs));
                }catch(SQLException e){
                    System.out.println(e);
                }
    }
}
