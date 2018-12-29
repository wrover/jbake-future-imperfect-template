package io.reverse;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class WriteRandomTextFile {
    public static void main(String[] args) throws IOException {
        try (var writer = Files.newBufferedWriter(Paths.get("spool", "big.txt"))) {
            var random = new Random();
            for (int i = 0; i < 100_000 - 1; i++) {
                writeRandomString(writer, random);
            }
        }
    }

    private static void writeRandomString(BufferedWriter writer, Random random)
            throws IOException {
        String str = RandomStringUtils.randomAlphabetic(random.nextInt(255));
        writer.write(str);
        writer.newLine();
    }
}
