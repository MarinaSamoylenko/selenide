package selenide.util;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesCache {
    private final Properties configProp = new Properties();

    private PropertiesCache() {
        //Private constructor to restrict new instances
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("test.properties");
        try {
            configProp.load(in);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    //Bill Pugh Solution for singleton pattern
    //initialization-on-demand holder idiom
    private static class LazyHolder {
        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }
}

