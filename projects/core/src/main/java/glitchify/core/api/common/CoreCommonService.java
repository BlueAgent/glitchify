package glitchify.core.api.common;

import glitchify.core.api.CoreUtils;

/**
 * To be implemented by core.
 */
public interface CoreCommonService {
    /**
     * For use by the game.
     */
    CoreCommonService INSTANCE = CoreUtils.loadClass("glitchify.core.internal.common.CoreCommonServiceImpl");

    /**
     * Assign an implementation of {@link GameCommonService} here.
     * Should be called in the constructor of the common mod class and only once.
     *
     * @param service implemented by the game.
     */
    void set(GameCommonService service);

    /**
     * When the common implementation is being initialized.
     */
    void init();
}
