import java.util.*;
import java.io.*;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.function.*;


public class main {

    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);
        System.out.println("to stop writing messages, write \"*stop*\"");
        System.out.print("pick a nickname : ");
        String nickname = input.next();
        System.out.println();
        contact[] contactBook = new contact[100];
        listen listen = new listen();
        boolean isWindows = isWindows();
        send.send(nickname, isWindows);
        System.out.println("ok this is epic");
    }


    public static void loadContacts(contact[] contactBook) {
        for(int i=0;i<contactBook.length;i++) {

        }
    }

    public static void saveContacts(contact[] contactBook) throws IOException {
        for(int i=0;i<contactBook.length;i++) {

        }
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
        String line;
        BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        if (error.readLine()!=null){
            installed = false;
        }
        return installed;
    }

}
