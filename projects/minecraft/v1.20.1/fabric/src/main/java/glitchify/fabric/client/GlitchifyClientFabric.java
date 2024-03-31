package glitchify.fabric.client;

import glitchify.quiltish.client.GlitchifyClientQuiltish;
import net.fabricmc.api.ClientModInitializer;

public class GlitchifyClientFabric extends GlitchifyClientQuiltish implements ClientModInitializer {
    public static GlitchifyClientQuiltish INSTANCE;

    protected GlitchifyClientFabric() {
        super(new GameClientServiceFabric());
        INSTANCE = this;
    }

    @Override
    public void onInitializeClient() {
        super.onInitializeClient();
    }
}
