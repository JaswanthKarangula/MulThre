package DB;

import java.sql.*;
import java.util.Scanner;

public class User {

    private int id;

    User(){
    }

    User(int id){
        this.id=id;

    }

     void insertQuery( Connection con)  {
        try {
            String query = "INSERT INTO users1 (first_name, last_name) VALUES (?,?) ";
            Scanner sc = new Scanner(System.in);
            PreparedStatement st = con.prepareStatement(query);
            System.out.println("enter first and last names  ");

                String fname = sc.next();
                String lname = sc.next();
                st.setString(1, fname);
                st.setString(2, lname);
                st.executeUpdate();

        }
        catch (Exception e){
            System.out.println("Exception  "+e);
        }

    }

     void readFromUser(Connection con) throws Exception{
        String query = "select * from users1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String name = rs.getString("first_name");
            int id = rs.getInt("id");


            System.out.println("first_name  " + name + "   id   --" + id);
        }
    }

     void updateUserName(Connection con) throws Exception{
        String query ="UPDATE users1  SET full_name = ? WHERE id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of user  and updated full  name ");
        int id1 = sc.nextInt();
        String pname = sc.next();
        st.setInt(2, id1);
        st.setString(1, pname);
        st.executeUpdate();
    }

     void deleteUsers(Connection con) throws Exception{
        String query ="DELETE FROM  users1  WHERE id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of user  to be deleted ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        st.executeUpdate();
     }

    void getAllFriendsOfUser(Connection con) throws  Exception {
        String query ="select p1_id from friendship where p2_id= ? union select p2_id from friendship where p1_id= ?;";
        PreparedStatement st = con.prepareStatement(query);


        st.setInt(1, id);
        st.setInt(2, id);
        ResultSet rs = st.executeQuery();
        System.out.println("The friends ids  are ");
        while(rs.next()){
            System.out.println( rs.getInt(1));
        }
    }

    public void  setUserId() {
        System.out.println("Enter User ID");
        Scanner sc = new Scanner(System.in);
        id=sc.nextInt();

    }

    public int  getUserId(){
        return id;
    }



}
