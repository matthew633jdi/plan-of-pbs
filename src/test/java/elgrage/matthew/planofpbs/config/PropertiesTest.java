package elgrage.matthew.planofpbs.config;

import elgrage.matthew.planofpbs.config.properties.PropertiesConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PropertiesTest {

    @Test
    @DisplayName("PROPERTIES")
    void propertiesTest() {
        Assertions.assertThat(PropertiesConfig.key).isEqualTo("private_key");
    }
}
