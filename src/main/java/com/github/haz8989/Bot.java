package com.github.haz8989;

import com.github.haz8989.commands.ExampleCommand;
import com.github.haz8989.commandutils.CommandManager;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * This class contains the JDA instance.
 */
public class Bot {

    // This is the JDA instance.
    private static JDA client;

    // This will initialize the JDA instance when the program is started.
    public static void main(String args[]) throws LoginException, InterruptedException {
        client = new JDABuilder(AccountType.BOT)
                .setToken("Token") // Insert your own Bot Token here.
                .buildBlocking();
        // Here we register the ExampleCommand.
        CommandManager.registerCommand(new ExampleCommand());
    }

    /**
     * Getter for the JDA instance.
     * @return the JDA instance for this session.
     */
    public static JDA getClient() {
        return client;
    }

}
