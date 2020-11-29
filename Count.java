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
public class Count {
    public static void count(Connection con){
       ResultSet rs;
        try{
           Statement stmt = con.createStatement();
           String sql="SELECT COUNT(*) FROM ";
           String[] str=new String[]{"DRIVER","PASSENGER","VEHICLE","TRIP","REQUEST","TAXI_STOP"};
           for(int i=0;i<6;i++){
               rs=stmt.executeQuery(sql+str[i]);
               rs.next();
               System.out.println(str[i]+" : "+rs.getInt("COUNT(*)"));
           }
       }catch(SQLException e){
           System.out.println(e);
       }
    }
}
