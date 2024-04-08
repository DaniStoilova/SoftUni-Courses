package softuni.exam.service;

import java.io.IOException;
import java.io.Serializable;

public interface PlayerService{
    String importPlayers() throws IOException;

    boolean areImported();

    String readPlayersJsonFile() throws IOException;

    String exportPlayersWhereSalaryBiggerThan();

    String exportPlayersInATeam();
}
