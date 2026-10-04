package net.saik.fftuntoldstory.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.saik.fftuntoldstory.network.FftUntoldStoryModVariables;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BirdmanDashProcedure {

    // 50 секунд = 1000 тиков
    private static final long COOLDOWN_TICKS = 1000;

    // Продолжительность рывка
    private static final int DASH_TICKS = 10;

    // Скорость в начале рывка
    private static final double DASH_SPEED = 1.8;

    // Храним время последнего использования
    private static final Map<UUID, Long> LAST_DASH = new HashMap<>();

    // Храним направление текущего рывка
    private static final Map<UUID, Vec3> DASH_DIRECTION = new HashMap<>();

    // Храним оставшееся время рывка
    private static final Map<UUID, Integer> DASH_TIME = new HashMap<>();


    public static void execute(Level level, Player player) {

        if (level == null || player == null) {
            return;
        }

        // Только сервер
        if (level.isClientSide()) {
            return;
        }

        // Проверяем Birdman
        if (!player.getData(
                FftUntoldStoryModVariables.PLAYER_VARIABLES
        ).Birdman) {
            return;
        }

        UUID uuid = player.getUUID();
        long currentTick = level.getGameTime();

        // Проверяем, не находится ли игрок уже в рывке
        if (DASH_TIME.containsKey(uuid)) {
            return;
        }

        // Проверяем перезарядку
        if (LAST_DASH.containsKey(uuid)) {

            long lastDash = LAST_DASH.get(uuid);

            if (currentTick - lastDash < COOLDOWN_TICKS) {
                return;
            }
        }

        // Получаем направление взгляда
        Vec3 direction = player.getLookAngle().normalize();

        // Запоминаем направление
        DASH_DIRECTION.put(uuid, direction);

        // Запускаем рывок
        DASH_TIME.put(uuid, DASH_TICKS);

        // Запоминаем время использования
        LAST_DASH.put(uuid, currentTick);

        // Начальный импульс
        player.setDeltaMovement(
                direction.x * DASH_SPEED,
                direction.y * DASH_SPEED,
                direction.z * DASH_SPEED
        );

        player.hurtMarked = true;
    }


    /**
     * Этот метод нужно вызывать каждый тик игрока.
     */
    public static void tick(Player player) {

        if (player == null) {
            return;
        }

        if (player.level().isClientSide()) {
            return;
        }

        UUID uuid = player.getUUID();

        if (!DASH_TIME.containsKey(uuid)) {
            return;
        }

        int remaining = DASH_TIME.get(uuid);

        Vec3 direction = DASH_DIRECTION.get(uuid);

        if (direction == null) {
            DASH_TIME.remove(uuid);
            return;
        }

        // Постепенно уменьшаем скорость
        double progress = (double) remaining / DASH_TICKS;

        double speed = DASH_SPEED * progress;

        player.setDeltaMovement(
                direction.x * speed,
                direction.y * speed,
                direction.z * speed
        );

        player.hurtMarked = true;

        remaining--;

        if (remaining <= 0) {

            DASH_TIME.remove(uuid);
            DASH_DIRECTION.remove(uuid);

            // Убираем остаточную скорость
            Vec3 velocity = player.getDeltaMovement();

            player.setDeltaMovement(
                    velocity.x * 0.2,
                    velocity.y * 0.2,
                    velocity.z * 0.2
            );

        } else {
            DASH_TIME.put(uuid, remaining);
        }
    }
}