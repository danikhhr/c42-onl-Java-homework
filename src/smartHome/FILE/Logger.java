package smartHome.FILE;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String FILE = "src/smartHome/FILE/smart_home_log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public void writeToFile(String message, String event) {
        try(FileWriter fileWriter = new FileWriter(FILE, true)) {
            String time = LocalDateTime.now().format(FORMATTER);
            fileWriter.write("----------------------------------------\n");
            fileWriter.write("[" + time  + "]" + event + "\n" + message + "\n");
            fileWriter.write("----------------------------------------\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
