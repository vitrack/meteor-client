/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client/).
 * Copyright (c) 2020 Meteor Development.
 */

package minegame159.meteorclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import minegame159.meteorclient.modules.ModuleManager;
import minegame159.meteorclient.modules.render.NoRender;
import minegame159.meteorclient.utils.Utils;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;

@Mixin(Screen.class)
public class ScreenMixin {

	@Shadow
	public int width;

	@Shadow
	public int height;

	@Inject(method = "renderBackground(Lnet/minecraft/client/util/math/MatrixStack;)V", at = @At("HEAD"), cancellable = true)
	private void onRenderBackground(CallbackInfo info) {
		if (Utils.canUpdate() && ModuleManager.INSTANCE.get(NoRender.class).noGuiBackground())
			info.cancel();
	}

	@Shadow
	public <T extends AbstractButtonWidget> T addButton(final T button) {
		return null;
	}

	@Shadow
	public void tick() {

	}
}
