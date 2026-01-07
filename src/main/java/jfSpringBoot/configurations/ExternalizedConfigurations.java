package jfSpringBoot.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class ExternalizedConfigurations {

    private String name;
    private String version;
    private String autor;
    private String country;

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String getAutor() {
        return autor;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Configuration "+ "\n"+ "nombre "+this.name+ "\n" + "version "+ this.autor;
    }
}
