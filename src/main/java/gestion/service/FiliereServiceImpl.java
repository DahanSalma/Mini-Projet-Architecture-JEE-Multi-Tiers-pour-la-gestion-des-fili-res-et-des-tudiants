package gestion.service;

import gestion.dao.FiliereDAO;
import gestion.dao.impl.FiliereDAOImpl;
import gestion.entites.Filiere;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FiliereServiceImpl implements FiliereService {

    private FiliereDAO filiereDao = new FiliereDAOImpl() ;

    @Override
    public List<Filiere> getSortedFiliere() {

        List<Filiere> filieres = this.filiereDao.getAll();

        Collections.sort(filieres, new Comparator<Filiere>() {

            @Override
            public int compare(Filiere o1, Filiere o2) {

                return o1.getId() - o2.getId();
            }
        });

        return filieres;
    }
}
