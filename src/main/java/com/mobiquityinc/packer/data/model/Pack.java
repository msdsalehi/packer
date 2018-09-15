package com.mobiquityinc.packer.data.model;

/**
 * Model class for representing a pack. A pack can afford a limited weight.
 *
 * @author Masoud Salehi Alamdari
 */
public class Pack {

    private Integer maxWeight;

    public Pack(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

    public Pack() {
        this(null);
    }

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }

}
