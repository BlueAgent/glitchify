package glitchify.forge;

import glitchify.Glitchify;
import glitchify.forge.client.GlitchifyForgeClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.IExtensionPoint;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkConstants;

@Mod(Glitchify.MOD_ID)
public class GlitchifyForge extends Glitchify {
    public static GlitchifyForge INSTANCE;

    public GlitchifyForge() {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one GlitchifyForge to be instantiated.");
        }

        INSTANCE = this;
        LOGGER.info(Glitchify.NAME + " is on Forge.");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> GlitchifyForgeClient.INSTANCE.registerEvents(modEventBus, forgeEventBus));
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
