package invocadores;

import comandos.Command;

/**
 * The invoker maintains a command and can execute or undo the last command.
 */
public class RemoteControl {
    private Command command;
    private Command lastCommand; // Store the last executed command

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        lastCommand = command; // Remember the last command
    }

    // New method to undo the last command
    public void pressUndo() {
        if (lastCommand != null) {
            lastCommand.execute(); // Execute the last command to reverse the action
            lastCommand = null; // Clear the last command after undoing
        } else {
            System.out.println("No action to undo.");
        }
    }
}
