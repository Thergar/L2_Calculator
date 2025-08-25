package l2calculator.Services;

import l2calculator.Utils.BaseConfiguration;
import l2calculator.Utils.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
public class TownServiceTest extends BaseConfiguration {

    @Autowired
    private TownService townService;

    @Test
    void getAllTownNames() {

        Set<String> townsNames = townService.getAllTownNames();

        assertThat(townsNames.size()).isEqualTo(6);
        assertTrue(townsNames.contains("Dion Castle Town"));

    }

    @Test
    void getTeleportData() {

        Map<String, Integer> teleportData = townService.getTeleportData("Elven Village");

        assertThat(teleportData.size()).isEqualTo(4);
        assertThat(teleportData.containsKey("Dion Castle Town")).isFalse();
        assertThat(teleportData.get("Dark Elven Village").intValue()).isEqualTo(13000);
    }
}
