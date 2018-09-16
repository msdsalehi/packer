package com.mobiquityinc.packer.service.impl;

import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import com.mobiquityinc.packer.service.dto.PackDTO;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackerServiceImplTest {

    private PackerServiceImpl packerService;
    private PackingObjectDTO packingObjectDTO1 = new PackingObjectDTO(1, 3, 100);
    private PackingObjectDTO packingObjectDTO2 = new PackingObjectDTO(2, 2, 20);
    private PackingObjectDTO packingObjectDTO3 = new PackingObjectDTO(3, 4, 60);
    private PackingObjectDTO packingObjectDTO4 = new PackingObjectDTO(4, 1, 40);
    private PackingScenarioDTO firstScenario = new PackingScenarioDTO();
    private PackingScenarioDTO secondScenario = new PackingScenarioDTO();
    private PackingScenarioDTO thirdScenario = new PackingScenarioDTO();

    @Before
    public void createServices() {
        packerService = new PackerServiceImpl();
    }

    @Before
    public void prepareFirstData() {
        PackDTO packFirst = new PackDTO(1);
        PackDTO packSecond = new PackDTO(5);
        PackDTO packThird = new PackDTO(3);
        List<PackingObjectDTO> packingObjects = new ArrayList<>();
        packingObjects.add(packingObjectDTO1);
        packingObjects.add(packingObjectDTO2);
        packingObjects.add(packingObjectDTO3);
        packingObjects.add(packingObjectDTO4);
        firstScenario.setObjectsToPack(packingObjects);
        secondScenario.setObjectsToPack(packingObjects);
        thirdScenario.setObjectsToPack(packingObjects);
        firstScenario.setPackDTO(packFirst);
        secondScenario.setPackDTO(packSecond);
        thirdScenario.setPackDTO(packThird);
    }

    @Test
    public void testPackedItem() {
        List<PackingObjectDTO> packed = packerService.pack(firstScenario.getPackDTO(),
                firstScenario.getObjectsToPack());
        assertTrue(packed.size() == 1);
        assertTrue(packed.get(0).getIndex() == 4);
        int maxCost = getMaxPossibleCost(packed);
        assertTrue(maxCost == 40);
    }

    @Test
    public void testPackedItemsCount() {
        List<PackingObjectDTO> packed = packerService.pack(secondScenario.getPackDTO(),
                secondScenario.getObjectsToPack());
        assertTrue(packed.size() == 2);
    }

    @Test
    public void testMaxPossibleCost() {
        List<PackingObjectDTO> packed = packerService.pack(thirdScenario.getPackDTO(),
                thirdScenario.getObjectsToPack());
        assertTrue(packed.size() == 1);
        int maxCost = getMaxPossibleCost(packed);
        assertTrue(maxCost == 100);
    }

    private int getMaxPossibleCost(List<PackingObjectDTO> packed) {
        int maxCost = 0;
        for (PackingObjectDTO packedObjectDTO : packed) {
            maxCost += packedObjectDTO.getCost();
        }
        return maxCost;
    }
}
