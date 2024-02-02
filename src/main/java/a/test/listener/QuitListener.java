package a.test.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.jetbrains.annotations.NotNull;

import java.net.http.WebSocket;

public class QuitListener implements WebSocket.Listener, @NotNull Listener {

    @EventHandler
    public  void  onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        event.setQuitMessage( ChatColor.DARK_RED.toString() + "Wir hoffen dich bald wieder zu sehen  " +  player.getName());



        player.sendMessage(ChatColor. DARK_RED + "Hat den server verlassen");
    }


}
