package com.spawnersense;

import com.spawnersense.client.particle.SpawnerParticles;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.SpawnerBlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = "spawnersense")
public class RenderEvent {
    public static int timer = 0;

    @SubscribeEvent
    public static void showSpawners(final RenderLevelStageEvent event) {
        if ((event.getStage() == RenderLevelStageEvent.Stage.AFTER_WEATHER) && (timer > 30)){
            Level level = Minecraft.getInstance().level;
            Vec3 playerFacing = Minecraft.getInstance().player.getForward();
            Vec3 playerPos = Minecraft.getInstance().player.getPosition(0);
            AABB area = new AABB(playerPos.x + 8, playerPos.y + 8, playerPos.z +8, playerPos.x - 8, playerPos.y -8, playerPos.z - 8);
            for (BlockPos i: BlockPos.withinManhattan(new BlockPos((int)playerPos.x, (int)playerPos.y, (int)playerPos.z), 8, 8, 8)) {
                if (level.getExistingBlockEntity(i) instanceof SpawnerBlockEntity) {
                    Double d0 = (double) i.getX();
                    Double d1 = (double) i.getY();
                    Double d2 = (double) i.getZ();
                    level.addParticle(SpawnerParticles.SPAWNERPARTICLE.get(), d0 + 0.5D, d1 + 0.5D, d2 + 0.5D, 0.0D, 0.0D, 0.0D);
                }
            }
            timer = 0;
        }
        else timer++;

    }

}



