package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.entities.Domaine;
import java.util.List;

/**
 *
 * @author Paul
 */
public interface DomaineService {

    /**
     * Get all domaines
     *
     * @return domaines
     */
    List<Domaine> getAllDomaines();

    /**
     * get Main domaines
     *
     * @return domaines
     */
    List<Domaine> getMainDomaines();

    /**
     * Get main domaines by cycle
     *
     * @param cycle cycle
     * @return domaines
     */
    List<Domaine> getMainDomainesByCycle(String cycle);

    /**
     * Get sous domaines
     *
     * @param domaineId domaine id
     * @return domaines
     */
    List<Domaine> getSousDomaines(Integer domaineId);

    /**
     * Get one domaine
     *
     * @param domaineId domaine id
     * @return domaine
     */
    Domaine getOneDomaine(Integer domaineId);

    /**
     * Save domaine
     *
     * @param domaine domaine
     * @return domaine
     */
    Domaine saveDomaine(Domaine domaine);

    /**
     * Update domaine
     *
     * @param domaine domaine
     * @return domaine
     */
    Domaine updateDomaine(Domaine domaine);

    /**
     * Delete domaine
     *
     * @param domaineId domaine id
     */
    void deleteDomaine(Integer domaineId);
}
