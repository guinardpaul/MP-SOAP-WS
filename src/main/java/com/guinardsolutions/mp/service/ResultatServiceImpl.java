package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.dao.ResultatDao;
import com.guinardsolutions.mp.entities.Resultat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul
 */
@Service("resultatService")
public class ResultatServiceImpl implements ResultatService {

    @Autowired
    private ResultatDao dao;

    @Override
    public List<Resultat> getAllResultats() {
        return dao.findAll();
    }

    @Override
    public List<Resultat> getAllResultatsByEleve(Integer eleveId) {
        return dao.getAllResultatsByEleve(eleveId);
    }

    @Override
    public List<Resultat> getAllResultatsByCompetence(Integer competenceId) {
        return dao.getAllResultatsByCompetence(competenceId);
    }

    @Override
    public List<Resultat> getAllResultatsByEleveAndCompetence(Integer eleveId, Integer competenceId) {
        return dao.getAllResultatsByEleveAndCompetence(eleveId, competenceId);
    }

    @Override
    public Resultat saveResultat(Resultat resultat) {
        return dao.save(resultat);
    }

    @Override
    public Resultat updateResultat(Resultat resultat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteResultat(Integer resultatId) {
        dao.deleteById(resultatId);
    }

    @Override
    public Resultat getOneResultat(Integer resultatId) {
        return dao.getOneResultat(resultatId);
    }

    @Override
    public List<Resultat> getAllResultatsByTrimestre(String trimestre) {
        return dao.getAllResultatsByTrimestre(trimestre);
    }

    @Override
    public List<Resultat> getAllResultatsByEleveAndTrimestre(Integer eleveId, String trimestre) {
        return dao.getAllResultatsByEleveAndTrimestre(eleveId, trimestre);
    }

    @Override
    public List<Resultat> getAllResultatsByCompetenceAndTrimestre(Integer competenceId, String trimestre) {
        return dao.getAllResultatsByCompetenceAndTrimestre(competenceId, trimestre);
    }

    @Override
    public List<Resultat> getAllResultatsByEleveAndCompetenceAndTrimestre(Integer eleveId, Integer competenceId, String trimestre) {
        return dao.getAllResultatsByEleveAndCompetenceAndTrimestre(eleveId, competenceId, trimestre);
    }

}
