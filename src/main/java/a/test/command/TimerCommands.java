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
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String label, @NotNull String[] args) 
    {

        if(args.length == 0) {
           sendUsage(commandSender);
        }

        Timer timer = Main.getInstance().getTimer();
        switch(args[0].toLowerCase()) 
        {
            case "resume": 
            {

                if (timer.isRunning()) 
                {
                    commandSender.sendMessage(ChatColor.RED + " Der Timer Läuft bereits.");
                    break;
                }

                timer.setRunning(true);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }

            case "time": 
            {
                if (!timer.isRunning()) 
                {
                    commandSender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.BLUE +
                            "/timer time <Zeit>");
                    return  true;
                }

                timer.setRunning(false);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }

            case "settime": 
            {
                int time = Integer.parseInt(args[1]);
                timer.setTime(time);
                commandSender.sendMessage(ChatColor.GRAY + " Der Timer wurde Gestartet.");
                break;
            }
            
            case "reset": 
            {
                timer.resetTime();
                break;
            }

            default:
                sendUsage(commandSender);
                break;

        }

        return false;
    }

    private void sendUsage(CommandSender sender) 
    {
        sender.sendMessage("§7Verwendung§8: §9/t resume, /timer pause, /timer settime <Zeit>, /timer reset");
    }
 }
