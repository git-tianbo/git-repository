package ptteng;

//导入sql包
import java.sql.*;

public class select {

    //声明  preparedstatement    和 resultset 对象
    private static PreparedStatement ps =null;
    private static   ResultSet rs = null;

    //入口
    public static void main(String[] args){

        /*获取与jdbcutil的连接
         *即执行JdbcUtil中的getconnection方法
         * 完成了
         * 1.加载驱动
         * 2.连接数据库
         */
        Connection connection =JdbcUtil.getConnection();


        try {
            String sql="select * from bj";

            //执行语句
            ps = connection.prepareStatement(sql);

            //存放结果集
            rs =ps.executeQuery(sql);

            //游标结果集不为空，则输出   且在while中循环
            while (rs.next()){

                //输出   int结果是           rs.getInt("名称")
                //       string结果为        rs.getString("名称")
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("name"));
            }

            System.out.println("查询成功！");

            //捕获数据库连接失败错误
        } catch (SQLException e) {
            e.printStackTrace();

            //最终   关闭结果集rs   sql语句执行类对象ps    关闭与jdbc的连接connection
        }finally {
           JdbcUtil.close(rs,ps,connection);
        }

    }

}

