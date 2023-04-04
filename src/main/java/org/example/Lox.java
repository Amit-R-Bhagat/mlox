package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Lox {
    public static void main(String[] args) throws IOException {
        if(args.length > 1){
            System.out.println("Usage: mjlox [script]");
            System.exit(64);
        }else if(args.length == 1){
            runFile(args[0]);
        }else{
            runPrompt();
        }
    }

    private static void runPrompt() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        for(;;){
            System.out.print("mjlox > ");
            String line = reader.readLine();
            if(line == null) break;
            run(line);
        }
    }

    private static void runFile(String pathString) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(pathString));
        run(new String(bytes, Charset.defaultCharset()));
    }

    private static void run(String sourceCode) {
        Scanner scanner = new Scanner(sourceCode);
        List<String> tokens = scanner.tokens().toList();
        System.out.println(tokens);
    }

}