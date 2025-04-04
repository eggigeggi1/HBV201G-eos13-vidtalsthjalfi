package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import vinnsla.LanguageSettings;

public class UpplysingarController {
    /** Færa sig til vinstri í slideshow. */
    public Button leftButton;
    /** Færa sig til hægri í slideshow. */
    public Button rightButton;
    /** Button fyrir til baka. */
    public Button tilBakaButton;
    /** Label fyrir upplýsingar til notanda. */
    public Label infoLabel;
    /** ImageView fyrir slideshow. */
    public ImageView slideshow;
    /** Index fyrir slideshow. */
    public int index;

    /**
     * Setjum tungumál á ensku ef á við.
     */
    public void initialize() {
        index = 1;
        if (LanguageSettings.isEnglish()) {
            tilBakaButton.setText("Back");
            infoLabel.setText("Advice regarding recruitment " +
                    "from an HR specialist");
        }
        updateButton();
    }

    /**
     * Færum slideshow til vinstri.
     * @param actionEvent
     */
    public void onLeft(ActionEvent actionEvent) {
        if (index > 1) {
            index--;
            updateButton();
            updateSlide();
        }
    }

    /**
     * Færum slideshow til hægri.
     * @param actionEvent
     */
    public void onRight(ActionEvent actionEvent) {
        if (index < 31) {
            index++;
            updateButton();
            updateSlide();
        }
    }

    /**
     * Breytum yfir á VELKOMINN view.
     * @param actionEvent
     */
    public void onBack(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    /**
     * Látum rétta glæru birtast.
     */
    public void updateSlide() {
        String imagePath = "slides/" + index + ".png";
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        slideshow.setImage(image);
    }

    /**
     * Látum vinstri og hægri takka vera disabled ef ekki eru fleiri glærur í
     * þeirra átt.
     */
    public void updateButton() {
        leftButton.setDisable(index <= 1);
        rightButton.setDisable(index >= 31);
    }
}
