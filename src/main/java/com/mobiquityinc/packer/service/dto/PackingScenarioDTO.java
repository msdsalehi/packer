package com.mobiquityinc.packer.service.dto;

import java.util.List;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenarioDTO {

    private PackDTO packDTO;
    private List<PackingObjectDTO> objectsToPack;

    public PackDTO getPackDTO() {
        return packDTO;
    }

    public void setPackDTO(PackDTO packDTO) {
        this.packDTO = packDTO;
    }

    public List<PackingObjectDTO> getObjectsToPack() {
        return objectsToPack;
    }

    public void setObjectsToPack(List<PackingObjectDTO> objectsToPack) {
        this.objectsToPack = objectsToPack;
    }
}
