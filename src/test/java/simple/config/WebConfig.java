package simple.config;

import lombok.Data;
import simple.WebDriverFactory;
@Data
public class WebConfig {
    private String baseUrl;
    private WebDriverFactory.Browser browser;


}
