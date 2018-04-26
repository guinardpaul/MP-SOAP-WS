/**
 *
 */
package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.dao.ClasseDao;
import com.guinardsolutions.mp.entities.Classe;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Paul
 *
 */
@Service("classeService")
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseDao dao;

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolution.mp.ws.service.ClasseService#getAllClasses()
     */
    @Override
    public List<Classe> getAllClasses() {
        return dao.findAll();
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolution.mp.ws.service.ClasseService#getOneClasse()
     */
    @Override
    public Classe getOneClasse(Integer classeId) {
        return dao.getOneClasse(classeId);
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolution.mp.ws.service.ClasseService#saveOrUpdateClasse(com.
	 * guinardsolution.mp.ws.entities.Classe)
     */
    @Override
    public Classe saveClasse(Classe classe) {
        return dao.save(classe);
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolution.mp.ws.service.ClasseService#updateClasse(com.
	 * guinardsolution.mp.ws.entities.Classe)
     */
    @Override
    public Classe updateClasse(Classe classe) {
        dao.updateClasse(classe.getName(), classe.getCycle(), classe.getEleves(), classe.getId());
        return dao.getOneClasse(classe.getId());
    }

    /*
	 * (non-Javadoc)
	 *
	 * @see com.guinardsolution.mp.ws.service.ClasseService#deleteClasse(java.lang.
	 * Integer)
     */
    @Override
    public void deleteClasse(Integer classeId) {
        dao.deleteById(classeId);
    }

}
