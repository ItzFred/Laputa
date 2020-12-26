
package net.mcreator.laputa.item;

@LaputaModElements.ModElement.Tag
public class SerpentSwordItem extends LaputaModElements.ModElement {

	@ObjectHolder("laputa:serpent_sword")
	public static final Item block = null;

	public SerpentSwordItem(LaputaModElements instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 850;
			}

			public float getEfficiency() {
				return 6f;
			}

			public float getAttackDamage() {
				return 3.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 14;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(LaputanDiamondItem.block, (int) (1)));
			}
		}, 3, -2.7000000000000002f, new Item.Properties().group(LaputaItemGroup.tab)) {

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();

					$_dependencies.put("entity", entity);

					SwordEffect3Procedure.executeProcedure($_dependencies);
				}
				return retval;
			}

		}.setRegistryName("serpent_sword"));
	}

}
