package qa.guru.graduate.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
        "classpath:properties/browserstack_auth.properties"
})
public interface AuthConfig extends Config {

    @Key("login")
    String getLogin();

    @Key("password")
    String getPassword();
}
