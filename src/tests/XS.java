package tests;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.enums.EnumConverter;
import com.velocity.jwakfu.model.Player;
import com.velocity.jwakfu.net.packets.out.enums.LoginResponseCode;

public class XS {
	
	private LoginResponseCode login = LoginResponseCode.ACCOUNT_BANNED;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		XStream xs = new XStream();
		xs.registerConverter(new EnumConverter());
		xs.alias("login", LoginResponseCode.class);
		System.out.println(xs.toXML(new XS()));
		
		Player player = new Player("velocity", "velocity", "cheese");
		player.save();
	}

}
