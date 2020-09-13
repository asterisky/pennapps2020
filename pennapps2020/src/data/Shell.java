package data;

import java.io.File;
import java.io.IOException;

/**
 * Class responsible for communicating with our virtual machine
 */
public class Shell {

    // Extracts runtime associated with our app
    Runtime runtime;

    public Shell() {
        runtime = Runtime.getRuntime();
    }

    // This website is useful for sending shell commands:
    // https://stackabuse.com/executing-shell-commands-with-java/

    public File getFile() {
        File retFile = null;

        String command = "";
        try {
            runtime.exec(command);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return retFile;
    }

    public void sendFile(File file) {
        String command = "";
        try {
            runtime.exec(command);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}