package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType)  {
		try {
			Class clazz = Class.forName("barracksWars.models.units." + unitType);
			Constructor<Unit> constructor = clazz.getDeclaredConstructor();
			return constructor.newInstance();
		} catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
