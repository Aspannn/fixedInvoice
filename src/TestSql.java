import java.sql.*;

public class TestSql {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:sqlite:sqlLight\\prok1.sqlite";
        Connection connectTo = DriverManager.getConnection(url);

//        String select = "SELECT * FROM prok WHERE mat =?";

//        PreparedStatement statement = connectTo.prepareStatement(select);
        Statement statement = connectTo.createStatement();
//        statement.setString(1, "1002111");
//        ResultSet resultSet = statement.executeQuery();
//
//        while (resultSet.next()) {
//            System.out.println(resultSet.getString(1));
//        }
//
//
//        String delete = "DELETE FROM prok WHERE mat = ?";
//        PreparedStatement deleteStatement = connectTo.prepareStatement(delete);
//        deleteStatement.setString(1, "1002111");
//        int resultSet1 = deleteStatement.executeUpdate();

//        System.out.println(resultSet1);
        String update = "UPDATE prok SET quantity = quantity - " + 50 + " WHERE id = " + 516318 + " AND virtualId =  " + 335356;
        int i = statement.executeUpdate(update);

        connectTo.close();
        System.out.println(i);

    }
}
