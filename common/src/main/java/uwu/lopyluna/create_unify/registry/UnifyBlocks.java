package uwu.lopyluna.create_unify.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import me.alphamode.forgetags.Tags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import uwu.lopyluna.create_unify.ModContent;
import uwu.lopyluna.create_unify.Unify;
import uwu.lopyluna.create_unify.content.blocks.BooleanDependentBlock;

import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;

@SuppressWarnings({"unused"})
public class UnifyBlocks {
	private static final CreateRegistrate REGISTRATE = Unify.registrate();

	public static final BlockEntry<BooleanDependentBlock>
			TIN_BLOCK = MetalBlock("tin", ModContent.EnableTin(), "Tin", SoundType.METAL, MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			ALUMINUM_BLOCK = MetalBlock("aluminum", ModContent.EnableAluminum(), "Aluminum", SoundType.METAL, MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			LEAD_BLOCK = MetalBlock("lead", ModContent.EnableLead(), "Lead", SoundType.NETHERITE_BLOCK, MaterialColor.TERRACOTTA_PURPLE, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			SILVER_BLOCK = MetalBlock("silver", ModContent.EnableSilver(), "Silver", SoundType.METAL, MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			PLATINUM_BLOCK = MetalBlock("platinum", ModContent.EnablePlatinum(), "Platinum", SoundType.METAL, MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			URANIUM_BLOCK = MetalBlock("uranium", ModContent.EnableUranium(), "Uranium", SoundType.METAL, MaterialColor.TERRACOTTA_GREEN, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			BRONZE_BLOCK = MetalBlock("bronze", ModContent.EnableBronze(), "Bronze", SoundType.NETHERITE_BLOCK, MaterialColor.TERRACOTTA_ORANGE, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			ELECTRUM_BLOCK = MetalBlock("electrum", ModContent.EnableElectrum(), "Electrum", SoundType.METAL, MaterialColor.COLOR_YELLOW, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			CAST_IRON_BLOCK = MetalBlock("cast_iron", ModContent.EnableCastIron(), "Cast Iron", SoundType.NETHERITE_BLOCK, MaterialColor.TERRACOTTA_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK),
			STEEL_BLOCK = MetalBlock("steel", ModContent.EnableSteel(), "Steel", SoundType.NETHERITE_BLOCK, MaterialColor.COLOR_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.IRON_BLOCK)
	;

	public static final BlockEntry<BooleanDependentBlock>
			RAW_TIN_BLOCK = RawOreBlock("tin", ModContent.EnableTin(), "Tin", SoundType.STONE, MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			RAW_ALUMINUM_BLOCK = RawOreBlock("aluminum", ModContent.EnableAluminum(), "Aluminum", SoundType.STONE, MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			RAW_LEAD_BLOCK = RawOreBlock("lead", ModContent.EnableLead(), "Lead", SoundType.STONE, MaterialColor.TERRACOTTA_PURPLE, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			RAW_SILVER_BLOCK = RawOreBlock("silver", ModContent.EnableSilver(), "Silver", SoundType.STONE, MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			RAW_PLATINUM_BLOCK = RawOreBlock("platinum", ModContent.EnablePlatinum(), "Platinum", SoundType.STONE, MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			RAW_URANIUM_BLOCK = RawOreBlock("uranium", ModContent.EnableUranium(), "Uranium", SoundType.STONE, MaterialColor.TERRACOTTA_GREEN, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK)
	;

	public static final BlockEntry<BooleanDependentBlock>
			TIN_ORE = OreBlock(UnifyItems.RAW_TIN.get() , "tin", ModContent.EnableTin(), "Tin", MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			ALUMINUM_ORE = OreBlock(UnifyItems.RAW_TIN.get() , "aluminum", ModContent.EnableAluminum(), "Aluminum", MaterialColor.QUARTZ, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			LEAD_ORE = OreBlock(UnifyItems.RAW_LEAD.get() , "lead", ModContent.EnableLead(), "Lead", MaterialColor.TERRACOTTA_PURPLE, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			SILVER_ORE = OreBlock(UnifyItems.RAW_SILVER.get() , "silver", ModContent.EnableSilver(), "Silver", MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			PLATINUM_ORE = OreBlock(UnifyItems.RAW_PLATINUM.get() , "platinum", ModContent.EnablePlatinum(), "Platinum", MaterialColor.COLOR_LIGHT_GRAY, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK),
			URANIUM_ORE = OreBlock(UnifyItems.RAW_URANIUM.get() , "uranium", ModContent.EnableUranium(), "Uranium", MaterialColor.TERRACOTTA_GREEN, BlockTags.NEEDS_IRON_TOOL, () -> Blocks.RAW_IRON_BLOCK)
	;

	public static BlockEntry<BooleanDependentBlock> MetalBlock(String id, boolean aBoolean, String lang, SoundType soundType, MaterialColor color, TagKey<Block> tags, NonNullSupplier<? extends Block> block) {
		return REGISTRATE.block(id + "_block", props -> new BooleanDependentBlock(props, aBoolean))
				.initialProperties(block)
				.properties(p -> p.color(color).requiresCorrectToolForDrops())
				.properties(p -> p.sound(soundType))
				.transform(pickaxeOnly())
				.blockstate(simpleCubeAll(id + "_block"))
				.tag(tags)
				.tag(Tags.Blocks.STORAGE_BLOCKS)
				.tag(BlockTags.BEACON_BASE_BLOCKS)
				.transform(tagBlockAndItem(id + "_block"))
				.tag(Tags.Items.STORAGE_BLOCKS)
				.build()
				.lang("Block of " + lang)
				.register();
	}

	public static BlockEntry<BooleanDependentBlock> RawOreBlock(String id, boolean aBoolean, String lang, SoundType soundType, MaterialColor color, TagKey<Block> tags, NonNullSupplier<? extends Block> block) {
		return REGISTRATE.block("raw_" + id + "_block", props -> new BooleanDependentBlock(props, aBoolean))
				.initialProperties(block)
				.properties(p -> p.color(color).requiresCorrectToolForDrops())
				.properties(p -> p.sound(soundType))
				.transform(pickaxeOnly())
				.tag(Tags.Blocks.STORAGE_BLOCKS)
				.tag(tags)
				.lang("Block of Raw " + lang)
				.transform(tagBlockAndItem("raw_" + id + "_blocks"))
				.tag(Tags.Items.STORAGE_BLOCKS)
				.build()
				.register();
	}

	public static BlockEntry<BooleanDependentBlock> OreBlock(ItemLike rawOre, String id, boolean aBoolean, String lang, MaterialColor color, TagKey<Block> tags, NonNullSupplier<? extends Block> block) {
		REGISTRATE.block("deepslate_" + id + "_ore", props -> new BooleanDependentBlock(props, aBoolean))
			.initialProperties(block)
			.properties(p -> p.color(color).requiresCorrectToolForDrops())
			.properties(p -> p.sound(SoundType.DEEPSLATE))
			.transform(pickaxeOnly())
			.lang("Deepslate" + lang + " Ore")
			.loot((lt, b) -> lt.add(b,
					RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
							RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(rawOre)
									.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
			.tag(tags)
			.tag(Tags.Blocks.ORES)
			.transform(tagBlockAndItem(id + "_ores", "ores_in_ground/deepslate"))
			.tag(Tags.Items.ORES)
			.build()
			.register();
		return REGISTRATE.block(id + "_ore", props -> new BooleanDependentBlock(props, aBoolean))
				.initialProperties(block)
				.properties(p -> p.color(color).requiresCorrectToolForDrops())
				.properties(p -> p.sound(SoundType.STONE))
				.transform(pickaxeOnly())
				.lang(lang + " Ore")
				.loot((lt, b) -> lt.add(b,
						RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
								RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(rawOre)
										.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
				.tag(tags)
				.tag(Tags.Blocks.ORES)
				.transform(tagBlockAndItem(id + "_ores", "ores_in_ground/stone"))
				.tag(Tags.Items.ORES)
				.build()
				.register();
	}
	public static void register() {}
}
