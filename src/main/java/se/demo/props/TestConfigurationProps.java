package se.demo.props;

import java.util.ResourceBundle;

public class TestConfigurationProps
{
    public static void main(String[] args)
    {
        try
        {
            ResourceBundle config = ResourceBundle.getBundle("database");

            config.keySet().forEach(key ->
            {
                String value = config.getString(key);
                System.out.println(key + " = " + value);
            });

        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}