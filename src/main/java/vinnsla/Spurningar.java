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
    /** HashMap of spurningum, mappað á ObservableList. */
    private final Map<String, ObservableList<String>> spurningar =
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

        ObservableList<String> taeknispurningar =
                FXCollections.observableArrayList(
                "Hvaða forritunarmál kannt þú?",
                "Hvað er recursion, og hvenær myndirðu nota það í forritun?",
                "Hvað er SQL injection, og hvernig geturðu varist því?",
                "Hver er munurinn á stack og heap í minnisstjórnun?",
                "Hvernig metur þú hraða reiknirits?"
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

        spurningar.put("Tæknispurningar", taeknispurningar);
        spurningar.put("Færnispurningar", faernispurningar);
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
     * Getter fyrir flokka.
     * @return ObservableList<String> fyrir flokka.
     */
    public ObservableList<String> getFlokkar() {
        return flokkar;
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
