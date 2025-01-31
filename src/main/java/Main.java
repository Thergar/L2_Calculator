import Lineage2Calculator.ApplicationFacade;
import Lineage2Calculator.DbServices.TownService;
import Lineage2Calculator.Graph.GraphBuilder;
import Lineage2Calculator.InteractionManager.UserInterface;
import Lineage2Calculator.MainApplication.AlgorithmExecution;
import Lineage2Calculator.MainApplication.AppRunner;

public class Main {

    public static void main(String[] args) {
        AlgorithmExecution algorithmExecution = new AlgorithmExecution();
        TownService townService = new TownService();
        GraphBuilder graphBuilder = new GraphBuilder(townService);
        UserInterface userInterface = new UserInterface();

        ApplicationFacade applicationFacade = new ApplicationFacade(algorithmExecution, graphBuilder, userInterface);





        AppRunner appRunner = new AppRunner(applicationFacade);
        appRunner.run();
    }
}