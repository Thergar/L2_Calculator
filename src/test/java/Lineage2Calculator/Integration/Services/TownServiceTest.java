package Lineage2Calculator.Integration.Services;

import Lineage2Calculator.Entities.TownRepository.TownRepository;
import Lineage2Calculator.Integration.BaseConfiguration;
import Lineage2Calculator.Services.TownService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TownService.class)
public class TownServiceTest extends BaseConfiguration {

    @Autowired
    private TownRepository townRepository;

    @Autowired
    private TownService townService;

    @Test
    void getAllTownNames() {

        Set<String> townsNames = townService.getAllTownNames();

        assertThat(townsNames.size()).isEqualTo(15);
        Assertions.assertTrue(townsNames.contains("Heine"));
        Assertions.assertTrue(townsNames.contains("Aden Castle Town"));
    }

    @Test
    void getTeleportData() {

        Map<String, Integer> teleportData = townService.getTeleportData("Heine");

        assertThat(teleportData.size()).isBetween(1, 14);
        assertThat(teleportData.containsKey("Dion Castle Town")).isTrue();
        assertThat(teleportData.get("Gludio Castle Town").intValue()).isEqualTo(47000);
    }
}
