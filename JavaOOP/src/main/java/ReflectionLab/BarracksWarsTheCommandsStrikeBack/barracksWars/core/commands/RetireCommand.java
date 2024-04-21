package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        try {
            String unitType = getData()[1];
            getRepository().removeUnit(unitType);
            return String.format("%s retired!",unitType);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }

    }
}