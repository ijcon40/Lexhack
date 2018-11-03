
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.function.*;


public class main {

    public static void main(String[] args) throws IOException, InterruptedException{
        if(isWindows()) {
            System.out.println(hasnc());
        } else {
            connect.open();
        }

        listen listen = new listen();
        OnGetMessageListener MessageRespone = new MessageResponse();
        listen.MountListener(MessageRespone);
        listen.CheckResponse();
    }

    private static void sendPacket(String packet, String ip)throws IOException, InterruptedException{
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        String LocalDirectory = System.getProperty("user.home");

    }

    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    private static boolean hasnc()throws IOException{
        boolean installed = true;
        Process process = Runtime.getRuntime().exec("cmd /C ncat");
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        if (error.readLine()!=null){
            installed = false;
        }
        return installed;
    }

}
