package glitchify.quilt;

import glitchify.Glitchify;
import glitchify.quilt.common.GameCommonServiceQuilt;
import glitchify.quiltish.GlitchifyQuiltish;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.QuiltLoader;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

@SuppressWarnings("unused")
public class GlitchifyQuilt extends GlitchifyQuiltish implements ModInitializer {
    public static GlitchifyQuilt INSTANCE;

    public GlitchifyQuilt() {
        super(new GameCommonServiceQuilt());
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
