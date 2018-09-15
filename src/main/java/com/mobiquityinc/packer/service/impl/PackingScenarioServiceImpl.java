package com.mobiquityinc.packer.service.impl;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.data.mapper.PackingScenarioMapper;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.repository.Repository;
import com.mobiquityinc.packer.data.serialize.ObjectDeserializer;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import java.util.List;
import com.mobiquityinc.packer.service.PackingScenarioService;
import com.mobiquityinc.packer.validator.Validator;

/**
 * This is a composite service responsible for providing data from data repository, providing it with the appropriate
 * deserializer. Also it validates the loaded data using a validator object.
 *
 * If someone decides to use this project as a service and use data provided by client, this class can be omitted.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenarioServiceImpl implements PackingScenarioService {

    private PackingScenarioMapper packingScenarioMapper;
    private Repository<PackingScenario> repository;
    private ObjectDeserializer<PackingScenario> deserializer;
    private Validator<PackingScenario> validator;

    /**
     * Loads the packing scenarios out of a data source. It uses the relevant repository to load date, a deserializer to
     * transform data as objects and a validator for data validation.
     *
     * @param sourcePath The absolute path to a file name or different formats for other types of data source
     * @return The list of packing scenarios loaded from data source
     * @throws APIException in case of data restriction violations
     */
    @Override
    public List<PackingScenarioDTO> getPackingScenarios(String sourcePath) throws APIException {
        List<PackingScenario> packScenarios = repository.loadData(sourcePath, deserializer);
        validator.validateAll(packScenarios);
        return packingScenarioMapper.toDTOs(packScenarios);
    }

    public void setRepository(Repository<PackingScenario> repository) {
        this.repository = repository;
    }

    public void setDeserializer(ObjectDeserializer<PackingScenario> deserializer) {
        this.deserializer = deserializer;
    }

    public void setPackingScenarioMapper(PackingScenarioMapper packingScenarioMapper) {
        this.packingScenarioMapper = packingScenarioMapper;
    }

    public void setValidator(Validator<PackingScenario> validator) {
        this.validator = validator;
    }

}
