
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.function.*;


public class main {

    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(hasnc());
    }

    private static void sendPacket(String packet, String ip)throws IOException, InterruptedException{
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String LocalDirectory = System.getProperty("user.home");

    }

    private static boolean hasnc()throws IOException{
        boolean installed = true;
        Process process = Runtime.getRuntime().exec("cmd /C netcat");
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        if (error.readLine()!=null){
            installed = false;
        }
        return installed;
    }

}
