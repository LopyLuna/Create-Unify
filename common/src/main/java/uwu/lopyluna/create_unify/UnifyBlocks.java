package uwu.lopyluna.create_unify;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;

public class UnifyBlocks {
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(Unify.MOD_ID);

	public static final BlockEntry<Block> EXAMPLE_BLOCK = REGISTRATE.block(
			"example_block", Block::new)
			.simpleItem()
			.register();

	public static void init() {
		// load the class and register everything
		Unify.LOGGER.info("Registering blocks for " + Unify.NAME);
	}
}
