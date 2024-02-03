package a.test.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;
import java.net.http.WebSocket;

public class JoinListener implements Listener {

    @SuppressWarnings("deprecation")
    @EventHandler

    public void onJoin(PlayerJoinEvent event ){
            Player player = event.getPlayer();

            event.setJoinMessage(ChatColor.DARK_AQUA.toString() + ChatColor.UNDERLINE + player.getName() + " joined the server");


        player.sendMessage(ChatColor. GOLD + "Welcome to the Server!");
        player.sendMessage(ChatColor. GOLD + "Viel Spaß und vergnügen");
    }


}
