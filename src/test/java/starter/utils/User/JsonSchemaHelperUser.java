package starter.utils.User;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class JsonSchemaHelperUser {
    public String getResponseSchemaUser(String filepath) {
        try {
            InputStream inputStream = this.getClass()
                    .getClassLoader()
                    .getResourceAsStream(filepath);
            if (inputStream == null) throw new AssertionError();
            return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file");
        }
    }
}
