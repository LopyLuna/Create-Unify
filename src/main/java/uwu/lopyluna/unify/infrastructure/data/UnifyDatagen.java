package uwu.lopyluna.unify.infrastructure.data;

import com.tterrag.registrate.providers.ProviderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import uwu.lopyluna.unify.Unify;
import uwu.lopyluna.unify.content.data_recipes.UnifyProcessingRecipeGen;
import uwu.lopyluna.unify.registry.UnifyLangPartial;

import java.util.function.BiConsumer;

public class UnifyDatagen {
	public static void gatherData(GatherDataEvent event) {
		addExtraRegistrateData();

		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();

		if (event.includeServer()) {

			UnifyProcessingRecipeGen.registerAll(generator, output);
		}
	}

	private static void addExtraRegistrateData() {
		UnifyRegistrateTags.addGenerators();

		Unify.REGISTRATE.addDataGenerator(ProviderType.LANG, provider -> {
			BiConsumer<String, String> langConsumer = provider::add;

			providePartialLang(langConsumer);
			providePonderLang();
		});
	}

	private static void providePartialLang(BiConsumer<String, String> consumer) {
		UnifyLangPartial.provideLang(consumer);
	}

	private static void providePonderLang() {
	}
}
