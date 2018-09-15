package com.mobiquityinc.packer.util;

import java.util.Collection;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class Empty {

    public static boolean isEmpty(Object obj) {
        return obj == null;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
