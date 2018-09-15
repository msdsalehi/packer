package com.mobiquityinc.packer.service.dto;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackDTO {

    private Integer maxWeight;

    public PackDTO(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public PackDTO() {
        this(null);
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

}
