import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaDocParser {

    public static void main(String[] args) {
        // Path to the directory containing JavaDoc HTML files
        File docDirectory = new File("./docs");

        if (!docDirectory.exists() || !docDirectory.isDirectory()) {
            System.err.println("Error: The 'docs' directory does not exist or is not a directory.");
            return;
        }

        // Map to store class information
        Map<String, String> classMap = new ConcurrentHashMap<>();

        // Use a thread pool to process files concurrently
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        recursivelyProcessFiles(docDirectory, classMap, executor);

        // Shutdown the executor and wait for all tasks to complete
        executor.shutdown();
        try {
            executor.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES); // Wait up to 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Debugging output to verify map is populated
        System.out.println("Class Map Size: " + classMap.size());

        // Write the class map to a JSON file
        writeMapToJson(classMap, "class_map.json");

        // Preprocess embeddings using preprocess.py (optional, run this once)
        try {
            preprocessPythonScript("preprocess.py");
            System.out.println("Preprocessing completed successfully.");
        } catch (Exception e) {
            System.err.println("Error during preprocessing: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        // Query the user for input
        System.out.println("Enter your search query:");
        String query = new java.util.Scanner(System.in).nextLine();

        // Call the Python query script for text retrieval
        try {
            String pythonScriptPath = "query.py"; // Ensure this matches the actual location of the script
            String result = executePythonScript(pythonScriptPath, query);
            System.out.println("Relevant Results:\n" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void recursivelyProcessFiles(File dir, Map<String, String> classMap, ExecutorService executor) {
        if (!dir.isDirectory()) {
            return;
        }

        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                recursivelyProcessFiles(file, classMap, executor);
            } else if (file.getName().endsWith(".html") && !file.getName().equals("index.html")) {
                // Exclude irrelevant files like index.html
                executor.submit(() -> {
                    try {
                        processFile(file, classMap);
                    } catch (Exception e) {
                        System.err.println("Error processing file: " + file.getAbsolutePath());
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    private static void processFile(File file, Map<String, String> classMap) throws Exception {
        System.out.println("Processing file: " + file.getName());

        Document doc = Jsoup.parse(file, "UTF-8");

        String className = extractClassName(doc);
        String classDescription = extractClassDescription(doc);

        if (!className.isEmpty() && !classDescription.isEmpty()) {
            classMap.put(className, classDescription);
            System.out.println("Parsed class: " + className + " - " + classDescription);
        } else {
            System.out.println("No class information found in file: " + file.getName());
        }
    }

    private static String extractClassName(Document doc) {
        Element titleElement = doc.selectFirst("h1.title, h1.typeNameLabel");
        return (titleElement != null) ? titleElement.text() : "";
    }

    private static String extractClassDescription(Document doc) {
        Element descriptionElement = doc.selectFirst("div.block, div.description");
        return (descriptionElement != null) ? descriptionElement.text() : "";
    }

    private static void writeMapToJson(Map<String, String> map, String filename) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(map);
            Files.write(Paths.get(filename), json.getBytes());
            System.out.println("Wrote " + map.size() + " entries to " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void preprocessPythonScript(String scriptPath) throws Exception {
        // Use the Miniconda Python executable path
        String pythonCommand = "C:\\Users\\hinna\\Miniconda3\\python.exe";

        System.out.println("Executing Preprocessing Python script: " + scriptPath);
        System.out.println("Python command: " + pythonCommand);
        System.out.println("Full command: " + pythonCommand + " " + scriptPath + " class_map.json");

        ProcessBuilder processBuilder = new ProcessBuilder(pythonCommand, scriptPath, "class_map.json");
        processBuilder.redirectErrorStream(true); // Redirect error stream to standard output
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();
        StringBuilder errorOutput = new StringBuilder();

        // Capture standard output
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        // Capture error output
        try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                errorOutput.append(errorLine).append("\n");
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Preprocessing Python script failed with exit code " + exitCode);
            System.err.println("Python Output: " + output.toString());
            System.err.println("Python Errors: " + errorOutput.toString());
            throw new RuntimeException("Preprocessing Python script failed with exit code " + exitCode + ". Check the script for errors.");
        }
    }

    private static String executePythonScript(String scriptPath, String query) throws Exception {
        // Use the Miniconda Python executable path
        String pythonCommand = "C:\\Users\\hinna\\Miniconda3\\python.exe";

        System.out.println("Executing Python query script: " + scriptPath);
        System.out.println("Python command: " + pythonCommand);
        System.out.println("Full command: " + pythonCommand + " " + scriptPath + " " + query + " class_map.json");

        // Pass only two arguments: <query> and <class_map_file>
        ProcessBuilder processBuilder = new ProcessBuilder(pythonCommand, scriptPath, query, "class_map.json");
        processBuilder.redirectErrorStream(true); // Redirect error stream to standard output
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();
        StringBuilder errorOutput = new StringBuilder();

        // Capture standard output
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        // Capture error output
        try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            String errorLine;
            while ((errorLine = errorReader.readLine()) != null) {
                errorOutput.append(errorLine).append("\n");
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            System.err.println("Python query script failed with exit code " + exitCode);
            System.err.println("Python Output: " + output.toString());
            System.err.println("Python Errors: " + errorOutput.toString());
            throw new RuntimeException("Python query script failed with exit code " + exitCode + ". Check the script for errors.");
        }

        return output.toString();
    }
}
