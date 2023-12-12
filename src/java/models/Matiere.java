/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import connexionBase.ConnexionBase;
import dao.annotations.Colonne;
import dao.annotations.PrimaryKey;
import dao.annotations.Table;
import dao.generiqueDAO.GeneriqueDAO;
import java.util.List;

/**
 *
 * @author Rota
 */
@PrimaryKey(longPK = 10, prefix = "MT", maFonction = "nextid", seq = "seqMatiere")
@Table
public class Matiere extends GeneriqueDAO {
    @Colonne
    String id;
    @Colonne
    String matiere;
    
    public Matiere() {}
    
    public Matiere(String matiere) {
        this.setMatiere(matiere);
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }
    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }
    
    public Matiere getDonnees() throws Exception {
        ConnexionBase con = new ConnexionBase();
        List<Matiere> liste = (List<Matiere>)this.list(con.getConnection());
        con.getConnection().close();
        if(liste.size() > 0)
            return liste.get(0);
        return null;
    }
    
    public boolean matiereExist(Matiere matire) {
        if(matiere == null)
            return false;
        return true;
    }
    
    public void ajoutMatiere() throws Exception {
        ConnexionBase con = new ConnexionBase();
        try {
            this.setId(this.construirePK(con.getConnection()));
            this.insert(con.getConnection());
            con.getConnection().commit();
            con.getConnection().close();
        } catch(Exception io) {            
            con.getConnection().close();
            throw new Exception("Le matiere: " + this.getMatiere() + " existe deja");
        }
    }
    
    public List<Matiere> getListeMatiere() throws Exception {
        ConnexionBase con = new ConnexionBase();
        this.setOrderCondition("order by matiere asc");
        List<Matiere> liste = (List<Matiere>)this.list(con.getConnection());
        con.getConnection().close();
        return liste;
    }
    
    public List<Matiere> getListeMatiere(String idStyle) throws Exception {
        ConnexionBase con = new ConnexionBase();
        List<Matiere> liste = (List<Matiere>)this.list("select * from liste_matiere_style where idStyle='"+ idStyle +"' order by matiere", con.getConnection());
        con.getConnection().close();
        return liste;
    }
}
