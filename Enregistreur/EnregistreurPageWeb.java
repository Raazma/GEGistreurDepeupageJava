
import java.io.*;
import java.net.*;


public class EnregistreurPageWeb
{
Socket leSocket;

public EnregistreurPageWeb()
{

}
public void Enregistrer(String url,String name)
{
  try
  {

  leSocket = new Socket(InetAddress.getByName(url),80);
  PrintWriter writer = new  PrintWriter( new OutputStreamWriter(leSocket.getOutputStream()));
  BufferedReader reader = new BufferedReader(new InputStreamReader(leSocket.getInputStream()));
  PrintWriter writeFile = new PrintWriter(new BufferedWriter( new FileWriter( name) ) );
  String line = new String();
  writer.println("GET / HTTP/1.1");
  writer.println("Host: " + url);
  writer.println("");
  writer.flush();

  while((line = reader.readLine()) != null)
   writeFile.println(line);
  writeFile.close();

  }
  catch(IOException e)
  {
     System.out.println("SITE IMPOSSIBRu");
  }

}

  public static void main(String args[] )
  {
    EnregistreurPageWeb gitreur = new EnregistreurPageWeb();

     if(args.length == 1)
     {
       gitreur.Enregistrer(args[0],"Page.html");
     }
    else     
    {
       if(args.length == 2)
       {
        gitreur.Enregistrer(args[0],args[1]);
       }
       else
       {
        System.out.println("1 or 2 parameters sti mautadine YOUR DURE DE COMPRENURE!");
        
       }
     
    }
}
}
