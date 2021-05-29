package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.MiscSerializer;
import protocolsupport.protocol.utils.EnumConstantLookup;

public abstract class MiddleUnlockRecipes extends ClientBoundMiddlePacket {

	protected MiddleUnlockRecipes(MiddlePacketInit init) {
		super(init);
	}

	protected Action action;
	protected boolean craftRecipeBookOpen;
	protected boolean craftRecipeBookFiltering;
	protected boolean smeltingRecipeBookOpen;
	protected boolean smeltingRecipeBookFiltering;
	protected boolean blastFurnaceRecipeBookOpen;
	protected boolean blastFurnaceRecipeBookFiltering;
	protected boolean smokerRecipeBookOpen;
	protected boolean smokerRecipeBookFiltering;
	protected String[] recipes1;
	protected String[] recipes2;

	@Override
	protected void decode(ByteBuf serverdata) {
		action = MiscSerializer.readVarIntEnum(serverdata, Action.CONSTANT_LOOKUP);
		craftRecipeBookOpen = serverdata.readBoolean();
		craftRecipeBookFiltering = serverdata.readBoolean();
		smeltingRecipeBookOpen = serverdata.readBoolean();
		smeltingRecipeBookFiltering = serverdata.readBoolean();
		blastFurnaceRecipeBookOpen = serverdata.readBoolean();
		blastFurnaceRecipeBookFiltering = serverdata.readBoolean();
		smokerRecipeBookOpen = serverdata.readBoolean();
		smokerRecipeBookFiltering = serverdata.readBoolean();
		recipes1 = ArraySerializer.readVarIntVarIntUTF8StringArray(serverdata);
		if (action == Action.INIT) {
			recipes2 = ArraySerializer.readVarIntVarIntUTF8StringArray(serverdata);
		}
	}

	protected enum Action {
		INIT, ADD, REMOVE;
		public static final EnumConstantLookup<Action> CONSTANT_LOOKUP = new EnumConstantLookup<>(Action.class);
	}

}
