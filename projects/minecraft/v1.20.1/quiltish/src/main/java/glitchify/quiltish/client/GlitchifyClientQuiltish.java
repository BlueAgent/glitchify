package glitchify.quiltish.client;

import glitchify.core.api.client.CoreClientService;
import glitchify.vanilla.client.GlitchifyClient;

public abstract class GlitchifyClientQuiltish extends GlitchifyClient {
    public static GlitchifyClientQuiltish INSTANCE;

    protected GlitchifyClientQuiltish(GameClientServiceQuiltish clientService) {
        super(clientService);
        INSTANCE = this;
    }

    protected void onInitializeClient() {
        CoreClientService.INSTANCE.init();
    }
}
