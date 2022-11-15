package mds.project.model;

import org.apache.commons.io.file.SimplePathVisitor;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class StreamLibrary extends ArrayList<String> {
    private String searchDirectory, keepSuffix;

    public StreamLibrary(String searchDirectory, String keepSuffix) throws IOException {
        super();
        for (File file : discoverFiles(Path.of(searchDirectory), keepSuffix)) {
            this.add(file.getParentFile().getName());
        }
    }

    private static List<File> discoverFiles(Path directory, String keepSuffix) throws IOException {
        List<File> files = new ArrayList<>();
        Files.walkFileTree(directory, new SimplePathVisitor() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String filePath = String.valueOf(file);
                if (filePath.endsWith(keepSuffix)) files.add(new File(filePath));
                return super.visitFile(file, attrs);
            }
        });
        return files;
    }

}
