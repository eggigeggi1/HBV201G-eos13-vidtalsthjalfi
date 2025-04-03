package vinnsla;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

public class Spurningar {
    /** ObservableList af spurningaflokkum. */
    private final ObservableList<String> flokkar =
            FXCollections.observableArrayList();
    /** ObservableList af spurningaflokkum. */
    private final ObservableList<String> flokkarEnglish =
            FXCollections.observableArrayList();
    /** HashMap of spurningum, mappað á ObservableList. */
    private final Map<String, ObservableList<String>> spurningar =
            new HashMap<>();
    /** HashMap of spurningum, mappað á ObservableList. */
    private final Map<String, ObservableList<String>> spurningarEnglish =
            new HashMap<>();
    /** String property fyrir fjölda svaraðra spurninga. */
    private final SimpleStringProperty fjoldiSvaradraSpurninga =
            new SimpleStringProperty("0");

    /**
     * Smiður fyrir klasann. Setur rétta flokka og spurningar í breyturnar.
     */
    public Spurningar() {
        flokkar.add("Tæknispurningar");
        flokkar.add("Færnispurningar");
        flokkarEnglish.add("Technical questions");
        flokkarEnglish.add("Soft skills questions");

        ObservableList<String> taeknispurningar =
                FXCollections.observableArrayList(
                    "Hvaða forritunarmál kannt þú?",
                    "Hvað er recursion, og hvenær myndirðu nota það í forritun?",
                    "Hvað er SQL injection, og hvernig geturðu varist því?",
                    "Hver er munurinn á stack og heap í minnisstjórnun?",
                    "Hvernig metur þú hraða reiknirits?"
        );
        ObservableList<String> taeknispurningarEnglish =
                FXCollections.observableArrayList(
                        "What pogramming languages do you know?",
                        "What is recursion, and when would you use it in " +
                                "programming?",
                        "What is an SQL injection, and how can you defend " +
                                "against it?",
                        "What is the difference between the stack and the " +
                                "heap in regards to memory management?",
                        "How do you assess the speed of an algorithm?"
                );
        ObservableList<String> faernispurningar =
                FXCollections.observableArrayList(
                "Segðu frá þegar þú lentir í erfiðu vandamáli í verkefni. " +
                        "Hvernig leystir þú það?",
                "Hvernig vinnur þú með öðrum í liði, sérstaklega " +
                        "þegar það eru ágreiningur um hvernig eigi " +
                        "að leysa vandamál?",
                "Hvernig heldur þú þig upplýstur um nýjungar í forritun?",
                "Hvernig myndir þú útskýra flókið tæknilegt hugtak fyrir" +
                        " einhverjum sem skilur það ekki?",
                "Hvað gerir þú þegar þú lendir í verkefni sem þú veist ekki " +
                        "hvernig á að leysa?"
        );
        ObservableList<String> faernispurningarEnglish =
                FXCollections.observableArrayList(
                        "Give an example of a time you encountered a " +
                                "difficult issue when working on a project, " +
                                "how did you solve it?",
                        "How do you work with others on a team, specifically " +
                                "when a conflict arises regarding the right " +
                                "solution for a problem?",
                        "How do you stay informed on the newest developments " +
                                "in programming?",
                        "How would you explain complicated technical terms" +
                                " to someone who does not understand them?",
                        "What do you do when you are tasked with a problem" +
                                " you are unsure how to solve?"
                );

        spurningar.put("Tæknispurningar", taeknispurningar);
        spurningar.put("Færnispurningar", faernispurningar);
        spurningarEnglish.put("Tæknispurningar", taeknispurningarEnglish);
        spurningarEnglish.put("Færnispurningar", faernispurningarEnglish);
    }

    /**
     * Getter fyrir spurningalista.
     * @param flokkur Hvaða flokk skal sækja spurningar fyrir.
     * @return ObservableList<String> af spurningum fyrir flokkinn.
     */
    public ObservableList<String> getSpurningalisti(String flokkur) {
        return spurningar.get(flokkur);
    }

    /**
     * Getter fyrir spurningalista á ensku.
     * @param flokkur Hvaða flokk skal sækja spurningar fyrir.
     * @return ObservableList<String> af spurningum fyrir flokkinn.
     */
    public ObservableList<String> getSpurningalistiEnglish(String flokkur) {
        return spurningarEnglish.get(flokkur);
    }

    /**
     * Getter fyrir flokka.
     * @return ObservableList<String> fyrir flokka.
     */
    public ObservableList<String> getFlokkar() {
        return flokkar;
    }

    /**
     * Getter fyrir flokka á ensku.
     * @return ObservableList<String> fyrir flokka.
     */
    public ObservableList<String> getFlokkarEnglish() {
        return flokkarEnglish;
    }

    /**
     * Getter fyrir fjoldiSvaradraSpurninga.
     * @return fjoldiSvaradraSpurninga property.
     */
    public SimpleStringProperty spurningarProperty() {
        return fjoldiSvaradraSpurninga;
    }

    /**
     * Aðferð sem hækkar töluna í fjoldiSvaradraSpurninga um einn.
     */
    public void haekkaSpurningar() {
        int current = Integer.parseInt(fjoldiSvaradraSpurninga.getValue());
        current++;
        fjoldiSvaradraSpurninga.setValue(current + "");
    }

    /**
     * Main aðferð sem prófar fallið.
     * @param args á ekki við.
     */
    public static void main(String[] args) {
        Spurningar spurningar = new Spurningar();
        System.out.println(
                spurningar.getSpurningalisti("Færnispurningar").get(1));
        System.out.println(
                spurningar.getSpurningalisti("Tæknispurningar").get(0));
        System.out.println(spurningar.getFlokkar());
    }
}
