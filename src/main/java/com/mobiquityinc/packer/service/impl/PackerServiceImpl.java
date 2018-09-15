package com.mobiquityinc.packer.service.impl;

import com.mobiquityinc.exception.APIException;
import com.mobiquityinc.packer.service.dto.PackDTO;
import com.mobiquityinc.packer.service.dto.PackingObjectDTO;
import com.mobiquityinc.packer.service.PackerService;
import java.util.ArrayList;
import java.util.List;

/**
 * Knapsack implementation of the PackService interface. This class uses Knapsack 0-1 algorithm to pack the most
 * valuable objects in the pack regarding to the weight limit of the pack itself. If there are more than one objects
 * having the same value with different weights, the lighter object would be chosen.
 *
 * @author Masoud Salehi Alamdari
 */
public class PackerServiceImpl implements PackerService {

    /**
     * Gets a PackDTO and a list of objects to pack in it regarding to the cost and weight of the objects. The most
     * valuable objects will be chosen and returned regarding to the weight limit of the given pack.
     *
     * @param pack The pack is required to set the weight limit to its maximum affordable weight
     * @param objectsToPack The objects which have to be chosen to be packed or not
     * @return The list of selected packing objects which will be able to be packed in the given PackDTO
     */
    @Override
    public List<PackingObjectDTO> pack(PackDTO pack, List<PackingObjectDTO> objectsToPack) {
        try {
            int totalObjects = objectsToPack.size();
            int weight = pack.getMaxWeight();
            int[][] calculatedMatrix = new int[totalObjects + 1][pack.getMaxWeight() + 1];
            calculateMatrix(totalObjects, calculatedMatrix, weight, objectsToPack);
            List<PackingObjectDTO> selectedItems = findSelectedItems(weight, totalObjects, calculatedMatrix,
                    objectsToPack);
            List<PackingObjectDTO> finalDTOs = replaceWithLigherObjectsIfPossible(selectedItems, objectsToPack);
            return finalDTOs;
        } catch (Exception ex) {
            throw new APIException(ex);
        }
    }

    /**
     * If there are more than one objects having the same value with different weights, the lighter object would be
     * chosen. This method, checks this constraint and replaces the selected objects if required.
     *
     * @param selectedDTOs
     * @param objectsToPack
     * @return final chosen items
     */
    private List<PackingObjectDTO> replaceWithLigherObjectsIfPossible(List<PackingObjectDTO> selectedDTOs,
            List<PackingObjectDTO> objectsToPack) {
        List<PackingObjectDTO> finalDTOs = new ArrayList<>();
        for (PackingObjectDTO selected : selectedDTOs) {
            PackingObjectDTO finalDTO = selected;
            for (PackingObjectDTO objectToPack : objectsToPack) {
                if (!selectedDTOs.contains(objectToPack) && finalDTO.getCost().equals(objectToPack.getCost())) {
                    if (finalDTO.getWeight() > objectToPack.getWeight()) {
                        finalDTO = objectToPack;
                    }
                }
            }
            finalDTOs.add(finalDTO);
        }
        return finalDTOs;
    }

    /**
     * Finds and returns selected items from the given matrix. selected items are the objects which are meant to be
     * packed.
     *
     * @param weight
     * @param totalObjects
     * @param calculatedMatrix
     * @param objectsToPack
     * @return selected items to be packed up
     */
    private List<PackingObjectDTO> findSelectedItems(int weight, int totalObjects, int[][] calculatedMatrix,
            List<PackingObjectDTO> objectsToPack) {
        List<PackingObjectDTO> selectedDTOs = new ArrayList<>();
        int k = weight;
        for (int i = totalObjects; i > 0; i--) {
            if (calculatedMatrix[i][k] != calculatedMatrix[i - 1][k]) {
                selectedDTOs.add(objectsToPack.get(i - 1));
                k = k - objectsToPack.get(i - 1).getWeight();
            }
        }
        return selectedDTOs;
    }

    /**
     * Calculates the matrix of knapsack algorithm. The maximum value which are able to be selected while the sum of
     * selected objects' weight is less than or equal to the weight argument. Items are then extractable from this
     * matrix. This method gets a two-dimensional array as argument and fills it up.
     *
     * @param totalObjects
     * @param calculatedMatrix
     * @param weight
     * @param objectsToPack
     */
    private void calculateMatrix(int totalObjects, int[][] calculatedMatrix, int weight,
            List<PackingObjectDTO> objectsToPack) {
        for (int i = 0; i <= totalObjects; i++) {
            calculatedMatrix[i][0] = 0;
        }
        for (int i = 0; i <= weight; i++) {
            calculatedMatrix[0][i] = 0;
        }
        for (int i = 1; i <= totalObjects; i++) {
            for (int j = 0; j <= weight; j++) {
                if (objectsToPack.get(i - 1).getWeight() > j) {
                    calculatedMatrix[i][j] = calculatedMatrix[i - 1][j];
                } else {
                    final int costWithoutSelectingCurrentItem = calculatedMatrix[i - 1][j];
                    final int costAfterSelectingCurrentItem
                            = calculatedMatrix[i - 1][j - objectsToPack.get(i - 1).getWeight()]
                            + objectsToPack.get(i - 1).getCost();
                    final int newCost = Math.max(costWithoutSelectingCurrentItem, costAfterSelectingCurrentItem);
                    calculatedMatrix[i][j] = newCost;
                }
            }
        }
    }

}
