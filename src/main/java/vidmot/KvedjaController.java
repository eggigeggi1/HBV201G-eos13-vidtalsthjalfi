package vidmot;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class KvedjaController {

    /**
     * Lokar forritinu.
     * @param actionEvent
     */
    public void onHaettaButton(ActionEvent actionEvent) {
        Platform.exit();
    }
}
