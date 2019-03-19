package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.common.configuration.BaseTestRunner;
import br.com.dextra.hamburgueria.common.enumerable.ConfigurationCatalog;
import br.com.dextra.hamburgueria.common.util.JSONUtil;
import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class responsible for testing all existing {@link PromotionCalculatorService}.
 *
 * @author rafaelcustodio
 */
public class PromotionCalculatorServiceTest extends BaseTestRunner {

    /**
     * Defines the allowed delta between the final result obtained from the discount calculation and the expected.
     */
    private static final double ALLOWED_DELTA_RESULT = 0.1;

    @Autowired
    @Qualifier("lightPromotionCalculatorServiceImpl")
    private PromotionCalculatorService lightPromotionCalculatorService;

    @Autowired
    @Qualifier("highAmountMeatPromotionCalculatorServiceImpl")
    private PromotionCalculatorService highAmountMeatPromotionCalculatorService;

    @Autowired
    @Qualifier("highAmountCheesePromotionCalculatorServiceImpl")
    private PromotionCalculatorService highAmountCheesePromotionCalculatorService;

    @Test
    public void testIngredientsMatchForLightPromotion() throws IOException {
        Assert.assertEquals(0.42, this.lightPromotionCalculatorService.getDiscount(this.buildLightPromotionMock()), ALLOWED_DELTA_RESULT);
    }

    @Test
    public void testEmptyIngredientMatchForLightPromotion() {
        Assert.assertEquals(0.0, this.lightPromotionCalculatorService.getDiscount(Collections.emptyList()), ALLOWED_DELTA_RESULT);
    }

    @Test
    public void testIngredientsMatchForHighAmountOfMeatPromotion() throws IOException {
        Assert.assertEquals(3.06, this.highAmountMeatPromotionCalculatorService.getDiscount(this.buildHighAmountOfMeatPromotionMock()), ALLOWED_DELTA_RESULT);
    }

    @Test
    public void testEmptyIngredientMatchForHighAmountOfMeatPromotion() {
        Assert.assertEquals(0.0, this.highAmountMeatPromotionCalculatorService.getDiscount(Collections.emptyList()), ALLOWED_DELTA_RESULT);
    }

    @Test
    public void testIngredientsMatchForHighAmountOfCheesePromotion() throws IOException {
        Assert.assertEquals(1.53, this.highAmountCheesePromotionCalculatorService.getDiscount(this.buildHighAmountOfCheesePromotionMock()), ALLOWED_DELTA_RESULT);
    }

    @Test
    public void testEmptyIngredientMatchForHighAmountOfCheesePromotion() {
        Assert.assertEquals(0.0, this.highAmountCheesePromotionCalculatorService.getDiscount(Collections.emptyList()), ALLOWED_DELTA_RESULT);
    }

    /**
     * Create a list of ingredients that match a high amount of cheese promotion specification.
     * @return The created list.
     * @throws IOException Error while reading the base files.
     */
    private List<IngredientDTO> buildHighAmountOfCheesePromotionMock() throws IOException {

        // Get the mocked information for a cheese ingredient.
        final IngredientDTO cheese = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.CHEESE_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));

        return Arrays.asList(cheese,cheese,cheese);
    }

    /**
     * Create a list of ingredients that match a high amount of meat promotion specification.
     * @return The created list.
     * @throws IOException Error while reading the base files.
     */
    private List<IngredientDTO> buildHighAmountOfMeatPromotionMock() throws IOException {

        // Get the mocked information for a meat ingredient.
        final IngredientDTO meat = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.MEAT_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));

        return Arrays.asList(meat,meat,meat);
    }

    /**
     * Create a list of ingredients that match a light promotion specification.
     * @return The created list.
     * @throws IOException Error while reading the base files.
     */
    private List<IngredientDTO> buildLightPromotionMock() throws IOException {

        // Get the mocked information for a lettuce ingredient.
        final IngredientDTO lettuce = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.LETTUCE_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));

        // Get the mocked information for a meat ingredient.
        final IngredientDTO meat = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.MEAT_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));

        // Get the mocked information for a meat ingredient.
        final IngredientDTO egg = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.EGG_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));

        return Arrays.asList(lettuce,meat,egg);
    }
}