package com.mobiquityinc.packer.data.repository.impl;

import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.serialize.impl.PackScenarioDeserializer;
import java.net.URL;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class TextFileRepositoryTest {
    
    private TextFileRepository fileRepository = new TextFileRepository();
    
    @Test
    public void test(){
        URL url = Thread.currentThread().getContextClassLoader().getResource(
                "com/mobiquityinc/packer/data/repository/impl/test-data.txt");
        List<PackingScenario> data = fileRepository.loadData(url.getPath(), new PackScenarioDeserializer());
        assertNotNull(data);
        assertTrue(data.size() == 4);
        assertEquals(data.get(0).getPack().getMaxWeight(), new Integer(8100));
        assertEquals(data.get(3).getPack().getMaxWeight(), new Integer(5600));
        assertTrue(data.get(3).getObjectsToPack().size() == 9);
        assertTrue(data.get(3).getObjectsToPack().get(0).getWeight() == 9072);
        assertTrue(data.get(2).getObjectsToPack().get(1).getCost() == 74);
        assertTrue(data.get(0).getObjectsToPack().get(2).getIndex()== 3);
    }
}
