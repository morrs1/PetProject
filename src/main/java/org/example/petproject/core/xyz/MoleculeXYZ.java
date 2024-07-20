package org.example.petproject.core.xyz;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public record MoleculeXYZ(Integer amountOfAtoms, String descriptionOfMolecule,
                          LinkedHashMap<String, ArrayList<ArrayList<Double>>> descriptionOfAtoms) {
}
