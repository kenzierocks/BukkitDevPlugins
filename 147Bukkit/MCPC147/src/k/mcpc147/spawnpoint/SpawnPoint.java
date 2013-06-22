package k.mcpc147.spawnpoint;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnPoint extends JavaPlugin {

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (label == "spawnpoint") {
			processCommand(sender, args);
		}
		return true;
	}

	public void processCommand(CommandSender sender, String[] par2ArrayOfStr) {
		Player entityplayermp = par2ArrayOfStr.length == 0 ? (Player) sender
				: getServer().getPlayerExact(par2ArrayOfStr[0]);

		if (par2ArrayOfStr.length == 4) {
			if (entityplayermp.getWorld() != null) {
				byte b0 = 1;
				int i = 30000000;
				int j = b0 + 1;
				int k = parseIntBounded(sender, par2ArrayOfStr[b0], -i, i);
				int l = parseIntBounded(sender, par2ArrayOfStr[j++], 0, 256);
				int i1 = parseIntBounded(sender, par2ArrayOfStr[j++], -i, i);
				entityplayermp
						.setBedSpawnLocation(
								new Location(entityplayermp.getWorld(), k, l,
										i1), true);
			}
		} else {
			if (par2ArrayOfStr.length > 1) {
				sender.sendMessage("Error: Incorrect argument count!");
			}
			if (sender instanceof Player) {
				Location location = ((Player) sender).getLocation();
				entityplayermp.setBedSpawnLocation(location, true);
			}
			sender.sendMessage("Incorrect usage..check again!");
		}
	}

	private int parseIntBounded(CommandSender sender, String string, int i,
			int i2) {
		int res = Integer.parseInt(string);
		if (res < i) {
			throw new NumberFormatException(string + " is too small!");
		} else if (res > i2) {
			throw new NumberFormatException(string + " is too large!");
		}
		return res;
	}

}
