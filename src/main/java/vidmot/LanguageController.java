package vidmot;

import javafx.event.ActionEvent;
import vinnsla.LanguageSettings;

public class LanguageController {

    public void onEnglish(ActionEvent actionEvent) {
        LanguageSettings.setEnglish(true);
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    public void onIslenska(ActionEvent actionEvent) {
        LanguageSettings.setEnglish(false);
        ViewSwitcher.switchTo(View.VELKOMINN);
    }
}
