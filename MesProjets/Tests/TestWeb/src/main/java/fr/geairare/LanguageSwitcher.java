/*
* Geairare 2021
* Author : Geairare gco.alias@laposte.net on 13 janv. 2021
*/
package fr.geairare;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LanguageSwitcher {
	private String language = "fr";

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
