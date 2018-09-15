package com.mobiquityinc.packer;

import java.net.URL;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class PackerTest {
    
    @Test
    public void test(){
        URL url = Thread.currentThread().getContextClassLoader().getResource(
                "com/mobiquityinc/packer/data/repository/impl/test-data.txt");
        String packed = Packer.pack(url.getPath());
        String[] split = packed.split("\n");
        assertEquals(split[0], "4");
        assertEquals(split[1], "-");
        assertEquals(split[2], "7, 2");
        assertEquals(split[3], "9, 8");
    }
}
