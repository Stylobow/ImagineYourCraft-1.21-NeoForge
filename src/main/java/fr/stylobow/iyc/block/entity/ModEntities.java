package fr.stylobow.iyc.block.entity;

import fr.stylobow.iyc.ImagineYourCraft;
import fr.stylobow.iyc.block.entity.custom.ChairEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, ImagineYourCraft.MOD_ID);

    public static final Supplier<EntityType<ChairEntity>> CHAIR_ENTITY =
            ENTITY_TYPES.register("chair_entity", () -> EntityType.Builder.<ChairEntity>of(ChairEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.55f)
                    .build("chair_entity"));
}