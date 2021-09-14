package week2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

// Initialization on demand(lazy) holder idiom
// volatile 이나 synchronized 키워드 없이 동시성 문제 해결
public class Logger_DemandHolder {
    private final String LOGFILE = "log.txt";
    private PrintWriter writer;
    private static Logger_DemandHolder instance;
    // 명령어 reorder(최적화 수행)로 발생할 오류 차단을 위한 volatile(reorder 금지)
    // private volatile static Logger_DCL instance;
    private Logger_DemandHolder() {
        try {
            FileWriter fw = new FileWriter(LOGFILE);
            writer = new PrintWriter(fw, true);
        } catch(IOException e) {}
    }

    private static class LazyHolder {
        public static final Logger_DemandHolder INSTANCE = new Logger_DemandHolder();
    }

    public static Logger_DemandHolder getInstance() { return LazyHolder.INSTANCE; }
    public void log(String message) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        writer.println(formatter.format(date) + ":" + message);
    }
}
