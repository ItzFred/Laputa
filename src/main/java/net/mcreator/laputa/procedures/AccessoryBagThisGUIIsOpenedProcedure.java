package net.mcreator.laputa.procedures;

@LaputaModElements.ModElement.Tag
public class AccessoryBagThisGUIIsOpenedProcedure extends LaputaModElements.ModElement {

	public AccessoryBagThisGUIIsOpenedProcedure(LaputaModElements instance) {
		super(instance, 177);

	}

	public static void executeProcedure(Map<String, Object> dependencies){
		if(dependencies.get("entity") == null) {
			if(!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure AccessoryBagThisGUIIsOpened!");
			return;
		}

				Entity entity = (Entity) dependencies.get("entity");

		if(entity instanceof PlayerEntity) {
	Container _current = ((PlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			ItemStack _setstack = new ItemStack(, (int)(1));
			_setstack.setCount((int) 1);
			((Slot) ((Map) invobj).get((int)(3))).putStack(_setstack);
			_current.detectAndSendChanges();
		}
	}
}if(entity instanceof PlayerEntity) {
	Container _current = ((PlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			ItemStack _setstack = new ItemStack(, (int)(1));
			_setstack.setCount((int) 1);
			((Slot) ((Map) invobj).get((int)(4))).putStack(_setstack);
			_current.detectAndSendChanges();
		}
	}
}if(entity instanceof PlayerEntity) {
	Container _current = ((PlayerEntity) entity).openContainer;
	if(_current instanceof Supplier) {
		Object invobj = ((Supplier) _current).get();
		if(invobj instanceof Map) {
			ItemStack _setstack = new ItemStack(, (int)(1));
			_setstack.setCount((int) 1);
			((Slot) ((Map) invobj).get((int)(5))).putStack(_setstack);
			_current.detectAndSendChanges();
		}
	}
}

	}

}
