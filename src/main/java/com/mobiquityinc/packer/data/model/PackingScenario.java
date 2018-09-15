package com.mobiquityinc.packer.data.model;

import java.util.List;

/**
 * Model class for representing a packing scenario object. A packing scenario is a pack plus a list of packing objects.
 * some of these packing objects then will be selected for being packed. This model is required because of the data
 * source (file) format.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenario {

    private Pack pack;
    private List<PackingObject> objectsToPack;

    public PackingScenario() {
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public List<PackingObject> getObjectsToPack() {
        return objectsToPack;
    }

    public void setObjectsToPack(List<PackingObject> objectsToPack) {
        this.objectsToPack = objectsToPack;
    }

}
