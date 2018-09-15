package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting PackingScenario Model to DTO. 
 * This is necessary because we have to use different POJOs for data access layer and service layer.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenarioMapper {

    private PackMapper packMapper = new PackMapper();
    private PackingObjectMapper packingObjectMapper = new PackingObjectMapper();

    /**
     * Takes a PackingScenario model and converts it to relevant DTO
     *
     * @param model
     * @return The DTO object having its properties equal to the argument model
     */
    public PackingScenarioDTO toDTO(PackingScenario challenge) {
        PackingScenarioDTO challengeDTO = new PackingScenarioDTO();
        challengeDTO.setPackDTO(packMapper.toDTO(challenge.getPack()));
        challengeDTO.setObjectsToPack(packingObjectMapper.toDTOs(challenge.getObjectsToPack()));
        return challengeDTO;
    }

    /**
     * Takes a PackingScenario DTO and converts it to relevant model
     *
     * @param dto
     * @return The model object having its properties equal to the argument DTO
     */
    public List<PackingScenarioDTO> toDTOs(List<PackingScenario> challenges) {
        return challenges.stream().map(challenge -> toDTO(challenge)).collect(Collectors.toList());
    }
}
