package com.github.haz8989.commands;

import com.github.haz8989.commandutils.Command;
import com.github.haz8989.commandutils.CommandContext;
import com.github.haz8989.commandutils.CommandManager;

public class ExampleCommand implements Command {

    // The identifier for the command is "example"
    @Override
    public String getName() {
        return "example";
    }

    @Override
    public String getDescription() {
        return "This is an example command";
    }

    // This command has no arguments.
    @Override
    public String getUsage() {
        return "example";
        // return "example <required arg> [optional arg]";
    }

    // This command has no aliases
    @Override
    public String[] getAliases() {
        return new String[0];
        // return new String[]{"alias1", "alias2"};
    }

    // For this command all we do is reply to tell the member that he ran the command.
    @Override
    public void onCommand(CommandContext context) {
        context.getChannel().sendMessage(context.getMember().getAsMention() + " You ran the command: " + context.getLabel()).queue();
    }

}
