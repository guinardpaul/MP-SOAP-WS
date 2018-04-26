package com.guinardsolutions.mp.dao;

import com.guinardsolutions.mp.entities.AbstractDomaine;
import com.guinardsolutions.mp.entities.Domaine;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Paul
 */
@Repository
public interface DomaineDao extends JpaRepository<Domaine, Integer> {

    /**
     * Get main domaines
     *
     * @return domaines
     */
    @Query(value = "SELECT * FROM domaines d where d.ref IS NOT NULL", nativeQuery = true)
    List<Domaine> getMainDomaines();

    /**
     * get main domaines by cycle
     *
     * @param cycle cycle
     * @return domaines
     */
    @Query(value = "SELECT * FROM domaines d where d.ref IS NOT NULL AND d.cycle=?1", nativeQuery = true)
    List<Domaine> getMainDomainesByCycle(String cycle);

    /**
     * get sous domaines
     *
     * @param domaineId domaine id
     * @return domaines
     */
    @Query(value = "SELECT * FROM domaines d where d.ref IS NULL AND d.abstract_domaine_id=?1", nativeQuery = true)
    List<Domaine> getSousDomaines(Integer domaineId);

    /**
     * Get one domaine
     *
     * @param domaineId domaine id
     * @return domaine
     */
    @Query(value = "SELECT * FROM domaines d where d.id=?1", nativeQuery = true)
    Domaine getOneDomaine(Integer domaineId);

    /**
     * update domaine
     *
     * @param ref ref
     * @param description description
     * @param cycle cycle
     * @param abstractDomaine abstractDomaine
     * @param domaineId domaineId
     * @return domaine
     */
    @Modifying
    @Query(value = "UPDATE domaines d SET d.ref=?1, d.description=?2, d.cycle=?3, d.abstract_domaine_id=?4 WHERE d.id=?5", nativeQuery = true)
    Domaine updateDomaine(String ref, String description, String cycle, AbstractDomaine abstractDomaine,
            Integer domaineId);
}
