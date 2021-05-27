package entity;

import org.bukkit.entity.EntityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import protocolsupport.protocol.types.networkentity.NetworkEntityType;
import zinit.PlatformInit;

public class NetworkEntityTypeTests extends PlatformInit {

	@Test
	protected void testFilled() {
		for (EntityType bukkitType : EntityType.values()) {
			if (bukkitType != EntityType.UNKNOWN) {
				Assertions.assertNotEquals(NetworkEntityType.getByBukkitType(bukkitType), NetworkEntityType.NONE, "NetworkEntityType for Bukkit EntityType " + bukkitType + " ");
			}
		}
	}

}
