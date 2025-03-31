package vidmot;

import javafx.event.ActionEvent;

public class VelkominnController {
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
}
