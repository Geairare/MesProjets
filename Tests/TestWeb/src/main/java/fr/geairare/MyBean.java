/*
* Geairare 2021
* Author : Geairare gco.alias@laposte.net on 13 janv. 2021
*/
package fr.geairare;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "mybean")
@SessionScoped
public class MyBean implements Serializable {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

}
