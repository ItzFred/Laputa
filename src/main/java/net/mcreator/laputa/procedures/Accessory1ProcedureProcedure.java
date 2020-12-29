package net.mcreator.laputa.procedures;

import net.minecraft.util.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.laputa.LaputaModVariables;
import net.mcreator.laputa.LaputaModElements;

import java.util.function.Supplier;
import java.util.Map;

@LaputaModElements.ModElement.Tag
public class Accessory1ProcedureProcedure extends LaputaModElements.ModElement {
	public Accessory1ProcedureProcedure(LaputaModElements instance) {
		super(instance, 173);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Accessory1Procedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((ItemTags.getCollection().getOrCreate(new ResourceLocation(("forge:accessories").toLowerCase(java.util.Locale.ENGLISH)))
				.contains((new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (0))).getItem())) && (((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory1).getItem() == (ItemStack.EMPTY).getItem()))) {
			{
				ItemStack _setval = (new Object() {
					public ItemStack getItemStack(int sltid) {
						Entity _ent = entity;
						if (_ent instanceof ServerPlayerEntity) {
							Container _current = ((ServerPlayerEntity) _ent).openContainer;
							if (_current instanceof Supplier) {
								Object invobj = ((Supplier) _current).get();
								if (invobj instanceof Map) {
									return ((Slot) ((Map) invobj).get(sltid)).getStack();
								}
							}
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack((int) (0)));
				entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Accessory1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
						_current.detectAndSendChanges();
					}
				}
			}
		} else if ((((new Object() {
			public ItemStack getItemStack(int sltid) {
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) _ent).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							return ((Slot) ((Map) invobj).get(sltid)).getStack();
						}
					}
				}
				return ItemStack.EMPTY;
			}
		}.getItemStack((int) (0))).getItem() == (ItemStack.EMPTY).getItem())
				&& (!(((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new LaputaModVariables.PlayerVariables())).Accessory1).getItem() == (ItemStack.EMPTY).getItem())))) {
			if (entity instanceof PlayerEntity) {
				Container _current = ((PlayerEntity) entity).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						ItemStack _setstack = ((entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new LaputaModVariables.PlayerVariables())).Accessory1);
						_setstack.setCount((int) 1);
						((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
						_current.detectAndSendChanges();
					}
				}
			}
			{
				ItemStack _setval = (ItemStack.EMPTY);
				entity.getCapability(LaputaModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Accessory1 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
