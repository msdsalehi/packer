package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.Pack;
import com.mobiquityinc.packer.service.dto.PackDTO;

/**
 * Mapper class for converting Packer Model to DTO and vise versa. This is necessary because we have to use different
 * POJOs for data access layer and service layer.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackMapper {

    /**
     * Takes a Pack model and converts it to relevant DTO
     *
     * @param model
     * @return The DTO object having its properties equal to the argument model
     */
    public PackDTO toDTO(Pack model) {
        return new PackDTO(model.getMaxWeight());
    }

    /**
     * Takes a Pack DTO and converts it to relevant model
     *
     * @param dto
     * @return The model object having its properties equal to the argument DTO
     */
    public Pack fromDTO(Pack dto) {
        return new Pack(dto.getMaxWeight());
    }
}
