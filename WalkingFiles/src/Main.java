import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        String actualPath = "D:\\Datos\\Downloads";
        try (var pathStream = Files.list(Path.of(actualPath))) {
            Pattern pattern = Pattern.compile("\\.([^.]+)$");
            Map<String, List<Path>> extensionMap = pathStream
                            .filter(p -> p.toFile().isFile())
                            .collect(Collectors.groupingBy(path -> {
                                Matcher matcher = pattern.matcher(path.getFileName().toString());
                                if (matcher.find()) {
                                    return matcher.group(1);
                                } else {
                                    return "sin_extension";
                                }
                            }));
            extensionMap.forEach((extension, files) ->
            {
                Path folderPath = Path.of(actualPath + "\\" + extension);
                if(Files.notExists(folderPath)) {
                    try {
                        Files.createDirectories(folderPath);
                        System.out.println(folderPath + " was created successfully");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                for (Path file : files) {
                    try {
                        Files.move(file, folderPath.resolve(file.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Moving successfully");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (IOException e ){
            e.printStackTrace();
        }
    }
}
