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
@PrimaryKey(longPK = 10, prefix = "ST", maFonction = "nextid", seq = "seqMatiere")
@Table
public class Style extends GeneriqueDAO{
    @Colonne
    String id;
    @Colonne
    String style;
    
    public Style() {}
    
    public Style(String style) {
        this.setStyle(style);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    
    public void ajoutStyle(String[] matieres) throws Exception {
        ConnexionBase con = new ConnexionBase();
        try {
            this.setId(this.construirePK(con.getConnection()));
            this.insert(con.getConnection());
            for(int i=0; i<matieres.length; i++) {
                DetailStyle detail = new DetailStyle(this.getId(), matieres[i]);
                detail.insert(con.getConnection());
            }
            con.getConnection().commit();
            con.getConnection().close();
        } catch(Exception io) {
            con.getConnection().rollback();
            con.getConnection().close();
            throw new Exception("Le style: " + this.getStyle() + " existe deja");
        }
    }
    
    public List<Style> getListeStyle() throws Exception {
        ConnexionBase con = new ConnexionBase();
        this.setOrderCondition("order by style");
        List<Style> liste = (List<Style>)this.list(con.getConnection());
        con.getConnection().close();
        return liste;
    }   
    
    public Style getDonnees() throws Exception {
        ConnexionBase con = new ConnexionBase();
        List<Style> liste = (List<Style>)this.list(con.getConnection());
        if(liste.size() > 0)
            return liste.get(0);
        return null;
    }
    
    
    
}
