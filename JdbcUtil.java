package ptteng;

//导入包
import java.sql.*;

public class JdbcUtil {

    //声明connection对象
    private static Connection Connection;

    //声明preparedstatement对象
    private static PreparedStatement ps;

    //创建私有 受保护的3个成员变量   且赋值
    private static String url = "jdbc:mysql://localhost:3306/student?characterEncoding=UTF-8";
    private  static String user = "root";
    private  static String pass = "451976";

        //必须返回connection的方法
        public static Connection getConnection(){

            try {
            //1加载驱动
            Class.forName("com.mysql.jdbc.Driver");

             //2返回 connection     connection 为连接数据库的结果
            return Connection = DriverManager.getConnection(url, user, pass);

                //捕捉所有的异常
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(ResultSet rs, Statement stmt,Connection connection){//栈式关闭（最先连接，最后关闭连接）
        try{
            //关闭结果集   如果结果集不是空的，则关闭
            if(rs!=null) rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            //关闭sql语句   如果preparedStatement 不是空的  则 关闭
            if(ps!=null) ps.close();
            if(stmt!=null) stmt.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            //关闭连接   如果connection不是空的  则关闭
            if(connection!=null) connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
