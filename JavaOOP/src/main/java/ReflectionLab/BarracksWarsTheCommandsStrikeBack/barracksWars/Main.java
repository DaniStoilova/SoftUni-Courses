package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars;

import barracksWars.core.commands.CommandInterpreterImpl;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.CommandInterpreter;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Repository;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import barracksWars.core.Engine;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        CommandInterpreter commandInterpreter = new CommandInterpreterImpl(repository,unitFactory);

        Runnable engine = new Engine(commandInterpreter);
        engine.run();

    }
}

