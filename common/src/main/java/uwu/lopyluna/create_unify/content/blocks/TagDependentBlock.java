package uwu.lopyluna.create_unify.content.blocks;

import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class TagDependentBlock extends Block {

    private TagKey<Item> tag;

    public TagDependentBlock(Properties properties, TagKey<Item> itemTagKey) {
        super(properties);
        this.tag = itemTagKey;
    }

    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (!shouldHide())
            super.fillItemCategory(tab, list);
    }

    public boolean shouldHide() {
        boolean tagMissing = !Registry.ITEM.isKnownTagName(this.tag);
        boolean tagEmpty = tagMissing || !Registry.ITEM.getTagOrEmpty(this.tag).iterator().hasNext();
        return tagMissing || tagEmpty;
    }
}
