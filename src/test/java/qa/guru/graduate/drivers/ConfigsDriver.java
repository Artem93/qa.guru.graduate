package qa.guru.graduate.drivers;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;
import qa.guru.graduate.config.*;

public class ConfigsDriver {
    @Getter
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    @Getter
    private static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    @Getter
    private static final RealConfig realConfig = ConfigFactory.create(RealConfig.class, System.getProperties());
    @Getter
    private static final EmulationConfig emulationConfig = ConfigFactory.create(EmulationConfig.class, System.getProperties());
    @Getter
    private static final SystemConfig systemConfig = ConfigFactory.create(SystemConfig.class, System.getProperties());
    @Getter
    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

}
