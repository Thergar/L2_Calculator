package Lineage2Calculator.Integration.Services;

import Lineage2Calculator.Graph.Graph;
import Lineage2Calculator.Integration.BaseConfiguration;
import Lineage2Calculator.Services.GraphBuilderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GraphBuilderServiceTest extends BaseConfiguration {

    @Autowired
    private GraphBuilderService graphBuilderService;

    /*@Test
    void buildGraphWithCorrectData() {

        Graph graph = graphBuilderService.buildGraph();

        assertThat(graph).isNotNull();
        assertThat(graph.getAdjacencyMap().isEmpty()).isFalse();

        assertThat(graph.getNeighbors("Heine").containsKey("Goddard Castle Town")).isTrue();
        assertThat(graph.getNeighbors("Heine").containsValue(83000));
        assertThat(graph.getNeighbors("Aden Castle Town").isEmpty()).isFalse();
    }*/
}
