package net.mcreator.laputa.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.laputa.LaputaModVariables;
import net.mcreator.laputa.LaputaModElements;

import java.util.function.Supplier;
import java.util.Map;

@LaputaModElements.ModElement.Tag
public class AccessoryBagThisGUIIsOpenedProcedure extends LaputaModElements.ModElement {
	public AccessoryBagThisGUIIsOpenedProcedure(LaputaModElements instance) {
		super(instance, 177);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AccessoryBagThisGUIIsOpened!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = ((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new LaputaModVariables.PlayerVariables())).Accessory1);
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = ((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new LaputaModVariables.PlayerVariables())).Accessory2);
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (entity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) entity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = ((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new LaputaModVariables.PlayerVariables())).Accessory3);
					_setstack.setCount((int) 1);
					((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
