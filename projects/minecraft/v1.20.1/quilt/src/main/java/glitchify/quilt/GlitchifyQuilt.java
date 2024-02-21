package glitchify.quilt;

import glitchify.Glitchify;
import glitchify.quiltish.GlitchifyQuiltish;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class GlitchifyQuilt extends GlitchifyQuiltish implements ModInitializer {
    public static GlitchifyQuilt INSTANCE;

    public GlitchifyQuilt() {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one GlitchifyQuilt to be instantiated.");
        }

        INSTANCE = this;
        Glitchify.LOGGER.info(Glitchify.NAME + " is on Quilt");
    }

    @Override
    public void onInitialize(ModContainer mod) {
        super.onInitialize();
    }

    @Override
    public boolean isModLoaded(String modId) {
        return QuiltLoader.isModLoaded(modId);
    }
}
