
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.function.*;

public class main {

    public static void main(String[] args){
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        boolean isLinux = System.getProperty("os.name").toLowerCase().startsWith("linux");
        String LocalDirectory = System.getProperty("user.home");
        if (isWindows){
            try {
                Process process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", LocalDirectory));
            }
            catch(IOException err) {
                System.out.println(err);
            }
        }
        else if (isLinux){
            try {
                Process process = Runtime.getRuntime().exec(String.format("cmd.exe /c dir %s", LocalDirectory));
            }
            catch(IOException err) {
                System.out.println(err);
            }
        }
    }

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }
}
