package hellandback.hellandback;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class PlayerHandler implements Listener {
    @EventHandler
    public void onPlayerDead(PlayerDeathEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("hellandback.antihell")==false) {
        player.spigot().respawn();
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "hell "+ player.getName());
    }}
}
