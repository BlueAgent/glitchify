package glitchify.core.api.client;

import glitchify.core.api.CoreUtils;

/**
 * To be implemented by core.
 */
public interface CoreClientService {
    /**
     * For use by the game.
     */
    CoreClientService INSTANCE = CoreUtils.loadClass("glitchify.core.internal.client.CoreClientServiceImpl");

    /**
     * Assign an implementation of {@link GameClientService} here.
     * Should be called in the constructor of the client mod class and only once.
     *
     * @param service implemented by the game.
     */
    void set(GameClientService service);

    /**
     * When the client implementation is being initialized.
     */
    void init();
}
