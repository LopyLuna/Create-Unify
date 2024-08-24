package uwu.lopyluna.unify.infrastructure.tabs;

import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.registry.UnifyMaterialProvider;

public class BaseCreativeModeTab extends UnifyCreativeModeTab {
	public BaseCreativeModeTab() {
		super("base");
	}

	@Override
	@NotNull
	public ItemStack makeIcon() {
		return UnifyMaterialProvider.TIN.ingot.asStack();
	}
}
