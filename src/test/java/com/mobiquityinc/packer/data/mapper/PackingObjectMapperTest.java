package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.PackingObject;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackingObjectMapperTest {

    PackingObjectMapper mapper = new PackingObjectMapper();

    @Test
    public void testFromDTO() {
        PackingObjectDTO dto = new PackingObjectDTO(1, 2, 3);
        PackingObject model = mapper.fromDTO(dto);
        assertNotNull(model);
        assertEquals(dto.getCost(), model.getCost());
        assertEquals(dto.getIndex(), model.getIndex());
        assertEquals(dto.getWeight(), model.getWeight());
    }

    @Test
    public void testToDTO() {
        PackingObject model = new PackingObject(3, 2, 1);
        PackingObjectDTO dto = mapper.toDTO(model);
        assertNotNull(dto);
        assertEquals(model.getCost(), dto.getCost());
        assertEquals(model.getIndex(), dto.getIndex());
        assertEquals(model.getWeight(), dto.getWeight());
    }
}
