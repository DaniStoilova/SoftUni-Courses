package IntroductionToDBApps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class RemoveVillain {

    private static final  String GET_VILLAINS_NAME = "SELECT `name`FROM `villains`WHERE `id` = ?;";
    private static final  String NUMBER_OF_MINIONS = "SELECT COUNT(*) FROM `minions_villains` WHERE `villain_id` = ?;";
    private static final  String DELETE_MINIONS_VILLAINS = "DELETE FROM `minions_villains` WHERE `villain_id` = ?;";
    private static final  String DELETE_VILLAINS = "DELETE FROM `villains` WHERE `id` = ?;";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Utils.getConnection();

        final int villainId = Integer.parseInt(scanner.nextLine());

        PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAME);
        statement.setInt(1,villainId);

        ResultSet resultSet = statement.executeQuery();

        if(!resultSet.next()){
            System.out.println("No such villain was found");
            connection.close();
            return;
        }

        final String name = resultSet.getString(1);

        connection.setAutoCommit(false);

        PreparedStatement countReleased = connection.prepareStatement(NUMBER_OF_MINIONS);
        countReleased.setInt(1,villainId);

        ResultSet result = countReleased.executeQuery();
        result.next();

        final int count = result.getInt(1);


        try {
            PreparedStatement deleteMinionsVillains = connection.prepareStatement(DELETE_MINIONS_VILLAINS);
            deleteMinionsVillains.setInt(1,villainId);
            deleteMinionsVillains.executeUpdate();

            PreparedStatement deleteVillains = connection.prepareStatement(DELETE_VILLAINS);
            deleteVillains.setInt(1,villainId);
            deleteVillains.executeUpdate();

            connection.commit();

            System.out.printf("%s was deleted%n",name);
            System.out.printf("%d minions released%n",count);
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
        }

    }
}
