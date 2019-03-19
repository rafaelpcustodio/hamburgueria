package br.com.dextra.hamburgueria.webapp.service.impl;

import br.com.dextra.hamburgueria.webapp.dto.ConfigurationDTO;
import br.com.dextra.hamburgueria.webapp.dto.IngredientDTO;
import br.com.dextra.hamburgueria.webapp.dto.RequestDTO;
import br.com.dextra.hamburgueria.webapp.enumerable.ConfigurationCode;
import br.com.dextra.hamburgueria.webapp.mapper.ClientMapper;
import br.com.dextra.hamburgueria.webapp.mapper.RequestMapper;
import br.com.dextra.hamburgueria.webapp.model.Request;
import br.com.dextra.hamburgueria.webapp.repository.RequestRepository;
import br.com.dextra.hamburgueria.webapp.service.ConfigurationService;
import br.com.dextra.hamburgueria.webapp.service.PromotionCalculatorService;
import br.com.dextra.hamburgueria.webapp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Service responsible for handling operations associated to a {@link Request}.
 *
 * @author rafaelcustodio
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private List<PromotionCalculatorService> promotionCalculatorServices;

    @Override
    public List<RequestDTO> findAll() {
        return RequestMapper.entityToDTO(this.requestRepository.findAll());
    }

    @Override
    public RequestDTO findOne(final Long id) {
        return RequestMapper.entityToDTO(this.requestRepository.findOne(id));
    }

    @Override
    public RequestDTO save(final RequestDTO request) {

        // Applies the discount.
        this.applyDiscount(request);

        final Request requestToPersist = RequestMapper.dtoToEntity(request);
        requestToPersist.setClient(ClientMapper.dtoToEntity(request.getClient()));

        return RequestMapper.entityToDTO(this.requestRepository.save(requestToPersist));
    }

    @Override
    public void delete(final Long id) {
        this.requestRepository.delete(id);
    }

    /**
     * Applies the discount into the final price for the request according to the matched criteria.
     * @param request The request to be applied the discount.
     */
    private void applyDiscount(final RequestDTO request) {

        // Get the discount according to the matched criteria.
        final double discount = this.promotionCalculatorServices.stream()
                .mapToDouble(promotionCalculatorService -> promotionCalculatorService.getDiscount(request.getIngredients()))
                .sum();

        // Sum the prices of all ingredients associated to the request.
        final double totalPrice = request.getIngredients().stream().mapToDouble(IngredientDTO::getPrice).sum();

        // Defines the final price.
        final ConfigurationDTO inflation = configurationService.findByCode(ConfigurationCode.INFLATION);
        final double finalPrice = (totalPrice - discount) * (1 + Double.valueOf(inflation.getValue()));
        request.setTotal(finalPrice);
    }
}