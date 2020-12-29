
package net.mcreator.laputa.itemgroup;

@LaputaModElements.ModElement.Tag
public class LaputaItemGroup extends LaputaModElements.ModElement {

	public LaputaItemGroup(LaputaModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tablaputa") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.DIAMOND, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;

}
