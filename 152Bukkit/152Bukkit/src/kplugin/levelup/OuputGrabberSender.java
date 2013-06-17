package kplugin.levelup;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

public class OuputGrabberSender implements CommandSender {

	private LevelUp ref;

	public OuputGrabberSender(LevelUp levelUp) {
		ref = levelUp;
	}

	@Override
	public boolean isPermissionSet(String name) {
		return true;
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		return true;
	}

	@Override
	public boolean hasPermission(String name) {
		return true;
	}

	@Override
	public boolean hasPermission(Permission perm) {
		return true;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value) {
		return new PermissionAttachment(plugin, this);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {
		return new PermissionAttachment(plugin, this);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value, int ticks) {
		return new PermissionAttachment(plugin, this);
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
		return new PermissionAttachment(plugin, this);
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {
	}

	@Override
	public void recalculatePermissions() {
	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {
		return new HashSet<PermissionAttachmentInfo>();
	}

	@Override
	public boolean isOp() {
		return true;
	}

	@Override
	public void setOp(boolean value) {
	}

	@Override
	public void sendMessage(String message) {
		ref.onMessage(ChatColor.stripColor(message));
	}

	@Override
	public void sendMessage(String[] messages) {
		for (String msg : messages) {
			sendMessage(msg);
		}
	}

	@Override
	public Server getServer() {
		return ref.getServer();
	}

	@Override
	public String getName() {
		return "OutputGrabberSender";
	}

}
