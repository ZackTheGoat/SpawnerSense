package com.spawnersense.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class SpawnerParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, "spawnersense");

    public static final RegistryObject<SimpleParticleType> SPAWNERPARTICLE =
            PARTICLE_TYPES.register("spawnerparticle", () -> new SimpleParticleType(true));

    public static void register (IEventBus bus){
        PARTICLE_TYPES.register(bus);

    }


}
