package com.mobiquityinc.packer.util;

import com.mobiquityinc.packer.validator.impl.PackScenarioValidator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author masoud
 */
public class Restrictions {

    private static Properties props = new Properties();

    static {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            InputStream resourceAsStream = systemClassLoader.getResourceAsStream("restrictions.properties");
            props.load(resourceAsStream);
        } catch (IOException ex) {
            Logger.getLogger(PackScenarioValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Integer getMaxPackageWeight() {
        return Integer.parseInt(props.getProperty("max_package_weight"));
    }

    public static Integer getMaxItemsCount() {
        return Integer.parseInt(props.getProperty("max_items_count"));
    }

    public static Integer getMaxItemWeight() {
        return Integer.parseInt(props.getProperty("max_item_weight"));
    }

    public static Integer getMaxItemCost() {
        return Integer.parseInt(props.getProperty("max_item_cost"));
    }
}
