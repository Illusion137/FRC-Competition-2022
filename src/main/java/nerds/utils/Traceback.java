package nerds.utils;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**Delete this file as well as all instances of this finding
 * and the containings of it to improve preformance
 */
public class Traceback {
    public static final String tracebackPath = "../../../../../Traceback.txt";
    
    public static void traceback_delete(){   
        File traceBackFile = new File(tracebackPath); 
        if(traceBackFile.exists()){traceBackFile.delete();}
    }
    public static void traceback_write(String writeTo){
        try{
            FileWriter traceBackFile = new FileWriter(tracebackPath);
            traceBackFile.write("\n"+writeTo);
            traceBackFile.close();
        } catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}