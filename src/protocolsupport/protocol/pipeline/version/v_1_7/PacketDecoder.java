package protocolsupport.protocol.pipeline.version.v_1_7;

import protocolsupport.api.utils.NetworkState;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.packet.middleimpl.serverbound.handshake.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.SetProtocol;
import protocolsupport.protocol.packet.middleimpl.serverbound.login.v_4_5_6_7.EncryptionResponse;
import protocolsupport.protocol.packet.middleimpl.serverbound.login.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.LoginStart;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7.Animation;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7.BlockDig;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7.BlockPlace;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7.KeepAlive;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7.Move;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryClick;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryClose;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.InventoryConfirmTransaction;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.CreativeSetSlot;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.Ground;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.HeldSlot;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.InventoryButton;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.Look;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_6_7.EntityAction;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_6_7.MoveLook;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_6_7.SteerVehicle;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15.PlayerAbilities;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7.ClientSettings;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7.CustomPayload;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7.TabComplete;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7.UpdateSign;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7.UseEntity;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.Chat;
import protocolsupport.protocol.packet.middleimpl.serverbound.play.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.ClientCommand;
import protocolsupport.protocol.packet.middleimpl.serverbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.Ping;
import protocolsupport.protocol.packet.middleimpl.serverbound.status.v_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2_17r1_17r2.ServerInfoRequest;
import protocolsupport.protocol.pipeline.version.util.decoder.AbstractModernPacketDecoder;

public class PacketDecoder extends AbstractModernPacketDecoder {

	public PacketDecoder(ConnectionImpl connection) {
		super(connection);
	}

	{
		registry.register(NetworkState.HANDSHAKING, 0x00, SetProtocol::new);
		registry.register(NetworkState.LOGIN, 0x00, LoginStart::new);
		registry.register(NetworkState.LOGIN, 0x01, EncryptionResponse::new);
		registry.register(NetworkState.STATUS, 0x00, ServerInfoRequest::new);
		registry.register(NetworkState.STATUS, 0x01, Ping::new);
		registry.register(NetworkState.PLAY, 0x00, KeepAlive::new);
		registry.register(NetworkState.PLAY, 0x01, Chat::new);
		registry.register(NetworkState.PLAY, 0x02, UseEntity::new);
		registry.register(NetworkState.PLAY, 0x03, Ground::new);
		registry.register(NetworkState.PLAY, 0x04, Move::new);
		registry.register(NetworkState.PLAY, 0x05, Look::new);
		registry.register(NetworkState.PLAY, 0x06, MoveLook::new);
		registry.register(NetworkState.PLAY, 0x07, BlockDig::new);
		registry.register(NetworkState.PLAY, 0x08, BlockPlace::new);
		registry.register(NetworkState.PLAY, 0x09, HeldSlot::new);
		registry.register(NetworkState.PLAY, 0x0A, Animation::new);
		registry.register(NetworkState.PLAY, 0x0B, EntityAction::new);
		registry.register(NetworkState.PLAY, 0x0C, SteerVehicle::new);
		registry.register(NetworkState.PLAY, 0x0D, InventoryClose::new);
		registry.register(NetworkState.PLAY, 0x0E, InventoryClick::new);
		registry.register(NetworkState.PLAY, 0x0F, InventoryConfirmTransaction::new);
		registry.register(NetworkState.PLAY, 0x10, CreativeSetSlot::new);
		registry.register(NetworkState.PLAY, 0x11, InventoryButton::new);
		registry.register(NetworkState.PLAY, 0x12, UpdateSign::new);
		registry.register(NetworkState.PLAY, 0x13, PlayerAbilities::new);
		registry.register(NetworkState.PLAY, 0x14, TabComplete::new);
		registry.register(NetworkState.PLAY, 0x15, ClientSettings::new);
		registry.register(NetworkState.PLAY, 0x16, ClientCommand::new);
		registry.register(NetworkState.PLAY, 0x17, CustomPayload::new);
	}

}
