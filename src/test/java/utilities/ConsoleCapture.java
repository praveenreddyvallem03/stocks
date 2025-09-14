package utilities;

import java.io.*;
import java.nio.charset.StandardCharsets;

public final class ConsoleCapture {
    private static PrintStream originalOut;
    private static PrintStream myLogOut;
    private static FileOutputStream fileOut;

    private ConsoleCapture() {}

    public static synchronized void start(String logPath) {
    	
        if (myLogOut != null) return;
        
        try {
            originalOut = System.out;
            fileOut = new FileOutputStream(logPath, false);

            myLogOut = new PrintStream(fileOut, true, StandardCharsets.UTF_8);

            // Wrap System.out with custom filter
            System.setOut(new PrintStream(originalOut) {
                @Override
                public void println(String x) {
                    // Only capture lines starting with [MYLOG]
                    if (x.startsWith("[MYLOG]")) {
                        myLogOut.println(x);
                    }
                    originalOut.println(x); // always print to console
                }
            });

        } catch (IOException e) {
            throw new RuntimeException("Failed to start console capture", e);
        }
    }

    public static synchronized void stop() {
        if (myLogOut == null) return;
        try {
            System.setOut(originalOut);
            myLogOut.flush();
            myLogOut.close();
        } finally {
            myLogOut = null;
            fileOut = null;
        }
    }
}
