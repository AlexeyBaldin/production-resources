package util;


import algorithm.Algorithm;
import algorithm.AlgorithmFactory;
import algorithm.BaseAlgorithm;
import algorithm.model.result.OperationResult;
import generator.GeneratedData;
import generator.Generator;
import generator.GeneratorJsonReader;
import generator.GeneratorParameters;
import parse.input.order.InputOrderInformation;
import parse.input.production.InputProduction;
import parse.output.result.OutputResult;
import parse.input.XMLReader;
import parse.output.XMLWriter;
import testing.ComparisonTester;
import testing.GeneratorTester;
import testing.PossibilityTester;
import testing.RealityTester;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Класс для любых тестов и проверок
 */
public class Trash {

    public static void main(String[] args) throws Exception {

        int threadCount = 3;

        GeneratorParameters generatorParameters = GeneratorJsonReader.readGeneratorParameters("generatorParameters.json");
        ArrayList<GeneratedData> generatedData = Generator.generateData(100, generatorParameters);

        generatedData.forEach(generatedData1 -> {
            if(GeneratorTester.test(generatorParameters, generatedData1) && PossibilityTester.test(generatedData1.getInputProduction(), generatedData1.getInputOrderInformation())) {
                System.out.println("Ура!");
                XMLWriter writer = new XMLWriter();
                writer.writeProductionFile("production.xml", generatedData.get(0).getInputProduction());
                writer.writeOrderInformationFile("orders.xml", generatedData.get(0).getInputOrderInformation());

                Algorithm base = new BaseAlgorithm(generatedData1.getInputProduction(),
                        generatedData1.getInputOrderInformation().getOrders(),
                        LocalDateTime.of(2023, 10, 20, 0, 0), threadCount);
                OutputResult result = null;
                try {
                    result = base.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                writer.writeResultFile("result.xml", result);
                if(RealityTester.test(generatedData1.getInputProduction(), generatedData1.getInputOrderInformation(), result)) {
                    System.out.println("Ура2!");
                } else {
                    System.out.println(":(2");
                }
            } else {
                System.out.println(":(");
            }
        });

        /*XMLReader reader = new XMLReader();
        InputProduction inputProduction = reader.readProductionFile("production.xml");
        InputOrderInformation inputOrderInformation = reader.readOrderFile("orders.xml");
        for (int i = 0; i < 100; i++) {
            if (PossibilityTester.test(inputProduction, inputOrderInformation)) {
                System.out.println("Ура!");
                XMLWriter writer = new XMLWriter();
                Algorithm base = new BaseAlgorithm(inputProduction, inputOrderInformation.getOrders(),
                        LocalDateTime.of(2023, 10, 20, 0, 0));

                OutputResult result = null;
                try {
                    result = base.start();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                //writer.writeResultFile("result.xml", result);
                if (RealityTester.test(inputProduction, inputOrderInformation, result)) {
                    System.out.println("Ура2!");
                } else {
                    System.out.println(":(2");
                }
            } else {
                System.out.println(":(");
            }
        }*/
    }
}
