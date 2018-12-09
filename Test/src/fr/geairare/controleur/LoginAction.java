package fr.geairare.controleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import fr.geairare.donnees.LoginForm;

public final class LoginAction extends Action {

  public ActionForward execute(ActionMapping mapping, 
                               ActionForm form, 
                               HttpServletRequest req, 
                               HttpServletResponse res) throws Exception {
    String resultat = null;
    String nomUtilisateur = ((LoginForm) form).getNomUtilisateur();
    String mdpUtilisateur = ((LoginForm) form).getMdpUtilisateur();

    if (nomUtilisateur.equals("xyz") && mdpUtilisateur.equals("xyz")) {
      resultat = "succes";
    } else {
      resultat = "echec";
    }

    return mapping.findForward(resultat);
  }

}