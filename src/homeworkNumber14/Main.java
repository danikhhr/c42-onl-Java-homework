package homeworkNumber14;

import homeworkNumber14.Documents.DocumentsAnalyzer;
import homeworkNumber14.RomeoAndJuliet.FileTextAnalyzer;

public class Main {
    public static void main(String[] args) {
        createFileTextAnalyzer();
        System.out.println("=".repeat(60));
        createDocumentsAnalyzer();
        System.out.println("=".repeat(60));
    }

    public static void createFileTextAnalyzer() {
        FileTextAnalyzer fileTextAnalyzer = new FileTextAnalyzer();
        fileTextAnalyzer.readAndWrite();
    }

    public static void createDocumentsAnalyzer() {
        DocumentsAnalyzer doc = new DocumentsAnalyzer();
        doc.analyzeDocuments();
    }
}
