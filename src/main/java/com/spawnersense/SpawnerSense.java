package com.spawnersense;

import com.mojang.logging.LogUtils;
import com.spawnersense.client.particle.SpawnerParticle;
import com.spawnersense.client.particle.SpawnerParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("spawnersense")
public class SpawnerSense {
  public static Logger logger = LogUtils.getLogger();
  public SpawnerSense(FMLJavaModLoadingContext context){
    SpawnerParticles.PARTICLE_TYPES.register(context.getModEventBus());
  }
  @Mod.EventBusSubscriber(modid = "spawnersense", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvent {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      // Some client setup code
      logger.info("HELLO FROM CLIENT SETUP");
      logger.info("baaa :3");
    }
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event){

      event.registerSpriteSet(SpawnerParticles.SPAWNERPARTICLE.get(), SpawnerParticle.CustomProvider::new);
    }

  }


  }
