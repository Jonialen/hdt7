package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        try {
            File dictionaryFile = new File("src\\main\\resources\\diccionario.txt");
            Scanner scanner = new Scanner(dictionaryFile, "utf-8");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                line = line.replaceAll("[()]", "");
                String[] parts = line.split(",");
                String english = parts[0].trim();
                String spanish = parts[1].trim();
                dictionary.insert(english, spanish);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo 'diccionario.txt' no se encontró.");
            return;
        }

        System.out.println("Diccionario ordenado por palabra en inglés:");
        dictionary.inOrder();

        try {
            File textFile = new File("src\\main\\resources\\texto.txt");
            Scanner scanner = new Scanner(textFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().toLowerCase();
                String translatedLine = "";

                String[] words = line.split(" ");
                for (String word : words) {
                    String cleanedWord = word.replaceAll("[^a-z]", "").toLowerCase();
                    if (!cleanedWord.isEmpty()) {
                        String translatedWord = dictionary.search(cleanedWord);

                        if (translatedWord != null) {
                            translatedLine += translatedWord + " ";
                        } else {
                            translatedLine += "*" + word + "* ";
                        }
                    } else {
                        translatedLine += " ";
                    }
                }

                System.out.println(translatedLine.trim());
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo 'texto.txt' no se encontró.");
        }
    }
}
