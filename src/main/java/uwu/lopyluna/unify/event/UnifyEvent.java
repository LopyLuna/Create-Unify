package uwu.lopyluna.unify.event;

import com.simibubi.create.foundation.ModFilePackResources;
import com.simibubi.create.foundation.utility.Components;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.language.IModFileInfo;
import net.minecraftforge.forgespi.locating.IModFile;
import net.minecraftforge.registries.ForgeRegistries;
import uwu.lopyluna.unify.Unify;
import uwu.lopyluna.unify.registry.UnifyMaterialProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static uwu.lopyluna.unify.registry.UnifyMaterialProvider.getTagEntries;

@SuppressWarnings("deprecation")
@Mod.EventBusSubscriber
public class UnifyEvent {

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModBusEvents {

        @SubscribeEvent
        public static void addPackFinders(AddPackFindersEvent event) {
            if (event.getPackType() == PackType.SERVER_DATA) {
                IModFileInfo modFileInfo = ModList.get().getModFileById(Unify.MOD_ID);
                if (modFileInfo == null) {
                    Unify.LOGGER.error("Could not find " + Unify.NAME + " mod file info; built-in data packs will be missing!");
                    return;
                }
                IModFile modFile = modFileInfo.getFile();
                event.addRepositorySource(consumer -> {
                    Pack pack = Pack.readMetaAndCreate(Unify.asResource("create_unify_ore_gen").toString(), Components.literal("Create Unify Ore Generation by Phoenix492"), false,
                            id -> new ModFilePackResources(id, modFile, "server_packs/create_unify_ore_gen"), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.BUILT_IN);
                    if (pack != null) {
                        consumer.accept(pack);
                    }
                });
            }
            if (event.getPackType() == PackType.CLIENT_RESOURCES) {
                IModFileInfo modFileInfo = ModList.get().getModFileById(Unify.MOD_ID);
                if (modFileInfo == null) {
                    Unify.LOGGER.error("Could not find " + Unify.NAME + " mod file info; built-in resource packs will be missing!");
                    return;
                }
                IModFile modFile = modFileInfo.getFile();
                event.addRepositorySource(consumer -> {
                    Pack pack = Pack.readMetaAndCreate(Unify.asResource("create_ore_retexture").toString(), Components.literal("Create Ore Retexture"), true,
                            id -> new ModFilePackResources(id, modFile, "resource_packs/create_ore_retexture"), PackType.CLIENT_RESOURCES, Pack.Position.TOP, PackSource.BUILT_IN);
                    if (pack != null) {
                        consumer.accept(pack);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityEvent event) {
        if (event.getEntity() instanceof ItemEntity itemEntity && !UnifyMaterialProvider.getEntries().isEmpty()) {
            ItemStack itemStack = itemEntity.getItem();
            Item item = itemStack.getItem();
            for (String modIDs : getModIDs()) { if (safeModId(item).contains(modIDs)) {
                for (Item itemEntry : UnifyMaterialProvider.getEntries()) {
                    if (safeId(item).equals(safeId(itemEntry).replace("unify:", ""))) {
                        ItemStack newItemstack = new ItemStack(itemEntry);
                        newItemstack.setCount(itemStack.getCount());
                        itemEntity.setItem(newItemstack);
                    } else {
                        for (TagKey<Item> tagKey : itemEntry.builtInRegistryHolder().tags().toList()) {
                            for (TagKey<Item> itemTagKey : getTagEntries()) {
                                if (item.builtInRegistryHolder().containsTag(tagKey) && tagKey == itemTagKey) {
                                    ItemStack newItemstack = new ItemStack(itemEntry);
                                    newItemstack.setCount(itemStack.getCount());
                                    itemEntity.setItem(newItemstack);
                                }
                            }
                        }
                    }
                }
            }}
        }
    }

    @SubscribeEvent
    public static void onLivingEntityTick(LivingEvent.LivingTickEvent event) {
        if (event.getEntity() instanceof Player player && !UnifyMaterialProvider.getEntries().isEmpty() && !(player.containerMenu instanceof CreativeModeInventoryScreen.ItemPickerMenu)) {
            List<Slot> slots = player.hasContainerOpen() ? player.containerMenu.slots : player.inventoryMenu.slots;
            for (Slot slot : slots) {
                ItemStack itemStack = slot.getItem();
                Item item = itemStack.getItem();
                for (String modIDs : getModIDs()) { if (safeModId(item).contains(modIDs)) {
                    for (Item itemEntry : UnifyMaterialProvider.getEntries()) {
                        if (safeId(item).equals(safeId(itemEntry).replace("unify:", ""))) {
                            ItemStack newItemstack = new ItemStack(itemEntry);
                            newItemstack.setCount(itemStack.getCount());
                            itemStack.shrink(itemStack.getCount());
                            slot.set(newItemstack);
                        } else {
                            for (TagKey<Item> tagKey : itemEntry.builtInRegistryHolder().tags().toList()) {
                                for (TagKey<Item> itemTagKey : getTagEntries()) {
                                    if (item.builtInRegistryHolder().containsTag(tagKey) && tagKey == itemTagKey) {
                                        ItemStack newItemstack = new ItemStack(itemEntry);
                                        newItemstack.setCount(itemStack.getCount());
                                        itemStack.shrink(itemStack.getCount());
                                        slot.set(newItemstack);
                                    }
                                }
                            }
                        }
                    }
                }}
            }
        }
    }


    protected static List<String> getModIDs() {
        List<String> modIDs = new ArrayList<>();
        modIDs.add("createaddition");
        modIDs.add("createbigcannons");
        modIDs.add("createdeco");
        modIDs.add("create_dd");
        modIDs.add("northstar");
        modIDs.add("createindustry");
        modIDs.add("create_new_age");
        modIDs.add("alloyed");
        modIDs.add("creatingspace");
        modIDs.add("ad_astra");

        return modIDs;
    }

    private static String safeModId(ItemLike registryEntry) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(registryEntry.asItem())).getNamespace();
    }
    private static String safeId(ItemLike registryEntry) {
        return safeName(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(registryEntry.asItem())));
    }
    private static String safeName(ResourceLocation id) {
        return id.getPath().replace('/', '_');
    }
}
