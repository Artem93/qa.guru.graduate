package qa.guru.graduate.config;

import lombok.Data;
import org.aeonbits.owner.Config;

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("129.0")
    String getBrowserVersion();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("resolution")
    @DefaultValue("1980x1080")
    String getResolution();
}
