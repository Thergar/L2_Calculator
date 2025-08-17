package Lineage2Calculator.Entities.TownRepository;

import Lineage2Calculator.Utils.BaseConfiguration;
import Lineage2Calculator.Utils.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TownRepositoryCustomImplTest extends BaseConfiguration {

    @Autowired
    private TownRepositoryCustomImpl townRepositoryCustomImpl;

    @Test
    void fetchTownDataWithDynamicTable_CorrectTable() {

        var result = townRepositoryCustomImpl.fetchTownDataWithDynamicTable("Dion_Castle_Town_teleports");
        var firstRow = result.get(0);

        assertNotNull(result);
        assertInstanceOf(String.class, firstRow[0]);
        assertInstanceOf(Number.class, firstRow[1]);
    }

    @Test
    void fetchTownDataWithDynamicTable_IncorrectTable() {

        assertThrows(Exception.class, () -> {;
            townRepositoryCustomImpl.fetchTownDataWithDynamicTable("incorrect_table");
        });
    }
}