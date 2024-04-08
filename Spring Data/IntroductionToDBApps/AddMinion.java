package IntroductionToDBApps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {

    private static final String GET_TOWN_BY_NAME = "SELECT `id`" +
            " FROM `towns`" +
            " WHERE `name` = ?;";
    private static final String INSERT_TOWN = "INSERT INTO `towns`(`name`) values(?);";

    private static final String GET_VILLAIN_BY_NAME = "SELECT `id`" +
            " FROM `villains`" +
            " WHERE `name` = ?;";
    private static final String INSERT_VILLAIN = "INSERT INTO `villains`(`name`,`evilness_factor`) values(?,?);";
    private static final String EVIL_FACTOR = "evil";

    private static final String GET_MINION_BY_NAME = "INSERT INTO `minions_villains` values(?,?)";
    private static final String GET_LAST_MINION = "SELECT `id` FROM `minions` ORDER BY `id` DESC LIMIT 1";

    private static final String INSERT_MINION = "INSERT INTO `minions`(`name`,`age`,`town_id`) values(?,?,?);";


    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final String[] minionInfo = scanner.nextLine().split(" ");
        final String[] villainInfo = scanner.nextLine().split(" ");

        final String minionName = minionInfo[1];
        final int age = Integer.parseInt(minionInfo[2]);
        final String townName = minionInfo[3];
        final String villainName = villainInfo[1];



        final Connection connection = Utils.getConnection();


        int townId = addTown(townName, connection);

        int villainId = addVillain(villainName, connection);


        final PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, age);
        insertMinion.setInt(3, townId);
        insertMinion.executeUpdate();

        final PreparedStatement getLast = connection.prepareStatement(GET_LAST_MINION);

        final ResultSet resultLastMinions = getLast.executeQuery();
        resultLastMinions.next();
        int lastId = resultLastMinions.getInt("id");


        final PreparedStatement statementByMinionName = connection.prepareStatement(GET_MINION_BY_NAME);
        statementByMinionName.setInt(1,lastId);
        statementByMinionName.setInt(2,villainId);
        statementByMinionName.executeUpdate();


        System.out.printf("Successfully added %s to be minion of %s.",minionName, villainName);


    }

    private static int addVillain(String villainName, Connection connection) throws SQLException {

        PreparedStatement statementByVillainsName = connection.prepareStatement(GET_VILLAIN_BY_NAME);
        statementByVillainsName.setString(1, villainName);

        ResultSet villainSet = statementByVillainsName.executeQuery();

        int villainId = 0;
        if (!villainSet.next()){
            PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN);
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, EVIL_FACTOR);

            insertVillain.executeUpdate();

            ResultSet updateResult = statementByVillainsName.executeQuery();
            updateResult.next();

            villainId = updateResult.getInt("id");
            System.out.printf("Villain %s was added to the database.%n", villainName);

        }else{
            villainId = villainSet.getInt("id");
        }
        return villainId;
    }

    private static int addTown(String townName, Connection connection) throws SQLException {
        PreparedStatement statementByTownName = connection.prepareStatement(GET_TOWN_BY_NAME);
        statementByTownName.setString(1, townName);

        ResultSet resultSet = statementByTownName.executeQuery();

        int townId = 0;
        if (!resultSet.next()){
            PreparedStatement insertTowns = connection.prepareStatement(INSERT_TOWN);
            insertTowns.setString(1, townName);
            insertTowns.executeUpdate();

            ResultSet result = statementByTownName.executeQuery();
            result.next();
            townId = result.getInt("id");

            System.out.printf("Town %s was added to the database.%n", townName);
        }else{
            townId = resultSet.getInt("id");
        }
        return townId;
    }

}
