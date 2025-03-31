package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import vinnsla.Spurningar;

public class SpurningarController {
    public ListView flokkarListView;
    /** listi fyrir spurningar. */
    public ListView spurningarListView;
    /** label fyrir fjölda spurninga. */
    public Label fjoldiSpurningaLabel;
    /** textabox fyrir svaraðar spurningar. */
    public TextArea spurningarTextArea;
    /** index fyrir flokka listann. */
    private int virkurIndex;
    /** vinnsluklasi. */
    private Spurningar spurningar = new Spurningar();

    /**
     * Hér er fjoldiSpurninga bundinn við property í vinnsluklasanum,
     * flokkar listinn fylltur af réttum gildum úr vinnsluklasa,
     * og changelistener bætt við til að réttar spurningar birtist í
     * spurningalistanum.
     */
    public void initialize() {
        fjoldiSpurningaLabel.textProperty().bind(
                spurningar.spurningarProperty());
        flokkarListView.setItems(spurningar.getFlokkar());
        flokkarListView.getSelectionModel().selectedIndexProperty()
                .addListener((obs, old, newIndex) -> {
                    if (newIndex.intValue() >= 0) {
                        virkurIndex = newIndex.intValue();
                        if (virkurIndex == 0) {
                            spurningarListView.setItems(spurningar.
                                    getSpurningalisti("Tæknispurningar"));
                        }
                        else if (virkurIndex == 1) {
                            spurningarListView.setItems(spurningar.
                                    getSpurningalisti("Færnispurningar"));
                        }
                    }
                });
    }

    /**
     * Hér poppar upp dialog gluggi til að svara spurningu sem notandi hefur
     * valið og viðmótið uppfært eftirá.
     * @param actionEvent
     */
    public void onSvaraButton(ActionEvent actionEvent) {
        String spurning = spurningarListView.
                getSelectionModel().getSelectedItem().toString();
        Dialog<String> svarDialog = new SvarDialogController(spurning);
        svarDialog.showAndWait().ifPresent(result -> {
            updateSpurningar(result);
        });
    }

    /**
     * Breytt yfir í VELKOMINN view.
     * @param actionEvent
     */
    public void onTilBakaButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.VELKOMINN);
    }

    /**
     * Breytt yfir í KVEÐJA view.
     * @param actionEvent
     */
    public void onHaettaButton(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.KVEDJA);
    }

    /**
     * Aðferð til að bæta við svaraðri spurningu í spurninga log og hækka
     * fjölda spurninga.
     * @param spurning spurning sem hefur verið svarað.
     */
    public void updateSpurningar(String spurning) {
        spurningarTextArea.appendText(spurning + "\n");
        spurningar.haekkaSpurningar();
    }
}
