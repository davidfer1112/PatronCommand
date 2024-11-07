package cliente;

import comandos.Command;
import comandos.LightOnCommand;
import comandos.LightOffCommand;
import invocadores.RemoteControl;
import receptores.Light;

/**
 * Main class to execute the Command pattern with undo functionality.
 */
public class Cliente {
    public static void main(String[] args) {
        // Receiver
        Light light = new Light();

        // Commands
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // Turn on the light
        remote.setCommand(lightOn);
        remote.pressButton(); // Output: Light is on

        // Turn off the light
        remote.setCommand(lightOff);
        remote.pressButton(); // Output: Light is off

        // Undo last command (should turn the light on)
        remote.pressUndo(); // Output: Light is on
    }
}
