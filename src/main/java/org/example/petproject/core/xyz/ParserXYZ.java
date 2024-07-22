package org.example.petproject.core.xyz;

import javafx.scene.paint.Color;

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
        LinkedHashMap<String, ArrayList<Atom>> descriptionOfAtoms = new LinkedHashMap<>();
        IntStream.range(2, lines.size()).forEach(indexOfRow -> {
            String typeOfAtom = lines.get(indexOfRow).substring(0, 1);
            List<String> coordinatesAsString = Arrays.asList(lines.get(indexOfRow).substring(2).split(" "));
            Atom atom = new Atom(
                    Double.parseDouble(coordinatesAsString.getFirst()),
                    Double.parseDouble(coordinatesAsString.get(1)),
                    Double.parseDouble(coordinatesAsString.get(2)),
                    Color.BLUE,
                    typeOfAtom
            );
            if (!descriptionOfAtoms.containsKey(typeOfAtom)) {
                var list = new ArrayList<Atom>();
                list.add(atom);
                descriptionOfAtoms.put(typeOfAtom, list);
            } else {
                descriptionOfAtoms.get(typeOfAtom).add(atom);
            }

        });
        return new MoleculeXYZ(Integer.parseInt(lines.getFirst()), lines.get(1), descriptionOfAtoms);
    }

    private static ArrayList<String> readAllLinesOfFile(String pathToXYZ) {
        try {
            return (ArrayList<String>) Files.readAllLines(Path.of(pathToXYZ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
