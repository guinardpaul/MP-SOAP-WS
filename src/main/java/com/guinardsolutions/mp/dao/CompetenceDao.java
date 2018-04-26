package com.guinardsolutions.mp.dao;

import com.guinardsolutions.mp.entities.AbstractDomaine;
import com.guinardsolutions.mp.entities.Competence;
import com.guinardsolutions.mp.entities.Domaine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Competence DAO
 *
 * @author Paul
 */
@Repository
public interface CompetenceDao extends JpaRepository<Competence, Integer> {

    /**
     * Get all competences
     *
     * @return competences
     */
    @Query(value = "SELECT * FROM competences c", nativeQuery = true)
    List<Competence> getAllCompetences();

    /**
     * Get all competences by domaine
     *
     * @param domaineId domaine id
     * @return competences
     */
    @Query(value = "SELECT * FROM competences c WHERE c.abstract_domaine_id=?1", nativeQuery = true)
    List<Competence> getAllCompetencesByDomaine(Integer domaineId);

    /**
     * Get all competences by cycle
     *
     * @param cycle cycle string
     * @return competences
     */
    @Query(value = "SELECT * FROM competences c WHERE c.cycle=?1", nativeQuery = true)
    List<Competence> getAllCompetencesByCycle(String cycle);

    /**
     * Get one competence
     *
     * @param competenceId competence id
     * @return Competence
     */
    @Query(value = "SELECT * FROM competences c WHERE c.id=?1", nativeQuery = true)
    Competence getOneCompetence(Integer competenceId);

    /**
     * Update competence
     *
     * @param ref ref
     * @param description description
     * @param cycle cycle
     * @param abstractDomaine abstractDomaine
     * @param competenceId competenceId
     * @return competence
     */
    @Modifying
    @Query(value = "UPDATE competences c SET c.ref=?1, c.description=?2, c.cycle=?3, c.abstract_domaine_id)=?4 WHERE d.id=?5", nativeQuery = true)
    Domaine updateCompetence(String ref, String description, String cycle, AbstractDomaine abstractDomaine,
            Integer competenceId);

}
