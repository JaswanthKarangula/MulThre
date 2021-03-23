package DB;
import java.sql.*;
import java.sql.Connection;


public class JDBC1 {

    //1      loading drivers
    public static void main(String[] args) throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/temp?useSSL=false";
        String uname = "jaswanthdb";
        String pass="jaswanth";
        String query="select empname from emp where empid=1";
       // Any JDBC 4.0 drivers that are found in your class path are automatically loaded.
        // (However, you must manually load any drivers prior to JDBC 4.0 with the method Class.forName.)
      //    Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(url,uname,pass);
        //
       // Statement: Used to implement simple SQL statements with no parameters.
       // PreparedStatement: (Extends Statement.) Used for precompiling SQL statements that might contain input parameters.

        //CallableStatement: (Extends PreparedStatement.) Used to execute stored procedures that may contain both input and output parameters.

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        rs.next();
        String name = rs.getString("empname");
        System.out.println(name);

        st.close();
        con.close();
    }

}

