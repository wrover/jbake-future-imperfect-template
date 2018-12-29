package io.reverse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * starts working from ~ -Xmx20m on JDK11
 */
public class ReversingInMemory {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("spool","big.txt"));
        var iter = lines.listIterator(lines.size());
        try (var writer = Files.newBufferedWriter(Paths.get("spool","reverse-memory.txt"))) {
            while (iter.hasPrevious()) {
                writer.write(iter.previous());
                writer.newLine();
            }
        }
    }
}
