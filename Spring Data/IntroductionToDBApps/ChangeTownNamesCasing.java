package IntroductionToDBApps;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.String.join;

public class ChangeTownNamesCasing {

    private static final  String TOWNS_UPPER_NAME = "SELECT UPPER(`name`)" +
            " FROM `towns`" +
            " WHERE `country`= ?;";
    private static final String NUMBER_OF_TOWNS = "SELECT COUNT(*) " +
            " FROM `towns`" +
            " WHERE `country`= ?" +
            " GROUP BY `country`= ?; ";


    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        final String country = scanner.nextLine();

        final Connection connection = Utils.getConnection();

        final PreparedStatement statementCountTowns = connection.prepareStatement(NUMBER_OF_TOWNS);
        statementCountTowns.setString(1,country);
        statementCountTowns.setString(2,country);

        final ResultSet result = statementCountTowns.executeQuery();

        if(!result.next()){
            System.out.println("No town names were affected.");
            connection.close();
            return;
        }

        System.out.printf("%d town names were affected.%n",result.getInt(1));


        final PreparedStatement statement = connection.prepareStatement(TOWNS_UPPER_NAME);
        statement.setString(1,country);

        final ResultSet resultSet = statement.executeQuery();

        List<String> towns = new ArrayList<>();
        while (resultSet.next()){
            towns.add(resultSet.getString(1));

        }
        System.out.print(towns);

        connection.close();

    }
}
