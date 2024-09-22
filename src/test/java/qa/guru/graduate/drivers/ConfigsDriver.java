package qa.guru.graduate.drivers;

import org.aeonbits.owner.ConfigFactory;
import qa.guru.graduate.config.*;

public class ConfigsDriver {
    private static final AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    private static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    private static final RealConfig realConfig = ConfigFactory.create(RealConfig.class, System.getProperties());
    private static final EmulationConfig emulationConfig = ConfigFactory.create(EmulationConfig.class, System.getProperties());
    private static final SystemConfig systemConfig = ConfigFactory.create(SystemConfig.class, System.getProperties());

    public static AuthConfig getAuthConfig() {
        return authConfig;
    }

    public static BrowserstackConfig getBrowserstackConfig() {
        return browserstackConfig;
    }

    public static SystemConfig getSystemConfig() {
        return systemConfig;
    }

    public static RealConfig getRealConfig() {
        return realConfig;
    }

    public static EmulationConfig getEmulationConfig() {
        return emulationConfig;
    }
}
