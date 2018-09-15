package com.mobiquityinc.packer.data.repository;

import com.mobiquityinc.packer.data.serialize.ObjectDeserializer;
import java.util.List;

/**
 * Implementations of this interface are responsible for loading data out of a data source. Data model, can be defined
 * as a generic type and different source path can be passed while calling the loadData method. It then returns the list
 * of models exported from given datasource.
 *
 * @author Masoud Salehi Alamdari
 */
public interface Repository<T> {

    /**
     * Loads data out of a data source accessed using the given sourcePath. A deserializer is required to deserialize
     * the data to specific model objects.
     *
     * @param sourcePath
     * @param deserializer
     * @return List of exported data models from the file
     */
    List<T> loadData(String sourcePath, ObjectDeserializer<T> deserializer);
}
