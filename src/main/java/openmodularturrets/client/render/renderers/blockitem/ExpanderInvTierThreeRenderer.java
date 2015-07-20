package openmodularturrets.client.render.renderers.blockitem;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import openmodularturrets.client.render.models.ModelExpander;
import openmodularturrets.reference.ModInfo;
import openmodularturrets.tileentity.expander.AbstractInvExpander;
import openmodularturrets.tileentity.expander.AbstractPowerExpander;
import org.lwjgl.opengl.GL11;

public class ExpanderInvTierThreeRenderer extends TileEntitySpecialRenderer {

    private ModelExpander model;

    public ExpanderInvTierThreeRenderer() {
        model = new ModelExpander();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {

        AbstractInvExpander expander = (AbstractInvExpander) te;
        ResourceLocation textures = (new ResourceLocation(ModInfo.ID + ":textures/blocks/expanderInvTierThree.png"));
        Minecraft.getMinecraft().renderEngine.bindTexture(textures);

        int rotation = 0;
        if (te.getWorldObj() != null) {
            rotation = te.getBlockMetadata();
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);

        model.expander.rotateAngleX = expander.baseFitRotationX;
        model.expander.rotateAngleY = expander.baseFitRotationZ;
        model.renderAll();

        GL11.glPopMatrix();
    }
}
