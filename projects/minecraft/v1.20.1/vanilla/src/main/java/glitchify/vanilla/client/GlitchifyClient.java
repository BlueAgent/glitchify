package glitchify.vanilla.client;

import glitchify.core.api.client.CoreClientService;

public abstract class GlitchifyClient {
    public static GlitchifyClient INSTANCE;

    public GlitchifyClient(GameClientServiceVanilla clientService) {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one GlitchifyClient to be instantiated.");
        }

        INSTANCE = this;
        CoreClientService.INSTANCE.set(clientService);
    }
}
