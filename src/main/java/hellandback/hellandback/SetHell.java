package hellandback.hellandback;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class SetHell implements CommandExecutor {


    private Plugin plugin;
    public SetHell(Plugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if ("world_nether".equals(player.getWorld().getName())) {
                int posx = player.getLocation().getBlockX();
                int posy = player.getLocation().getBlockY();
                int posz = player.getLocation().getBlockZ();
                plugin.getConfig().set("hellpos.x", posx);
                plugin.getConfig().set("hellpos.y", posy);
                plugin.getConfig().set("hellpos.z", posz);
                plugin.saveConfig();
                Component argis_str = Component.text((plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("success-set-hell")+" " + posx +" "+ posy+" " + posz)).color(TextColor.color(123456));
                player.sendMessage(argis_str);
            }
            else {
                Component argis_str = Component.text((plugin.getConfig().getString("prefix")+" "+plugin.getConfig().getString("error-set-hell"))).color(TextColor.color(123456));
                player.sendMessage(argis_str);
            }
        }

        return true;
    }

}
