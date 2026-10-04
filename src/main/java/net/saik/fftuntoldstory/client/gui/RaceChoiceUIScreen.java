package net.saik.fftuntoldstory.client.gui;

import net.saik.fftuntoldstory.world.inventory.RaceChoiceUIMenu;
import net.saik.fftuntoldstory.procedures.IsChosenRaceProcedure;
import net.saik.fftuntoldstory.network.RaceChoiceUIButtonMessage;
import net.saik.fftuntoldstory.init.FftUntoldStoryModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

public class RaceChoiceUIScreen extends AbstractContainerScreen<RaceChoiceUIMenu> implements FftUntoldStoryModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_remain_human;
	private Button button_become_imp;
	private Button button_become_birdman;

	public RaceChoiceUIScreen(RaceChoiceUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 134;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("fft_untold_story:textures/screens/race_choice_ui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (IsChosenRaceProcedure.execute(entity))
			guiGraphics.drawString(this.font, Component.translatable("gui.fft_untold_story.race_choice_ui.label_choose_your_race"), 41, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_remain_human = Button.builder(Component.translatable("gui.fft_untold_story.race_choice_ui.button_remain_human"), e -> {
			int x = RaceChoiceUIScreen.this.x;
			int y = RaceChoiceUIScreen.this.y;
			if (IsChosenRaceProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new RaceChoiceUIButtonMessage(0, x, y, z));
				RaceChoiceUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 40, this.topPos + 57, 87, 20).build();
		this.addRenderableWidget(button_remain_human);
		button_become_imp = Button.builder(Component.translatable("gui.fft_untold_story.race_choice_ui.button_become_imp"), e -> {
			int x = RaceChoiceUIScreen.this.x;
			int y = RaceChoiceUIScreen.this.y;
			if (IsChosenRaceProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new RaceChoiceUIButtonMessage(1, x, y, z));
				RaceChoiceUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 45, this.topPos + 86, 77, 20).build();
		this.addRenderableWidget(button_become_imp);
		button_become_birdman = Button.builder(Component.translatable("gui.fft_untold_story.race_choice_ui.button_become_birdman"), e -> {
			int x = RaceChoiceUIScreen.this.x;
			int y = RaceChoiceUIScreen.this.y;
			if (IsChosenRaceProcedure.execute(entity)) {
				ClientPacketDistributor.sendToServer(new RaceChoiceUIButtonMessage(2, x, y, z));
				RaceChoiceUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 32, this.topPos + 29, 103, 20).build();
		this.addRenderableWidget(button_become_birdman);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.button_remain_human.visible = IsChosenRaceProcedure.execute(entity);
		this.button_become_imp.visible = IsChosenRaceProcedure.execute(entity);
		this.button_become_birdman.visible = IsChosenRaceProcedure.execute(entity);
	}
}