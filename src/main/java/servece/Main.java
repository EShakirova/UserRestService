package servece;

import org.eclipse.jetty.server.Server;

public class Main {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8082);
        //server.setHandler();
        server.start();
        server.join();
    }
}
