package glitchify.forge;

import glitchify.Glitchify;
import glitchify.core.api.common.CoreCommonService;
import glitchify.forge.client.GlitchifyClientForge;
import glitchify.forge.common.GameCommonServiceForge;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Glitchify.MOD_ID)
public class GlitchifyForge extends Glitchify {
    public static GlitchifyForge INSTANCE;

    public GlitchifyForge() {
        super(new GameCommonServiceForge());
        INSTANCE = this;
        CoreCommonService.INSTANCE.init();
        LOGGER.info(Glitchify.NAME + " is on Forge.");
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> GlitchifyClientForge.INSTANCE.registerEvents(modEventBus, forgeEventBus));
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
