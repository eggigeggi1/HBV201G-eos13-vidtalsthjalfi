package vidmot;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import vinnsla.HuggingFaceClient;

import java.io.IOException;

public class FerilskraController {
    public TextArea cvFeedbackText;
    public TextArea cvInputText;
    public HuggingFaceClient client;

    public void initialize() {
        client = new HuggingFaceClient(
                "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");
    }
    public void onFeedbackCV(ActionEvent actionEvent) {
        String input = cvInputText.getText();
        String prompt = "You are an expert on CV construction. Evaluate the " +
                "following CV for an immigrant woman in the Icelandic labor" +
                "market. The following text is the CV: " +
                input + " address me directly, give helpful feedback on what is" +
                "good and what could be improved. (Feedback-below)";
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
