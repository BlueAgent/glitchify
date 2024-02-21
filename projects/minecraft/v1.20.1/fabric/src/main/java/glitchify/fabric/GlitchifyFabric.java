package glitchify.fabric;

import glitchify.Glitchify;
import glitchify.quiltish.GlitchifyQuiltish;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class GlitchifyFabric extends GlitchifyQuiltish implements ModInitializer {
    public static GlitchifyFabric INSTANCE;

    public GlitchifyFabric() {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one GlitchifyFabric to be instantiated.");
        }

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
