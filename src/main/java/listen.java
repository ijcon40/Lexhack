import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface OnGetMessageListener{
   void OnGetMessage(String Message);
}


public class listen {
    private OnGetMessageListener listener;
    private Process process;

    public void MountListener(OnGetMessageListener Listener){
        this.listener = Listener;
    }

    public void CheckResponse(){
        new Thread(new Runnable() {
            public void run(){
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while(true){
                    try {
                        String line;
                        line =reader.readLine();
                    if (line==null){
                        listener.OnGetMessage(line);
                    }
                    }
                    catch(IOException err){
                        System.out.println(err);
                    }

                }

            }
        });
    }


    public listen() throws IOException {
        int port = connect.getPort();
        this.process=Runtime.getRuntime().exec("/bin/bash -c netcat -l -p " + port);
        System.out.println("listening on port " + port);
    }
}

class MessageResponse implements OnGetMessageListener{
    public void OnGetMessage(String Message){
        System.out.println(Message);
    }
}
