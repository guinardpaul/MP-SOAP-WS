package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.entities.Competence;
import java.util.List;

/**
 * Competence service
 *
 * @author Paul
 */
public interface CompetenceService {

    /**
     * Get all competences
     *
     * @return competences
     */
    List<Competence> getAllCompetences();

    /**
     * Get all competences by domaine
     *
     * @param domaineId domaine id
     * @return competences
     */
    List<Competence> getAllCompetencesByDomaine(Integer domaineId);

    /**
     * Get all competences by cycle
     *
     * @param cycle cycle
     * @return competences
     */
    List<Competence> getAllCompetencesByCycle(String cycle);

    /**
     * Get one competence
     *
     * @param competenceId competence id
     * @return competence
     */
    Competence getOneCompetence(Integer competenceId);

    /**
     * Save competence
     *
     * @param competence competence
     * @return competence
     */
    Competence saveCompetence(Competence competence);

    /**
     * Update competence
     *
     * @param competence competence
     * @return competence
     */
    Competence updateCompetence(Competence competence);

    /**
     * Delete competence
     *
     * @param competenceId competence id
     */
    void deleteCompetence(Integer competenceId);
}
