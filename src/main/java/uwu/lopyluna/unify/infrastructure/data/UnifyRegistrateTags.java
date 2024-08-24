package uwu.lopyluna.unify.infrastructure.data;

import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import uwu.lopyluna.unify.UnifyCreate;

public class UnifyRegistrateTags {

	public static void addGenerators() {
		UnifyCreate.REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, UnifyRegistrateTags::genBlockTags);
		UnifyCreate.REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, UnifyRegistrateTags::genItemTags);
	}
	private static void genItemTags(RegistrateTagsProvider<Item> prov) {


	}

	private static void genBlockTags(RegistrateTagsProvider<Block> prov) {


	}
}
