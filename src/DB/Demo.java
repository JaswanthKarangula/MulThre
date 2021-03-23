package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/newdb?useSSL=false";
        String uname = "social";
        String pass = "jaswanth";

            Connection con = DriverManager.getConnection(url, uname, pass);


        String options="enter 0 to finish process \n"
                +"enter 1 to see users data \n"
                + "enter 2 to see posts data \n"
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
            User user=new User();
            Posts post = new Posts();
            Friendship friendship=new Friendship();
            Interaction interaction =new Interaction();
            switch(option) {
                case 0:
                    option = 0;
                    System.out.println("Bye  :");
                    break;
                case 1:
                    user.setUserId();
                    user.readFromUser(con);
                    break;
                case 2:
                    post.setPostId();
                    post.getPostData(con);
                case 3:
                     user.setUserId();
                     user.insertQuery(con);
                    break;
                case 4:
                    user.setUserId();
                    user.deleteUsers(con);
                    break;
                case 5:
                    user.setUserId();
                    user.updateUserName(con);
                    break;
                case 6:
                    user.setUserId();
                    user.getAllFriendsOfUser(con);
                    break;
                case 7:
                    // getALLCommentsForPost(con);
                    break;
                case 8:
                    post.setPostId();
                    post.addPosts(con);
                    break;
                case 9:
                    friendship.setUsers();
                    friendship.addFriends(con);
                    break;
                case 10:
                    interaction.setInteractingUser();
                    interaction.setPostForInteraction();
                    interaction.addInteraction(con);
                    break;
                case 11:
                    interaction.setInteractingUser();
                    interaction.setPostForInteraction();
                    interaction.numberOfLikesForPost(con);
                    break;
                case 12:
                    //getAllPostsOfFriends(con);
                    break;
            }
            System.out.println("\n******************** \n");
        }
    }
}
