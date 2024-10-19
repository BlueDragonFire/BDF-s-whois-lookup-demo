import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class whois
{
    public static void main(String[] args) throws UnknownHostException, IOException 
    {
        String domain = "shoprite.co.za"; // <---- Domain you want to lookup
        final String server = "coza-whois.registry.net.za"; // <---- Registry server with port 43 WHOIS capability
        final int port = 43;
        String query = domain + "\r\n";
        String line;

        try (Socket socket = new Socket(server, port); OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream()); BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) 
        {
            writer.write(query);
            writer.flush();
            
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }  
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
}