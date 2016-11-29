package omtteam.openmodularturrets.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import omtteam.openmodularturrets.handler.ConfigHandler;

import java.text.DecimalFormat;
import java.util.List;

public class ItemBlockGrenadeLauncherTurret extends ItemBlock {
    private static final DecimalFormat df = new DecimalFormat("0.0");

    public ItemBlockGrenadeLauncherTurret(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List p_77624_3_, boolean p_77624_4_) {
        p_77624_3_.add("");
        p_77624_3_.add(TextFormatting.GOLD + "--" + I18n.translateToLocal("tooltip.info") + "--");
        p_77624_3_.add(I18n.translateToLocal("tooltip.tier") + ": " + TextFormatting.WHITE + "3");
        p_77624_3_.add(I18n.translateToLocal("tooltip.range") + ": " + TextFormatting.WHITE +
                               ConfigHandler.getGrenadeTurretSettings().getRange());
        p_77624_3_.add(I18n.translateToLocal("tooltip.accuracy") + ": " + TextFormatting.WHITE +
                               I18n.translateToLocal("turret.accuracy.medium"));
        p_77624_3_.add(I18n.translateToLocal("tooltip.ammo") + ": " + TextFormatting.WHITE +
                               I18n.translateToLocal("turret.ammo.2"));
        p_77624_3_.add(I18n.translateToLocal("tooltip.tier_required") + ": " + TextFormatting.WHITE +
                               I18n.translateToLocal("base.tier.3"));
        p_77624_3_.add("");
        p_77624_3_.add(
                TextFormatting.DARK_PURPLE + "--" + I18n.translateToLocal("tooltip.damage.label") + "--");
        p_77624_3_.add(I18n.translateToLocal("tooltip.damage.stat") + ": " + TextFormatting.WHITE +
                               (ConfigHandler.getGrenadeTurretSettings().getDamage() / 2F) + " " + I18n.translateToLocal(
                "tooltip.health"));
        p_77624_3_.add(I18n.translateToLocal("tooltip.aoe") + ": 3");
        p_77624_3_.add(I18n.translateToLocal("tooltip.fire_rate") + ": " + TextFormatting.WHITE + df.format(
                20.0F / ConfigHandler.getGrenadeTurretSettings().getFireRate()));
        p_77624_3_.add(I18n.translateToLocal("tooltip.energy.stat") + ": " + TextFormatting.WHITE +
                               ConfigHandler.getGrenadeTurretSettings().getPowerUsage() + " RF");
        p_77624_3_.add("");
        p_77624_3_.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.turret.2a"));
        p_77624_3_.add(TextFormatting.DARK_GRAY + I18n.translateToLocal("flavour.turret.2b"));
    }
}