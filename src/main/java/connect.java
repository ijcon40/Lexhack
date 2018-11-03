import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class connect {

    public static void open(String contacts) throws IOException {
        if(isWindows()) {
            Runtime.getRuntime().exec("cmd /C ncat "+contacts+" "+getPort());
        } else {
            Runtime.getRuntime().exec("/bin/bash -c netcat" + contacts+" "+getPort());
            System.out.println("trying connection");
        }
    }


    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    public static int getPort() {
        return 6443;
    }

    private static String askIp() {
        Scanner input = new Scanner(System.in);
        System.out.print("IP to connect to : ");
        String ip = input.nextLine();
        System.out.println();
        return ip;
    }

    private static String getIPLinux() throws IOException{
        Process getip;
        getip = Runtime.getRuntime().exec("/bin/bash -c curl -s http://icanhazip.com");
        BufferedReader in = new BufferedReader(new InputStreamReader(getip.getInputStream()));
        return(in.readLine());
    }
}