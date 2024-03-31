package glitchify.core.internal.common;

import glitchify.core.api.common.CoreCommonService;
import glitchify.core.api.common.GameCommonService;

@SuppressWarnings("unused")
public class CoreCommonServiceImpl implements CoreCommonService {
    private GameCommonService common;

    @Override
    public void set(GameCommonService service) {
        if (common != null) {
            throw new RuntimeException("Expected only one Common Service to be instantiated.");
        }

        common = service;
    }

    @Override
    public void init() {
        if (common == null) {
            throw new RuntimeException("Expected Common Service to be set.");
        }
    }
}
