package utilities;


import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:enviromentConfig/${env}.properties"})
public interface Enviroment extends Config {
	//Hàm Getter
	@Key("App.Url")
	String appUrl();
	
	@Key("App.User")
	String appUser();
	
	@Key("App.Pass")
	String appPassword();
	
	@Key("DB.Host")
	String dbHostName();
	
	@Key("DB.User")
	String dbUser();
	
	@Key("DB.Pass")
	String dbPassword();
}
