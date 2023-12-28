package config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class FileProperty {

    @Value("${file.url}")
    private String url;
    @Value("${file.path}")
    private String path;
}
