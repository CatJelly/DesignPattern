package week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger_DCL {
    private final String LOGFILE = "log.txt";
    private PrintWriter writer;
    private static Logger_DCL instance;
    // 명령어 reorder(최적화 수행)로 발생할 오류 차단을 위한 volatile(reorder 금지)
    // private volatile static Logger_DCL instance;
    private Logger_DCL() {
        try {
            FileWriter fw = new FileWriter(LOGFILE);
            writer = new PrintWriter(fw, true);
        } catch(IOException e) {}
    }

    public static Logger_DCL getInstance() {
        if(instance == null) {
            synchronized(Logger_DCL.class) {
                if(instance == null) {
                    instance = new Logger_DCL();
                }
            }
        }
        return instance;
    }
    public void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        writer.println(formatter.format(date) + ":" + message);
    }
}
