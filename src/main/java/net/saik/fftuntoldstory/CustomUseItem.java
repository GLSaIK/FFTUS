package net.saik.fftuntoldstory.client;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import net.saik.fftuntoldstory.item.TemplarShieldItem;


/**
 * Список предметов, которые не должны замедлять игрока
 * во время использования через ПКМ.
 *
 * Здесь можно просто добавлять свои предметы.
 */
public class CustomUseItem {

    /**
     * Проверяет, должен ли предмет игнорировать
     * ванильное замедление при использовании.
     */
    public static boolean shouldIgnoreUseSlowdown(ItemStack stack) {

        if (stack == null || stack.isEmpty()) {
            return false;
        }

        Item item = stack.getItem();

        /*
         * ============================================================
         * ДОБАВЛЯЙ СЮДА ПРЕДМЕТЫ
         * ============================================================
         *
         * Например:
         *
         * if (item instanceof TemplarShieldItem) {
         *     return true;
         * }
         *
         * Можно добавлять сколько угодно предметов.
         *
         * Важно:
         * здесь можно указывать не только щиты.
         * Подойдут любые твои Item-классы.
         */

        if (item instanceof TemplarShieldItem) {
            return true;
        }

        /*
         * Пример для другого собственного предмета:
         *
         * if (item instanceof MyCustomItem) {
         *     return true;
         * }
         */

        return false;
    }
}
