package starter.utils.Admin;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    public static JSONObject getAdmin() {
        try {
            String filePath = "src/test/resources/sample/getToken.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
