package com.guinardsolutions.mp.dao;

import com.guinardsolutions.mp.entities.Resultat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paul
 */
@Repository
public interface ResultatDao extends JpaRepository<Resultat, Integer> {

    /**
     *
     * @param eleveId
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.eleve=?1", nativeQuery = true)
    List<Resultat> getAllResultatsByEleve(Integer eleveId);

    /**
     *
     * @param trimestre
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.trimestre=?1", nativeQuery = true)
    List<Resultat> getAllResultatsByTrimestre(String trimestre);

    /**
     *
     * @param eleveId
     * @param trimestre
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.eleve=?1 AND r.trimestre=?2", nativeQuery = true)
    List<Resultat> getAllResultatsByEleveAndTrimestre(Integer eleveId, String trimestre);

    /**
     *
     * @param competenceId
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.competence=?1", nativeQuery = true)
    List<Resultat> getAllResultatsByCompetence(Integer competenceId);

    /**
     *
     * @param competenceId
     * @param trimestre
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.eleve=?1 AND r.trimestre=?2", nativeQuery = true)
    List<Resultat> getAllResultatsByCompetenceAndTrimestre(Integer competenceId, String trimestre);

    /**
     *
     * @param eleveId
     * @param competenceId
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.eleve=?1 AND r.competence=?2", nativeQuery = true)
    List<Resultat> getAllResultatsByEleveAndCompetence(Integer eleveId, Integer competenceId);

    /**
     *
     * @param eleveId
     * @param competenceId
     * @param trimestre
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.eleve=?1 AND r.competence=?2 AND r.trimestre=?3", nativeQuery = true)
    List<Resultat> getAllResultatsByEleveAndCompetenceAndTrimestre(Integer eleveId, Integer competenceId,
            String trimestre);

    /**
     *
     * @param resultatId
     * @return
     */
    @Query(value = "SELECT * FROM resultats r WHERE r.id=?1", nativeQuery = true)
    Resultat getOneResultat(Integer resultatId);

}
