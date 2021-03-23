package DB;
import java.sql.*;
import java.util.*;

public class JDBC2 {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/temp?verifyServerCertificate=false&useSSL=true";
        //String url = "jdbc:mysql://localhost:3306/temp?useSSL=false";
        String uname = "jaswanthdb";
        String pass="jaswanth";
       // String query="select empname from emp where empid=1";
        // the DriverManager class will attempt to load the driver classes referenced in the "jdbc.drivers" system property.
        // This allows a user to customize the JDBC Drivers used by their applications.
        Connection con = DriverManager.getConnection(url,uname,pass);
        //creating table
        String createString =
                "create table Student " + "(id integer NOT NULL, " +
                        "name varchar(40) NOT NULL, " +  " state char(2) NOT NULL, " +
                        "pincode char(5), " + "PRIMARY KEY (id))";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createString);
        } catch (SQLException e) {
            //
        }
        Scanner sc=new Scanner(System.in);
        try (Statement stmt1 = con.createStatement()) {
            String name,state;
            int id,pincode;
            int num;

            num=sc.nextInt();
            for(int i=0;i<num;++i){
                id =sc.nextInt();
                name=sc.next();
                state=sc.next();
                pincode=sc.nextInt();
                String insertQuery =String.format("insert into Student values(%d,'%s','%s',%d )",id, name,state,pincode);
                System.out.println(stmt1.executeUpdate(insertQuery));
            }

        }
        catch (SQLException e) {
            System.out.println("Exception    ---        "+e);
        }

        String query = "select * from Student";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            System.out.println("number of rows present are   " +rs.getRow());
            rs.beforeFirst();
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");

                String state = rs.getString("state");
                int pincode = rs.getInt("pincode");
                System.out.println(name + ", " + id + ", " + state +
                        ", " + pincode );
            }
        } catch (SQLException e) {
            System.out.println("EXception" +e);
        }
        int id =sc.nextInt();
        String name =sc.next();

         query = "select count(*) from Student where  name = '"+name+"' and  id= "+ id+";";
         try(Statement stmt= con.createStatement()){
             ResultSet rs= stmt.executeQuery(query);
             int c=0;
             if(rs.next()){
                 c=rs.getInt(1);

             }
             if(c==0){
                 System.out.println(" not Present");
             }
             else{
                 System.out.println(" present");
             }
         }
         System.out.println("Prepared statment ");
        query = "select count(*) from Student where   id= ?;";
        try(PreparedStatement stmt= con.prepareStatement(query)){
            stmt.setInt(1,id);
            // stmt.setString(1,name);
            ResultSet rs= stmt.executeQuery();
            int c=0;
            if(rs.next()){
                c=rs.getInt(1);

            }
            if(c==0){
                System.out.println(" not Present");
            }
            else{
                System.out.println(" present");
            }
        }
    }
}
