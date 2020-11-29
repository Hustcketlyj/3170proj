/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj170;
import java.sql.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author luyij
 */
public class Read {
    
    public static void insert(Connection con){
     try{
         File file=new File("C:/Users/luyij/Desktop/3170/project/test_data/drivers.csv");
      Scanner in =new Scanner(file);
     String sql = "insert into DRIVER (id,name,vehicle_id,driving_years)"
 + "values(?,?,?,?)";
     PreparedStatement pstmt = con.prepareStatement(sql);
     //System.out.println(in.nextLine());
     while(in.hasNext()){
        String temp1=in.nextLine();
        String[] temp=temp1.split(",");
        if(temp.length==4){
          pstmt.setInt(1, Integer.parseInt(temp[0]));
          pstmt.setString(2, temp[1]);
          pstmt.setString(3, temp[2]);
          pstmt.setInt(4, Integer.parseInt(temp[3]));
          pstmt.executeUpdate();
        }
     }
     file=new File("C:/Users/luyij/Desktop/3170/project/test_data/passengers.csv");
     in=new Scanner(file);
     sql = "insert into PASSENGER (id,name)"
 + "values(?,?)";
     pstmt = con.prepareStatement(sql);
     while(in.hasNext()){
        String temp1=in.nextLine();
        String[] temp=temp1.split(",");
        if(temp.length==2){
          pstmt.setInt(1, Integer.parseInt(temp[0]));
          pstmt.setString(2, temp[1]);
          pstmt.executeUpdate();
        }
     }
     file=new File("C:/Users/luyij/Desktop/3170/project/test_data/taxi_stops.csv");
     in=new Scanner(file);
     sql = "insert into TAXI_STOP (name,location_x,location_y)"
 + "values(?,?,?)";
     pstmt = con.prepareStatement(sql);
     while(in.hasNext()){
        String temp1=in.nextLine();
        String[] temp=temp1.split(",");
        if(temp.length==3){
          pstmt.setString(1, temp[0]);
          pstmt.setInt(2, Integer.parseInt(temp[1]));
          pstmt.setInt(3, Integer.parseInt(temp[2]));
          pstmt.executeUpdate();
        }
     }
     file=new File("C:/Users/luyij/Desktop/3170/project/test_data/vehicles.csv");
     in=new Scanner(file);
     sql = "insert into VEHICLE (id,model,seats)"
 + "values(?,?,?)";
     pstmt = con.prepareStatement(sql);
     while(in.hasNext()){
        String temp1=in.nextLine();
        String[] temp=temp1.split(",");
        if(temp.length==3){
          pstmt.setString(1, temp[0]);
          pstmt.setString(2, temp[1]);
          pstmt.setInt(3, Integer.parseInt(temp[2]));
          pstmt.executeUpdate();
        }
     }
     file=new File("C:/Users/luyij/Desktop/3170/project/test_data/trips.csv");
     in=new Scanner(file);
     sql = "insert into TRIP (id,driver_id,passenger_id,start_time,end_time,start_location,destination,fee)"
 + "values(?,?,?,?,?,?,?,?)";
     pstmt = con.prepareStatement(sql);
     while(in.hasNext()){
        String temp1=in.nextLine();
        String[] temp=temp1.split(",");
        if(temp.length==8){
          pstmt.setInt(1, Integer.parseInt(temp[0]));//d
          pstmt.setInt(2, Integer.parseInt(temp[1]));//d
          pstmt.setInt(3, Integer.parseInt(temp[2]));//d
          pstmt.setString(4, temp[3]);
          pstmt.setString(5, temp[4]);
          pstmt.setString(6, temp[5]);//d
          pstmt.setString(7, temp[6]);//d
          pstmt.setInt(8, Integer.parseInt(temp[7]));
          pstmt.executeUpdate();
        }
     }
     System.out.println("Loading.... Data insertion complete!");
     }catch(FileNotFoundException e){
         System.out.println(e);
     }catch(SQLException e1){
         System.out.println(e1);
     }
      
 
    }
}
