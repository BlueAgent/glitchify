package glitchify.forge.client;

import glitchify.core.api.client.CoreClientService;
import glitchify.vanilla.client.GlitchifyClient;
import net.minecraftforge.eventbus.api.IEventBus;

public class GlitchifyClientForge extends GlitchifyClient {
    public static final GlitchifyClientForge INSTANCE = new GlitchifyClientForge();

    public GlitchifyClientForge() {
        super(new GameClientServiceForge());
        CoreClientService.INSTANCE.init();
    }

    public void registerEvents(IEventBus modEventBus, IEventBus forgeEventBus) {
    }
}
