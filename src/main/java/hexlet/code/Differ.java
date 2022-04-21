package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Prints the diff between two files to STDOUT.")
public final class Differ implements Callable<Integer> {

    @Parameters(index = "0", description = "Path to the first file.")
    private String filePath1;

    @Parameters(index = "1", description = "Path to the second file.")
    private String filePath2;

    public static String generate(String filePath1, String filePath2) {
        return "";
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Differ()).execute(args);
        System.exit(exitCode);
    }

}
