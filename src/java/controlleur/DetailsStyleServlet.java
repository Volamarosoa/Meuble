/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

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
@WebServlet(name = "DetailsStyleServlet", urlPatterns = {"/DetailsStyleServlet"})
public class DetailsStyleServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try {
//        1 - Maka ny parametre nalefa raha misy
        String erreur = request.getParameter("erreur");
        
//        2 - controlle de valeur na instanciation objet raha ilaina
            if(erreur != null)
                request.setAttribute("erreur", erreur);
            List<Style> liste = new Style().getListeStyle();

//        3 - miset ny attribut ho an redirection raha misy
            request.setAttribute("liste", liste);
//        4 - Redirection
            RequestDispatcher dispatcher = request.getRequestDispatcher("regarde_matiere.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("DetailsStyleServlet?erreur=" + e.getMessage());
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStyle = request.getParameter("idStyle");
       try {
 //        1 - Maka ny parametre nalefa raha misy
        
//        2 - controlle de valeur na instanciation objet raha ilaina
           List<Matiere> liste = new Matiere().getListeMatiere(idStyle);
           Style style = new Style();
           style.setId(idStyle);
           style = style.getDonnees();

//        3 - miset ny attribut ho an redirection raha misy
            request.setAttribute("liste", liste);
            request.setAttribute("style", style);
//        4 - Redirection
            RequestDispatcher dispatcher = request.getRequestDispatcher("liste_matiere.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Erreur: " + e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("DetailsStyleServlet?erreur=" + e.getMessage());
            response.sendRedirect("DetailsStyleServlet?erreur=" + e.getMessage());
        }
    }

}
