package glitchify.quiltish;

import glitchify.Glitchify;
import glitchify.core.api.common.CoreCommonService;
import glitchify.quiltish.common.GameCommonServiceQuiltish;

public abstract class GlitchifyQuiltish extends Glitchify {
    public static GlitchifyQuiltish INSTANCE;

    protected GlitchifyQuiltish(GameCommonServiceQuiltish commonService) {
        super(commonService);
        INSTANCE = this;
    }

    protected void onInitialize() {
        CoreCommonService.INSTANCE.init();
    }
}
