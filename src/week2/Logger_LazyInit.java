package week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger_LazyInit {
    private final String LOGFILE = "log.txt";
    private PrintWriter writer;
    private static Logger_LazyInit instance;
    private Logger_LazyInit() {
        try {
            FileWriter fw = new FileWriter(LOGFILE);
            writer = new PrintWriter(fw, true);
        } catch(IOException e) {}
    }
    public static Logger_LazyInit getInstance() {
        if(instance == null)
            instance = new Logger_LazyInit();
        return instance;
    }
    public void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        writer.println(formatter.format(date) + ":" + message);
    }
}
