package com.mobiquityinc.packer.service.impl;

import com.mobiquityinc.exception.InvalidMaxItemWeightException;
import com.mobiquityinc.exception.InvalidMaxItemCostException;
import com.mobiquityinc.exception.InvalidMaxItemCountException;
import com.mobiquityinc.exception.InvalidMaxPackWeightException;
import com.mobiquityinc.packer.data.mapper.PackingScenarioMapper;
import com.mobiquityinc.packer.data.model.Pack;
import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.repository.Repository;
import com.mobiquityinc.packer.data.repository.impl.TextFileRepository;
import com.mobiquityinc.packer.data.serialize.impl.PackScenarioDeserializer;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import com.mobiquityinc.packer.validator.impl.PackScenarioValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingScenarioServiceImplTest {

    private PackingScenarioServiceImpl packingScenarioServiceImpl = new PackingScenarioServiceImpl();
    private Repository<PackingScenario> repositoryMock = Mockito.mock(TextFileRepository.class);
    private PackingScenario scenario1 = new PackingScenario();
    private PackingScenario scenario2 = new PackingScenario();
    private PackingScenario scenario3 = new PackingScenario();
    private PackingScenario scenario4 = new PackingScenario();
    private PackingScenario scenario5 = new PackingScenario();

    @Before
    public void loadContext() {
        packingScenarioServiceImpl.setRepository(new TextFileRepository());
        packingScenarioServiceImpl.setDeserializer(new PackScenarioDeserializer());
        packingScenarioServiceImpl.setPackingScenarioMapper(new PackingScenarioMapper());
        packingScenarioServiceImpl.setValidator(new PackScenarioValidator());
    }

    @Before
    public void initializeFirstScenario() {
        PackingObject packingObject1 = new PackingObject(1, 3, 100);
        PackingObject packingObject2 = new PackingObject(2, 2, 20);
        PackingObject packingObject3 = new PackingObject(3, 4, 60);
        PackingObject packingObject4 = new PackingObject(4, 1, 40);
        Pack packFirst = new Pack(1);
        List<PackingObject> packingObjects = new ArrayList<>();
        packingObjects.add(packingObject1);
        packingObjects.add(packingObject2);
        packingObjects.add(packingObject3);
        packingObjects.add(packingObject4);
        scenario1.setObjectsToPack(packingObjects);
        scenario1.setPack(packFirst);
    }

    @Before
    public void initializeSecondScenario() {
        PackingObject packingObject = new PackingObject(1, 3, 100);
        Pack pack = new Pack(20000);
        List<PackingObject> packingObjects = new ArrayList<>();
        packingObjects.add(packingObject);
        scenario2.setObjectsToPack(packingObjects);
        scenario2.setPack(pack);
    }

    @Before
    public void initializeThirdScenario() {
        Pack pack = new Pack(90);
        List<PackingObject> packingObjects = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            packingObjects.add(new PackingObject());
        }
        scenario3.setObjectsToPack(packingObjects);
        scenario3.setPack(pack);
    }

    @Before
    public void initializeFourthScenario() {
        PackingObject packingObject = new PackingObject(1, 300, 100);
        Pack pack = new Pack(90);
        List<PackingObject> packingObjects = new ArrayList<>();
        packingObjects.add(packingObject);
        scenario4.setObjectsToPack(packingObjects);
        scenario4.setPack(pack);
    }

    @Before
    public void initializeFifthScenario() {
        PackingObject packingObject = new PackingObject(1, 30, 10000);
        Pack pack = new Pack(90);
        List<PackingObject> packingObjects = new ArrayList<>();
        packingObjects.add(packingObject);
        scenario5.setObjectsToPack(packingObjects);
        scenario5.setPack(pack);
    }

    @Test
    public void testScenario1() {
        when(repositoryMock.loadData(anyString(), anyObject())).thenReturn(Arrays.asList(scenario1));
        packingScenarioServiceImpl.setRepository(repositoryMock);
        List<PackingScenarioDTO> packingScenarios = packingScenarioServiceImpl.getPackingScenarios("test");
        assertNotNull(packingScenarios);
        assertEquals(packingScenarios.size(), 1);
        assertEquals(packingScenarios.get(0).getObjectsToPack().size(), 4);
        assertEquals(packingScenarios.get(0).getPackDTO().getMaxWeight(), new Integer(1));
        assertEquals(packingScenarios.get(0).getObjectsToPack().get(0).getWeight(), new Integer(3));
        assertEquals(packingScenarios.get(0).getObjectsToPack().get(1).getCost(), new Integer(20));
        assertEquals(packingScenarios.get(0).getObjectsToPack().get(3).getIndex(), new Integer(4));
    }

    @Test(expected = InvalidMaxPackWeightException.class)
    public void wronPacktotalWeight() {
        when(repositoryMock.loadData(anyString(), anyObject())).thenReturn(Arrays.asList(scenario2));
        packingScenarioServiceImpl.setRepository(repositoryMock);
        packingScenarioServiceImpl.getPackingScenarios("test");
    }

    @Test(expected = InvalidMaxItemCountException.class)
    public void wrongMaxItemTotalCount() {
        when(repositoryMock.loadData(anyString(), anyObject())).thenReturn(Arrays.asList(scenario3));
        packingScenarioServiceImpl.setRepository(repositoryMock);
        packingScenarioServiceImpl.getPackingScenarios("test");
    }

    @Test(expected = InvalidMaxItemWeightException.class)
    public void wrongMaxItemWeight() {
        when(repositoryMock.loadData(anyString(), anyObject())).thenReturn(Arrays.asList(scenario4));
        packingScenarioServiceImpl.setRepository(repositoryMock);
        packingScenarioServiceImpl.getPackingScenarios("test");
    }

    @Test(expected = InvalidMaxItemCostException.class)
    public void wrongMaxItemCost() {
        when(repositoryMock.loadData(anyString(), anyObject())).thenReturn(Arrays.asList(scenario5));
        packingScenarioServiceImpl.setRepository(repositoryMock);
        packingScenarioServiceImpl.getPackingScenarios("test");
    }
}
