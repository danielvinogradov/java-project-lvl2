package hexlet.code;

import hexlet.code.diffgenerator.DiffGenerator;
import hexlet.code.diffgenerator.defaultdiffgenerator.DefaultDiffGenerator;
import hexlet.code.diffunit.DiffUnit;
import hexlet.code.diffunitsetformatter.DiffUnitSetFormatter;
import hexlet.code.diffunitsetformatter.DiffUnitSetFormatterManager;
import hexlet.code.diffunitsetformatter.FormatType;
import hexlet.code.fileparser.FileParser;
import hexlet.code.fileparser.FileType;
import hexlet.code.fileparser.defaultfileparser.DefaultFileParser;
import hexlet.code.fileparser.defaultfileparser.util.StringParserException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public final class Differ {

    private static final FormatType DEFAULT_FORMAT_TYPE = FormatType.STYLISH;

    private Differ() {
    }

    public static String generate(@NotNull final String filePath1,
                                  @NotNull final String filePath2)
            throws IOException, StringParserException {
        return generate(filePath1, filePath2, DEFAULT_FORMAT_TYPE);
    }

    public static String generate(@NotNull final String filePath1,
                                  @NotNull final String filePath2,
                                  @NotNull final FormatType formatType)
            throws IOException, StringParserException {
        Path path1 = Paths.get(filePath1);
        Path path2 = Paths.get(filePath2);

        // получили пути, проверяем, что у файлов одинаковые extensions
        // https://www.baeldung.com/java-file-extension
        if (FileType.fromPath(path1) != FileType.fromPath(path2)) {
            throw new UnsupportedOperationException("Сравнение файлов с разными расширениями не поддерживается.");
        }

        FileParser fileParser = new DefaultFileParser();
        Map<String, Object> data1 = fileParser.parse(path1);
        Map<String, Object> data2 = fileParser.parse(path2);

        DiffGenerator defaultDiffProcessor = new DefaultDiffGenerator();
        Set<DiffUnit> diffUnitList = defaultDiffProcessor.process(data1, data2);

        DiffUnitSetFormatter diffUnitSetFormatter = DiffUnitSetFormatterManager.getFormatter(formatType);

        return diffUnitSetFormatter.format(diffUnitList);
    }

}
