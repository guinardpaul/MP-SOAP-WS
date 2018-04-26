/**
 *
 */
package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.entities.Classe;
import java.util.List;

/**
 * @author Paul
 *
 */
public interface ClasseService {

    /**
     * Get all classes
     *
     * @return classes
     */
    List<Classe> getAllClasses();

    /**
     * Get one classe
     *
     * @param classeId classe id
     * @return classe
     */
    Classe getOneClasse(Integer classeId);

    /**
     * Save classe
     *
     * @param classe classe
     * @return classe
     */
    Classe saveClasse(Classe classe);

    /**
     * Delete Classe
     *
     * @param classeId classe id
     */
    void deleteClasse(Integer classeId);

    /**
     * Update classe
     *
     * @param classe classe
     * @return classe
     */
    Classe updateClasse(Classe classe);

}
