/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import dao.annotations.Colonne;
import dao.annotations.Table;
import dao.generiqueDAO.GeneriqueDAO;

/**
 *
 * @author Rota
 */
@Table(name="details_style")
public class DetailStyle extends GeneriqueDAO {
    @Colonne
    int id;
    @Colonne
    String idStyle;
    @Colonne
    String idMatiere;
    
    public DetailStyle() {}
    
    public DetailStyle(String idStyle, String idMatiere) {
        this.setIdStyle(idStyle);
        this.setIdMatiere(idMatiere);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdStyle() {
        return idStyle;
    }

    public void setIdStyle(String idStyle) {
        this.idStyle = idStyle;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(String idMatiere) {
        this.idMatiere = idMatiere;
    }
    
    
}
