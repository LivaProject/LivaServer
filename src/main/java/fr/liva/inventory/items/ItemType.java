package fr.liva.inventory.items;

import fr.liva.language.LanguageKeys;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ItemType {

    SWORD(LanguageKeys.SWORD),
    PICKAXE(LanguageKeys.PICKAXE),

    WOOD(LanguageKeys.WOOD),
    STONE(LanguageKeys.STONE);

    private final LanguageKeys name;


}
