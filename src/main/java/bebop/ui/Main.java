package bebop.ui;

import java.io.IOException;

import bebop.exception.BebopException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {

    private Bebop bebop;
    public Main() throws IOException {
        this.bebop = new Bebop("data/Bebop.txt");
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setBebop(bebop);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
