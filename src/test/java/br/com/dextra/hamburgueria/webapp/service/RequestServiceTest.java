package br.com.dextra.hamburgueria.webapp.service;

import br.com.dextra.hamburgueria.common.configuration.BaseTestRunner;
import br.com.dextra.hamburgueria.common.enumerable.ConfigurationCatalog;
import br.com.dextra.hamburgueria.common.util.JSONUtil;
import br.com.dextra.hamburgueria.webapp.dto.ClientDTO;
import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.dto.RequestDTO;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;

/**
 * Class responsible for testing all existing {@link RequestService}.
 *
 * @author rafaelcustodio
 */
public class RequestServiceTest extends BaseTestRunner {

    @Autowired
    private RequestService requestService;

    @Test
    public void testSaveValidClientRequest() throws IOException {
        final RequestDTO clientRequest = this.requestService.save(this.buildClientRequestMock());
        Assert.assertEquals(6.20, clientRequest.getTotal(), 0.1);
    }

    /**
     * Create a mock of a client request used to for the unit tests.
     * @return The mocked client request.
     * @throws IOException Error while reading the files from the test resources.
     */
    private RequestDTO buildClientRequestMock() throws IOException {

        final RequestDTO clientRequest = new RequestDTO();

        // Get the mocked information for a client associated to the request.
        final ClientDTO client = (ClientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.DEFAULT_CLIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(ClientDTO.class));
        clientRequest.setClient(client);

        // Get the mocked information for a meat ingredient.
        final IngredientDTO meat = (IngredientDTO) JSONUtil
                .fileToBean(ConfigurationCatalog.MEAT_INGREDIENT_FILE.getValue(),
                        TypeFactory.defaultInstance().constructType(IngredientDTO.class));
        clientRequest.setIngredients(Arrays.asList(meat,meat,meat));

        return clientRequest;
    }
}