package week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class Logger_EagerInit {
    private final String LOGFILE = "log.txt";
    private PrintWriter writer;
    private static Logger_EagerInit instance = new Logger_EagerInit();
    private Logger_EagerInit() {
        try {
            FileWriter fw = new FileWriter(LOGFILE);
            writer = new PrintWriter(fw, true);
        } catch(IOException e) {}
    }
    public static Logger_EagerInit getInstance() { return instance; }
    public void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        writer.println(formatter.format(date) + ":" + message);
    }
}
