package glitchify.vanilla;

import dev.ftb.mods.ftbteams.api.FTBTeamsAPI;
import dev.ftb.mods.ftbteams.api.Team;
import dev.ftb.mods.ftbteams.api.TeamRank;
import glitchify.vanilla.common.integration.ftbquests.FTBQuestsIntegration;
import net.minecraft.server.level.ServerPlayer;

public class MixinHooks {
    /**
     * For preventing task submission in some cases.
     *
     * @param player Player that is submitting the task.
     * @return true if the {@param player} can submit tasks.
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public static boolean canSubmitTasks(ServerPlayer player) {
        Team team = FTBTeamsAPI.api().getManager().getTeamForPlayerID(player.getUUID()).orElse(null);
        if (team == null) {
            return true;
        }

        if (!team.getProperty(FTBQuestsIntegration.ONLY_OWNER_SUBMIT)) {
            return true;
        }

        TeamRank rank = team.getRankForPlayer(player.getGameProfile().getId());

        return rank == TeamRank.OWNER;
    }
}
