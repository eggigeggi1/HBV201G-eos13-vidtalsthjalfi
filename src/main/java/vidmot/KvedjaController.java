package vidmot;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.LanguageSettings;

public class KvedjaController {
    /** Label fyrir kveðju */
    public Label kvedjaLabel;
    /** Button fyrir að loka forriti */
    public Button kvedjaHaettaButton;


    public void initialize() {
        if (LanguageSettings.isEnglish()) {
            kvedjaLabel.setText("Good luck on your interview!");
            kvedjaHaettaButton.setText("Quit");
        }
    }
    /**
     * Lokar forritinu.
     * @param actionEvent
     */
    public void onHaettaButton(ActionEvent actionEvent) {
        Platform.exit();
    }
}
