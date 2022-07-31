package hellandback.hellandback;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;


public class HellReload implements CommandExecutor {
    private Plugin plugin;
    public  HellReload(Plugin plugin){
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            plugin.reloadConfig();
            player.sendMessage("reloaded");
            return true;
        }
        if (sender instanceof ConsoleCommandSender){
            ConsoleCommandSender con = (ConsoleCommandSender) sender;
            plugin.reloadConfig();
            con.sendMessage("reloaded");
            return true;
        }
        return false;
    }
}
