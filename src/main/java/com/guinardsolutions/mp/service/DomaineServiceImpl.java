package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.dao.DomaineDao;
import com.guinardsolutions.mp.entities.Domaine;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Paul
 */
@Service("domaineService")
public class DomaineServiceImpl implements DomaineService {

    @Autowired
    private DomaineDao dao;

    /**
     *
     * @return
     */
    @Override
    public List<Domaine> getAllDomaines() {
        return dao.findAll();
    }

    @Override
    public List<Domaine> getMainDomaines() {
        return dao.getMainDomaines();
    }

    @Override
    public List<Domaine> getSousDomaines(Integer domaineId) {
        return dao.getSousDomaines(domaineId);
    }

    @Override
    public Domaine getOneDomaine(Integer domaineId) {
        return dao.getOneDomaine(domaineId);
    }

    @Override
    public Domaine saveDomaine(Domaine domaine) {
        return dao.save(domaine);
    }

    @Override
    public Domaine updateDomaine(Domaine domaine) {
        return dao.updateDomaine(domaine.getRef(), domaine.getDescription(), domaine.getCycle(),
                domaine.getAbstractDomaine(), domaine.getId());
    }

    @Override
    public void deleteDomaine(Integer domaineId) {
        dao.deleteById(domaineId);
    }

    @Override
    public List<Domaine> getMainDomainesByCycle(String cycle) {
        return dao.getMainDomainesByCycle(cycle);
    }

}
