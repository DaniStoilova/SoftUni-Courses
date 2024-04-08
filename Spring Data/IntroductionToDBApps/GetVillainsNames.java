package IntroductionToDBApps;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class GetVillainsNames {

   private static final String GET_VILLAINS_NAME =
            "SELECT  v.`name`, COUNT(DISTINCT m.`minion_id`) AS 'output'"+
            " FROM `villains` v" +
            " JOIN `minions_villains` m ON m.`villain_id`= v.`id`" +
            " GROUP BY v.`id`" +
            " HAVING `output` > ?" +
            " ORDER BY `output` DESC;";


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Properties props = new Properties();
        props.setProperty(Constants.USER_KEY,Constants.USER_VALUE);
        props.setProperty(Constants.PASSWORD_KEY,Constants.PASSWORD_VALUE);

        Connection connection = DriverManager
                .getConnection(Constants.JDBC_SQL_URL, props);


        final PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAME);
        statement.setInt(1,15);


        final ResultSet result = statement.executeQuery();

        while(result.next()){
            final String name = result.getString("name");
            final int count_of_minions = result.getInt("output");

            System.out.printf("%s %d",name,count_of_minions);
        }


        connection.close();


    }
}
