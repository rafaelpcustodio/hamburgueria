package br.com.dextra.hamburgueria.common.enumerable;

/**
 * Catalog with all main information used by the unit tests.
 *
 * @author rafaelcustodio
 */
public enum ConfigurationCatalog {

    COMMON_BASE_DIRECTORY("/common"),

    CLIENT_BASE_DIRECTORY(COMMON_BASE_DIRECTORY.getValue() + "/client"),

    DEFAULT_CLIENT_FILE(CLIENT_BASE_DIRECTORY.getValue() + "/default-client.json"),

    INGREDIENT_BASE_DIRECTORY(COMMON_BASE_DIRECTORY.getValue() + "/ingredient"),

    BACON_INGREDIENT_FILE(INGREDIENT_BASE_DIRECTORY.getValue() + "/bacon-ingredient.json"),

    CHEESE_INGREDIENT_FILE(INGREDIENT_BASE_DIRECTORY.getValue() +  "/cheese-ingredient.json"),

    EGG_INGREDIENT_FILE(INGREDIENT_BASE_DIRECTORY.getValue() +  "/egg-ingredient.json"),

    LETTUCE_INGREDIENT_FILE(INGREDIENT_BASE_DIRECTORY.getValue() +  "/lettuce-ingredient.json"),

    MEAT_INGREDIENT_FILE(INGREDIENT_BASE_DIRECTORY.getValue() +  "/meat-ingredient.json");

    private String value;

    ConfigurationCatalog(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
