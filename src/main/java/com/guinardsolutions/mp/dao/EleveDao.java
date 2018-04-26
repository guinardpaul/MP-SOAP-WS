/**
 *
 */
package com.guinardsolutions.mp.dao;

import com.guinardsolutions.mp.entities.Classe;
import com.guinardsolutions.mp.entities.Eleve;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Paul
 *
 */
@Repository
public interface EleveDao extends JpaRepository<Eleve, Integer> {

    /**
     * Get all eleves by classe
     *
     * @param classe_id classe id
     * @return Classes
     */
    @Query(value = "SELECT * FROM eleves e where e.classe_id = ?1", nativeQuery = true)
    List<Eleve> getAllElevesByClasse(Integer classe_id);

    /**
     * Get one eleve
     *
     * @param eleveId eleve id
     * @return eleve
     */
    @Query(value = "SELECT * FROM eleves e where e.id = ?1", nativeQuery = true)
    Eleve getOneEleve(Integer eleveId);

    /**
     * Update eleve
     *
     * @param firstname firstname
     * @param lastname lastname
     * @param classe classe
     * @param eleveId eleveId
     * @return eleve
     */
    @Modifying
    @Query(value = "UPDATE eleves e SET e.firstname=?1, e.lastname=?2, e.classe_id=?3 WHERE e.id=?4", nativeQuery = true)
    Eleve updateEleve(String firstname, String lastname, Classe classe, Integer eleveId);
}
