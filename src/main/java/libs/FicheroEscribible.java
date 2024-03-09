package libs;

import java.nio.file.Files;
import java.nio.file.Path;

public class FicheroEscribible {

    public static boolean ficheroEscribible(Path p){
        boolean ficheroOK = false;
        if(Files.exists(p)){
            if (Files.isWritable(p)) {
                ficheroOK = true;
            }
        }
        return ficheroOK;
    }

    public static boolean ficheroLegible(Path p) {
        boolean ficheroOK = false;
        if (Files.exists(p)) {
            if (Files.isReadable(p)) {
                ficheroOK = true;
            }
        }
        return ficheroOK;
    }
}
