package DB;

import java.sql.*;
import java.util.Scanner;

public class Comments {
    Interaction interaction;

    void getALLCommentsForPost(Connection con) throws Exception{
        String query ="select c.comment_data from comment as c where c.interaction_id in (select interaction_id from interaction as i where i.post_id=?);";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of post ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        ResultSet rs = st.executeQuery();
        System.out.println("The comments area ");
        while(rs.next()){
            System.out.println( rs.getString(1));
        }
    }





}
