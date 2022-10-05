package fr.liva.language;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class Language {

    public static final Map<LanguageKeys, Language> langue = new HashMap<>();

    private final String en;
    private final String fr;

    public static void addKey(LanguageKeys key, Language language) {
        langue.put(key, language);
    }

}
