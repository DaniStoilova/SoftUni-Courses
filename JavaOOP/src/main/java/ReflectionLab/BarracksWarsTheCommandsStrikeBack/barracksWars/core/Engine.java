package ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.core;

import barracksWars.core.commands.AddUnitCommand;
import barracksWars.core.commands.FightCommand;
import barracksWars.core.commands.Report;
import barracksWars.interfaces.*;
import ReflectionLab.BarracksWarsTheCommandsStrikeBack.barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

	private CommandInterpreter commandInterpreter;

	public Engine(CommandInterpreter commandInterpreter) {
		this.commandInterpreter = commandInterpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				Executable executable = commandInterpreter.interpretCommand(data,commandName);
				String result = executable.execute();
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}





}
