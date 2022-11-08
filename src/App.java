import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        AnchorPane todolayout = loader.load();
        Scene scan = new Scene(todolayout);

        primaryStage.setTitle("title");
        primaryStage.setScene(scan);
        primaryStage.show();

        ControlerUtama controller = loader.getController();
        controller.setData();

    }

    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");
        launch(args);
    }
}
