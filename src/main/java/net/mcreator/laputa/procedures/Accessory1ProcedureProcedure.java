package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class Accessory1ProcedureProcedure extends LaputaModElements.ModElement {

	public Accessory1ProcedureProcedure(LaputaModElements instance) {
		super(instance, 173);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Accessory1Procedure!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if (((!((new Object(){
	public ItemStack getItemStack(int sltid) {
			Entity _ent = entity;
			if(_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if(_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if(invobj instanceof Map) {
						return ((Slot) ((Map) invobj).get(sltid)).getStack();
					}
				}
			}
			return ItemStack.EMPTY;
		}
	}.getItemStack((int)(0))).getItem() == new ItemStack(Blocks.AIR, (int)(1)).getItem()))&&(new ItemStack(, (int)(1)).getItem() == (ItemStack.EMPTY).getItem()))) {if(entity instanceof ServerPlayerEntity) {
	Container _current = ((ServerPlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			((Slot) ((Map) invobj).get((int)(0))).putStack(ItemStack.EMPTY);
			_current.detectAndSendChanges();
		}
	}
}}else if ((((new Object(){
	public ItemStack getItemStack(int sltid) {
			Entity _ent = entity;
			if(_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if(_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if(invobj instanceof Map) {
						return ((Slot) ((Map) invobj).get(sltid)).getStack();
					}
				}
			}
			return ItemStack.EMPTY;
		}
	}.getItemStack((int)(0))).getItem() == (ItemStack.EMPTY).getItem())&&(!(new ItemStack(, (int)(1)).getItem() == (ItemStack.EMPTY).getItem())))) {if(entity instanceof PlayerEntity) {
	Container _current = ((PlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			ItemStack _setstack = new ItemStack(, (int)(1));
			_setstack.setCount((int) 1);
			((Slot) ((Map) invobj).get((int)(0))).putStack(_setstack);
			_current.detectAndSendChanges();
		}
	}
}}

	}

}
