package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class FightCommand extends Command{
    @Override
    public String execute() {
        return "fight";
    }

    public FightCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);

    }
}
