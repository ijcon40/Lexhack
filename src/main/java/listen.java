import java.io.IOException;

interface OnGetMessageListener{
   void OnGetMessage(String Message);
}


public class listen {
    private OnGetMessageListener listener;

    public void MountListener(OnGetMessageListener Listener){
        this.listener = Listener;
    }

    public void CheckResponse(){
        new Thread(new Runnable() {
            public void run() {
                if(listener!=null){
                    MessageResponse.OnGetMessage(Message);
                }
            }
        });
    }


    public static void listen() throws IOException {
        int port = connect.getPort();
        Runtime.getRuntime().exec("/bin/bash -c netcat -l -p " + port);
        System.out.println("listening on port " + port);
    }
}

class MessageResponse implements OnGetMessageListener{
    public void OnGetMessage(String Message){
        System.out.println(Message);
    }
}
