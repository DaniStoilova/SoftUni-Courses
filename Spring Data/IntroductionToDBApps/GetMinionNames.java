package IntroductionToDBApps;

import java.sql.*;
import java.util.Scanner;

public class GetMinionNames {

    private static final String GET_MINIONS_NAMES =
            "SELECT `name`,`age`" +
            " FROM `minions`m" +
            " JOIN `minions_villains`mv ON mv.`minion_id`= m.`id`" +
            " WHERE `villain_id` = ?;";

    private static final String GET_VILLAINS_NAME =
            "SELECT `name`" +
            " FROM `villains`" +
            " WHERE `id` = ?;";



    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

       final Connection connection = Utils.getConnection();

       final int villainId = scanner.nextInt();

       final PreparedStatement statement = connection.prepareStatement(GET_MINIONS_NAMES);
       statement.setInt(1,villainId);

       final PreparedStatement statementVillainsName = connection.prepareStatement(GET_VILLAINS_NAME);
       statementVillainsName.setInt(1,villainId);

        final ResultSet resultSeT = statementVillainsName.executeQuery();

        if (!resultSeT.next()){
            System.out.printf("No villain with ID %d exists in the database.",villainId );
            connection.close();
            return;
        }

        printVillains(resultSeT);


        final ResultSet result = statement.executeQuery();

        int count = 1;
        while (result.next()){

            printMinionsName(result, count);
            count++;
        }
        connection.close();

    }

    private static void printMinionsName(ResultSet result, int count) throws SQLException {
        final String name = result.getString("name");
        final int age = result.getInt("age");

        System.out.printf("%d. %s %d%n", count,name,age);
    }

    private static void printVillains(ResultSet resultSeT) throws SQLException {
        final String villainName = resultSeT.getString("name");
        System.out.printf("Villain: %s%n",villainName);
    }
}
