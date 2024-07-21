package org.example.petproject.core.xyz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;

public class ParserXYZ {
    public static MoleculeXYZ parseXYZ(String pathToXYZ) {
        ArrayList<String> lines = readAllLinesOfFile(pathToXYZ);
        LinkedHashMap<String, ArrayList<ArrayList<Double>>> descriptionOfAtoms = new LinkedHashMap<>();
        IntStream.range(2, lines.size()).forEach(indexOfRow -> {
            String typeOfAtom = lines.get(indexOfRow).substring(0, 1);
            List<String> coordinatesAsString = Arrays.asList(lines.get(indexOfRow).substring(2).split(" "));
            ArrayList<Double> coordinates = new ArrayList<>();
            coordinatesAsString.forEach(coordinate -> coordinates.add(Double.parseDouble(coordinate)));
            if (!descriptionOfAtoms.containsKey(typeOfAtom)) {
                var list = new ArrayList<ArrayList<Double>>();
                list.add(coordinates);
                descriptionOfAtoms.put(typeOfAtom, list);
            } else {
                descriptionOfAtoms.get(typeOfAtom).add(coordinates);
            }

        });
        return new MoleculeXYZ(Integer.parseInt(lines.getFirst()), lines.get(1), descriptionOfAtoms);
    }

    private static ArrayList<String> readAllLinesOfFile(String pathToXYZ){
        try {
            return  (ArrayList<String>) Files.readAllLines(Path.of(pathToXYZ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
