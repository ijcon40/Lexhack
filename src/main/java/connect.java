

public class connect {

    public static void open() {
        if(isWindows()) {

        } else {
            String ip = askIp();
            Runtime.getRuntime().exec("/bin/bash -c netcat " + ip + getPort());
            System.out.println("trying connection");
        }
    }

    public static void listen() {
        int port = getPort();
        Runtime.getRuntime().exec("/bin/bash -c netcat -l -p " + port);
        System.out.println("lisening on port " + port);
    }

    private static boolean isLinux() {
        return System.getProperty("os.name").toLowerCase().startsWith("linux");
    }

    private static boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("windows");
    }

    private static int getPort() {
        return 6443;
    }

    private static String askIp() {
        Scanner input = new Scanner(System.in);
        System.out.print("IP to connect to : ");
        String ip = input.nextLine();
        System.out.println();
        return ip;
    }

    private static String getIPLinux() {
        String ip;
        ip = Runtime.getRuntime().exec("/bin/bash -c curl -s http://icanhazip.com");
    }
}