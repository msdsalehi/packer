package com.mobiquityinc.packer.service;

import com.mobiquityinc.packer.service.dto.PackDTO;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import java.util.List;

/**
 * The interface for the service responsible for packing objcts up. different implementations may use different
 * algorithms for packing the objects up.
 *
 * @author Masoud Salehi Alamdari
 */
public interface PackerService {

    /**
     * Gets a PackDTO and a list of objects to pack in it regarding to the cost and weight of the objects. The most
     * valuable objects will be chosen and returned regarding to the weight limit of the given pack.
     *
     * @param pack The pack is required to set the weight limit to its maximum affordable weight
     * @param objectsToPack The objects which have to be chosen to be packed or not
     * @return The list of selected objects which will be packed in the given PackDTO.
     */
    List<PackingObjectDTO> pack(PackDTO pack, List<PackingObjectDTO> objectsToPack);
}
