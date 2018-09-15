package com.mobiquityinc.packer.data.serialize;

/**
 * This can be implemented for deserialization process of different data formats.
 *
 * @author Masoud Salehi Alamdari
 */
public interface ObjectDeserializer<T> {

    /**
     * Deserialized and extracts Given Data model out of provided String.
     *
     * @param input
     * @return
     */
    T deserialize(String input);
}
