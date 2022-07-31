package hellandback.hellandback;

import org.bukkit.plugin.java.JavaPlugin;

public final class HellAndBack extends JavaPlugin {


    @Override
        public void onEnable() {
            getConfig().addDefault("prefix", "[HellAndBack]");
            getConfig().addDefault("no-player", "You didn't enter a player's nickname...");
            getConfig().addDefault("success-hell", "Player successfully sent to hell!");
            getConfig().addDefault("error-set-hell", "You are not in hell!");
            getConfig().addDefault("success-set-hell", "You have successfully saved the hellpoint to:");
            getConfig().options().copyDefaults(true);
            saveConfig();
            getLogger().info("Turn on!");
            getServer().getPluginManager().registerEvents(new PlayerHandler(), this);
            this.getCommand("sethell").setExecutor(new SetHell(this));
            this.getCommand("hell").setExecutor(new Hell(this));
            this.getCommand("hellreload").setExecutor(new HellReload(this));
    }

        @Override
        public void onDisable() {

        }

    }
