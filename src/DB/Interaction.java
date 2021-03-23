package DB;


import java.sql.*;
import java.util.Scanner;

public class Interaction {

    private Posts post;
    private User user;
    private int post_id;
    private int user_id;
    private int interaction_id;

    Interaction(Posts post,User user){
        this.post=post;
        this.user=user;
        user_id=user.getUserId();
        post_id=post.getPost_id();
    }

    Interaction(int interaction_id){
        this.interaction_id=interaction_id;
    }

    Interaction(Posts post,User user,int interaction_id){

        this.post=post;
        this.user=user;
        this.interaction_id=interaction_id;
        user_id=user.getUserId();
        post_id=post.getPost_id();
    }

    public Interaction() {

    }

    void setPostForInteraction(){
        post=new Posts();
        post.setPostId();
    }

    void setInteractingUser(){
        user= new User();
        user.setUserId();
        user_id=user.getUserId();
    }
    int getInteractionId(){
        return interaction_id;
    }

    private String getComment(){
        System.out.println("Enter the comment");
        Scanner sc= new Scanner(System.in);
        return sc.next();
    }

    void addInteraction(Connection con) throws Exception {
        String query ="INSERT INTO interaction ( post_id, interaction_type,person_id) VALUES (?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        String query2 ="INSERT INTO comment (interaction_id,comment_data) VALUES (?,?)";
        PreparedStatement st2 = con.prepareStatement(query2);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of interaction  ");
        int type_int = sc.nextInt();
            st.setInt(1, post_id);
            st.setInt(2, type_int);

            st.setInt(3, user_id);
            st.executeUpdate();
            String query1 ="select * from interaction";
            PreparedStatement st1 = con.prepareStatement(query1);
            ResultSet rs = st1.executeQuery();
            rs.last();
            interaction_id= rs.getInt(5);
            if(type_int==2){
                st2.setInt(1, interaction_id);
                String str=getComment();
                st2.setString(2,str);
                st2.executeUpdate();
            }
            if(type_int==3){
                System.out.println("Enter the comment id which you are liking");
                int cmt_id=sc.nextInt();
                String query3="update interaction set comment_id="+ cmt_id + " where interaction_id="+ interaction_id+ " ; ";
                PreparedStatement ps= con.prepareStatement(query3);
                ps.executeUpdate();
            }
            if(type_int==4){
                System.out.println("Enter comment id on which you want to comment");
                int cmt_id=sc.nextInt();
                String query3="update interaction set comment_id="+ cmt_id + " where interaction_id="+ interaction_id+ " ; ";
                PreparedStatement ps= con.prepareStatement(query3);
                ps.executeUpdate();
                String cmt=getComment();
                st2.setInt(1,interaction_id);
                st2.setString(2,cmt);
                st2.executeUpdate();

            }


    }

    void deleteInteraction(Connection con) throws Exception{
        String query ="DELETE FROM  interaction  WHERE interaction_id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, interaction_id);
        st.executeUpdate();
    }

    void getAllInteractionsForPost(Connection con) throws Exception{
        String query ="select interaction_id,person_id,interaction_type from interaction as i where i.post_id=?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of post ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        ResultSet rs = st.executeQuery();
        System.out.println("The Interactions   area ");
        System.out.println("InteractionID             PersonId       InteractionType");
        while(rs.next()){
            System.out.print( rs.getInt(1)+"         ");
            System.out.print( rs.getInt(2)+"         ");
            System.out.println( rs.getInt(3)+"         ");
        }
    }

    void numberOfLikesForPost(Connection con) throws Exception{
        String query ="select count(*) from interaction where interaction_type=1 and post_id=?;";
        PreparedStatement st = con.prepareStatement(query);
        System.out.println("Enter id of post ");
        st.setInt(1, post_id);
        ResultSet rs = st.executeQuery();
        rs.next();
        System.out.println("number of likes is :  " + rs.getInt(1));
    }

}
