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
public class Proj170 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String dbAddress="jdbc:mysql://projgw.cse.cuhk.edu.hk:2633/group83";
        String dbUsername="Group83";
        String dbPassword="3170group83";
        Connection con=null;
        Statement stmt=null;
        String sql;
        int rs=0;//result of execute query 0-success
        int command1=10;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(dbAddress,dbUsername,dbPassword);
        }catch(ClassNotFoundException e){
            System.out.println("error,java mysql db driver not found");
            System.exit(0);
        }catch(SQLException e){
            System.out.println(e);
        }
        //System.out.println(con);
        //System.out.println("Connected database successfully...");
        //Interface
        while(command1!=0){
        System.out.println("Welcome! Who are you?");
        System.out.println("1. An administrator");
        System.out.println("2. A passenager");
        System.out.println("3. A driver");
        System.out.println("4. A  manager");
        System.out.println("0. None of the above");
        System.out.println("Please enter [1-4]");
        Scanner input=new Scanner(System.in);
        command1=input.nextInt();
        int command12=0;
        if(command1==1){
            //admin interface
            while(command12!=5){
            System.out.println("Administrator, what would you like to do?");
            System.out.println("1. Create tables");
            System.out.println("2. Delete tables");
            System.out.println("3. Load data");
            System.out.println("4. Check data");
            System.out.println("5. Go back");
            System.out.println("Please enter [1-5]");
            command12=input.nextInt();
            if(command12==1){
                //create table function
                CreateTable C1=new CreateTable();
                C1.create(con);
            }
            else if(command12==2){
                //delete tables;
                try{
                    stmt=con.createStatement();
                    sql="DROP TABLE IF EXISTS DRIVER,VEHICLE,PASSENGER,REQUEST,TRIP,TAXI_STOP;";
                    rs=stmt.executeUpdate(sql);
                    System.out.println("drop all table: "+(0==rs));
                }catch(SQLException e){
                    System.out.println(e);
                }
            }
            else if(command12==3){
                //load data;
                Read insertdata=new Read();
                insertdata.insert(con);
            }
            else if(command12==4){
                //check data
                Count countnum=new Count();
                countnum.count(con);
            }
            }
            continue;
        }
        }//end of admin operation
    }
    
}
