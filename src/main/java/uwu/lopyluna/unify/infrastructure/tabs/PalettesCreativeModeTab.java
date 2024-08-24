package uwu.lopyluna.unify.infrastructure.tabs;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class PalettesCreativeModeTab extends UnifyCreativeModeTab {
	public PalettesCreativeModeTab() {
		super("palettes");
	}

	@Override
	public void addItems(NonNullList<ItemStack> items, boolean specialItems) {
	}

	@Override
	@NotNull
	public ItemStack makeIcon() {
		return Items.GLASS.getDefaultInstance();
	}
}
