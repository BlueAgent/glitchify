package glitchify.quilt.client;

import glitchify.quiltish.client.GlitchifyClientQuiltish;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@SuppressWarnings("unused")
public class GlitchifyClientQuilt extends GlitchifyClientQuiltish implements ClientModInitializer {
    public static GlitchifyClientQuiltish INSTANCE;

    protected GlitchifyClientQuilt() {
        super(new GameClientServiceQuilt());
        INSTANCE = this;
    }

    @Override
    public void onInitializeClient(ModContainer mod) {
        super.onInitializeClient();
    }
}
