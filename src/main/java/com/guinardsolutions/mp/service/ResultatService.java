package com.guinardsolutions.mp.service;

import com.guinardsolutions.mp.entities.Resultat;
import java.util.List;

/**
 *
 * @author Paul
 */
public interface ResultatService {

    /**
     * Get all resultats
     *
     * @return resultats
     */
    List<Resultat> getAllResultats();

    /**
     * Get all resultats by eleve
     *
     * @param eleveId eleve id
     * @return resultats
     */
    List<Resultat> getAllResultatsByEleve(Integer eleveId);

    /**
     * Get all resultats by competence
     *
     * @param competenceId competence id
     * @return resultats
     */
    List<Resultat> getAllResultatsByCompetence(Integer competenceId);

    /**
     * Get all resultats by eleve and competence
     *
     * @param eleveId eleve id
     * @param competenceId competence id
     * @return resultats
     */
    List<Resultat> getAllResultatsByEleveAndCompetence(Integer eleveId, Integer competenceId);

    /**
     * Get all resultats by trimestre
     *
     * @param trimestre trimestre
     * @return resultats
     */
    List<Resultat> getAllResultatsByTrimestre(String trimestre);

    /**
     * Get all resultats by eleve and trimestre
     *
     * @param eleveId eleve id
     * @param trimestre trimestre
     * @return resultats
     */
    List<Resultat> getAllResultatsByEleveAndTrimestre(Integer eleveId, String trimestre);

    /**
     * Get all resultats by competence and trimestre
     *
     * @param competenceId competence id
     * @param trimestre trimestre
     * @return resultats
     */
    List<Resultat> getAllResultatsByCompetenceAndTrimestre(Integer competenceId, String trimestre);

    /**
     * Get all resultats by eleve and competence and trimestre
     *
     * @param eleveId eleve id
     * @param competenceId competence id
     * @param trimestre trimestre
     * @return resultats
     */
    List<Resultat> getAllResultatsByEleveAndCompetenceAndTrimestre(Integer eleveId, Integer competenceId,
            String trimestre);

    /**
     * Get one resultat
     *
     * @param resultatId resultat id
     * @return resultat
     */
    Resultat getOneResultat(Integer resultatId);

    /**
     * Save resultat
     *
     * @param resultat resultat
     * @return resultat
     */
    Resultat saveResultat(Resultat resultat);

    /**
     * Update resultat
     *
     * @param resultat resultat
     * @return resultat
     */
    Resultat updateResultat(Resultat resultat);

    /**
     * Delete resultat
     *
     * @param resultatId resultat id
     */
    void deleteResultat(Integer resultatId);
}
