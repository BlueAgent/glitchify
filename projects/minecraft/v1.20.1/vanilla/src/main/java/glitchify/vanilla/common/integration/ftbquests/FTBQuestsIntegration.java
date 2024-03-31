package glitchify.vanilla.common.integration.ftbquests;

import dev.ftb.mods.ftbteams.api.event.TeamEvent;
import dev.ftb.mods.ftbteams.api.property.BooleanProperty;
import glitchify.Glitchify;
import net.minecraft.resources.ResourceLocation;

public final class FTBQuestsIntegration {
    public static final BooleanProperty ONLY_OWNER_SUBMIT = new BooleanProperty(new ResourceLocation(Glitchify.MOD_ID, "only_owner_submit"), false);

    private FTBQuestsIntegration() {
    }

    public static void init() {
        TeamEvent.COLLECT_PROPERTIES.register(e -> {
            e.add(ONLY_OWNER_SUBMIT);
        });
    }
}
