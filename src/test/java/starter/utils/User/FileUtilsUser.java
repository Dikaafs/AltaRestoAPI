package starter.utils.User;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtilsUser {
    public static JSONObject getUser() {
        try {
            String filePath = "src/test/resources/sample/admin.json";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            return new JSONObject(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
