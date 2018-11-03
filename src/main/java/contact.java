import java.util.*;

public class contact {

    public contact(String name, String localIP, String publicIP, String nickname) {
        String name;
        String localIP;
        String publicIP;
        String nickname;
    }

    public static contact[] loadContacts() {

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