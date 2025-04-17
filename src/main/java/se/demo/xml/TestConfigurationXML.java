package se.demo.xml;


import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestConfigurationXML
{
    public static void main(String[] args)
    {

        try
        {
            Configurations configs = new Configurations();
            XMLConfiguration config = configs.xml("database.xml");

            //hardcode version
            String nomBase = config.getString("database[@nom]");
            String host = config.getString("database.host");
            String port = config.getString("database.port");
            String user = config.getString("database.user");
            String pwd = config.getString("database.pwd");

            HashSet<String> keySet = new HashSet<>(Set.of(nomBase, host, port, user, pwd));
            System.out.println("Settings set: " + keySet);

            HashMap<String, String> keyMap = new HashMap<>();
            keyMap.put("database.name", nomBase);
            keyMap.put("database.host", host);
            keyMap.put("database.port", port);
            keyMap.put("database.user", user);
            keyMap.put("database.password", pwd);

            System.out.println("Settings map: " + keyMap);


            //iterate version
            config.subset("database").getKeys()
                    .forEachRemaining(key -> System.out.println(key + " = " + config.getString("database." + key)));

        } catch (ConfigurationException e)
        {
            throw new RuntimeException(e);
        }


    }
}