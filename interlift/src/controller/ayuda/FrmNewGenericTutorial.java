package controller.ayuda;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.database.SecurityGroup;
import model.database.SecurityUser;
import model.service.ServiceSecurityGroup;
import model.service.ServiceSecurityUser;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.image.Image;
import org.zkoss.io.Files;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

public class FrmNewGenericTutorial {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;
	@WireVariable
	private ServiceSecurityGroup serviceSecurityGroup;
	private List<File> listImages;
	private List<SecurityGroup> listGroups;
	private Set<SecurityGroup> selectedGroups;

	public List<SecurityGroup> getListGroups() {
		return listGroups;
	}

	public void setListGroups(List<SecurityGroup> listGroups) {
		this.listGroups = listGroups;
	}

	public Set<SecurityGroup> getSelectedGroups() {
		return selectedGroups;
	}

	public void setSelectedGroups(Set<SecurityGroup> selectedGroups) {
		this.selectedGroups = selectedGroups;
	}

	public List<File> getListImages() {
		return listImages;
	}

	public void setListImages(List<File> listImages) {
		this.listImages = listImages;
	}

	@Init
	public void init() {
		restartForm();
		listGroups = serviceSecurityGroup.listActive();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		selectedGroups = new HashSet<SecurityGroup>();
		listImages = new ArrayList<File>();
		refreshListImages();
	}

	public void refreshListImages() {
		listImages.clear();
		File file = new File(Sessions.getCurrent().getWebApp().getRealPath("/resource/images/system/help"));
		File[] listFiles = file.listFiles();
		if (listFiles != null) {
			for (File auxFile : listFiles) {
				listImages.add(auxFile);
			}
		}
	}

	@NotifyChange("listImages")
	@Command
	public void upload(BindContext context, @BindingParam("component") Component component) {
		UploadEvent event = (UploadEvent) context.getTriggerEvent();
		Media media = event.getMedia();
		if (media instanceof Image) {
			File file = new File(Sessions.getCurrent().getWebApp().getRealPath("/resource/images/system/help/" + media.getName()));
			try {
				Files.copy(file, media.getStreamData());
			} catch (IOException e) {
				e.printStackTrace();
			}
			refreshListImages();
		} else {
			Clients.showNotification("Cargar solo imagenes!", "warning", component, "end_center", 2000);
		}
	}

	@NotifyChange("listImages")
	@Command
	public void deleteImage(@BindingParam("image") File images) {
		listImages.remove(images);
		images.delete();
		refreshListImages();
	}

	@Command
	public void ok() {
		List<SecurityUser> listUsers = serviceSecurityUser.listAll();
		List<SecurityUser> listUsersFeature = new ArrayList<SecurityUser>();
		for (SecurityUser securityUser : listUsers) {
			Set<SecurityGroup> groups = securityUser.getSecurityGroups();
			group:
			for (SecurityGroup userGroup : groups) {
				for (SecurityGroup selectedGroup : selectedGroups) {
					if (userGroup.getIdSecurityGroup() == selectedGroup.getIdSecurityGroup())
						listUsersFeature.add(securityUser);
					break group;
				}
			}
		}
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}