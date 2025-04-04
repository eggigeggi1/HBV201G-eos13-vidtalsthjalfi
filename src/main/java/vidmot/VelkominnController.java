package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vinnsla.LanguageSettings;

public class VelkominnController {
    /** Spurningar takki. */
    public Button welcomeSpurningarButton;
    /** Hætta takki. */
    public Button welcomeHaettaButton;
    /** Ferilskrár takki. */
    public Button welcomeFerilskrarButton;
    /** Upplýsingar takki. */
    public Button welcomeUpplysingarButton;
    /** Label fyrir velkominn skilaboð. */
    public Label welcomeLabel;

    /**
     * Setjum tungumál á ensku ef á við.
     */
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
