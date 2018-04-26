package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.dao.CompetenceDao;
import com.guinardsolutions.mp.entities.Competence;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation competence service
 *
 * @author Paul
 */
@Service("competenceService")
public class CompetenceServiceImpl implements CompetenceService {

    @Autowired
    private CompetenceDao dao;

    @Override
    public List<Competence> getAllCompetences() {
        return dao.findAll();
    }

    @Override
    public List<Competence> getAllCompetencesByDomaine(Integer domaineId) {
        return dao.getAllCompetencesByDomaine(domaineId);
    }

    @Override
    public List<Competence> getAllCompetencesByCycle(String cycle) {
        return dao.getAllCompetencesByCycle(cycle);
    }

    @Override
    public Competence getOneCompetence(Integer competenceId) {
        return dao.getOneCompetence(competenceId);
    }

    @Override
    public Competence saveCompetence(Competence competence) {
        return dao.save(competence);
    }

    @Override
    public Competence updateCompetence(Competence competence) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteCompetence(Integer competenceId) {
        dao.deleteById(competenceId);
    }

}
