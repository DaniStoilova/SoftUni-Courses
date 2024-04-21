package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class Report extends Command{
    public Report(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }
    @Override
    public String execute() {
        return getRepository().getStatistics();
    }


}
