package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.Pack;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenarioMapperTest {

    private PackingScenarioMapper mapper = new PackingScenarioMapper();
    
    @Test
    public void testToDTOs() {
        Pack pack = new Pack(9);
        PackingObject packingObjectFirst = new PackingObject(1, 2, 3);
        PackingObject packingObjectSecond = new PackingObject(2, 3, 4);
        List<PackingObject> packingObjects = new ArrayList<>();
        packingObjects.add(packingObjectFirst);
        packingObjects.add(packingObjectSecond);
        PackingScenario scenario = new PackingScenario();
        scenario.setObjectsToPack(packingObjects);
        scenario.setPack(pack);
        PackingScenarioDTO scenarioDTO = mapper.toDTO(scenario);
        assertNotNull(scenarioDTO);
        assertNotNull(scenarioDTO.getObjectsToPack());
        assertNotNull(scenarioDTO.getPackDTO());
        assertEquals(scenarioDTO.getObjectsToPack().size(), 2);
        assertTrue(scenarioDTO.getObjectsToPack().get(0).getIndex() == 1);
        assertTrue(scenarioDTO.getObjectsToPack().get(1).getWeight()== 3);
        assertTrue(scenarioDTO.getPackDTO().getMaxWeight() == 9);
    }
}
