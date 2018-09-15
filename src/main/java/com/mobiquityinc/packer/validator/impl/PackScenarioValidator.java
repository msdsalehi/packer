package com.mobiquityinc.packer.validator.impl;

import com.mobiquityinc.exception.InvalidMaxItemCostException;
import com.mobiquityinc.exception.InvalidMaxItemCountException;
import com.mobiquityinc.exception.InvalidMaxItemWeightException;
import com.mobiquityinc.exception.InvalidMaxPackWeightException;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.util.Restrictions;
import com.mobiquityinc.packer.validator.Validator;
import java.util.Collection;

/**
 * Data validator for PackScenario objects.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackScenarioValidator implements Validator<PackingScenario> {

    @Override
    public void validate(PackingScenario scenario) {
        if (scenario.getPack().getMaxWeight() > Restrictions.getMaxPackageWeight()) {
            throw new InvalidMaxPackWeightException("InvalidMaxPackageWeightException: ["
                    + scenario.getPack().getMaxWeight() + "]");
        }
        if (scenario.getObjectsToPack().size() > Restrictions.getMaxItemsCount()) {
            throw new InvalidMaxItemCountException("InvalidMaxItemCountException: ["
                    + scenario.getObjectsToPack().size() + "]");
        }
        for (PackingObject packingObject : scenario.getObjectsToPack()) {
            if (packingObject.getWeight() > Restrictions.getMaxItemWeight()) {
                throw new InvalidMaxItemWeightException("InvalidMaxItemWeightException: ["
                        + packingObject.getWeight() + "]");
            }
            if (packingObject.getCost() > Restrictions.getMaxItemCost()) {
                throw new InvalidMaxItemCostException("InvalidMaxItemCostException: ["
                        + packingObject.getCost() + "]");
            }
        }
    }

    @Override
    public void validateAll(Collection<PackingScenario> packScenarios) {
        for (PackingScenario packScenario : packScenarios) {
            validate(packScenario);
        }
    }

}
