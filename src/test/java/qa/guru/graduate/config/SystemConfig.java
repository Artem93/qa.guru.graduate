package qa.guru.graduate.config;

import org.aeonbits.owner.Config;

public interface SystemConfig extends Config {

    @Key("deviceHost")
    @DefaultValue("emulation")
    String getDeviceHost();

    @Key("location")
    @DefaultValue("LOCAL")
    String getLocation();
}
