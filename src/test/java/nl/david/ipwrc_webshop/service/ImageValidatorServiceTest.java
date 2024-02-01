
package nl.david.ipwrc_webshop.service;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ImageValidatorService Tests")
public class ImageValidatorServiceTest {

    @Test
    public void test_validBase64PngImage() {
        String base64Image = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAFUlEQVR42mP8z8BQz0AEYBxVSF+FABJADveWkH6oAAAAAElFTkSuQmCC";
        assertTrue(ImageValidatorService.isBase64Png(base64Image));
    }
}
