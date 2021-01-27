package fr.geairare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SelectOneMenuView {

	private Theme theme;
	private List<Theme> themes;

	@PostConstruct
	public void init() {
		themes = new ArrayList<Theme>();
		themes.add(new Theme(0, "fr", "fr"));
		themes.add(new Theme(1, "uk", "uk"));
		themes.add(new Theme(2, "lb", "lb"));
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public int themesSize() {
		return themes.size();
	}
}