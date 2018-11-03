import java.util.*;

public class contact {
    private String name;
    private String localIP;
    private String publicIP;
    private String nickname;

    public contact(String name, String localIP, String publicIP, String nickname) {
        this.name = name;
        this.localIP= localIP;
        this.publicIP= publicIP;
        this.nickname= nickname;
    }



    public static contact newContact() {
        Scanner input = new Scanner(System.in);
        String name,localIP,publicIP,nickname;
        System.out.print("enter name : ");
        name = input.next();
        System.out.print("\n + enter nickname : ");
        nickname = input.next();
        System.out.print("\n + enter local IP : ");
        localIP = input.next();
        System.out.print("\n + enter public IP : ");
        publicIP = input.next();
        contact one = new contact(name,localIP,publicIP,nickname);

        return one;
    }
}