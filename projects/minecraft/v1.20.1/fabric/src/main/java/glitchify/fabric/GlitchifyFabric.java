package glitchify.fabric;

import glitchify.Glitchify;
import glitchify.fabric.common.GameCommonServiceFabric;
import glitchify.quiltish.GlitchifyQuiltish;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class GlitchifyFabric extends GlitchifyQuiltish implements ModInitializer {
    public static GlitchifyFabric INSTANCE;

    public GlitchifyFabric() {
        super(new GameCommonServiceFabric());
        INSTANCE = this;
        Glitchify.LOGGER.info(Glitchify.NAME + " is on Fabric.");
    }

    @Override
    public void onInitialize() {
        super.onInitialize();
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
