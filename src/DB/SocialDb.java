package DB;
import java.sql.*;
import java.util.Scanner;
public class SocialDb {

    static void insertQuery( Connection con)  {
        try {
            String query = "INSERT INTO users1 (first_name, last_name) VALUES (?,?) ";
            int num;
            System.out.println("enter number of rows to insert");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
            PreparedStatement st = con.prepareStatement(query);
            System.out.println("enter first and last names  ");
            for (int i = 0; i < num; ++i) {
                String fname = sc.next();
                String lname = sc.next();
                st.setString(1, fname);
                st.setString(2, lname);
                st.executeUpdate();
            }
        }
        catch (Exception e){
            System.out.println("Exception  "+e);
        }

    }

    static void readFromUser(Connection con) throws Exception{
        String query = "select * from users1";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String name = rs.getString("first_name");
            int id = rs.getInt("id");


            System.out.println("first_name  " + name + "   id   --" + id);
        }
    }

    static void addFriends(Connection con) throws  Exception {
        String query ="INSERT INTO friendship ( p1_id, p2_id) VALUES (?,?)";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of  friendships   ");
        int num=sc.nextInt();
        for(int i=0;i<num;++i) {
            System.out.println("Enter  id s  of users ");
            int id1 = sc.nextInt();
            int id2 = sc.nextInt();
            st.setInt(1, id1);
            st.setInt(2, id2);
            st.executeUpdate();
        }
    }

    static void addPosts(Connection con) throws Exception {
        String query ="INSERT INTO Post ( person_id, post_name) VALUES (?,?)";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of  posts to insert   ");
        int num=sc.nextInt();
        for(int i=0;i<num;++i) {
            System.out.println("Enter  id of users  and post name ");
            int id1 = sc.nextInt();
            String pname = sc.next();
            st.setInt(1, id1);
            st.setString(2, pname);
            st.executeUpdate();
        }
    }

    static void updateUserName(Connection con) throws Exception{
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

    static void deleteUsers(Connection con) throws Exception{
        String query ="DELETE FROM  users1  WHERE id = ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of user  to be deleted ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        st.executeUpdate();
    }


    static void addInteraction(Connection con) throws Exception {
        String query ="INSERT INTO interaction ( post_id, interaction_type,person_id) VALUES (?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        String query2 ="INSERT INTO comment (interaction_id,comment_data) VALUES (?,?)";
        PreparedStatement st2 = con.prepareStatement(query2);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of  interaction ");
        int num=sc.nextInt();
        for(int i=0;i<num;++i) {

            System.out.println("Enter   post_id   and  type of interaction and user interacted ");

            int post_id = sc.nextInt();
            int type_int = sc.nextInt();
            st.setInt(1, post_id);
            st.setInt(2, type_int);
            int user_id=sc.nextInt();
            st.setInt(3, user_id);
            st.executeUpdate();
            String query1 ="select * from interaction";
            PreparedStatement st1 = con.prepareStatement(query1);
            ResultSet rs = st1.executeQuery();
            rs.last();
            int int_id= rs.getInt(5);
            if(type_int==2){
                System.out.println("Enter   users comment  ");

                st2.setInt(1, int_id);

                String str=sc.next();
                st2.setString(2,str);
                st2.executeUpdate();
            }
            if(type_int==3){
                System.out.println("Enter the comment id which you are liking");
                int cmt_id=sc.nextInt();
                String query3="update interaction set comment_id="+ cmt_id + " where interaction_id="+ int_id+ " ; ";
                PreparedStatement ps= con.prepareStatement(query3);
                ps.executeUpdate();
            }
            if(type_int==4){
                System.out.println("Enter comment id on which you want to comment");
                int cmt_id=sc.nextInt();
                String query3="update interaction set comment_id="+ cmt_id + " where interaction_id="+ int_id+ " ; ";
                PreparedStatement ps= con.prepareStatement(query3);
                ps.executeUpdate();


                System.out.println("Enter the comment");
                String cmt=sc.next();
                st2.setInt(1,int_id);
                st2.setString(2,cmt);
                st2.executeUpdate();

            }

        }
    }

    static void numberOfLikesForPost(Connection con) throws Exception{
        String query ="select count(*) from interaction where interaction_type=1 and post_id=?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of post ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        ResultSet rs = st.executeQuery();
        rs.next();
        System.out.println("number of likes is :  " + rs.getInt(1));
    }

    static void getALLCommentsForPost(Connection con) throws Exception{
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

    static void getAllFriendsOfUser(Connection con) throws  Exception {
        String query ="select p1_id from friendship where p2_id= ? union select p2_id from friendship where p1_id= ?;";
        PreparedStatement st = con.prepareStatement(query);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id of person  ");
        int id1 = sc.nextInt();
        st.setInt(1, id1);
        st.setInt(2, id1);
        ResultSet rs = st.executeQuery();
        System.out.println("The friends ids  are ");
        while(rs.next()){
            System.out.println( rs.getInt(1));
        }
    }

    static  void getAllPostsOfFriends(Connection con ) throws  Exception {
        System.out.println("Enter the number of post to be displayed in each iteration   ");
        Scanner sc = new Scanner(System.in);
        int offset=0;
        int limit=sc.nextInt();
        String query ="select * from Post as p where p.person_id in (select p1_id from friendship where p2_id= ? union select p2_id from friendship where p1_id= ?)  order by post_timestaamp desc limit ?,? ;";
        PreparedStatement st = con.prepareStatement(query);
        System.out.println("Enter id of person  ");
        int id1 = sc.nextInt();
        ResultSet rs;

        Timestamp lastTime=new Timestamp(System.currentTimeMillis());

        while(true) {
            System.out.println("The posts ids     person id        postname    are ");
            st.setInt(1, id1);
            st.setInt(2, id1);
            st.setInt(3,offset);
            st.setInt(4,limit);

            int count=limit;
            rs= st.executeQuery();
            while(count!=0) {
                count=0;
                while (rs.next()) {
                    Timestamp curr = rs.getTimestamp(6);
                    if (curr.compareTo(lastTime) >=  0) {

                       // System.out.println("time stamp of current record " +curr);
                        count++;
                    }
//                    int post_id =rs.getInt(2);
//                    System.out.println("postid is itr   "+post_id);
                }
                // System.out.println("count  " +count);
                offset += (count);
                st.setInt(1, id1);
                st.setInt(2, id1);
                st.setInt(3,offset);
                st.setInt(4,limit);
                rs= st.executeQuery();
            }

            while(rs.next()){
                    int post_id =rs.getInt(2);
                    int person_id =rs.getInt(1);
                    String post_name=rs.getString(3);
                    System.out.println(post_id+"      "+person_id+"     "+post_name);
                lastTime = rs.getTimestamp(6);

            }

            System.out.println("Enter 1 to display next set 0 to exit ");
            int op=sc.nextInt();
            if(op==0  )  break;
            offset+=limit;


        }

    }

    public static void main (String[] args)  throws Exception {
        String url = "jdbc:mysql://localhost:3306/newdb?useSSL=false";
        String uname = "social";
        String pass = "jaswanth";
        try {
            Connection con = DriverManager.getConnection(url, uname, pass);
            String options="enter 0 to finish process \n"
                    +"enter 1 to see users table \n"
                    + "enter 2 to see posts table \n"
                    + "enter 3 to insert data in users table \n"
                    +"enter 4 to delete data from users table \n"
                    +"enter 5 to update users name \n"
                    +"enter 6 to show all users ids of friends\n"
                    +"enter 7 to show all comments on any post  \n"
                    +"enter 8 to add posts  \n"
                    +"enter 9 to add friends \n"
                    +"enter 10 to add interaction   \n"
                    +"enter 11 to get number of likes of a post   \n"
                    +"enter 12 to show all posts  of friends  \n";
            System.out.println();
            Scanner sc=new Scanner(System.in);
            int option=-1;
            while(option!=0){
                System.out.println(options);
                option=sc.nextInt();
                System.out.println("\n******************** \n");
                switch(option) {
                    case 0:
                        option = 0;
                        System.out.println("Bye  :");
                        break;
                    case 1:
                        readFromUser(con);
                        break;
                    case 2:
                        break;
                    case 3:
                        insertQuery(con);
                        break;
                    case 4:
                        deleteUsers(con);
                        break;
                    case 5:
                        updateUserName(con);
                        break;
                    case 6:
                        getAllFriendsOfUser(con);
                        break;
                    case 7:
                        getALLCommentsForPost(con);
                        break;
                    case 8:
                        addPosts(con);
                        break;
                    case 9:
                        addFriends(con);
                        break;
                    case 10:
                        addInteraction(con);
                        break;
                    case 11:
                        numberOfLikesForPost(con);
                        break;
                    case 12:
                            getAllPostsOfFriends(con);
                        break;
                }
                System.out.println("\n******************** \n");
            }
        }
        catch (Exception e){
            System.out.println("exeception  "+e);
        }
    }
}
// 10 1
// 3 2 8