package uwu.lopyluna.unify.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.unify.UnifyCreate;

public class UnifyCreativeModeTabs {
	public static final CreativeModeTab BASE_CREATIVE_TAB = new CreativeModeTab(UnifyCreate.MOD_ID + ".base") {
		@Override
		public @NotNull ItemStack makeIcon() {
			return new ItemStack(UnifyMaterialProvider.TIN.ingot.get());
		}
	};

}
