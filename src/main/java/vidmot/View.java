package vidmot;

public enum View {
    /** Velkominn view. */
    VELKOMINN("velkominn-view.fxml"),
    /** Spurningar view. */
    SPURNINGAR("spurningar-view.fxml"),
    /** Kveðja view. */
    KVEDJA("kvedja-view.fxml");

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
