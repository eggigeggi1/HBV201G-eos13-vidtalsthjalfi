package vinnsla;

public class LanguageSettings {
    private static boolean english;

    public static void setEnglish(Boolean englishLang) {
        english = englishLang;
    }

    public static boolean isEnglish() {
        return english;
    }
}
