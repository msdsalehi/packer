package com.mobiquityinc.packer.data.mapper;

import com.mobiquityinc.packer.data.model.Pack;
import com.mobiquityinc.packer.service.dto.PackDTO;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackMapperTest {

    private PackMapper mapper = new PackMapper();

    @Test
    public void testFromDTO() {
        Pack dto = new Pack(9);
        Pack model = mapper.fromDTO(dto);
        assertNotNull(model);
        assertEquals(dto.getMaxWeight(), model.getMaxWeight());
    }

    @Test
    public void testToDTO() {
        Pack model = new Pack(9);
        PackDTO dto = mapper.toDTO(model);
        assertNotNull(model);
        assertEquals(model.getMaxWeight(), dto.getMaxWeight());
    }
}
