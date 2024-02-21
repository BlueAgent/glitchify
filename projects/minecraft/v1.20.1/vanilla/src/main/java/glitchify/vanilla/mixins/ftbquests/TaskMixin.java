package glitchify.vanilla.mixins.ftbquests;

import dev.ftb.mods.ftbquests.quest.QuestObject;
import dev.ftb.mods.ftbquests.quest.TeamData;
import dev.ftb.mods.ftbquests.quest.task.Task;
import glitchify.vanilla.MixinHooks;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Task.class)
public abstract class TaskMixin extends QuestObject {
    public TaskMixin(long id) {
        super(id);
    }

    @Inject(method = "Ldev/ftb/mods/ftbquests/quest/task/Task;submitTask(Ldev/ftb/mods/ftbquests/quest/TeamData;Lnet/minecraft/server/level/ServerPlayer;)V",
            at = @At("HEAD"),
            cancellable = true)
    public final void submitTask(TeamData teamData, ServerPlayer player, CallbackInfo ci) {
        if (!MixinHooks.canSubmitTasks(player)) {
            ci.cancel();
        }
    }
}
