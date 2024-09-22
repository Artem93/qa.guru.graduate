package qa.guru.graduate.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:properties/${env}.properties",
        "classpath:properties/emulator.properties"
})
public interface EmulationConfig extends Config {

    @Key("osVersion")
    @DefaultValue("UIAutomator2")
    String getUiAutomator();

    @Key("osVersion")
    @DefaultValue("Android")
    String getPlatform();

    @Key("osVersion")
    String getOSVersion();

    @Key("device")
    String getDevice();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();
}
