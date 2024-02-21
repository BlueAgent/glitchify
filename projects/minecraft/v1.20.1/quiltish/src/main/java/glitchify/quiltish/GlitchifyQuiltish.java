package glitchify.quiltish;

import glitchify.Glitchify;

public abstract class GlitchifyQuiltish extends Glitchify {
    public static GlitchifyQuiltish INSTANCE;

    protected GlitchifyQuiltish() {
        if (INSTANCE != null) {
            throw new RuntimeException("Expected only one GlitchifyQuiltish to be instantiated.");
        }

        INSTANCE = this;
    }

    protected void onInitialize() {
    }
}
