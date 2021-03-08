package Server;

public class ServerFactory {

        public static IServer CreateInstance() {
            return new Server();
        }


}
