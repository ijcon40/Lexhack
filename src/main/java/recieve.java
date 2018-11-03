import.java.util.*;

public class recieve {

    public static void start() {
        if(isLinux()) {
            int port = getPort();
            Runtime.getRuntime().exec("/bin/bash -c netcat -l -p " + port);
        } else if(isWindows()) {
            int port = getPort();

        }
    }

    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    private static int getPort() {
        return 6643;
    }
}