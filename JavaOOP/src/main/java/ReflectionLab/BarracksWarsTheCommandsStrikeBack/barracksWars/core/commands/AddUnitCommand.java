package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;

public class AddUnitCommand extends Command{
    public AddUnitCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
      getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
