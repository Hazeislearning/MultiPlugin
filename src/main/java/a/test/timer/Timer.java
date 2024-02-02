package a.test.timer;

import a.test.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private  boolean running; // true or false
    private  int time;

    public Timer(boolean running, int time) {
        this.running = running;
        this.time = time;

        run();

        Timer timer = new Timer(false, 0);

    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void resetTimer() {
        setTime(0);
    }

    public void sendActionBar() {

        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {

                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY.toString() +
                        "Timer ist Pausiert"));

                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.AQUA.toString()+
                    ChatColor.BOLD + getTime()));
        }
    }

    private void  run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!isRunning())
                    return;


                setTime(getTime() + 1);

            }

        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}


