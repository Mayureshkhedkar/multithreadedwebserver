package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    public Runnable getRunnble(){
        return new Runnable() {
            @Override
            public void run() {
                int port=8010;
                try {
                    InetAddress address=InetAddress.getByName("localhost");
                    Socket socket=new Socket(address,port);
                    try {
                        PrintWriter toSocket = new PrintWriter(socket.getOutputStream(),true);
                        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                        toSocket.print("hello from the client " + socket.getRemoteSocketAddress());
                        String line = fromSocket.readLine();
                        System.out.println("Response from server " + line);
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        };


    }
    public static void main(String[] args) {
        client client=new client();
        for(int i=0 ; i<100;i++){

                Thread thread = new Thread(client.getRunnble());
                thread.start();
//            }catch (IOException e){
//                return;
//            }

        }
    }
}
