import java.io.*;
import java.util.*;
import java.text.*;

public class RoyalRoadR2 extends FitnessFunction {

    public RoyalRoadR2() {
        name = "Royal Road R2 Problem";
    }

    // COMPUTE A CHROMOSOME'S RAW FITNESS *************************************
    public void doRawFitness(Chromo X) {
        // Initialize raw fitness to 0
        X.rawFitness = 0;

        // Define the schemas as per the figure and their respective coefficients
        String[] schemas = {
            "11111111********************************************************",
            "********11111111************************************************",
            "****************11111111****************************************",
            "************************11111111********************************",
            "********************************11111111************************",
            "****************************************11111111****************",
            "************************************************11111111********",
            "********************************************************11111111",
            "1111111111111111************************************************",
            "****************1111111111111111********************************",
            "********************************1111111111111111****************",
            "************************************************1111111111111111",
            "11111111111111111111111111111111********************************",
            "********************************11111111111111111111111111111111"
        };
        int[] coefficients = {8, 8, 8, 8, 8, 8, 8, 8, 16, 16, 16, 16, 32, 32};

        // Calculate the fitness based on schema detection
        for (int i = 0; i < schemas.length; i++) {
            if (detectSchema(X.chromo, schemas[i])) {
                X.rawFitness += coefficients[i];
            }
        }
    }

    private boolean detectSchema(String chromo, String schema) {
        // Ensure we don't go out of bounds for either the chromosome or the schema
        int minLength = Math.min(chromo.length(), schema.length());
        for (int i = 0; i < minLength; i++) {
            // If the schema expects a '1' but the chromosome doesn't have it, return false
            if (schema.charAt(i) == '1' && chromo.charAt(i) != '1') {
                return false; // Schema does not match at this position
            }
        }
        return true; // Schema matches if no mismatches were found
    }
    

    // PRINT OUT AN INDIVIDUAL GENE TO THE SUMMARY FILE *********************************
    public void doPrintGenes(Chromo X, FileWriter output) throws java.io.IOException {
        for (int i = 0; i < Parameters.numGenes; i++) {
            Hwrite.right(X.getGeneAlpha(i), 11, output);
        }
        output.write("   RawFitness");
        output.write("\n        ");
        for (int i = 0; i < Parameters.numGenes; i++) {
            Hwrite.right(X.getPosIntGeneValue(i), 11, output);
        }
        Hwrite.right((int) X.rawFitness, 13, output);
        output.write("\n\n");
        return;
    }
}
