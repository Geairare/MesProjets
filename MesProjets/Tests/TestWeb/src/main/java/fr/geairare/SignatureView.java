/*
* Geairare 2021
* Author : Geairare gco.alias@laposte.net on 13 janv. 2021
*/
package fr.geairare;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SignatureView {

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}