/*
* Copyright (c) 2020. Seamless Distribution Systems AB - eServGlobal SAS - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited. It is proprietary and confidential.
* Author : G.Courouble gerard.courouble@seamless.se
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