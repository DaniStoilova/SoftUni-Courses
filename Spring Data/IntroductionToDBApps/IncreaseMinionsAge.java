package IntroductionToDBApps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IncreaseMinionsAge {

   private static final  String UPDATE_AGE = "UPDATE `minions`" +
            " SET `name` = LOWER(`name`)," +
            " `age` = `age` + 1 " +
            " WHERE `id`IN(?,?,?)";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String[] info = scanner.nextLine().split(" ");

        final int id1 = Integer.parseInt(info[0]);
        final int id2 = Integer.parseInt(info[1]);
        final int id3 = Integer.parseInt(info[2]);

        final Connection connection = Utils.getConnection();

        final PreparedStatement statement = connection.prepareStatement(UPDATE_AGE);
        statement.setInt(1,id1);
        statement.setInt(2,id2);
        statement.setInt(3,id3);

        statement.executeUpdate();

        final PreparedStatement statement1 = connection.prepareStatement("SELECT `name`, `age`" +
                "FROM `minions`;");


       final ResultSet resultSet = statement1.executeQuery();

        while (resultSet.next()){
            final String name = resultSet.getString("name");
            final int age = resultSet.getInt("age");

            System.out.printf("%s %d%n",name,age);
        }
        connection.close();

    }
}
