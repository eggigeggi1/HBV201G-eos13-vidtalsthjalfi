package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import vinnsla.HuggingFaceClient;
import vinnsla.LanguageSettings;

import java.io.IOException;

public class FerilskraController {
    /** Feedback text area */
    public TextArea cvFeedbackText;
    /** Input CV text area */
    public TextArea cvInputText;
    /** Instructions label */
    public Label instructionsLabel;
    /** Button fyrir endurgjöf */
    public Button feedbackButton;
    /** Button til að fara til baka */
    public Button tilBakaButton;
    /** AI client */
    public HuggingFaceClient client;

    /** Störtum AI client með HuggingFace API key, breytum í ensku ef þarf */
    public void initialize() {
        client = new HuggingFaceClient(
                "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");
        if (LanguageSettings.isEnglish()) {
            instructionsLabel.setText("Copy and paste your CV below");
            feedbackButton.setText("Feedback");
            tilBakaButton.setText("Back");
        }
    }
    public void onFeedbackCV(ActionEvent actionEvent) {
        String input = cvInputText.getText();
        String prompt = "You are an expert on CV construction. Evaluate the " +
                "following CV for an immigrant woman in the Icelandic labor" +
                "market. The following text is the CV: " +
                input + " address me directly, give helpful feedback on what" +
                " is good and what could be improved. (Feedback-below)";
        try {
            String feedback = client.queryModel("HuggingFaceH4/zephyr-7b-alpha",
                    prompt);
            cvFeedbackText.setText(feedback);
        }
        catch(IOException e) {
            cvFeedbackText.setText(e.getMessage());
        }
    }

    public void onTilBaka(ActionEvent actionEvent) {
        ViewSwitcher.switchTo(View.VELKOMINN);
    }
}
