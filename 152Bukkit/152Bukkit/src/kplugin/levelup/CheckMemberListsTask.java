package kplugin.levelup;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class CheckMemberListsTask implements Runnable {
	LevelUp lvlup = null;

	public CheckMemberListsTask(LevelUp lu) {
		lvlup = lu;
	}

	@Override
	public void run() {
		try {
			URL geturl = new URL(
					"http://www.battlenations.com/LevelUp/getmemberlist.php");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					geturl.openStream()));
			List<String> members = lvlup.memberlist;
			for (String line = ""; (line = in.readLine()) != null;) {
				if (line.startsWith("member:")) {
					line = line.replace("member:", "");
					if (!members.contains(line)) {
						members.add(line);
						lvlup.player = lvlup.getServer().getPlayerExact(line);
						lvlup.getServer().dispatchCommand(lvlup.outputgrabber,
								"/manwhois " + line);
					}
				}
			}
			lvlup.memberlist = members;
		} catch (Exception e) {
			throw new RuntimeException("Error with Member list fetch", e);
		}
	}
}
