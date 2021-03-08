package Client;

import Server.IServer;
import Server.ServerFactory;

public class MainGUI {
    public static void main(String args[])
    {


        IServer iF = ServerFactory.CreateInstance();

        iF.WindowLaunch();

        String enIn =  "Cp1251";
        String enOut = "Cp1251";


        String s = "End. Конец.";

        try
        {
            System.out.println(s);
            System.out.println( new String(s.getBytes(enIn),enOut) );
        }
        catch (Exception e) {}

        System.out.println("Ending main...");
    }


}
