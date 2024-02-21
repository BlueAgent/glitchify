package glitchify;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Glitchify {
    public static final String MOD_ID = "glitchify";
    public static final String NAME = "Glitchify";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String TRINKETS_MOD_ID = "trinkets";
    public static final String CURIOS_MOD_ID = "curios";
    public static Glitchify INSTANCE;

    protected Glitchify() {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one Glitchify to be instantiated.");
        }

        INSTANCE = this;
    }

    public abstract boolean isModLoaded(String modId);
}
