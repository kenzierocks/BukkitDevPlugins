package kplugin.levelup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelUp extends JavaPlugin {
	public static String ver = "Unknown. Reason: Description Not Loaded";
	public List<String> memberlist = new ArrayList<String>();
	public OuputGrabberSender outputgrabber;
	public Player player;
	private List<String> lowerThanMember = Arrays
			.asList(new String[] { "beginner" });

	public void onEnable() {
		if (getDescription() != null) {
			ver = getDescription().getVersion();
		}
		getLogger().info("Running version " + ver + ".");
		outputgrabber = new OuputGrabberSender(this);
		Bukkit.getScheduler().runTaskTimer(this,
				new CheckMemberListsTask(this), 0, 10);
		getLogger().info("LevelUp! enabled.");
	}

	public void onDisable() {
		getLogger().info("LevelUp! disabled.");
	}

	public void onMessage(String message) {
		if (message.contains("Group: ")) {
			String group = message.replace("Group: ", "").toLowerCase();
			System.out.println("GROUP   " + group);
			if (lowerThanMember.contains(group)) {
				getServer().dispatchCommand(getServer().getConsoleSender(),
						"/manpromote");
			}
		}
	}
}
