package me.smourad.fastertools.event;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Warning: This event is not called on the main server thread,
 * so much of the Bukkit API cannot be called directly
 * in a listener of this event.
 */
public class PlayerMiningBlockEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private final Player player;
    private final Block block;
    private final ItemStack tool;
    private double toolSpeedEfficiency;
    private boolean canHarvest;
    private boolean isBestTool;
    private boolean isCancelled;

    public PlayerMiningBlockEvent(@Nonnull final Player player, @Nonnull final Block block, @Nullable final ItemStack tool) {
        this.player = player;
        this.block = block;
        this.tool = tool;
        this.toolSpeedEfficiency = 1.0;
        this.canHarvest = false;
        this.isBestTool = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    @Nonnull
    public HandlerList getHandlers() {
        return handlers;
    }

    @Nonnull
    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Block getBlock() {
        return block;
    }

    public ItemStack getTool() {
        return tool;
    }

    public double getToolSpeedEfficiency() {
        return toolSpeedEfficiency;
    }

    public void setToolSpeedEfficiency(double toolSpeedEfficiency) {
        this.toolSpeedEfficiency = toolSpeedEfficiency;
    }

    public boolean canHarvest() {
        return canHarvest;
    }

    public void setBestTool(boolean isBestTool) {
        this.isBestTool = isBestTool;
    }

    public boolean isBestTool() {
        return isBestTool;
    }

    public void setCanHarvest(boolean canHarvest) {
        this.canHarvest = canHarvest;
    }

    public Player getPlayer() {
        return player;
    }
}
