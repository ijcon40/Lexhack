
import java.io.*;
import java.util.concurrent.Executors;
import java.util.function.*;


public class main {

    public static void main(String[] args) throws IOException, InterruptedException{
        sendPacket("Hello", "192.168.43.113");
    }

    private static void sendPacket(String packet, String ip)throws IOException, InterruptedException{
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String LocalDirectory = System.getProperty("user.home");
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (isWindows){
            processBuilder.command("cmd.exe", "/c", "ssh "+ip+" "+"\""+packet+"\"");
        }
        else{
            processBuilder.command("bin/bash",  "-c", "ssh "+ip+" "+"\""+packet+"\"");
        }
        processBuilder.directory(new File(LocalDirectory));
        Process process = processBuilder.start();
        System.out.print(processBuilder.command());
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
