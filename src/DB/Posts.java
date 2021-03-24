package DB;

import java.sql.*;
import java.util.Scanner;

public class Posts {
     private int user_id;
     private int post_id;
     private User user;

    Posts(User user){
        this.user=user;
        this.user_id=user.getUserId();
    }

    Posts(User user,int post_id){
        this.user=user;
        this.post_id=post_id;
        this.user_id=user.getUserId();
    }

    Posts() {

    }

    void addPosts(Connection con) throws Exception {
        String query ="INSERT INTO Post ( person_id, post_name) VALUES (?,?)";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);


            System.out.println("Enter   post name ");

            String pname = sc.next();
            st.setInt(1, user_id);
            st.setString(2, pname);
            st.executeUpdate();
    }

    void updatePostName(Connection con) throws Exception{

        String query ="UPDATE Post  SET post_name = ? WHERE post_id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter updated post  name ");

        String pname = sc.next();
        st.setInt(2, post_id);
        st.setString(1, pname);
        st.executeUpdate();
    }

    void updatePostContent(Connection con) throws Exception{
        String query ="UPDATE Post  SET content = ? WHERE post_id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of user  and updated post  content ");

        String content = sc.next();
        st.setInt(2, post_id);
        st.setString(1, content);
        st.executeUpdate();
    }

    void deletePost(Connection con) throws Exception{
        String query ="DELETE FROM  Post  WHERE post_id = ?;";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, post_id);
        st.executeUpdate();
    }

    void getPostContent(Connection con) throws Exception{
        String query = "select content from Post where post_id =?;";
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setInt(1,post_id);
        ResultSet rs = stmt.executeQuery();
        rs.next();
            String name = rs.getString("content");
            System.out.println("content of post  :   " + name);

    }

    void getAllPostsOfFriends(Connection con ) throws  Exception {
        System.out.println("Enter the number of post to be displayed in each iteration   ");
        Scanner sc = new Scanner(System.in);
        int offset=0;
        int limit=sc.nextInt();
        String query ="select * from Post as p where p.person_id in (select p1_id from friendship where p2_id= ? union select p2_id from friendship where p1_id= ?)  order by post_timestaamp desc ;";
        PreparedStatement st = con.prepareStatement(query);

        int id1 ;
        st.setInt(1, user_id);
        st.setInt(2, user_id);
        ResultSet rs = st.executeQuery();
        rs.last();
        int num_rows = rs.getRow();
        rs.beforeFirst();
        while(true) {
            System.out.println("The posts ids  are ");
            for(int i=0;i<limit;++i){
                if(rs.next()){
                    int post_id =rs.getInt(2);
                    int person_id =rs.getInt(1);
                    String post_name=rs.getString(3);
                    System.out.println(post_id+"      "+person_id+"     "+post_name);
                }
            }
            System.out.println("Enter 1 to display next set 0 to exit ");
            int op=sc.nextInt();
            if(op==0  )  break;
            offset+=limit;
            if(offset>=num_rows){
                System.out.println("No more posts");
                break;

            }
        }
    }

    void getPostData(Connection con){


    }

    public void setPostId() {
        System.out.println("Enter POst id ");
        Scanner sc =new Scanner(System.in);
        post_id=sc.nextInt();
    }

    public void setUserForPost(){
        user=new User();
        user.setUserId();
        user_id=user.getUserId();
    }

    public int getPost_id() {
        return post_id;
    }

}


//MVC
