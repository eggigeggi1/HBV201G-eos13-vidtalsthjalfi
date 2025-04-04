package vidmot;

import javafx.event.ActionEvent;
import vinnsla.LanguageSettings;

public class LanguageController {
    /**
     * Setjum tungumál forrits á ensku.
     * @param actionEvent
     */
    public void onEnglish(ActionEvent actionEvent) {
        LanguageSettings.setEnglish(true);
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    /**
     * Setjum tungumál forrits á íslensku.
     * @param actionEvent
     */
    public void onIslenska(ActionEvent actionEvent) {
        LanguageSettings.setEnglish(false);
        ViewSwitcher.switchTo(View.VELKOMINN);
    }
}
