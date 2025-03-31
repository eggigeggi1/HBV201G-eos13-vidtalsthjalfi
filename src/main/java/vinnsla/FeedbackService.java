package vinnsla;

/******************************************************************************
 * Nafn : Eggert Örn Sigurðsson
 * T-póstur: eos13@hi.is
 * Lýsing : Klasi sem gefur feedback á hve svar við viðtalsspurningu er gott.
 * Endurbætið að vild - Hafið feedback á íslensku ef spurningar eru á
 íslensku
 *
 *
 *****************************************************************************/
public class FeedbackService {
    /**
     * Gefur feedback á svari frá notanda.
     * @param answer svar frá notanda.
     * @return feedbackið.
     */
    public static String provideFeedback(String answer) {
        if (answer == null || answer.trim().isEmpty()) {
            return "Your answer seems too short. Try adding more details.";
        }
        if (answer.toLowerCase().contains("team player")) {
            return "Good! You mentioned teamwork. Can you give a specific "
                    + "example?";
        }
        if (answer.toLowerCase().contains("problem-solving")) {
            return "Nice! Problem-solving is key in many jobs. "
                    + "Can you explain a situation where you solved a problem "
                    + "effectively?";
        }
        return "Your answer is okay, "
                + "but try making it more structured with a clear example.";
    }

    /**
     * Main aðferð prófar klasann.
     * @param args á ekki við.
     */
    public static void main(String[] args) {
        String userResponse = "I am a team player and I solve "
                + "problems efficiently.";
        System.out.println(provideFeedback(userResponse));
    }
}
