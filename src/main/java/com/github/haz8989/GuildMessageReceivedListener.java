package com.github.haz8989;

import com.github.haz8989.commandutils.CommandContext;
import com.github.haz8989.commandutils.CommandManager;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GuildMessageReceivedListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        String prefix = CommandManager.getPrefix();

        if (!e.getMessage().getContentRaw().startsWith(prefix)) {
            return;
        }

        String command = e.getMessage().getContentStripped().replace(prefix, "").split(" ")[0];
        String[] args = e.getMessage().getContentRaw().replace(prefix, "").replace(command, "").split(" ");
        CommandContext context = new CommandContext(e.getMember(), e.getChannel(), e.getMessage(), command, args);

        CommandManager.runCommand(context);

    }
}
