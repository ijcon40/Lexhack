
import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.*;


public class main {

    public static void main(String[] args) {

    }

    private static void sendPacket(String packet)throws IOException, InterruptedException{
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        boolean isLinux = System.getProperty("os.name").toLowerCase().startsWith("linux");
        String LocalDirectory = System.getProperty("user.home");
        String Command;
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows){
            processBuilder.command("cmd.exe", "/c", "dir");
        }
        else{
            processBuilder.command("sh",  "-c", "ls");
        }
        processBuilder.directory(new File(LocalDirectory));
        Process process = processBuilder.start();
        StreamGobbler CMDIO = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(CMDIO);
        int exitcode = process.waitFor();
        assert exitcode==0;
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
