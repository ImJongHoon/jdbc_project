import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void main(String[] args){

        String url = "jdbc:mysql://192.168.56.101:4567/madang";
        String userName = "ijh0614";
        String password = "1234";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, userName,password);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+ " "+rs.getString(3));
            }

            stmt.executeUpdate("DELETE From Book Where bookid = '23'");

            //stmt.executeUpdate("Insert Into Book(bookid, bookname, publisher, price) Values (23, '눈물을 마시는 새', '황금가지', 13000)");

            rs = stmt.executeQuery("SELECT * FROM Book");

            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+ " "+rs.getString(3));
            }

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}