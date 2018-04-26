/**
 *
 */
package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.entities.Eleve;
import java.util.List;

/**
 * @author Paul
 *
 */
public interface EleveService {

    /**
     * Get all eleves
     *
     * @return eleves
     */
    List<Eleve> getAllEleves();

    /**
     * Get all eleves by classe
     *
     * @param classeId classe id
     * @return eleves
     */
    List<Eleve> getAllEleveByClasse(Integer classeId);

    /**
     * Get one eleve
     *
     * @param eleveId eleve id
     * @return eleve
     */
    Eleve getOneEleve(Integer eleveId);

    /**
     * Save eleve
     *
     * @param eleve eleve
     * @return eleve
     */
    Eleve saveEleve(Eleve eleve);

    /**
     * Update eleve
     *
     * @param eleve eleve
     * @return eleve
     */
    Eleve updateEleve(Eleve eleve);

    /**
     * Delete eleve
     *
     * @param eleveId eleve id
     */
    void deleteEleve(Integer eleveId);
}
