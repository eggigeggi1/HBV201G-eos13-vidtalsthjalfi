package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.LanguageSettings;

public class VelkominnController {
    public Button welcomeSpurningarButton;
    public Button welcomeHaettaButton;
    public Button welcomeFerilskrarButton;
    public Button welcomeUpplysingarButton;
    public Label welcomeLabel;


    public void initialize() {
        if (LanguageSettings.isEnglish()) {
            welcomeLabel.setText("Welcome to the Interview Trainer!");
            welcomeSpurningarButton.setText("Questions");
            welcomeHaettaButton.setText("Quit");
            welcomeFerilskrarButton.setText("CV");
            welcomeUpplysingarButton.setText("Information");

        }
    }
    /**
     * Færa yfir í SPURNINGAR view.
     * @param actionEvent
     */
    public void onSpurningarButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.SPURNINGAR);
    }
    /**
     * Færa yfir í KVEÐJA view.
     * @param actionEvent
     */
    public void onWelcomeHaettaButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }

    /**
     * Færa yfir í FERILSKRA view.
     * @param actionEvent
     */
    public void onFerilskrarButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.FERILSKRA);
    }

    /**
     * Færa yfir í UPPLYSINGAR view.
     * @param actionEvent
     */
    public void onUpplysingarButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.UPPLYSINGAR);
    }
}
