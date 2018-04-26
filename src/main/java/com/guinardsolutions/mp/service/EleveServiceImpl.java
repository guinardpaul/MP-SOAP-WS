/**
 *
 */
package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.dao.EleveDao;
import com.guinardsolutions.mp.entities.Eleve;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 *
 */
@Service("eleveService")
public class EleveServiceImpl implements EleveService {

    @Autowired
    private EleveDao dao;

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolutions.mp.service.EleveService#getAllEleves()
     */
    @Override
    public List<Eleve> getAllEleves() {
        return dao.findAll();
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.guinardsolutions.mp.service.EleveService#getAllEleveByClasse(java.lang.
	 * Integer)
     */
    @Override
    public List<Eleve> getAllEleveByClasse(Integer classeId) {
        return dao.getAllElevesByClasse(classeId);
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.guinardsolutions.mp.service.EleveService#getOneEleve(java.lang.Integer)
     */
    @Override
    public Eleve getOneEleve(Integer eleveId) {
        return dao.getOneEleve(eleveId);
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.guinardsolutions.mp.service.EleveService#saveEleve(com.guinardsolutions.
	 * mp.entities.Eleve)
     */
    @Override
    public Eleve saveEleve(Eleve eleve) {
        return dao.save(eleve);
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.guinardsolutions.mp.service.EleveService#updateEleve(com.guinardsolutions
	 * .mp.entities.Eleve)
     */
    @Override
    public Eleve updateEleve(Eleve eleve) {
        // TODO: Vérifier update
        return dao.updateEleve(eleve.getFirstname(), eleve.getLastname(), eleve.getClasse(), eleve.getId());
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.guinardsolutions.mp.service.EleveService#deleteEleve(java.lang.Integer)
     */
    @Override
    public void deleteEleve(Integer eleveId) {
        dao.deleteById(eleveId);
    }

}
