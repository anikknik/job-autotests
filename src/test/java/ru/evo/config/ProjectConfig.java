package ru.evo.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/remote.properties"
})
public interface ProjectConfig extends Config {

    @DefaultValue("chrome")
    String browser();
    @DefaultValue("99.0")
    String browserVersion();
    @DefaultValue("1920x1080")
    String browserSize();
    String remote();
    String login();
    String password();
}
