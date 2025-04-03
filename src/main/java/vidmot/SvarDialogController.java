package vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import vinnsla.HuggingFaceClient;
import vinnsla.LanguageSettings;

import java.io.IOException;

public class SvarDialogController extends Dialog<String> {
    /** Label fyrir spurninguna. */
    public Label spurningLabel;
    /** Textagluggi fyrir svarið frá notanda. */
    public TextField svarTextField;
    /** Label fyrir feedback frá bakenda. */
    public TextArea feedbackField;
    /** AI client */
    public  HuggingFaceClient client;
    /** Button fyrir feedback */
    public Button feedbackButton;

    /**
     * Smiður fyrir klasann. Setur upp dialoginn, setur spurninguna sem var
     * valin og stillir ResultConverter.
     * @param selectedItem Spurningin sem var valin.
     */
    public SvarDialogController(String selectedItem) {
        setDialogPane(lesaSvarDialog());
        client = new HuggingFaceClient(
                "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");
        spurningLabel.setText(selectedItem);
        setResultConverter(b -> {
            if (b.getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                return selectedItem;
            } else {
                return null;
            }
        });

        if(LanguageSettings.isEnglish()) {
            feedbackButton.setText("Get feedback");
        }
    }

    /**
     * Loadar FXML skránni.
     * @return fxml skráin frá fxmlLoader.
     */
    private DialogPane lesaSvarDialog() {
        FXMLLoader fxmlLoader =
                new FXMLLoader(getClass().getResource(
                        LanguageSettings.isEnglish() ?
                                "svar-view-english.fxml" : "svar-view.fxml"));
        try {
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        }
        catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * Gefur feedback á svarið sem notandi skrifaði. Kallar á HuggingFaceClient
     * bakendaforrit.
     * @param actionEvent
     */
    public void onFeedbackButton(ActionEvent actionEvent) {
        String svar = svarTextField.getText();
        try {
            String prompt = String.format(
                    "You are an expert interview coach. Use the following criteria to evaluate my response:\n" +
                            "\n" +
                            "1. Relevance: Does the answer address the question clearly and directly?\n" +
                            "2. Helpfulness: Is the answer informative, complete, and insightful?\n" +
                            "3. Professionalism: Is the tone appropriate, and is the language well-structured?\n" +
                            "\n" +
                            "Interview Question: %s\n" +
                            "\n" +
                            "My Answer: %s\n" +
                            "\n" +
                            "Address me directly, Please evaluate the answer on each criterion (1 to 5), provide a brief explanation for each, and then give an overall comment." +
                            "(Feedback-below)",
                    spurningLabel.getText(),
                    svar
            );
            String feedback = client.queryModel("HuggingFaceH4/zephyr-7b-alpha",
                    prompt);
            feedbackField.setText(feedback);
        }
        catch(IOException e) {
            feedbackField.setText(e.getMessage());
        }

    }
}
