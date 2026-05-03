package practice.OOPS;

class ConfigManager{
    private static ConfigManager instance;

    private ConfigManager(){
        System.out.println("Loading configs...");
    }

    public static  synchronized  ConfigManager getInstance(){
        if(instance == null){
            instance = new ConfigManager();
        }
        return instance;
    }

    public void  showConfig(){
        System.out.println("Config is ready to use");
    }
}

public class privateConstructorRestrictedInstantiation {
    public static void main(String[] args) {
        ConfigManager c1= ConfigManager.getInstance();
        ConfigManager c2= ConfigManager.getInstance();

        System.out.println(c1==c2);
    }
}
