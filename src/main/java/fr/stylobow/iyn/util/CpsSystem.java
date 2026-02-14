package fr.stylobow.iyn.util;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = "iyn", value = Dist.CLIENT)
public class CpsSystem {

    private static final List<Long> leftClicks = new ArrayList<>();
    private static final List<Long> rightClicks = new ArrayList<>();

    @SubscribeEvent
    public static void onMouseClick(InputEvent.MouseButton.Pre event) {
        if (event.getAction() == 1) {
            long now = System.currentTimeMillis();
            if (event.getButton() == 0) leftClicks.add(now);
            if (event.getButton() == 1) rightClicks.add(now);
        }
    }

    public static int getLeftCps() {
        cleanup(leftClicks);
        return leftClicks.size();
    }

    public static int getRightCps() {
        cleanup(rightClicks);
        return rightClicks.size();
    }

    private static void cleanup(List<Long> clicks) {
        long now = System.currentTimeMillis();
        clicks.removeIf(time -> time < now - 1000);
    }
}