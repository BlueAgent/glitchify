package glitchify.vanilla.mixins.ftbquests;

import dev.ftb.mods.ftbquests.util.FTBQuestsInventoryListener;
import glitchify.vanilla.MixinHooks;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.ContainerListener;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FTBQuestsInventoryListener.class)
public abstract class FTBQuestsInventoryListenerMixin implements ContainerListener {
    @Inject(method = "detect(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/world/item/ItemStack;J)V",
            at = @At("HEAD"),
            cancellable = true)
    private static void detect(ServerPlayer player, ItemStack craftedItem, long sourceTask, CallbackInfo ci) {
        if (!MixinHooks.canSubmitTasks(player)) {
            ci.cancel();
        }
    }
}
