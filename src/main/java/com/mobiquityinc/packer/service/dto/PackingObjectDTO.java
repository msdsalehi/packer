package com.mobiquityinc.packer.service.dto;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingObjectDTO {

    private Integer index;
    private Integer weight;
    private Integer cost;

    public PackingObjectDTO(Integer index, Integer weight, Integer cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public PackingObjectDTO() {
        this(null, null, null);
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return index + "";
    }

}
