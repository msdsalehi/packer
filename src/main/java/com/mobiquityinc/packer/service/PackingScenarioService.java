package com.mobiquityinc.packer.service;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import java.util.List;

/**
 * Implementations of this interface are responsible to provide data for batch execution scenarios to be to be used for
 * packer service.
 *
 *
 * @author Masoud Salehi Alamdari
 */
public interface PackingScenarioService {

    /**
     * Loads the packing scenarios out of a data source.
     *
     * @param sourcePath The absolute path to a file name or different formats for other types of data source
     * @return The list of packing scenarios loaded from data source
     * @throws APIException in case of data restriction violations
     */
    List<PackingScenarioDTO> getPackingScenarios(String sourcePath) throws APIException;
}
