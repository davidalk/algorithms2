package uk.co.alkanani.file;

import java.io.File;
import java.net.URL;

public class CommonFileUtil {

    public static File getFile(String filename) {
        URL url = CommonFileUtil.class.getClassLoader().getResource(filename);
        File file;
        if (url != null) {
            file = new File(url.getFile());
        } else {
            throw new IllegalArgumentException("Invalid file");
        }
        return file;
    }

}
