/*
* Copyright (c) 2020. Seamless Distribution Systems AB - eServGlobal SAS - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited. It is proprietary and confidential.
* Author : G.Courouble gerard.courouble@seamless.se
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
