import Model.ModelClient;
import Model.ModelManagerClient;
import View.ViewHandler;
import ViewModel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ClientApplication extends Application {
    /**
     * Starts the application.
     *
     * @param primaryStage;
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ModelClient model = new ModelManagerClient();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler view = new ViewHandler(viewModelFactory);
        view.start(primaryStage);
    }
}
