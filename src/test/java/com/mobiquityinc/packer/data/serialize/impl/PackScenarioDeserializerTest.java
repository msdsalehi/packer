package com.mobiquityinc.packer.data.serialize.impl;

import com.mobiquityinc.packer.data.model.PackingScenario;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackScenarioDeserializerTest {

    private PackScenarioDeserializer deserializer;

    @Before
    public void initialize() {
        deserializer = new PackScenarioDeserializer();
    }

    @Test
    public void scenarioFirst() {
        String scenario = "81 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9) (6,46.34,€48)";
        PackingScenario deserialized = deserializer.deserialize(scenario);
        assertNotNull(deserialized.getPack());
        assertNotNull(deserialized.getObjectsToPack());
        assertTrue(deserialized.getPack().getMaxWeight() == 8100);
        assertTrue(deserialized.getObjectsToPack().size() == 6);
        assertEquals(new Integer(76), deserialized.getObjectsToPack().get(3).getCost());
        assertEquals(new Integer(7848), deserialized.getObjectsToPack().get(2).getWeight());
        assertEquals(new Integer(6), deserialized.getObjectsToPack().get(5).getIndex());
    }

    @Test
    public void scenarioSecond() {
        String scenario = "75 : (1,85.31,€29) (2,14.55,€74) (3,3.98,€16) (4,26.24,€55) (5,63.69,€52) "
                + "(6,76.25,€75) (7,60.02,€74) (8,93.18,€35) (9,89.95,€78)";
        PackingScenario deserialized = deserializer.deserialize(scenario);
        assertNotNull(deserialized.getPack());
        assertNotNull(deserialized.getObjectsToPack());
        assertTrue(deserialized.getPack().getMaxWeight() == 7500);
        assertTrue(deserialized.getObjectsToPack().size() == 9);
        assertEquals(new Integer(55), deserialized.getObjectsToPack().get(3).getCost());
        assertEquals(new Integer(6002), deserialized.getObjectsToPack().get(6).getWeight());
        assertEquals(new Integer(9), deserialized.getObjectsToPack().get(8).getIndex());
    }

}
