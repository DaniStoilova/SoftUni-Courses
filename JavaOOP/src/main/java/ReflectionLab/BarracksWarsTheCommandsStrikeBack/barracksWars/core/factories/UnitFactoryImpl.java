package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core.factories;

import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Unit;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.UnitFactory;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.Archer;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.Pikeman;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.models.units.Swordsman;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class unitClass = Class.forName("barracksWars.models.units." + unitType);
            Constructor<Unit> constructor = unitClass.getDeclaredConstructor();
            return constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                 InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());

        }
        return null;
    }
}

