package IntroductionToDBApps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintAllMinionNames {

    private static final  String MINION_NAMES = "SELECT `name`" +
            " FROM `minions`;";

    public static void main(String[] args) throws SQLException {

        Connection connection = Utils.getConnection();

        PreparedStatement statement = connection.prepareStatement(MINION_NAMES);

        ResultSet resultSet = statement.executeQuery();

        List<String> names = new ArrayList<>();
        while (resultSet.next()){

            names.add(resultSet.getString("name"));
        }

        for (int i = 0; i < names.size() ; i++) {
            System.out.println(names.get(i));
            names.remove(i);
            System.out.println(names.get(names.size() - 1));
            names.remove(names.size() - 1);
            if (names.isEmpty()){
                break;
            }
            i--;

        }

        connection.close();
    }

}
