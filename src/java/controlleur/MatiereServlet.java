/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur;

import connexionBase.ConnexionBase;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Matiere;

/**
 *
 * @author Rota
 */
@WebServlet(name = "MatiereServlet", urlPatterns = {"/MatiereServlet"})
public class MatiereServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try {
//        1 - Maka ny parametre nalefa raha misy
            System.out.print("Tonga ohh");
          String erreur = request.getParameter("erreur");
            System.out.print("Tonga ohh ==> " + erreur);

//        2 - controlle de valeur na instanciation objet raha ilaina

//        3 - miset ny attribut ho an redirection raha misy
            if(erreur != null)
                request.setAttribute("erreur", erreur);
            
            System.out.print("Vita ohh");
//        4 - Redirection
            RequestDispatcher dispatcher = request.getRequestDispatcher("ajout_matiere.jsp");
            dispatcher.forward(request, response);
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Erreur: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
//        1 - Maka ny parametre nalefa raha misy
            String nom = request.getParameter("matiere");
            
//        2 - controlle de valeur na instanciation objet raha ilaina
            Matiere matiere = new Matiere(nom);
            matiere.ajoutMatiere();
            
//        3 - miset ny attribut ho an redirection raha misy

//        4 - Redirection
            response.sendRedirect("MatiereServlet");
        }
        catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
            try {          
                response.sendRedirect("MatiereServlet?erreur="+e.getMessage());
            } catch(Exception o) {
            
            }
        }
    }

}
