package fr.geairare;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "In the service method" );
        super.service(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println( "In the doGet" );
         
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
        if ( login == null ) login = "";
        if ( password == null ) password = "";

        response.setContentType( "text/html" );
        try ( PrintWriter out = response.getWriter() ) {
            out.println( "<!DOCTYPE html>" );
            out.println( "<html>" );
            out.println( "    <head>" );
            out.println( "        <title>Identification</title>" );
            out.println( "        <link rel='stylesheet' type='text/css' href='styles.css' />" );
            out.println( "    </head>" );
            out.println( "    <body>" );
            out.println( "        <h1>Identification</h1>" );
            out.println( "        <h2>" + new Date() + "</h2>" );
            
            out.println( "        <form method='POST' action='login'>" );
            out.println( "            <label for='txtLogin'>Qui t'es toi ? </label>" ); 
            out.println( "            <input id='txtLogin' name='txtLogin' type='text' value='" + login + "' autofocus /><br/>" );
            out.println( "            <label for='txtPassword'>Prouves-le :</label>" ); 
            out.println( "            <input name='txtPassword' type='password' value='" + password + "' /><br/>" );
            out.println( "            <br/>" );
            out.println( "            <input name='btnConnect' type='submit' value='Se connecter' /><br/>" );
            out.println( "        </form>" );
            
            out.println( "    </body>" );
            out.println( "</html>" );

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
         
        System.out.println( "in the doPost" );

        if ( login.equals( "Bond" ) && password.equals( "007" ) ) {
            response.setContentType( "text/html" );
            try ( PrintWriter out = response.getWriter() ) {
                out.println( "OK" );
            }
        } else {
            doGet( request, response );
        }
    }

}