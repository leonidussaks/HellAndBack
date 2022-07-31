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

public class Hell implements CommandExecutor {
private Plugin plugin;
public  Hell(Plugin plugin){
    this.plugin = plugin;
}
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args[0] == null){
                Component mes = Component.text(plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("no-player")).color(TextColor.color(123456));
                player.sendMessage(mes);
                return false;
            }
            String pName = args[0];
            Player p = Bukkit.getPlayer(pName);
            World world = Bukkit.getServer().getWorld("world_nether");
            double posX = Double.parseDouble(plugin.getConfig().getString("hellpos.x"));
            double posY = Double.parseDouble(plugin.getConfig().getString("hellpos.y"));
            double posZ = Double.parseDouble(plugin.getConfig().getString("hellpos.z"));
            p.teleport(new Location(world, posX, posY, posZ));
            Component mes = Component.text((plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("success-hell")+" "+p.getName())).color(TextColor.color(123456));
            player.sendMessage(mes);
            return true;
        }
        if (sender instanceof ConsoleCommandSender){
            ConsoleCommandSender con = (ConsoleCommandSender) sender;
            if (args[0] == null){
                Component mes = Component.text(plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("no-player")).color(TextColor.color(123456));
                con.sendMessage(mes);
                return false;
            }
            String pName = args[0];
            Player p = Bukkit.getPlayer(pName);
            World world = Bukkit.getServer().getWorld("world_nether");
            double posX = Double.parseDouble(plugin.getConfig().getString("hellpos.x"));
            double posY = Double.parseDouble(plugin.getConfig().getString("hellpos.y"));
            double posZ = Double.parseDouble(plugin.getConfig().getString("hellpos.z"));
            p.teleport(new Location(world, posX, posY, posZ));
            Component mes = Component.text((plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("success-hell")+" "+p.getName())).color(TextColor.color(123456));
            con.sendMessage(mes);
            return true;
        }
        return false;
    }
}
