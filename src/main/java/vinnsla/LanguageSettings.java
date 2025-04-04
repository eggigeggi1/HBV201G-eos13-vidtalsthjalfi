package vinnsla;

public class LanguageSettings {
    /** Breyta sem segir hvort forritið eigi að vera á ensku. */
    private static boolean english;

    /**
     * Aðferðin stillir english breytuna.
     * @param englishLang Hvort skal english vera true eða false.
     */
    public static void setEnglish(Boolean englishLang) {
        english = englishLang;
    }

    /**
     * Getter fyrir english breytuna.
     * @return english breytan.
     */
    public static boolean isEnglish() {
        return english;
    }
}
