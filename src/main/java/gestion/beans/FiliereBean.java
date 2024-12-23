package gestion.beans;

import gestion.entites.Filiere;
import gestion.service.FiliereService;
import gestion.service.FiliereServiceImpl;

import java.util.List;

public class FiliereBean {

    private Filiere filiere;
    private FiliereService filiereService;
    private boolean modifyContext;


    public FiliereBean() {

        this.filiere = new Filiere();
        this.filiereService = new FiliereServiceImpl();
        this.modifyContext = false;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }


    public boolean isModifyContext() {
        return modifyContext;
    }

    public void setModifyContext(boolean modifyContext) {
        this.modifyContext = modifyContext;
    }

    public String getLabel() {
        return this.isModifyContext() ? "Modification" : "Ajout";
    }

    public List<Filiere> getFilieres() {
        return this.filiereService.getSortedFiliere();
    }
}
