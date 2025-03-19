package Lineage2Calculator.Integration.Entities;

import Lineage2Calculator.Entities.Town;
import Lineage2Calculator.Entities.TownRepository.TownRepository;
import Lineage2Calculator.Integration.BaseConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;
import static org.junit.Assert.assertTrue;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TownTest extends BaseConfiguration {

    @Autowired
    private TownRepository townRepository;

    @Test
    void saveAndFindByTownId() {

        Town town = new Town("newTown");
        Town savedTown = townRepository.save(town);

        Optional<Town> foundedTown = townRepository.findById(savedTown.getTownId());

        assertThat(foundedTown).isPresent();
        assertThat(foundedTown.get().getTownName()).isEqualTo("newTown");

    }

    @Test
    void saveAndFindByTownName() {

        Town town = new Town("newTown2");
        Town savedTown = townRepository.save(town);

        Optional<Town> foundedTown = townRepository.findByTownName("newTown2");

        assertThat(foundedTown).isPresent();
        assertThat(foundedTown.get().getTownName()).isEqualTo("newTown2");
    }

    @Test
    void notFindTownIfNotExists() {

        Optional<Town> foundTown = townRepository.findByTownName("fakeTown");

        assertThat(foundTown).isEmpty();
    }

    @Test
    void fetchTownDataWithTable() {

        List<Object[]> result = townRepository.fetchTownDataWithDynamicTable("heine_teleports");

        List<String> townNames = result.stream()
                .map(results -> (String) results[0])
                .toList();

        assertThat(result).isNotEmpty();
        assertThat(townNames).contains("Town of Oren");
    }
}
