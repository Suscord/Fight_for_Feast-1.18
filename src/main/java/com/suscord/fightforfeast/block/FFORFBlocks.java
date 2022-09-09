package com.suscord.fightforfeast.block;

import com.suscord.fightforfeast.FightforFeastMod;
import com.suscord.fightforfeast.item.FFORFCreativeModeTab;
import com.suscord.fightforfeast.item.FFORFItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class FFORFBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FightforFeastMod.MOD_ID);

    public static final RegistryObject<Block> PEPPERMINT_BLOCK = registerBlock("peppermint_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)),
            FFORFCreativeModeTab.TAB_FFORF);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn,tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {

        return FFORFItems.ITEMS.register(name, () -> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

