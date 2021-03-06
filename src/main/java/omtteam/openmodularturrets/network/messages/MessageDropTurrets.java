package omtteam.openmodularturrets.network.messages;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import omtteam.omlib.tileentity.ITrustedPlayersManager;
import omtteam.omlib.util.PlayerUtil;
import omtteam.openmodularturrets.tileentity.turrets.TurretHead;

@SuppressWarnings("unused")
public class MessageDropTurrets implements IMessage {
    private int x, y, z;

    public MessageDropTurrets() {
    }

    public static class MessageHandlerDropTurrets implements IMessageHandler<MessageDropTurrets, IMessage> {
        @Override
        public IMessage onMessage(MessageDropTurrets messageIn, MessageContext ctxIn) {
            final MessageDropTurrets message = messageIn;
            final MessageContext ctx = ctxIn;
            ((WorldServer) ctx.getServerHandler().player.getEntityWorld()).addScheduledTask(() -> {
                World world = ctx.getServerHandler().player.getEntityWorld();
                EntityPlayerMP player = ctx.getServerHandler().player;
                TileEntity entity = world.getTileEntity(new BlockPos(message.getX(), message.getY(), message.getZ()));
                ITrustedPlayersManager machine = null;
                if (entity instanceof ITrustedPlayersManager) {
                    machine = (ITrustedPlayersManager) entity;
                }
                if (machine != null && PlayerUtil.isPlayerAdmin(player, machine)) {
                    world.destroyBlock(new BlockPos(message.getX(), message.getY(), message.getZ()), true);


                    if (world.getTileEntity(new BlockPos(message.getX() + 1, message.getY(), message.getZ())) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX() + 1, message.getY(), message.getZ()), true);
                    }

                    if (world.getTileEntity(new BlockPos(message.getX() - 1, message.getY(), message.getZ())) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX() - 1, message.getY(), message.getZ()), true);
                    }

                    if (world.getTileEntity(new BlockPos(message.getX(), message.getY() + 1, message.getZ())) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX(), message.getY() + 1, message.getZ()), true);
                    }

                    if (world.getTileEntity(new BlockPos(message.getX(), message.getY() - 1, message.getZ())) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX(), message.getY() - 1, message.getZ()), true);
                    }

                    if (world.getTileEntity(new BlockPos(message.getX(), message.getY(), message.getZ() + 1)) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX(), message.getY(), message.getZ() + 1), true);
                    }

                    if (world.getTileEntity(new BlockPos(message.getX(), message.getY(), message.getZ() - 1)) instanceof TurretHead) {
                        world.destroyBlock(new BlockPos(message.getX(), message.getY(), message.getZ() - 1), true);
                    }
                }
            });
            return null;
        }
    }

    public MessageDropTurrets(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.x);
        buf.writeInt(this.y);
        buf.writeInt(this.z);
    }

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    private int getZ() {
        return z;
    }
}
