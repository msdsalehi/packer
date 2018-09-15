package com.mobiquityinc.packer.data.serialize.impl;

import com.mobiquityinc.packer.data.model.Pack;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.data.serialize.ObjectDeserializer;
import java.util.ArrayList;
import java.util.List;

/**
 * A specific implementation of ObjectDeserializer which is responsible for deserializing PackingScenarios out of a
 * given String
 *
 * @author Masoud Salehi Alamdari
 */
public class PackScenarioDeserializer implements ObjectDeserializer<PackingScenario> {

    private final static Integer FLOATING_POINTS_REMOVING_FACTOR = 100;

    /**
     * Deserializes and extracts PackingScenario models out of given String.
     *
     * @param input
     * @return
     */
    @Override
    public PackingScenario deserialize(String input) {
        PackingScenario packScenario = new PackingScenario();
        packScenario.setPack(deserializePack(input));
        packScenario.setObjectsToPack(deserializePackingObjects(input));
        return packScenario;
    }

    private Pack deserializePack(String input) {
        Pack pack = new Pack();
        String packMaxWeight = input.split(":")[0].trim();
        pack.setMaxWeight(Integer.parseInt(packMaxWeight) * FLOATING_POINTS_REMOVING_FACTOR);
        return pack;
    }

    private List<PackingObject> deserializePackingObjects(String input) {
        String packObjectsInput = input.split(":")[1];
        List<PackingObject> packingObjects = new ArrayList<>();
        String[] parts = packObjectsInput.split("[)][\\s]*[(]");
        for (String part : parts) {
            part = part.replaceAll("[)(]", "");
            packingObjects.add(deserializePackingObject(part));
        }
        return packingObjects;
    }

    private PackingObject deserializePackingObject(String input) {
        final PackingObject packingObject = new PackingObject();
        String[] parts = input.split(",");
        packingObject.setIndex(Integer.parseInt(parts[0].trim()));
        Float weight = Float.parseFloat(parts[1].trim()) * FLOATING_POINTS_REMOVING_FACTOR;
        packingObject.setWeight(weight.intValue());
        packingObject.setCost(Integer.parseInt(parts[2].replaceAll("[\\D]", "")));
        return packingObject;
    }
}
