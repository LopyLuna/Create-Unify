package uwu.lopyluna.create_unify.content.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BooleanDependentItem extends Item {

    private boolean aBoolean;

    public BooleanDependentItem(Item.Properties properties, boolean aBoolean) {
        super(properties);
        this.aBoolean = aBoolean;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (!aBoolean)
            super.fillItemCategory(tab, list);
    }
}
