package com.mobiquityinc.packer.data.repository.impl;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.data.model.PackingScenario;
import com.mobiquityinc.packer.data.serialize.ObjectDeserializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.mobiquityinc.packer.data.repository.Repository;

/**
 * This class is responsible to load the data from a data source. As it is declared in the name of the class, it uses a
 * text file as data source. A deserializer has been used to deserialize the file content. One can send different
 * deserializer for different data format in file.
 *
 * @author Masoud Salehi Alamdari
 */
public class TextFileRepository implements Repository<PackingScenario> {

    /**
     * Gets a file path and a deserializer and loads PackingScenarios from the given file. Consumer can pass different
     * files and deserializers. But the deserializer must have the same Generic type as declared for this class's
     * generic type. This method loads PackingScenarios out of given file using the given deserializer.
     *
     * @param filePath
     * @param deserializer
     * @return List of PackingScenarios exported from the given file
     */
    @Override
    public List<PackingScenario> loadData(String filePath, ObjectDeserializer<PackingScenario> deserializer) {
        List<String> fileLines = readFileLines(filePath);
        return fileLines.stream()
                .map(line -> deserializer.deserialize(line))
                .collect(Collectors.toList());
    }

    /**
     * Responsible for IO task
     * @param filePath
     * @return List of file lines loaded using the given absolute path tothe file
     */
    private List<String> readFileLines(String filePath) {
        Path path = Paths.get(filePath);
        try {
            return Files.readAllLines(path);
        } catch (IOException ex) {
            Logger.getLogger(TextFileRepository.class.getName()).log(Level.SEVERE, "Error loading source file", ex);
            throw new APIException(ex);
        }
    }

}
