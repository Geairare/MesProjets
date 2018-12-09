package fr.geairare.donnees;

import org.apache.struts.action.*;
import javax.servlet.http.HttpServletRequest;

public class LoginForm extends ActionForm {
	private static final long serialVersionUID = 1L;

String nomUtilisateur;

  String mdpUtilisateur;

  public String getMdpUtilisateur() {
    return mdpUtilisateur;
  }

  public void setMdpUtilisateur(String mdpUtilisateur) {
    this.mdpUtilisateur = mdpUtilisateur;
  }

  public String getNomUtilisateur() {
    return nomUtilisateur;
  }

  public void setNomUtilisateur(String nomUtilisateur) {
    this.nomUtilisateur = nomUtilisateur;
  }

  public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
    ActionErrors errors = new ActionErrors();
    return errors;
  }

  public void reset(ActionMapping mapping, HttpServletRequest request) {
    this.mdpUtilisateur = null;
    this.nomUtilisateur = null;
  }

}