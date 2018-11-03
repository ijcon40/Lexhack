import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class listen {
    private Process process;

    public listen() throws IOException {
        int port = connect.getPort();
        if (!System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            this.process = Runtime.getRuntime().exec("/bin/bash -c netcat -l -p " + port);
            System.out.println("listening on port " + port);
        }
        else{
            this.process = Runtime.getRuntime().exec("cmd /C ncat -l -p "+port);
            System.out.println("listening on port " + port);
        }
        Thread Asynch = new Thread(new Runnable() {
            @Override
            public void run() {
            Scanner Reader = new Scanner((process.getInputStream()));
            String line;
            do {
                line = Reader.hasNextLine()?Reader.nextLine():null;
                if (line != null) {
                    System.out.println(line);
                }
            }while(true);
            }
        });
        Asynch.start();


    }
}

