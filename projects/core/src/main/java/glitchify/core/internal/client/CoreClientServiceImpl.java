package glitchify.core.internal.client;

import glitchify.core.api.client.CoreClientService;
import glitchify.core.api.client.GameClientService;

@SuppressWarnings("unused")
public class CoreClientServiceImpl implements CoreClientService {
    private GameClientService client;

    @Override
    public void set(GameClientService service) {
        if (client != null) {
            throw new RuntimeException("Expected only one Client Service to be instantiated.");
        }

        client = service;
    }

    @Override
    public void init() {
        if (client == null) {
            throw new RuntimeException("Expected Client Service to be set.");
        }
    }
}
