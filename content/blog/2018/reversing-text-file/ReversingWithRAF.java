package io.reverse;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * works with -Xmx2m on JDK11
 */
public class ReversingWithRAF {

    private static final String FILE_NAME = "spool/big.txt";

    public static void main(String[] args) throws IOException {

        var in = new File(FILE_NAME);

        try (var out = new RandomAccessFile(new File("spool/reverse-raf.txt"), "rw")) {
            try (var reader = Files.newBufferedReader(Paths.get(FILE_NAME))) {

                long pos = in.length();
                out.setLength(pos);

                String str;
                while ((str = reader.readLine()) != null) {
                    int len = str.length();
                    pos -= (len + 1);
                    out.seek(pos);
                    out.writeBytes(str + "\n");
                }
            }
        }
    }
}