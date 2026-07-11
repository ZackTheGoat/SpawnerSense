package com.spawnersense.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;


public class SpawnerParticle extends TextureSheetParticle {
    protected SpawnerParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet spriteSet, double pXSpeed, double pYSpeed, double pZSpeed) {

        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.friction = 0.8F;
        this.lifetime = 1;

        this.setSpriteFromAge(spriteSet);

        this.rCol = 0.7f;
        this.gCol = 0.2f;
        this.bCol = 0.3f;

    }
    @Override
    public ParticleRenderType getRenderType() {
        return DepthlessParticleRenderType.DEPTHLESS;
    }

    @OnlyIn(Dist.CLIENT)
    public static class CustomProvider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public CustomProvider(SpriteSet spriteSet) {

            this.spriteSet = spriteSet;
        }
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {

            return new SpawnerParticle(pLevel, pX, pY, pZ, this.spriteSet, pXSpeed, pYSpeed, pZSpeed);
        }
    }
}

