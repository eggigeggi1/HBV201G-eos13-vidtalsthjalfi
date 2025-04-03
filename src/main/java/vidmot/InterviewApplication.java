package vidmot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InterviewApplication extends Application {
    @Override
    public void start(Stage stage) {
        // Búin til sena með einhverjum viðmótshlut
        var scene = new Scene(new Pane());

        // Setjum senuna sem núverandi senu
        ViewSwitcher.setScene(scene);

        // skiptum yfir í viðmótstré fyrir LANGUAGE
        ViewSwitcher.switchTo(View.LANGUAGE);

        // tengjum senuna við gluggann
        stage.setScene(scene);

        // sýnum glugggann
        stage.show();

    }

    /**
     * Kallað á launch().
     * @param args Á ekki við.
     */
    public static void main(String[] args) {
        launch();
    }
}
