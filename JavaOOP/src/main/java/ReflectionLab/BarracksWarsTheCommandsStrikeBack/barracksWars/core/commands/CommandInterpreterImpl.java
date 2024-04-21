package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.commands;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.CommandInterpreter;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Executable;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;


public class CommandInterpreterImpl implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }
    @Override
    public Executable interpretCommand(String[] data, String commandName) {
       switch (commandName){
           case"add":
               return new  AddUnitCommand(data,repository,unitFactory);
           case"report":
               return new  Report(data,repository,unitFactory);
           case "fight":
               return new  FightCommand(data,repository,unitFactory);
           case "retire":
               return new RetireCommand(data,repository,unitFactory);
           default:
               throw new RuntimeException("Invalid input!");

       }
    }

}
