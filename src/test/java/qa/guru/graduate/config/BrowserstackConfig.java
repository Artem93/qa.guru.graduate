package qa.guru.graduate.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/browserstack_pixel3.properties"
})
public interface BrowserstackConfig extends Config {

    @Key("app")
    String getApp();

    @Key("device")
    String getDevice();

    @Key("osVersion")
    String getOSVersion();

    @Key("project")
    String getProject();

    @Key("build")
    String getBuild();

    @Key("name")
    String getName();

    @Key("remoteUrl")
    String getRemoteUrl();
}
