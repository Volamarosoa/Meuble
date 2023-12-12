/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import connexionBase.ConnexionBase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Matiere;
import models.Style;

/**
 *
 * @author Rota
 */
@WebServlet(name = "StyleServlet", urlPatterns = {"/StyleServlet"})
public class StyleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//        1 - Maka ny parametre nalefa raha misy
        String erreur = request.getParameter("erreur");
        
//        2 - controlle de valeur na instanciation objet raha ilaina
           List<Matiere> liste = new Matiere().getListeMatiere();

//        3 - miset ny attribut ho an redirection raha misy
            if(erreur != null)
                request.setAttribute("erreur", erreur);
            request.setAttribute("liste", liste);
//        4 - Redirection
            RequestDispatcher dispatcher = request.getRequestDispatcher("ajout_style.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        //        1 - Maka ny parametre nalefa raha misy
            String nom = request.getParameter("style");
            String[] matiers = request.getParameterValues("idMatiere[]");
            System.out.print(matiers.length);
//        2 - controlle de valeur na instanciation objet raha ilaina
            Style style = new Style(nom);
            style.ajoutStyle(matiers);
            
//        3 - miset ny attribut ho an redirection raha misy

//        4 - Redirection
            response.sendRedirect("StyleServlet");
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
            try {          
                response.sendRedirect("StyleServlet?erreur="+e.getMessage());
            } catch(Exception o) {
            
            }
        }
    }


}
