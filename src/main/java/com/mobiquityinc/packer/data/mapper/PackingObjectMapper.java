package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting PackingObject Model to DTO and vise versa. This is necessary because we have to use different POJOs for
 * data access layer and service layer.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingObjectMapper {

    public PackingObjectDTO toDTO(PackingObject model) {
        return new PackingObjectDTO(model.getIndex(), model.getWeight(), model.getCost());
    }

    /**
     * Takes a PackingObject model and converts it to relevant DTO
     *
     * @param model
     * @return The DTO object having its properties equal to the argument model
     */
    public List<PackingObjectDTO> toDTOs(List<PackingObject> models) {
        return models.stream().map(model -> toDTO(model)).collect(Collectors.toList());
    }

    /**
     * Takes a PackingObject DTO and converts it to relevant model
     *
     * @param dto
     * @return The model object having its properties equal to the argument DTO
     */
    public PackingObject fromDTO(PackingObjectDTO dto) {
        return new PackingObject(dto.getIndex(), dto.getWeight().intValue(), dto.getCost());
    }

}
