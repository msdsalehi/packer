package com.mobiquityinc.packer;

import com.mobiquityinc.packer.data.mapper.PackingScenarioMapper;
import com.mobiquityinc.packer.data.repository.impl.TextFileRepository;
import com.mobiquityinc.packer.data.serialize.impl.PackScenarioDeserializer;
import com.mobiquityinc.packer.service.dto.PackingScenarioDTO;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import com.mobiquityinc.packer.service.PackerService;
import com.mobiquityinc.packer.service.impl.PackingScenarioServiceImpl;
import com.mobiquityinc.packer.service.impl.PackerServiceImpl;
import com.mobiquityinc.packer.util.Empty;
import java.util.List;
import com.mobiquityinc.packer.service.PackingScenarioService;
import com.mobiquityinc.packer.validator.impl.PackScenarioValidator;

/**
 *
 * @author Masoud Salehi Alamdari
 */
public class Packer {

    private static PackingScenarioService packingScenarioService;
    private static PackerService packerService;

    static {
        loadContext();
    }

    public static String pack(String inputFilePath) {
        StringBuilder result = new StringBuilder();
        List<PackingScenarioDTO> packingScenarios = packingScenarioService.getPackingScenarios(inputFilePath);
        packingScenarios.stream().forEach(packScenario -> {
            List<PackingObjectDTO> packedObjects = packerService.pack(packScenario.getPackDTO(),
                    packScenario.getObjectsToPack());
            appendToResult(result, packedObjects);
        });
        return result.toString();
    }

    private static void appendToResult(StringBuilder result, List<PackingObjectDTO> packedObjects) {
        if (Empty.isEmpty(packedObjects)) {
            result.append("-");
        } else {
            String packedThingsStr = packedObjects.toString();
            result.append(packedThingsStr.substring(1, packedThingsStr.length() - 1));
        }
        result.append("\n");
    }
    
    private static void loadContext(){
        packingScenarioService = new PackingScenarioServiceImpl();
        final PackingScenarioServiceImpl scenarioService = (PackingScenarioServiceImpl) packingScenarioService;
        scenarioService.setRepository(new TextFileRepository());
        scenarioService.setDeserializer(new PackScenarioDeserializer());
        scenarioService.setPackingScenarioMapper(new PackingScenarioMapper());
        scenarioService.setValidator(new PackScenarioValidator());
        packerService = new PackerServiceImpl();
    }

}
