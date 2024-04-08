package IntroductionToDBApps;

import java.sql.*;
import java.util.Scanner;


public class IncreaseAgeStoredProcedure {

    private static final String CREATE_PROCEDURE =
            " CALL usp_get_older(?);";
    private static final String CALL_PROCEDURE =
            "SELECT `name`, `age`" +
                    " FROM `minions`" +
                    " WHERE `id` = ?;";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final int minionId = Integer.parseInt(scanner.nextLine());

        final Connection connection = Utils.getConnection();

        CallableStatement cs = connection.prepareCall(CREATE_PROCEDURE);

        cs.setInt(1, minionId);
        ResultSet rs = cs.executeQuery();


        final PreparedStatement statement = connection.prepareStatement(CALL_PROCEDURE);

        statement.setInt(1,minionId);
        final ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()){
            final String name = resultSet.getString("name");
            final int age = resultSet.getInt("age");

            System.out.printf("%s %d%n",name,age);
        }
        connection.close();

    }
}
