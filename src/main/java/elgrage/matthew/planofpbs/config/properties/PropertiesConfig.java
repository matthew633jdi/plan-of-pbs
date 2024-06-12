package elgrage.matthew.planofpbs.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesConfig {

    public static String key;

    @Value("${enc.key}")
    public void setKey(String key) {
        PropertiesConfig.key = key;
    }
}
