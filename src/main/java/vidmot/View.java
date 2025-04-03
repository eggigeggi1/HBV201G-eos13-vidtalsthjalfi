package vidmot;

public enum View {
    /** Velkominn view. */
    VELKOMINN("velkominn-view.fxml"),
    /** Language view. */
    LANGUAGE("language-view.fxml"),
    /** Spurningar view. */
    SPURNINGAR("spurningar-view.fxml"),
    /** Kveðja view. */
    KVEDJA("kvedja-view.fxml"),
    /** Ferilskrár view. */
    FERILSKRA("ferilskra-view.fxml"),
    /** Upplýsingar view. */
    UPPLYSINGAR("upplysingar-view.fxml");


    /** Nafn á file. */
    private String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Getter fyrir fileName.
     * @return fileName strengur.
     */
    public String getFileName() {
        return fileName;
    }
}
