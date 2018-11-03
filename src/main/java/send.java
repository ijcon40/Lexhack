import java.util.*;

public class send {

    public static void send(String nickname, boolean isWindows) {
        if(isWindows) {
            Scanner input = new Scanner(System.in);
            String message, name;
            while (true) {
                String message = input.nextLine();
                if (stopCheck(message)) {
                    break;
                }
                Runtime.getRuntime().exec("cmd /C " + "[" + nickname + "] " + message);
            }
        } else {
            Scanner input = new Scanner(System.in);
            String message, name;
            while (true) {
                String message = input.nextLine();
                if (stopCheck(message)) {
                    break;
                }
                Runtime.getRuntime().exec("/bin/bash -c " + "[" + nickname + "] " + message);
            }
        }
    }

    private static boolean stopCheck(String message) {
        int length = message.length();
        for(int i=0;i<length;i++) {
            if(message.charAt(i)=='*') {
                if(message.charAt(i+5)=='*') {
                    return true;
                }
            }
        }
        return false;
    }

}