package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Differ {

    private Differ() {
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        Path path1 = Paths.get(filePath1);
        Path path2 = Paths.get(filePath2);

        String fileContent1 = Files.readString(path1);
        String fileContent2 = Files.readString(path2);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> fileMap1 = objectMapper.readValue(fileContent1, new TypeReference<>() {
        });
        Map<String, String> fileMap2 = objectMapper.readValue(fileContent2, new TypeReference<>() {
        });

        List<String> list = new ArrayList<>(fileMap1.keySet().size() + fileMap2.keySet().size());
        for (String key : Stream.concat(fileMap1.keySet().stream(), fileMap2.keySet().stream()).distinct().sorted().collect(Collectors.toList())) {
            if (fileMap1.containsKey(key) && fileMap2.containsKey(key)) { // ключ в двух файлах
                if (fileMap1.get(key).equals(fileMap2.get(key))) { // значение не изменилос
                    list.add(String.format("    %s: %s", key, fileMap1.get(key)));
                } else { // значение изменилось
                    list.add(String.format("  - %s: %s", key, fileMap1.get(key)));
                    list.add(String.format("  + %s: %s", key, fileMap2.get(key)));
                }
            } else { // в каком то из файлов ключа нет
                if (fileMap1.containsKey(key)) { // ключ был удален
                    list.add(String.format("  - %s: %s", key, fileMap1.get(key)));
                } else { // ключ был добавлен
                    list.add(String.format("  + %s: %s", key, fileMap2.get(key)));
                }
            }
        }

        return String.format("{%n%s%n}", list.stream().collect(Collectors.joining("\n")));

    }

}
