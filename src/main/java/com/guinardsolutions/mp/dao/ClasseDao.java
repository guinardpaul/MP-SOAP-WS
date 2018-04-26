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
public interface ClasseDao extends JpaRepository<Classe, Integer> {

    /**
     * Update classe
     *
     * @param name name
     * @param cycle cycle
     * @param eleves list eleves
     * @param classeId classe id
     */
    @Modifying
    @Query(value = "UPDATE classes c SET c.name=?1, c.cycle=?2, c.eleves=?3 WHERE c.id=?4", nativeQuery = true)
    void updateClasse(String name, String cycle, List<Eleve> eleves, Integer classeId);

    /**
     * Get one classe
     *
     * @param classeId classe id
     * @return Classe
     */
    @Query(value = "SELECT * FROM classes c WHERE c.id=?1", nativeQuery = true)
    Classe getOneClasse(Integer classeId);
}
