package DB;

import java.sql.*;
import java.util.Scanner;

public class Friendship {
    User user1;
    User user2;

    Friendship(){

    }

    void setUsers(){
        System.out.println("Enter details for first user");
        user1.setUserId();
        System.out.println("Enter details fro second user ");
        user2.setUserId();
    }

    void addFriends(Connection con) throws  Exception {
        String query ="INSERT INTO friendship ( p1_id, p2_id) VALUES (?,?)";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
            int id1 = user1.id;
            int id2 = user2.id;
            st.setInt(1, id1);
            st.setInt(2, id2);
            st.executeUpdate();

    }

    void removeFriend(Connection con ) throws Exception{

    }

}
