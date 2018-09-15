package com.mobiquityinc.packer.data.model;

/**
 * Model class for representing a packing object. A packing object is the object which is being packed. Every object has
 * an index, a specific weight and cost.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingObject {

    private Integer index;
    private Integer weight;
    private Integer cost;

    public PackingObject(Integer index, Integer weight, Integer cost) {
        this.index = index;
        this.weight = weight;
        this.cost = cost;
    }

    public PackingObject() {
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
