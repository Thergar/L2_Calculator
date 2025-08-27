package l2calculator.entities.townrepository;


import l2calculator.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long>, TownRepositoryCustom {

    /**
     * Retrieves a town by its name.
     *
     * @param townName the name of the town to search for.
     * @return an {@link Optional} containing the {@link Town} if found, or empty if not found.
     */
    Optional<Town> findByTownName(String townName);

}
