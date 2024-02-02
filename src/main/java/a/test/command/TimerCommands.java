package a.test.command;

import a.test.Main;
import a.test.timer.Timer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TimerCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(args.length == 0) {
           sendUsage(commandSender);
        }
        switch (args[0].toLowerCase()) {
            case "resume": {
                Timer timer = Main.getInstance().getTimer();

                if (timer.isRunning()) {
                    commandSender.sendMessage(ChatColor.RED + " Der Timer Läuft bereits.");
                    break;
                }

                timer.setRunning(true);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }
            case "time": {
                Timer timer;
                if (!timer.isRunning()) {
                    commandSender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer time <Zeit>");
                    return  true;
                }

                timer.setRunning(false);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }


            if(args.length != 2) {
                sendUsage(commandSender);
            }

            case "time": {
                Timer timer = Main.getInstance().getTimer();

                timer.setTime(args[1]);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }
                break;
            case "reset":
                break;
            default:
                sendUsage(commandSender);
                break;


        }
        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage("§7Verwendung§8: §9/t resume, /timer pause, /timer time <Zeit>, /timer reset");
    }
 }
