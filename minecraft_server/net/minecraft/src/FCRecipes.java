// FCMOD

package net.minecraft.src;

import net.minecraft.src.FCEntityVillager.TradeConditional;
import net.minecraft.src.FCEntityVillager.TradeEffect;
import net.minecraft.src.FCEntityVillager.WeightedMerchantRecipeEntry;

public abstract class FCRecipes
{
	private static final int m_iIgnoreMetadata = FCUtilsInventory.m_iIgnoreMetadata;
	
	public static void AddAllModRecipes()
	{
		RemoveVanillaRecipes();
		
		AddClusteredRecipes();
		
		AddBlockRecipes();
		AddItemRecipes();	
		AddDyeRecipes();
		AddAlternateVanillaRecipes();
		AddConversionRecipes();
		AddSmeltingRecipes();
		AddCampfireRecipes();
		AddAnvilRecipes();
		AddCauldronRecipes();
		AddCrucibleRecipes();
		AddMillStoneRecipes();
		AddTuningForkRecipes();
		AddSubBlockRecipes();
		
		AddLegacyConversionRecipes();
		AddCustomRecipeClasses();
		
		addVillagerTrades();
		
		AddDebugRecipes();
	}
	
    public static ShapedRecipes AddRecipe( ItemStack itemStack, Object aobj[] )
	{
    	return CraftingManager.getInstance().addRecipe( itemStack, aobj );
	}
	
    public static ShapelessRecipes AddShapelessRecipe( ItemStack itemStack, Object aobj[] )
	{
    	return CraftingManager.getInstance().AddShapelessRecipe( itemStack, aobj );
	}
    
    public static ShapelessRecipes AddShapelessRecipeWithSecondaryOutputIndicator( ItemStack itemStack, Object aobj[] )
	{
    	ShapelessRecipes recipe = CraftingManager.getInstance().AddShapelessRecipe( itemStack, aobj );
    	
    	if ( recipe != null )
    	{
    		recipe.SetHasSecondaryOutput( true );
    	}
    	
    	return recipe;
	}
    
    public static ShapedRecipes AddShapedRecipeWithCustomClass( Class<? extends ShapedRecipes>recipeClass, ItemStack itemStack, Object aobj[] )
	{
    	return CraftingManager.getInstance().AddShapedRecipeWithCustomClass( recipeClass, itemStack, aobj );
	}
    
    public static void RemoveVanillaRecipe( ItemStack itemStack, Object aobj[] )
    {
    	CraftingManager.getInstance().RemoveRecipe( itemStack, aobj );
    }
    
    public static void RemoveVanillaShapelessRecipe( ItemStack itemStack, Object aobj[] )
    {
    	CraftingManager.getInstance().RemoveShapelessRecipe( itemStack, aobj );
    }
    
    public static void AddAnvilRecipe( ItemStack itemStack, Object aobj[] )
	{
    	FCCraftingManagerAnvil.getInstance().addRecipe( itemStack, aobj );
	}
	
    public static void AddShapelessAnvilRecipe( ItemStack itemStack, Object aobj[] )
	{
    	FCCraftingManagerAnvil.getInstance().addShapelessRecipe( itemStack, aobj );
	}
    
    public static void RemoveAnvilRecipe( ItemStack itemStack, Object aobj[] )
    {
    	FCCraftingManagerAnvil.getInstance().RemoveRecipe( itemStack, aobj );
    }
    
    public static void RemoveShapelessAnvilRecipe( ItemStack itemStack, Object aobj[] )
    {
    	FCCraftingManagerAnvil.getInstance().RemoveShapelessRecipe( itemStack, aobj );
    }
    
    public static void AddCauldronRecipe( ItemStack outputStack, ItemStack inputStacks[] )
    {
    	FCCraftingManagerCauldron.getInstance().AddRecipe( outputStack, inputStacks );
	}
    
    public static void AddCauldronRecipe( ItemStack outputStacks[], ItemStack inputStacks[] )
    {
    	FCCraftingManagerCauldron.getInstance().AddRecipe( outputStacks, inputStacks );
	}
    
    public static void AddStokedCauldronRecipe( ItemStack outputStack, ItemStack inputStacks[] )
    {
    	FCCraftingManagerCauldronStoked.getInstance().AddRecipe( outputStack, inputStacks );
	}
    
    public static void AddStokedCauldronRecipe( ItemStack outputStacks[], ItemStack inputStacks[] )
    {
    	FCCraftingManagerCauldronStoked.getInstance().AddRecipe( outputStacks, inputStacks );
	}
    
    public static void AddCrucibleRecipe( ItemStack outputStack, ItemStack inputStacks[] )
    {
    	FCCraftingManagerCrucible.getInstance().AddRecipe( outputStack, inputStacks );
	}
    
    public static void AddCrucibleRecipe( ItemStack outputStacks[], ItemStack inputStacks[] )
    {
    	FCCraftingManagerCrucible.getInstance().AddRecipe( outputStacks, inputStacks );
	}
    
    public static void AddStokedCrucibleRecipe( ItemStack outputStack, ItemStack inputStacks[] )
    {
    	FCCraftingManagerCrucibleStoked.getInstance().AddRecipe( outputStack, inputStacks );
	}
    
    public static void AddStokedCrucibleRecipe( ItemStack outputStacks[], ItemStack inputStacks[] )
    {
    	FCCraftingManagerCrucibleStoked.getInstance().AddRecipe( outputStacks, inputStacks );
	}
    
    public static void AddMillStoneRecipe( ItemStack outputStack, ItemStack inputStacks[] )
    {
    	FCCraftingManagerMillStone.getInstance().AddRecipe( outputStack, inputStacks );
	}
    
    public static void AddMillStoneRecipe( ItemStack outputStack, ItemStack inputStack )
    {
    	FCCraftingManagerMillStone.getInstance().AddRecipe( outputStack, inputStack );
	}
    
    public static void AddMillStoneRecipe( ItemStack outputStacks[], ItemStack inputStacks[] )
    {
    	FCCraftingManagerMillStone.getInstance().AddRecipe( outputStacks, inputStacks );
	}
    
    public static void AddCampfireRecipe( int iInputItemID, ItemStack outputStack ) 
    {
    	FCCraftingManagerCampfire.instance.AddRecipe( iInputItemID, outputStack );
    }
    
	private static void AddClusteredRecipes()
	{
		// trying a different way of organizing here, trying to keep things simple for new blocks added
		
		// rotten flesh blocks
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockRottenFleshSlab, 6 ), new Object[] {
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockRottenFlesh
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockRottenFlesh ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockRottenFleshSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockRottenFleshSlab )
		} );		
		
		AddShapelessRecipe( new ItemStack( Item.rottenFlesh, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockRottenFlesh ),
		} );
		
		AddShapelessRecipe( new ItemStack( Item.rottenFlesh, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockRottenFleshSlab ),
		} );
		
		// bone blocks
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBoneSlab, 6 ), new Object[] {
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeBone )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeBone ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockBoneSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockBoneSlab )
		} );		
		
		AddShapelessRecipe( new ItemStack( Item.bone, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeBone )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.bone, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockBoneSlab ),
		} );
		
		// creeper oyster blocks
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCreeperOystersSlab, 6 ), new Object[] {
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockCreeperOysters
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockCreeperOysters ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockCreeperOystersSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockCreeperOystersSlab )
		} );		
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemCreeperOysters, 16 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockCreeperOysters ),
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemCreeperOysters, 8 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockCreeperOystersSlab ),
		} );
		
		// smoothstone stairs
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockSmoothstoneStairs, 6 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), Block.stone 
		} );		
		
		// blood wood stairs and slabs

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodBloodStairs, 6 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( Block.planks, 1, 4 )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodBloodStairs, 1 ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 4 ) 
		} );
		
		AddRecipe( new ItemStack( Block.woodSingleSlab, 6, 4 ), new Object[] {
			"###", 
			Character.valueOf('#'), new ItemStack( Block.planks, 1, 4 )
		} );
		
		// clustered recipe functions

		AddEarlyGameRecipes();
		AddToolRecipes();
		AddLooseStoneRecipes();
		AddLooseBrickRecipes();
		AddLooseStoneBrickRecipes();
		AddLooseNetherBrickRecipes();
		AddTorchRecipes();
		AddWickerRecipes();
		AddWoodStairRecipes();
		AddWoolAndKnittingRecipes();
		AddSawDustRecipes();
		AddMeatCuringRecipes();
		AddPaneRecipes();
		AddSnowRecipes();
		AddChickenFeedRecipes();
		AddFishingRecipes();		
		AddDirtRecipes();
		AddGravelRecipes();
		AddSandRecipes();
		AddMechanicalRecipes();
		AddOreRecipes();
		AddPastryRecipes();
	}
	
	private static void AddEarlyGameRecipes()
	{
		// Chisels		
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChiselWood ), new Object[] {	    		
    		new ItemStack( Item.stick )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChiselStone ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemStone )
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemChiselIron ), new Object[] {
    		"XX", 
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemNuggetIron
		} );

		// clubs
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemClubWood ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), Item.stick
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemClubBone ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), Item.bone
		} );
		
		// fire starters
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemFireStarterSticks ), new Object[] {
    		"XX", 
    		Character.valueOf( 'X' ), Item.stick
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemFireStarterBow ), new Object[] {	    		
    		new ItemStack( Item.stick ),
    		new ItemStack( Item.stick ),
    		new ItemStack( Item.silk )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemFireStarterBow ), new Object[] {	    		
    		new ItemStack( Item.stick ),
    		new ItemStack( Item.stick ),
    		new ItemStack( FCBetterThanWolves.fcItemHempFibers )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCampfireUnlit ), new Object[] {
    		"XX", 
    		"XX", 
    		Character.valueOf( 'X' ), Item.stick
		} );
		
		AddShapelessRecipeWithSecondaryOutputIndicator( new ItemStack( Item.stick ), new Object[] {	    		
    		new ItemStack( Item.bow, 1, m_iIgnoreMetadata )
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockFurnaceBrickIdle ), new Object[] {
    		"XX", 
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockBrickLooseSlab
		} );
		
		AddShapelessRecipe( new ItemStack( Item.coal ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemCoalDust ),
    		new ItemStack( FCBetterThanWolves.fcItemCoalDust )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemPileClay ),
    		new ItemStack( FCBetterThanWolves.fcItemPileClay )
		} );
		
		// ladders
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockLadder, 2 ), new Object[] {
			"#S#", 
			"###", 
			"#S#", 
			'#', Item.stick,
        	'S', Item.silk
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockLadder, 2 ), new Object[] {
			"#S#", 
			"###", 
			"#S#", 
			'#', Item.stick,
        	'S', FCBetterThanWolves.fcItemHempFibers
		} );
		
		// arrows
		//AARON CHANGED arrow recipe from single arrow to 3, both string and hemp
		AddShapelessRecipe( new ItemStack( Item.arrow, 3 ), new Object[] {
    		new ItemStack( Item.feather ),
    		new ItemStack( Item.stick ),
    		new ItemStack( Item.silk ),
    		new ItemStack( Item.flint )
		} );
		AddShapelessRecipe( new ItemStack( Item.arrow, 3 ), new Object[] {
    		new ItemStack( Item.feather ),
    		new ItemStack( Item.stick ),
    		new ItemStack( FCBetterThanWolves.fcItemHempFibers ),
    		new ItemStack( Item.flint )
		} );
	}

	private static void AddToolRecipes()
	{
		AddStoneToolRecipes();
		
		AddRecipe( new ItemStack( Item.hoeIron ), new Object[] {
			"X#", 
			" #", 
			" #",
			'#', Item.stick,
			'X', Item.ingotIron			
		} );
		
		AddRecipe( new ItemStack( Item.hoeDiamond ), new Object[] {
			"X#", 
			" #", 
			" #",
			'#', Item.stick,
			'X', FCBetterThanWolves.fcItemIngotDiamond			
		} );
		
		AddRecipe( new ItemStack( Item.hoeGold ), new Object[] {
			"X#", 
			" #", 
			" #",
			'#', Item.stick,
			'X', Item.ingotGold			
		} );
	}
	
	private static void AddStoneToolRecipes()
	{
		AddShapelessRecipe( new ItemStack( Item.shovelStone ), new Object[] {
        	Item.stick, 
        	FCBetterThanWolves.fcItemStone, 
        	Item.silk
    	} );
        
		AddShapelessRecipe( new ItemStack( Item.shovelStone ), new Object[] {
        	Item.stick, 
        	FCBetterThanWolves.fcItemStone, 
        	FCBetterThanWolves.fcItemHempFibers
    	} );
        
		AddShapelessRecipe( new ItemStack( Item.axeStone ), new Object[] {
        	Item.stick, 
        	FCBetterThanWolves.fcItemStone, 
        	FCBetterThanWolves.fcItemStone, 
        	Item.silk
    	} );
        
		AddShapelessRecipe( new ItemStack( Item.axeStone ), new Object[] {
        	Item.stick, 
        	FCBetterThanWolves.fcItemStone, 
        	FCBetterThanWolves.fcItemStone, 
        	FCBetterThanWolves.fcItemHempFibers
    	} );
        
		AddRecipe( new ItemStack( Item.pickaxeStone ), new Object[] {
        	"XXX", 
        	" #S", 
        	" # ",         	
        	'#', Item.stick, 
        	'X', FCBetterThanWolves.fcItemStone, 
        	'S', Item.silk
    	} );
        
		AddRecipe( new ItemStack( Item.pickaxeStone ), new Object[] {
        	"XXX", 
        	" #S", 
        	" # ",         	
        	'#', Item.stick, 
        	'X', FCBetterThanWolves.fcItemStone, 
        	'S', FCBetterThanWolves.fcItemHempFibers
    	} );
	}
	
	private static void AddLooseStoneRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLoose ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseSlab ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ), 
			new ItemStack( FCBetterThanWolves.fcItemStone ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseStairs ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemStone ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseStairs, 8 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseStairs, 4 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseStairs, 2 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseSlab ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLoose ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockCobblestoneLooseSlab
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseSlab, 4 ), new Object[] {
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockCobblestoneLoose
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStone, 8 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLoose ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStone, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseSlab ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStone, 6 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockCobblestoneLooseStairs ) 
		} );		
	}
	
	private static void AddLooseBrickRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemBrickUnfired ), new Object[] {
			new ItemStack( Item.clay )
		} );		
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLoose ), new Object[] {
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseSlab ), new Object[] {
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ), 
			new ItemStack( Item.brick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseStairs ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( Item.brick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseStairs, 8 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseStairs, 4 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseStairs, 2 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockBrickLooseSlab ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLoose ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockBrickLooseSlab
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBrickLooseSlab, 4 ), new Object[] {
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockBrickLoose
		} );
		
		AddShapelessRecipe( new ItemStack( Item.brick, 8 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockBrickLoose ) 
		} );
		
		AddShapelessRecipe( new ItemStack( Item.brick, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockBrickLooseSlab ) 
		} );
		
		AddShapelessRecipe( new ItemStack( Item.brick, 6 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockBrickLooseStairs ) 
		} );
	}
	
	private static void AddLooseStoneBrickRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLoose ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseSlab ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick ), 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs, 2 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemStoneBrick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs, 8 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemStoneBrick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs, 4 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs, 2 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseSlab ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLoose ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockStoneBrickLooseSlab
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseSlab, 4 ), new Object[] {
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockStoneBrickLoose
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStoneBrick, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLoose ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStoneBrick, 2 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseSlab ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStoneBrick, 3 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockStoneBrickLooseStairs ) 
		} );

		// stone splitting with chisel
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStone, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemChiselIron, 1, m_iIgnoreMetadata ),
    		new ItemStack( FCBetterThanWolves.fcItemStoneBrick )
		} );
		
		AddShapelessRecipeWithSecondaryOutputIndicator(
			new ItemStack( FCBetterThanWolves.fcItemStoneBrick, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemChiselIron, 1, m_iIgnoreMetadata ),
    		new ItemStack( Block.stone )
		} );		
	}
	
	private static void AddLooseNetherBrickRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNetherBrickUnfired ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemNetherSludge ) 
		} );		
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLoose ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseSlab ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 
			new ItemStack( FCBetterThanWolves.fcItemNetherBrick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseStairs ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemNetherBrick ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseStairs, 8 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseStairs, 4 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLoose ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseStairs, 2 ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseSlab ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLoose ), new Object[] {
    		"X", 
    		"X", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockNetherBrickLooseSlab
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseSlab, 4 ), new Object[] {
    		"XX", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockNetherBrickLoose
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNetherBrick, 8 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLoose ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNetherBrick, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseSlab ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNetherBrick, 6 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockNetherBrickLooseStairs ) 
		} );
	}
	
	private static void AddTorchRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockTorchNetherUnlit, 1 ), new Object[] {
			"#",
			"X",
            Character.valueOf('#'), FCBetterThanWolves.fcItemNethercoal, 
            Character.valueOf('X'), Item.stick 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockTorchFiniteUnlit ), new Object[] {
			"#",
			"X",
            Character.valueOf('#'), new ItemStack( Item.coal, 1, m_iIgnoreMetadata ), 
            Character.valueOf('X'), Item.stick 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockTorchNetherBurning ), new Object[] {
			new ItemStack( Block.torchWood )
		} );
	}
	
	private static void AddWickerRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWickerWeaving, 1,
			FCItemWickerWeaving.m_iWickerWeavingMaxDamage - 1 ), new Object[] {
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), Item.reed 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockBasketWicker ), new Object[] {
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemWickerPiece 
		} );
		
		//AARON changed to make wicker basckets break down into more material (better recycling)
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWickerPiece, 3 ), new Object[] {	    		
			new ItemStack( FCBetterThanWolves.fcBlockBasketWicker )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockHamper ), new Object[] {
    		"###", 
    		"#P#", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemWickerPiece, 
    		Character.valueOf( 'P' ), Block.planks 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerPane ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockGrate ),
    		new ItemStack( FCBetterThanWolves.fcItemWickerPiece )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWicker ), new Object[] {
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockWickerPane
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerSlab ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockWickerPane
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerSlab, 4 ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockWicker
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerPane, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockWicker )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerPane, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockWickerSlab )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWicker ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockWickerSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockWickerSlab )
		} );
		
		// conversion of deprecated blocks
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWicker ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
    			FCBlockAestheticOpaque.m_iSubtypeWicker )
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerSlab ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 1, 
    			FCBlockAestheticNonOpaque.m_iSubtypeWickerSlab )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWickerPane ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemWickerPaneOld )
		} );
	}
	
	private static void AddWoodStairRecipes()
	{
		AddRecipe( new ItemStack( Block.stairsWoodOak, 6 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 0)});
		
		AddRecipe( new ItemStack( Block.stairsWoodBirch, 6 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 2)});
		
		AddRecipe( new ItemStack( Block.stairsWoodSpruce, 6 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 1)});
		
		AddRecipe( new ItemStack( Block.stairsWoodJungle, 6 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 3)});
	}
	
	//AARON Changed a recipe... ;p
	
	private static void AddWoolAndKnittingRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemKnittingNeedles ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemChiselWood, 1, 0 ),
    		new ItemStack( FCBetterThanWolves.fcItemChiselWood, 1, 0 )
		} );
		
		//changed hat recipe to only require a single wool... ;p
		AddShapedRecipeWithCustomClass( FCRecipesArmorWool.class, new ItemStack( FCBetterThanWolves.fcItemArmorWoolHelm ), new Object[] {
    		"#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWoolKnit, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapedRecipeWithCustomClass( FCRecipesArmorWool.class, new ItemStack( FCBetterThanWolves.fcItemArmorWoolChest ), new Object[] {
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWoolKnit, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapedRecipeWithCustomClass( FCRecipesArmorWool.class, new ItemStack( FCBetterThanWolves.fcItemArmorWoolLeggings ), new Object[] {
    		"##", 
    		"# ", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWoolKnit, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapedRecipeWithCustomClass( FCRecipesArmorWool.class, new ItemStack( FCBetterThanWolves.fcItemArmorWoolLeggings ), new Object[] {
    		"# ", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWoolKnit, 1, m_iIgnoreMetadata ) 
		} );
		

		//AARON changed the wool block recipe to not rely on wicker!
//		AddShapedRecipeWithCustomClass( FCRecipesWoolBlock.class, new ItemStack( Block.cloth ), new Object[] {
//    		" # ", 
//    		"#W#", 
//    		" # ", 
//    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWool, 1, m_iIgnoreMetadata ), 
//    		Character.valueOf( 'W' ), new ItemStack( FCBetterThanWolves.fcBlockWicker ) 
//		} );
		
		AddShapedRecipeWithCustomClass( FCRecipesWoolBlock.class, new ItemStack( Block.cloth ), new Object[] {
	    		" # ", 
	    		"#W#", 
	    		" # ", 
	    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcItemWool, 1, m_iIgnoreMetadata ), 
	    		Character.valueOf( 'W' ), Block.planks,
			} );
		
		for ( int iTempColor = 0; iTempColor < 16; iTempColor++ )
		{
			AddRecipe( new ItemStack( FCBetterThanWolves.fcWoolSlab, 6, iTempColor ), new Object[] {
	    		"###", 
	    		Character.valueOf( '#' ), new ItemStack( Block.cloth, 1, iTempColor )
			} );
			
			AddShapelessRecipe( new ItemStack( Block.cloth, 1, iTempColor ), new Object[] {
				new ItemStack( FCBetterThanWolves.fcWoolSlab, 1, iTempColor ), 
				new ItemStack( FCBetterThanWolves.fcWoolSlab, 1, iTempColor ) 				
			} );
		}
	}
	
	private static void AddSawDustRecipes()
	{
		// wood items to saw dust as backup method of burning in campfire & brick furnace
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSawDust, 2 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemFireStarterSticks, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSawDust, 2 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemFireStarterBow, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSawDust, 2 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemKnittingNeedles, 1, m_iIgnoreMetadata ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSawDust, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemKnitting, 1, m_iIgnoreMetadata ) 
		} );
	}
	
	private static void AddMeatCuringRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemMuttonRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( Item.chickenRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( Item.beefRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( Item.fishRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( Item.porkRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemWolfRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemRawMysteryMeat ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
			
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMeatCured ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemBeastLiverRaw ), new ItemStack( FCBetterThanWolves.fcItemNitre ) } );
	}
	
	private static void AddPaneRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockGrate, 1 ), new Object[] {
    		"S#S", 
    		"###", 
    		"S#S", 
    		Character.valueOf( '#' ), new ItemStack( Item.stick ),
    		Character.valueOf( 'S' ), new ItemStack( Item.silk )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockGrate, 1 ), new Object[] {
    		"S#S", 
    		"###", 
    		"S#S", 
    		Character.valueOf( '#' ), new ItemStack( Item.stick ),
    		Character.valueOf( 'S' ), new ItemStack( FCBetterThanWolves.fcItemHempFibers )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlats, 1 ), new Object[] {
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ) 
		} );		
		
		// conversion of deprecated items
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockGrate ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemGrateOld )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlats ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemSlatsOld )
		} );
	}
	
	private static void AddSnowRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSnowLooseSlab ), new Object[] {
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.snowball, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSnowLooseSlab )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.snowball, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSnowSolidSlab )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSnowLoose ), new Object[] {
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball ),
			new ItemStack( Item.snowball )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSnowLoose ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockSnowLooseSlab ),
			new ItemStack( FCBetterThanWolves.fcBlockSnowLooseSlab )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.snowball, 8 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSnowLoose )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.snowball, 8 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSnowSolid )
		} );
	}
	
	private static void AddChickenFeedRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChickenFeed ), new Object[] {	    		
    		new ItemStack( Item.dyePowder, 1, 15 ), // bone meal 
    		new ItemStack( Item.seeds )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChickenFeed ), new Object[] {	    		
    		new ItemStack( Item.dyePowder, 1, 15 ), // bone meal 
    		new ItemStack( FCBetterThanWolves.fcItemWheatSeeds )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChickenFeed ), new Object[] {	    		
    		new ItemStack( Item.dyePowder, 1, 15 ), // bone meal 
    		new ItemStack( FCBetterThanWolves.fcItemHempSeeds )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChickenFeed ), new Object[] {	    		
    		new ItemStack( Item.dyePowder, 1, 15 ), // bone meal 
    		new ItemStack( Item.pumpkinSeeds )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChickenFeed ), new Object[] {	    		
    		new ItemStack( Item.dyePowder, 1, 15 ), // bone meal 
    		new ItemStack( Item.melonSeeds )
		} );		
	}
	
	private static void AddFishingRecipes()
	{
		AddShapelessRecipe( new ItemStack( Item.fishingRod ), new Object[] {	    		
			new ItemStack( Item.stick ), 
			new ItemStack( Item.silk ),
			new ItemStack( Item.silk ),
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron )
		} );		
		
		AddShapelessRecipe( new ItemStack( Item.fishingRod ), new Object[] {	    		
			new ItemStack( Item.stick ), 
			new ItemStack( Item.silk ),
			new ItemStack( Item.silk ),
			new ItemStack( FCBetterThanWolves.fcItemFishHookBone )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemCarvingBone, 1, 
			FCItemCarvingBone.m_iDefaultMaxDamage - 1 ), new Object[] {	    		
			new ItemStack( Item.bone )
		} );			
	}
	
	private static void AddDirtRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLooseSlab, 4 ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockDirtLoose )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLooseSlab, 1 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLoose, 1 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt ), 
			new ItemStack( FCBetterThanWolves.fcItemPileDirt )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLoose ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockDirtLooseSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockDirtLooseSlab )
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtSlab, 4 ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( Block.dirt )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtSlab, 4, FCBlockDirtSlab.m_iSubtypePackedEarth ), new Object[] {
    		"EE", 
    		Character.valueOf( 'E' ), new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, FCBlockAestheticOpaqueEarth.m_iSubtypePackedEarth )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.dirt ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockDirtSlab ),
    		new ItemStack( FCBetterThanWolves.fcBlockDirtSlab )
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLoose, 2 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, FCBlockAestheticOpaqueEarth.m_iSubtypePackedEarth ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, FCBlockAestheticOpaqueEarth.m_iSubtypePackedEarth ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockDirtSlab, 1, FCBlockDirtSlab.m_iSubtypePackedEarth ),
    		new ItemStack( FCBetterThanWolves.fcBlockDirtSlab, 1, FCBlockDirtSlab.m_iSubtypePackedEarth )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockDirtLoose, 1 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockDirtSlab, 1, FCBlockDirtSlab.m_iSubtypePackedEarth ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileDirt, 8 ), new Object[] {
			new ItemStack( Block.dirt, 1 )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileDirt, 8 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockDirtLoose, 1 )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileDirt, 4 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcBlockDirtSlab ),
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileDirt, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockDirtLooseSlab, 1 )
		} );
	}
	
	private static void AddGravelRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeGravel ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemPileGravel ),
    		new ItemStack( FCBetterThanWolves.fcItemPileGravel ),
    		new ItemStack( FCBetterThanWolves.fcItemPileGravel ),
    		new ItemStack( FCBetterThanWolves.fcItemPileGravel )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.gravel ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ),
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel ), 
			new ItemStack( FCBetterThanWolves.fcItemPileGravel )
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileGravel, 8 ), new Object[] {
			new ItemStack( Block.gravel )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileGravel, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeGravel )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 4, FCBlockSlabSandAndGravel.m_iSubtypeGravel ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( Block.gravel )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.gravel ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeGravel ),
    		new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeGravel )
		} );
	}
	
	private static void AddSandRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeSand ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.sand ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSand )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileSand, 4 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeSand )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileSand, 8 ), new Object[] {
			new ItemStack( Block.sand )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 4, FCBlockSlabSandAndGravel.m_iSubtypeSand ), new Object[] {
    		"##", 
    		Character.valueOf( '#' ), new ItemStack( Block.sand )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.sand ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeSand ),
    		new ItemStack( FCBetterThanWolves.fcBlockSlabSandAndGravel, 1, FCBlockSlabSandAndGravel.m_iSubtypeSand )
		} );
	}
	
	private static void AddMechanicalRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockAxle ), new Object[] {
    		"#X#", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemRope 
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockAxle ), new Object[] {
    		"#X#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemRope 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockGearBox ), new Object[] {
    		"#X#", 
    		"XYX", 
    		"#X#", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcBlockAxle
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockGearBox ), new Object[] {
    		"#X#", 
    		"XYX", 
    		"#X#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcBlockAxle
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockRedstoneClutch ), new Object[] {
    		"#X#", 
    		"XYX", 
    		"#X#", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemRedstoneLatch
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockRedstoneClutch ), new Object[] {
    		"#X#", 
    		"XYX", 
    		"#X#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemRedstoneLatch
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcHandCrank ), new Object[] {
    		"  Y", 
    		" Y ", 
    		"#X#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), Item.stick 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcMillStone ), new Object[] {
    		"YYY", 
    		"YYY", 
    		"YXY", 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemStoneBrick 
		} );		

		AddRecipe( new ItemStack( FCBetterThanWolves.fcTurntable ), new Object[] {
    		"###", 
    		"ZXZ", 
    		"ZYZ", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), Item.pocketSundial, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemGear,
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemStoneBrick
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBellows ), new Object[] {
    		"###", 
    		"XXX", 
    		"YZY", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemTannedLeather, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemGear,
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemBelt
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBellows ), new Object[] {
    		"###", 
    		"XXX", 
    		"YZY", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemTannedLeatherCut, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemGear,
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemBelt
		} );
	}
	
	private static void AddOreRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkIronOre ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemPileIronOre ),
    		new ItemStack( FCBetterThanWolves.fcItemPileIronOre )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkIronOre ), new Object[] {
    		new ItemStack( Block.oreIron )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockChunkOreStorageIron ), new Object[] {
    		"###", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemChunkIronOre
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkIronOre, 9 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcBlockChunkOreStorageIron )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkGoldOre ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemPileGoldOre ),
    		new ItemStack( FCBetterThanWolves.fcItemPileGoldOre )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkGoldOre ), new Object[] {
    		new ItemStack( Block.oreGold )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockChunkOreStorageGold ), new Object[] {
    		"###", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemChunkGoldOre
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemChunkGoldOre, 9 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcBlockChunkOreStorageGold )
		} );
	}
	
	private static void AddPastryRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemBreadDough ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
    		new ItemStack( Item.bucketWater ),
		} );
        
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPastryUncookedCookies, 1 ), 
			new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemChocolate ), 
			new ItemStack( FCBetterThanWolves.fcItemFlour ),
			new ItemStack( FCBetterThanWolves.fcItemFlour ),
			new ItemStack( FCBetterThanWolves.fcItemFlour ),
			new ItemStack( FCBetterThanWolves.fcItemFlour )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPastryUncookedPumpkinPie, 1 ), 
			new Object[] {	    		
    		new ItemStack( Item.sugar ),
    		new ItemStack( FCBetterThanWolves.fcBlockPumpkinFresh ),
    		new ItemStack( FCBetterThanWolves.fcItemRawEgg ),
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
    		new ItemStack( FCBetterThanWolves.fcItemFlour ),
		} );
		
        AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPastryUncookedCake, 1 ), 
        	new Object[] {
            new ItemStack( Item.sugar ), 
            new ItemStack( Item.sugar ), 
            new ItemStack( Item.sugar ), 
            new ItemStack( Item.bucketMilk ),
            new ItemStack( Item.bucketMilk ),
            new ItemStack( FCBetterThanWolves.fcItemFlour ), 
            new ItemStack( FCBetterThanWolves.fcItemFlour ), 
            new ItemStack( FCBetterThanWolves.fcItemFlour ), 
            new ItemStack( FCBetterThanWolves.fcItemRawEgg )
        });
	}
	
	private static void AddBlockRecipes()
	{		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, 
			FCBlockAestheticOpaqueEarth.m_iSubtypeDung ), new Object[] {
    		"###", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemDung
		} );		

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeHellfire ), new Object[] {
	    		"###", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemConcentratedHellfire
			} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypePadding ), new Object[] {
	    		"###", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemPadding
			} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeSoap ), new Object[] {
	    		"###", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSoap
			} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeRope ), new Object[] {
	    		"###", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemRope
			} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeFlint ), new Object[] {
	    		"###", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), Item.flint
			} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
			FCBlockAestheticOpaque.m_iSubtypeEnderBlock ), new Object[] {
    		"###", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), Item.enderPearl
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockMiningCharge, 2 ), new Object[] {
    		"XYX", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemDynamite, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemRope,
    		Character.valueOf( 'Y' ), Item.slimeBall
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticVegetation, 1, FCBlockAestheticVegetation.m_iSubtypeVineTrap ), new Object[] {
	    		"###", 
	    		Character.valueOf( '#' ), Block.vine
			} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcAnvil, 1 ), new Object[] {	    		
    		new ItemStack( Item.netherStar ),
    		new ItemStack( FCBetterThanWolves.fcItemSoulFlux ),
    		new ItemStack( FCBetterThanWolves.fcBlockSoulforgeDormant )
		} );		
        
		AddRecipe( new ItemStack( FCBetterThanWolves.fcLightBulbOff, 1 ), new Object[] {
        	" # ", 
        	"#X#", 
        	" Y ", 
        	Character.valueOf( '#' ), Block.thinGlass, 
        	Character.valueOf( 'X' ), FCBetterThanWolves.fcItemFilament, 
        	Character.valueOf( 'Y' ), Item.redstone 
        } );
        
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBBQ ), new Object[] {
    		"XXX", 
    		"#Z#", 
    		"#Y#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemConcentratedHellfire, 
    		Character.valueOf( 'Y' ), Item.redstone, 
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemElement
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcHopper ), new Object[] {
    		"# #", 
    		"XYX", 
    		" Z ", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), Block.pressurePlatePlanks,
    		Character.valueOf( 'Z' ), new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 1, m_iIgnoreMetadata )
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcSaw ), new Object[] {
    		"YYY", 
    		"XZX", 
    		"#X#", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), Item.ingotIron,
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemBelt
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcSaw ), new Object[] {
    		"YYY", 
    		"XZX", 
    		"#X#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear, 
    		Character.valueOf( 'Y' ), Item.ingotIron,
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemBelt
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcPlatform ), new Object[] {
    		"#X#", 
    		" # ", 
    		"#X#", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcBlockWickerPane 
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcPlatform ), new Object[] {
    		"X#X", 
    		" X ", 
    		"X#X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcBlockWickerPane, 
    		Character.valueOf( 'X' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata )
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcPulley ), new Object[] {
    		"#Y#", 
    		"XZX", 
    		"#Y#", 
    		Character.valueOf( '#' ), Block.planks,
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear,
            Character.valueOf( 'Y' ), Item.ingotIron, 
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemRedstoneLatch
		} );		
		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcPulley ), new Object[] {
    		"#Y#", 
    		"XZX", 
    		"#Y#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ),
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGear,
            Character.valueOf( 'Y' ), Item.ingotIron, 
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemRedstoneLatch
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcCauldron ), new Object[] {
    		"#Y#", 
    		"#X#", 
    		"###", 
    		Character.valueOf( '#' ), Item.ingotIron, 
    		Character.valueOf( 'X' ), Item.bucketWater, 
    		Character.valueOf( 'Y' ), Item.bone 
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcDetectorRailWood, 6 ), new Object[] {
            "X X", 
            "X#X", 
            "XRX", 
            Character.valueOf( 'X' ), Item.ingotIron, 
            Character.valueOf( 'R' ), Item.redstone, 
            Character.valueOf( '#' ), Block.pressurePlatePlanks
        });
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockDetectorRailSoulforgedSteel, 6 ), new Object[] {
            "X X", 
            "X#X", 
            "XRX", 
            Character.valueOf( 'X' ), Item.ingotIron, 
            Character.valueOf( 'R' ), Item.redstone, 
            Character.valueOf( '#' ), FCBetterThanWolves.fcBlockPressurePlateSoulforgedSteel
        });
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockPlanterSoil ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcPlanter ), 
    		new ItemStack( FCBetterThanWolves.fcBlockDirtLoose )
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockPlanterSoil ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcPlanter, 1, FCBlockPlanter.m_iTypeSoil ) 
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockPlanterSoil ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcPlanter, 1, FCBlockPlanter.m_iTypeSoilFertilized ) 
		} );

		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcPlanter, 1, FCBlockPlanter.m_iTypeSoulSand ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcPlanter ), 
    		new ItemStack( Block.slowSand )
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockScrewPump ), new Object[] {
    		"XGX", 
    		"WSW", 
    		"WgW", 
    		Character.valueOf( 'W' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'g' ), FCBetterThanWolves.fcItemGear,
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemScrew,
    		Character.valueOf( 'G' ), FCBetterThanWolves.fcBlockGrate,
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGlue
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcLens ), new Object[] {
    		"GDG", 
    		"G G", 
    		"G#G", 
    		Character.valueOf( '#' ), Block.glass, 
    		Character.valueOf( 'G' ), Item.ingotGold, 
    		Character.valueOf( 'D' ), Item.diamond 
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcLens ), new Object[] {
    		"G#G", 
    		"G G", 
    		"GDG", 
    		Character.valueOf( '#' ), Block.glass, 
    		Character.valueOf( 'G' ), Item.ingotGold, 
    		Character.valueOf( 'D' ), Item.diamond 
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 2, FCBlockAestheticOpaque.m_iSubtypeBarrel ), new Object[] {
    		"###", 
    		"#X#", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGlue 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWhiteStoneStairs, 6, 0 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeWhiteStone ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWhiteStoneStairs, 6, 8 ), new Object[] {
    		"#  ", 
    		"## ", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeWhiteCobble ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 6, FCBlockAestheticNonOpaque.m_iSubtypeWhiteCobbleSlab ), new Object[] {
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeWhiteCobble ) 
		} );
		
		AddShapelessRecipe( new ItemStack( Item.skull.itemID, 1, 5 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemSoulUrn ),
    		new ItemStack( FCBetterThanWolves.fcItemSoulFlux ),
    		new ItemStack( Item.skull.itemID, 1, 1 )
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockShovel ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			Character.valueOf( '#' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockSpikeIron ), new Object[] {
    		"n", 
    		"n", 
    		"I", 
    		Character.valueOf( 'n' ), FCBetterThanWolves.fcItemNuggetIron, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockLightningRod ), new Object[] {
    		"n", 
    		"n", 
    		"I", 
    		Character.valueOf( 'n' ), Item.goldNugget, 
    		Character.valueOf( 'I' ), Item.ingotGold
		} );
	}
	
	private static void AddItemRecipes()
	{
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemGear, 2 ), new Object[] {
    		" X ", 
    		"X#X", 
    		" X ", 
    		Character.valueOf( '#' ), Block.planks, 
    		Character.valueOf( 'X' ), Item.stick 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemRope, 1 ), new Object[] {
    		"##", 
    		"##", 
    		"##", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemHempFibers 
		} );
		
		//AARON changed this to make the anchor affordable
		AddRecipe( new ItemStack( FCBetterThanWolves.fcAnchor ), new Object[] {
    		" X ", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
    		Character.valueOf( 'X' ), Item.ingotIron 
		} );
		AddRecipe( new ItemStack( FCBetterThanWolves.fcAnchor ), new Object[] {
		" X ", 
		"###", 
		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemNuggetIron
	} );
		AddRecipe( new ItemStack( FCBetterThanWolves.fcAnchor ), new Object[] {
		" X ", 
		"###", 
		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemNuggetSteel
	} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWaterWheel ), new Object[] {
			"###",
    		"# #", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemWoodBlade
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWindMillBlade ), new Object[] {
			"###",
    		"###", 
    		"XXX", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemHempCloth, 
    		Character.valueOf( 'X' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWindMillBlade ), new Object[] {
			"###",
    		"###", 
    		"XXX", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemHempCloth, 
    		Character.valueOf( 'X' ), Block.planks 
		} );
		
		AddShapelessRecipeWithSecondaryOutputIndicator( new ItemStack( FCBetterThanWolves.fcItemWindMillBlade ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemWindMill ) 
		} );
		
		AddShapelessRecipeWithSecondaryOutputIndicator( new ItemStack( FCBetterThanWolves.fcItemWindMillBlade ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemWindMillVertical ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWindMill ), new Object[] {
			" # ",
    		"# #", 
    		" # ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemWindMillBlade 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemHempCloth, 1 ), new Object[] {
    		"###", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemHempFibers 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemDung, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, 
				FCBlockAestheticOpaqueEarth.m_iSubtypeDung )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemConcentratedHellfire, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeHellfire )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPadding, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypePadding )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSoap, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeSoap )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemRope, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeRope )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.flint, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeFlint )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.enderPearl, 9 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
				FCBlockAestheticOpaque.m_iSubtypeEnderBlock )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemBelt, 1 ), new Object[] {
    		" # ", 
    		"# #", 
    		" # ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStrap 
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWoodBlade, 1 ), new Object[] {
    		"#  ", 
    		"#X#", 
    		"#  ", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGlue 
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemHaft, 1 ), new Object[] {
    		"Y", 
    		"X", 
    		"#", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemGlue, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemStrap, 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemCompositeBow, 1 ), new Object[] {
    		"X#Y", 
    		"ZX#", 
    		"X#Y", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), Item.bone, 
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemGlue, 
    		Character.valueOf( 'Z' ), Item.silk, 
		} );		
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemBroadheadArrow ), new Object[] {
    		new ItemStack( Item.feather ),
    		new ItemStack( Item.stick ),
    		new ItemStack( Item.silk ),
    		new ItemStack( FCBetterThanWolves.fcItemBroadheadArrowhead )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemBroadheadArrow ), new Object[] {
    		new ItemStack( Item.feather ),
    		new ItemStack( Item.stick ),
    		new ItemStack( FCBetterThanWolves.fcItemHempFibers ),
    		new ItemStack( FCBetterThanWolves.fcItemBroadheadArrowhead )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpHelm ), new Object[] {
    		"###", 
    		"#I#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpChest ), new Object[] {
    		"# #", 
    		"I#I", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpLeggings ), new Object[] {
    		"#I#", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpBoots ), new Object[] {
    		"# #", 
    		"I I", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpHelm ), new Object[] {
    		"###", 
    		"#I#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpChest ), new Object[] {
    		"# #", 
    		"I#I", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpLeggings ), new Object[] {
    		"#I#", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorGimpBoots ), new Object[] {
    		"# #", 
    		"I I", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut, 
    		Character.valueOf( 'I' ), Item.ingotIron 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemPadding ), new Object[] {
    		"C", 
    		"W", 
    		"C", 
    		Character.valueOf( 'C' ), FCBetterThanWolves.fcItemHempCloth, 
    		Character.valueOf( 'W' ), new ItemStack( FCBetterThanWolves.fcItemWool, 1, m_iIgnoreMetadata )
        } );
        
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemDynamite ), new Object[] {
    		"PF", 
    		"PN", 
    		"PS", 
    		Character.valueOf( 'P' ), Item.paper, 
    		Character.valueOf( 'F' ), FCBetterThanWolves.fcItemFuse, 
    		Character.valueOf( 'N' ), FCBetterThanWolves.fcItemBlastingOil, 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemSawDust 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemDynamite ), new Object[] {
    		"PF", 
    		"PN", 
    		"PS", 
    		Character.valueOf( 'P' ), Item.paper, 
    		Character.valueOf( 'F' ), FCBetterThanWolves.fcItemFuse, 
    		Character.valueOf( 'N' ), FCBetterThanWolves.fcItemBlastingOil, 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemSoulDust 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemBreedingHarness ), new Object[] {
    		"SLS", 
    		"LLL", 
    		"SLS", 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemStrap, 
    		Character.valueOf( 'L' ), FCBetterThanWolves.fcItemTannedLeather 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemBreedingHarness ), new Object[] {
    		"SLS", 
    		"LLL", 
    		"SLS", 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemStrap, 
    		Character.valueOf( 'L' ), FCBetterThanWolves.fcItemTannedLeatherCut 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemCandle, 2, 15 ), new Object[] {
    		"H", 
    		"T", 
    		"T", 
    		Character.valueOf( 'H' ), FCBetterThanWolves.fcItemHempFibers, 
    		Character.valueOf( 'T' ), FCBetterThanWolves.fcItemTallow 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemScrew ), new Object[] {
    		"## ", 
    		" ##", 
    		"## ", 
    		Character.valueOf( '#' ), new ItemStack( Item.ingotIron )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemOcularOfEnder, 1, 0 ), new Object[] {
    		"ggg", 
    		"gEg", 
    		"ggg", 
    		Character.valueOf( 'g' ), Item.goldNugget, 
    		Character.valueOf( 'E' ), Item.enderPearl 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemEnderSpectacles ), new Object[] {
    		"OSO", 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemStrap,
    		Character.valueOf( 'O' ), FCBetterThanWolves.fcItemOcularOfEnder    		
		} );

		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemStake, 2 ), new Object[] {	    		
    		"S", 
    		"M", 
    		Character.valueOf( 'M' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ),
    		Character.valueOf( 'S' ), new ItemStack( Item.silk )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemWindMillVertical ), new Object[] {
			"SSS",
    		"S S", 
    		"SSS", 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemWindMillBlade 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( Item.beefCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( Item.porkCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( Item.chickenCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( Item.fishCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( FCBetterThanWolves.fcItemWolfCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( FCBetterThanWolves.fcItemMuttonCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTastySandwich, 2 ), new Object[] {	    		
    		new ItemStack( Item.bread ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedMysteryMeat )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSteakAndPotatoes, 2 ), new Object[] {	    		
    		new ItemStack( Item.bakedPotato ),
    		new ItemStack( Item.beefCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSteakAndPotatoes, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ),
    		new ItemStack( Item.beefCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemHamAndEggs, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemHardBoiledEgg ),
    		new ItemStack( Item.porkCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemHamAndEggs, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemFriedEgg ),
    		new ItemStack( Item.porkCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSteakDinner, 3 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( Item.beefCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemSteakDinner, 3 ), new Object[] {	    		
    		new ItemStack( Item.bakedPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( Item.beefCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPorkDinner, 3 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( Item.porkCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPorkDinner, 3 ), new Object[] {	    		
    		new ItemStack( Item.bakedPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( Item.porkCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWolfDinner, 3 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( FCBetterThanWolves.fcItemWolfCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWolfDinner, 3 ), new Object[] {	    		
    		new ItemStack( Item.bakedPotato ),
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ),
    		new ItemStack( FCBetterThanWolves.fcItemWolfCooked )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemRawKebab, 3 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ),
    		new ItemStack( Item.carrot ),
    		new ItemStack( FCBetterThanWolves.fcItemMuttonRaw ),
    		new ItemStack( Item.stick ),
		} );
		
		AddShapelessRecipeWithSecondaryOutputIndicator( new ItemStack( Block.pumpkin ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcBlockPumpkinFresh )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemRawMushroomOmelet, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ),
    		new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ),
    		new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ),
    		new ItemStack( FCBetterThanWolves.fcItemRawEgg )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemRawScrambledEggs, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemRawEgg ),
    		new ItemStack( Item.bucketMilk )
		} );
		
		AddRecipe( new ItemStack( Item.helmetChain ), new Object[] {
    		"###", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemMail 
		} );
		
		AddRecipe( new ItemStack( Item.plateChain ), new Object[] {
    		"# #", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemMail
		} );
		
		AddRecipe( new ItemStack( Item.legsChain ), new Object[] {
    		"###", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemMail 
		} );
		
		AddRecipe( new ItemStack( Item.bootsChain ), new Object[] {
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemMail 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorPaddedHelm ), new Object[] {
    		"###", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemPadding 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorPaddedChest ), new Object[] {
    		"# #", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemPadding
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorPaddedLeggings ), new Object[] {
    		"###", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemPadding 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedHelm ), new Object[] {
    		"###", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedChest ), new Object[] {
    		"# #", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedLeggings ), new Object[] {
    		"###", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedBoots ), new Object[] {
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeather 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedHelm ), new Object[] {
    		"###", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedChest ), new Object[] {
    		"# #", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedLeggings ), new Object[] {
    		"###", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorTannedBoots ), new Object[] {
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemTannedLeatherCut
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemIngotDiamond ), new Object[] {	    		
    		new ItemStack( Item.ingotIron ),
    		new ItemStack( Item.diamond ),
    		new ItemStack( FCBetterThanWolves.fcItemCreeperOysters )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemLeatherCut, 2 ), new Object[] {	    		
    		new ItemStack( Item.shears, 1, m_iIgnoreMetadata ),
    		new ItemStack( Item.leather )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), new Object[] {	    		
    		new ItemStack( Item.shears, 1, m_iIgnoreMetadata ),
    		new ItemStack( FCBetterThanWolves.fcItemTannedLeather )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ), new Object[] {	    		
    		new ItemStack( Item.shears, 1, m_iIgnoreMetadata ),
    		new ItemStack( FCBetterThanWolves.fcItemScouredLeather )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStrap, 4 ), new Object[] {	    		
    		new ItemStack( Item.shears, 1, m_iIgnoreMetadata ),
    		new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut )
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemGoldenDung ), new Object[] {
    		"ggg", 
    		"gDg", 
    		"ggg", 
    		Character.valueOf( 'D' ), FCBetterThanWolves.fcItemDung,
    		Character.valueOf( 'g' ), Item.goldNugget,
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemRedstoneLatch ), new Object[] {
    		"ggg", 
    		" r ", 
    		Character.valueOf( 'g' ), Item.goldNugget,
    		Character.valueOf( 'r' ), Item.redstone
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemBucketMilkChocolate ), new Object[] {	    		
    		new ItemStack( Item.bucketMilk ),
    		new ItemStack( Item.dyePowder, 1, 3 ) // Cocoa powder
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemStumpRemover, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemCreeperOysters ),
    		new ItemStack( FCBetterThanWolves.fcItemMushroomRed ),
    		new ItemStack( Item.rottenFlesh )
		} );
	}
	
	private static void AddDyeRecipes()
	{
		// only to 14 to avoid white on white conversion
		
        for ( int i = 0; i < 15; i++ )
        {
            AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemCandle, 1, i ), new Object[] {
                new ItemStack( Item.dyePowder, 1, i ), 
                new ItemStack( FCBetterThanWolves.fcItemCandle, 1, 15 )
            } );
            
            AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWool, 1, i ), new Object[] {
                new ItemStack( Item.dyePowder, 1, i ), 
                new ItemStack( FCBetterThanWolves.fcItemWool, 1, 15 )
            } );
        }
        
        AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemCandle, 1, 3 ), new Object[] {
            new ItemStack( FCBetterThanWolves.fcItemDung ), 
            new ItemStack( FCBetterThanWolves.fcItemCandle, 1, 15 )
        } );
        
        AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWool, 1, 3 ), new Object[] {
            new ItemStack( FCBetterThanWolves.fcItemDung ), 
            new ItemStack( FCBetterThanWolves.fcItemWool, 1, 15 )
        } );
        
        for ( int i = 0; i < 15; i++ )
        {
            AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcVase, 1, BlockCloth.getBlockFromDye( i ) ), new Object[] {
                new ItemStack( Item.dyePowder, 1, i ), 
                new ItemStack( Item.itemsList[FCBetterThanWolves.fcVase.blockID], 1, 0 )
            });
            
            AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcWoolSlab, 1, BlockCloth.getBlockFromDye( i ) ), new Object[] {
                new ItemStack( Item.dyePowder, 1, i ), 
                new ItemStack( Item.itemsList[FCBetterThanWolves.fcWoolSlab.blockID], 1, 0 )
            });
        }
		
        AddShapelessRecipe( new ItemStack( Block.cloth, 1, 12 ), new Object[] {
            new ItemStack( FCBetterThanWolves.fcItemDung ), 
            new ItemStack( Item.itemsList[Block.cloth.blockID], 1, 0 )
        } );
        
        AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcVase, 1, 12 ), new Object[] {
            new ItemStack( FCBetterThanWolves.fcItemDung ), 
            new ItemStack( Item.itemsList[FCBetterThanWolves.fcVase.blockID], 1, 0 )
        } );
        
        AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcWoolSlab, 1, 12 ), new Object[] {
            new ItemStack( FCBetterThanWolves.fcItemDung ), 
            new ItemStack( Item.itemsList[FCBetterThanWolves.fcWoolSlab.blockID], 1, 0 )
        } );
	}
	
	private static void AddAlternateVanillaRecipes()
	{
		// Alternate recipes for vanilla items

		
		AddRecipe( new ItemStack( Block.pistonBase, 1 ), new Object[] {
            "#I#", 
            "XYX",
            "XZX",
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
            Character.valueOf('I'), Item.ingotIron,
            Character.valueOf('X'), FCBetterThanWolves.fcItemStoneBrick,
            Character.valueOf('Y'), FCBetterThanWolves.fcItemSoulUrn,
            Character.valueOf('Z'), FCBetterThanWolves.fcItemRedstoneLatch
		} );
		
		AddRecipe( new ItemStack( Block.fenceGate, 1 ), new Object[] {
            "#X#", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ), 
            Character.valueOf('X'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata )
		} );
		
		AddRecipe( new ItemStack( Block.stairsWoodOak, 1 ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 0 ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsWoodSpruce, 1 ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 1 ) 
		} );

		AddRecipe( new ItemStack( Block.stairsWoodBirch, 1 ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 2 ) 
		} );

		AddRecipe( new ItemStack( Block.stairsWoodJungle, 1 ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 3 ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsStoneBrick ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockStoneBrickMouldingAndDecorative ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWhiteStoneStairs ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWhiteStoneMouldingAndDecorative ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsNetherBrick ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockNetherBrickMouldingAndDecorative ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsBrick ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockBrickMouldingAndDecorative ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsSandStone ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockSandstoneMouldingAndDecorative ) 
		} );
		
		AddRecipe( new ItemStack( Block.stairsNetherQuartz ), new Object[] {
            "# ", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockMouldingAndDecorativeBlackStone ) 
		} );
		
		AddRecipe( new ItemStack( Item.sign, 3 ), new Object[] {
            "#", 
            "X", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
            Character.valueOf('X'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata )
		} );
		
		AddRecipe( new ItemStack( Item.doorWood, 1 ), new Object[] {
            "##", 
            "##", 
            "##", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata )
		} );
		
		AddRecipe( new ItemStack( Block.trapdoor, 1 ), new Object[] {
			"WW#", 
			"WW#", 
			Character.valueOf('#'), Item.stick, 
			Character.valueOf('W'), Block.planks
		} );
		
		AddRecipe( new ItemStack( Block.trapdoor, 2 ), new Object[] {
			"WW#", 
			"WW#", 
			Character.valueOf('#'), Item.stick, 
            Character.valueOf('W'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata )
		} );
		
		AddRecipe( new ItemStack( Item.boat, 1 ), new Object[] {
            "# #", 
            "###", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata )
		} );
        
		AddRecipe( new ItemStack( Block.bookShelf ), new Object[] {
    		"###", 
    		"XXX", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
    		Character.valueOf( 'X' ), Item.book
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockChest ), new Object[] {
            "###", 
            "# #", 
            "###", 
    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ) 
        } );
		
		AddRecipe( new ItemStack( Item.minecartCrate, 1 ), new Object[] {
			"A", 
			"B", 
			'A', FCBetterThanWolves.fcBlockChest, 
			'B', Item.minecartEmpty
		} );
		
		AddRecipe( new ItemStack( Item.redstoneRepeater, 1 ), new Object[] {
        	"#X#", 
        	"III", 
        	'#', Block.torchRedstoneActive, 
        	'X', Item.pocketSundial, 
        	'I', FCBetterThanWolves.fcItemStoneBrick } );
        
		AddRecipe( new ItemStack( FCBetterThanWolves.fcInfernalEnchanter ), new Object[] {
    		"CBC", 
    		"SES", 
    		"SSS", 
    		Character.valueOf( 'S' ), FCBetterThanWolves.fcItemSteel,
    		Character.valueOf( 'C' ), new ItemStack( FCBetterThanWolves.fcItemCandle, 1, 0 ),
    		Character.valueOf( 'E' ), Block.enchantmentTable,
    		Character.valueOf( 'B' ), Item.bone
		} );
		
        AddShapelessRecipe( new ItemStack( Item.stick ), new Object[] {
        	new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ) 
        } );
        
		AddRecipe( new ItemStack( Block.jukebox, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ),
			'X', Item.diamond
        });
		
		AddRecipe( new ItemStack( Block.music, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ),
			'X', FCBetterThanWolves.fcItemRedstoneLatch
		} );
		
		AddRecipe( new ItemStack( Block.tnt, 1), new Object[] {
			"GFG", 
			"GBG", 
			"GGG", 
			'B', new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeBarrel ),
			'G', Item.gunpowder,
			'F', FCBetterThanWolves.fcItemFuse
		} );
		
		AddShapelessRecipe( new ItemStack( Item.gunpowder ), new Object[] { 
            new ItemStack( FCBetterThanWolves.fcItemNitre ),
            new ItemStack( FCBetterThanWolves.fcItemBrimstone ),
            new ItemStack( FCBetterThanWolves.fcItemCoalDust ),
        } );
		
		AddRecipe( new ItemStack( Block.anvil, 1 ), new Object[] {
			"iii", 
			" i ", 
			"iii", 
			'i', Item.ingotIron
		} );
		
		// chiseled stone brick
		
		AddAnvilRecipe( new ItemStack( Block.stoneBrick, 12, 3 ), new Object[] {
    		"####", 
    		"#  #", 
    		"#  #", 
    		"####", 
    		Character.valueOf( '#' ), Block.stoneBrick
		} );
		
		AddShapelessRecipe( new ItemStack( Item.melon, 5 ), new Object[] { 
            new ItemStack( Block.melon )
        } );
		
		AddRecipe( new ItemStack( Item.bowlEmpty, 6 ), new Object[] {
            "# #", 
            " # ", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
		} );
		
		AddRecipe( new ItemStack( Item.compass, 1 ), new Object[] {
			" # ", 
			"#X#", 
			" # ", 
			'#', FCBetterThanWolves.fcItemNuggetIron, 
			'X', Item.redstone
		} );
		
		AddRecipe( new ItemStack( Item.pocketSundial, 1 ), new Object[] {
			" # ", 
			"#X#", 
			" # ", 
			'#', Item.goldNugget, 
			'X', Item.netherQuartz } );
		
		AddShapelessRecipe( new ItemStack( Item.flintAndSteel, 1 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron ), 
			new ItemStack( Item.flint )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay, 9 ), new Object[] { 
            new ItemStack( FCBetterThanWolves.fcBlockUnfiredClay ),
        } );
		
		AddRecipe( new ItemStack( Item.bucketEmpty, 1 ), new Object[] {
			"# #", 
			"# #", 
			"###", 
			'#', FCBetterThanWolves.fcItemNuggetIron 
		} );
		
		AddShapelessRecipe( new ItemStack( Item.silk, 2 ), new Object[] { 
            new ItemStack( FCBetterThanWolves.fcBlockWeb ),
		} );		
		
		// high effeciency leather recipes
		
		AddRecipe( new ItemStack( Item.helmetLeather ), new Object[] {
    		"###", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemLeatherCut 
		} );
		
		AddRecipe( new ItemStack( Item.plateLeather ), new Object[] {
    		"# #", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemLeatherCut 
		} );
		
		AddRecipe( new ItemStack( Item.legsLeather ), new Object[] {
    		"###", 
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemLeatherCut 
		} );
		
		AddRecipe( new ItemStack( Item.bootsLeather ), new Object[] {
    		"# #", 
    		"# #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemLeatherCut 
		} );
		
		AddShapelessRecipe( new ItemStack( Item.writableBook, 1 ), new Object[] {
			Item.paper, 
			Item.paper, 
			Item.paper, 
			FCBetterThanWolves.fcItemLeatherCut,
			new ItemStack( Item.dyePowder, 1, 0 ), 
			Item.feather
		} );
		
		AddShapelessRecipe( new ItemStack( Item.writableBook, 1 ), new Object[] {
			Item.paper, 
			Item.paper, 
			Item.paper, 
			Item.leather,
			new ItemStack( Item.dyePowder, 1, 0 ), 
			Item.feather
		} );
		
		AddRecipe( new ItemStack( Item.itemFrame, 1 ), new Object[] {
			"mmm", 
			"mlm", 
			"mmm", 
			'm', new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata ),
			'l', FCBetterThanWolves.fcItemLeatherCut
		} );		
        
		AddRecipe( new ItemStack( Item.itemFrame, 1 ), new Object[] {
			"mmm", 
			"mlm", 
			"mmm", 
			'm', Item.stick,
			'l', FCBetterThanWolves.fcItemLeatherCut
		} );		
        
		AddRecipe( new ItemStack( Item.helmetDiamond ), new Object[] {
			"XXX", 
			"X X", 
			'X', FCBetterThanWolves.fcItemIngotDiamond
		} ); 
	   
		AddRecipe( new ItemStack( Item.plateDiamond ), new Object[] {
			"X X", 
			"XXX", 
			"XXX", 
			'X', FCBetterThanWolves.fcItemIngotDiamond
		} );
	   
		AddRecipe( new ItemStack( Item.legsDiamond ), new Object[] {
			"XXX", 
			"X X", 
			"X X", 
			'X', FCBetterThanWolves.fcItemIngotDiamond
		} );
	   
		AddRecipe( new ItemStack( Item.bootsDiamond ), new Object[] {
			"X X", 
			"X X", 
			'X', FCBetterThanWolves.fcItemIngotDiamond
		} );
		
		AddRecipe( new ItemStack( Item.swordDiamond ), new Object[] {
			"X", 
			"X", 
			"#",
			'#', Item.stick,
			'X', FCBetterThanWolves.fcItemIngotDiamond
		} );
		
		AddRecipe( new ItemStack( Item.pickaxeDiamond ), new Object[] {
			"XXX", 
			" # ", 
			" # ",
			'#', Item.stick,
			'X', FCBetterThanWolves.fcItemIngotDiamond			
		} ); 
		
		AddRecipe( new ItemStack( Item.shovelDiamond ), new Object[] {
			"X", 
			"#", 
			"#",
			'#', Item.stick,
			'X', FCBetterThanWolves.fcItemIngotDiamond			
		} ); 
		
		AddRecipe( new ItemStack( Block.lever, 1 ), new Object[] {
			"X", 
			"#", 
			"r",
			'#', FCBetterThanWolves.fcItemStoneBrick, 
			'X', Item.stick, 
			'r', Item.redstone 
		} );
		
		AddRecipe( new ItemStack( Block.stoneButton, 1 ), new Object[] {
        	"#",
        	"r",
    		'#', new ItemStack( Item.itemsList[FCBetterThanWolves.fcBlockSmoothStoneSidingAndCorner.blockID], 1, 1 ),
			'r', Item.redstone 
    	} );
        
		AddRecipe( new ItemStack( Block.woodenButton, 1 ), new Object[] {
        	"#", 
        	"r",
    		'#', new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 1, m_iIgnoreMetadata ),
			'r', Item.redstone 
    	} );
        
		AddRecipe( new ItemStack( Block.pressurePlateStone, 1 ), new Object[] {
        	"#", 
        	"r",
    		'#', new ItemStack( Item.itemsList[FCBetterThanWolves.fcBlockSmoothStoneSidingAndCorner.blockID], 1, 0 ),
			'r', Item.redstone 
    	} );
        
		AddRecipe( new ItemStack( Block.pressurePlatePlanks, 1 ), new Object[] {
        	"#", 
        	"r",
    		'#', new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, m_iIgnoreMetadata ), 
			'r', Item.redstone 
    	} );
		
		AddRecipe( new ItemStack( Item.doorIron, 1 ), new Object[] {
			"##r", 
			"## ", 
			"##r", 
			'#', Item.ingotIron,
			'r', FCBetterThanWolves.fcItemRedstoneLatch 
		} );
		
		AddRecipe( new ItemStack( Block.dispenser, 1 ), new Object[] {
			"###", 
			"#X#", 
			"#R#", 
			'#', FCBetterThanWolves.fcItemStoneBrick, 
			'X', Item.bow, 
			'R', FCBetterThanWolves.fcItemRedstoneLatch
		} );
		
		AddRecipe( new ItemStack( Block.music, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Block.planks, 
			'X', FCBetterThanWolves.fcItemRedstoneLatch
		} );
		
		AddShapelessRecipe( new ItemStack( Block.pumpkinLantern, 1 ), new Object[] {
			new ItemStack( Block.pumpkin ), 
			new ItemStack( FCBetterThanWolves.fcItemCandle, 1, m_iIgnoreMetadata ) 
		} );		
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockUnfiredClay, 1 ), new Object[] {
			"###", 
			"###", 
			"###", 
			'#', Item.clay
		} );
        
		// axe recipe rebalance
		
        AddRecipe( new ItemStack( Item.axeIron ), new Object[] {
        	"X ", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Item.ingotIron
    	} );        
        
        AddRecipe( new ItemStack( Item.axeGold ), new Object[] {
        	"X ", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Item.ingotGold
    	} );
        
		AddRecipe( new ItemStack( Item.axeDiamond ), new Object[] {
			"X ", 
			"X#", 
			" #", 
			'#', Item.stick,
			'X', FCBetterThanWolves.fcItemIngotDiamond			
		} );
		
		AddShapelessRecipe( new ItemStack( Item.stick, 2 ), new Object[] { 
            new ItemStack( Block.planks, 1, m_iIgnoreMetadata )
        } );		
		
		AddRecipe( new ItemStack( Item.bed, 1 ), new Object[] {
			"###", 
			"XXX", 
			'#', FCBetterThanWolves.fcItemPadding, 
			'X', Block.planks
		} );
		
		// map creation and zooming
		
		AddRecipe( new ItemStack( Item.emptyMap, 1 ), new Object[] {
			"#S#", 
			"#X#", 
			"#S#", 
			'#', Item.paper, 
			'X', Item.compass,
			'S', FCBetterThanWolves.fcItemSoulUrn
		} );
		
		AddRecipe( new ItemStack( Item.emptyMap, 1, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Item.paper, 
			'X', new ItemStack( Item.emptyMap, 1, 0 )
		} );
		
		AddRecipe( new ItemStack( Item.emptyMap, 1, 2 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Item.paper, 
			'X', new ItemStack( Item.emptyMap, 1, 1 )
		} );
		
		AddRecipe( new ItemStack( Item.emptyMap, 1, 3 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Item.paper, 
			'X', new ItemStack( Item.emptyMap, 1, 2 )
		} );
		
		AddRecipe( new ItemStack( Item.emptyMap, 1, 4 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Item.paper, 
			'X', new ItemStack( Item.emptyMap, 1, 3 )
		} );		
	}
	
	private static void AddConversionRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemHempFibers, 9 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemHempCloth ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemHempFibers, 6 ), new Object[] {
    		new ItemStack( FCBetterThanWolves.fcItemRope ) 
		} );
		
		AddShapelessRecipe( new ItemStack( Block.cobblestone ), new Object[] {	    		
    		new ItemStack( Block.stoneSingleSlab, 1, 3 ), // metadata 3 is cobble slab
    		new ItemStack( Block.stoneSingleSlab, 1, 3 )
		} );

		AddShapelessRecipe( new ItemStack( Block.brick ), new Object[] {	    		
    		new ItemStack( Block.stoneSingleSlab, 1, 4 ), // metadata 4 is brick slab
    		new ItemStack( Block.stoneSingleSlab, 1, 4 )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.stoneBrick ), new Object[] {	    		
    		new ItemStack( Block.stoneSingleSlab, 1, 5 ), // metadata 5 is stone brick slab
    		new ItemStack( Block.stoneSingleSlab, 1, 5 )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.netherBrick ), new Object[] {	    		
    		new ItemStack( Block.stoneSingleSlab, 1, 6 ), // metadata 6 is nether brick slab
    		new ItemStack( Block.stoneSingleSlab, 1, 6 )
		} );
		
		for ( int iTempWoodType = 0; iTempWoodType < 5; iTempWoodType++ )
		{
			AddShapelessRecipe( new ItemStack( Block.planks, 1, iTempWoodType ), new Object[] {	    		
	    		new ItemStack( Block.woodSingleSlab, 1, iTempWoodType ),
	    		new ItemStack( Block.woodSingleSlab, 1, iTempWoodType )
			} );			
		}
		
		AddShapelessRecipe( new ItemStack( Item.clay, 8 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcUnfiredPottery, 1, FCBlockUnfiredPottery.m_iSubtypeCrucible )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay, 6 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcUnfiredPottery, 1, FCBlockUnfiredPottery.m_iSubtypePlanter )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay, 4 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcUnfiredPottery, 1, FCBlockUnfiredPottery.m_iSubtypeVase )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay, 2 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcUnfiredPottery, 1, FCBlockUnfiredPottery.m_iSubtypeUrn )
		} );
		
		AddShapelessRecipe( new ItemStack( Item.clay, 1 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcUnfiredPottery, 1, FCBlockUnfiredPottery.m_iSubtypeMould )
		} );
		
		AddRecipe( new ItemStack( Item.ingotIron, 1 ), new Object[] {
			"###", 
			"###", 
			"###", 
			'#', new ItemStack( FCBetterThanWolves.fcItemNuggetIron ),
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 9 ), new Object[] {
			new ItemStack( Item.ingotIron ) 
		} );
		
		AddRecipe( new ItemStack( FCBetterThanWolves.fcItemSteel, 1 ), new Object[] {
			"###", 
			"###", 
			"###", 
			'#', new ItemStack( FCBetterThanWolves.fcItemNuggetSteel ),
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 9 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemSteel ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemPileSoulSand, 4 ), new Object[] {
			new ItemStack( Block.slowSand, 1 )
		} );
		
		AddShapelessRecipe( new ItemStack( Block.slowSand, 1 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemPileSoulSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSoulSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSoulSand ), 
			new ItemStack( FCBetterThanWolves.fcItemPileSoulSand )
		} );		
		
		AddShapelessRecipe( new ItemStack( Item.book, 3 ), new Object[] {
			new ItemStack( Block.bookShelf )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWheatSeeds, 2 ), new Object[] {
			new ItemStack( FCBetterThanWolves.fcItemWheat )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemWheatSeeds ), new Object[] {
			new ItemStack( Item.seeds )
		} );
	}

	private static void AddSmeltingRecipes()
	{
		// food recipes (default cook times)
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemWolfRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemWolfCooked ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemBreadDough.itemID, new ItemStack( Item.bread ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemRawEgg.itemID, new ItemStack( FCBetterThanWolves.fcItemFriedEgg ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemMuttonRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemMuttonCooked ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( Item.carrot.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemRawKebab.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedKebab ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemRawMysteryMeat.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedMysteryMeat ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemRawScrambledEggs.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedScrambledEggs ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemRawMushroomOmelet.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedMushroomOmelet ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemPastryUncookedCake.itemID, new ItemStack( Item.cake ), 0 );
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemPastryUncookedCookies.itemID, new ItemStack( Item.cookie, 8 ), 0 );
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemPastryUncookedPumpkinPie.itemID, new ItemStack( Item.pumpkinPie ), 0 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemBeastLiverRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemBeastLiverCooked ), 0 );
		
		// non-food (custom cook times)
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemNetherSludge.itemID, new ItemStack( FCBetterThanWolves.fcItemNetherBrick ), 0, 2 );
		
		FurnaceRecipes.smelting().addSmelting( Item.clay.itemID, new ItemStack( Item.brick ), 0, 2 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemChunkIronOre.itemID, new ItemStack( FCBetterThanWolves.fcItemNuggetIron ), 0, 3 );
		
		FurnaceRecipes.smelting().addSmelting( FCBetterThanWolves.fcItemChunkGoldOre.itemID, new ItemStack( Item.goldNugget ), 0, 3 );
	}
	
	private static void AddCampfireRecipes()
	{
		AddCampfireRecipe( FCBetterThanWolves.fcItemWolfRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemWolfCooked ) );		
		AddCampfireRecipe( FCBetterThanWolves.fcItemMuttonRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemMuttonCooked ) );		
		AddCampfireRecipe( FCBetterThanWolves.fcItemRawMysteryMeat.itemID, new ItemStack( FCBetterThanWolves.fcItemCookedMysteryMeat ) );		
		AddCampfireRecipe( FCBetterThanWolves.fcItemBeastLiverRaw.itemID, new ItemStack( FCBetterThanWolves.fcItemBeastLiverCooked ) );
		
		AddCampfireRecipe( Item.porkRaw.itemID, new ItemStack( Item.porkCooked ) );
		AddCampfireRecipe( Item.beefRaw.itemID, new ItemStack( Item.beefCooked ) );
		AddCampfireRecipe( Item.chickenRaw.itemID, new ItemStack( Item.chickenCooked ) );
		AddCampfireRecipe( Item.fishRaw.itemID, new ItemStack( Item.fishCooked ) );
	}
	
	private static void AddAnvilRecipes()
	{
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemRefinedSword, 1 ), new Object[] {
    		"#", 
    		"#", 
    		"#", 
    		"X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemRefinedShovel, 1 ), new Object[] {
    		"#", 
    		"X", 
    		"X", 
    		"X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemRefinedPickAxe, 1 ), new Object[] {
    		"###", 
    		" X ", 
    		" X ", 
    		" X ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemMattock, 1 ), new Object[] {
    		" ###", 
    		"# X ", 
    		"  X ", 
    		"  X ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemRefinedHoe, 1 ), new Object[] {
    		"##", 
    		" X", 
    		" X", 
    		" X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemBattleAxe, 1 ), new Object[] {
    		"###", 
    		"#X#", 
    		" X ", 
    		" X ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemRefinedAxe, 1 ), new Object[] {
    		"# ", 
    		"#X", 
    		" X", 
    		" X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemHaft 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemArmorPlate, 1 ), new Object[] {
    		"#XY#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStrap, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemSteel,
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemPadding
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemPlateHelm, 1 ), new Object[] {
    		"####", 
    		"#  #", 
    		"#  #", 
    		" XX ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemArmorPlate 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemPlateBreastPlate, 1 ), new Object[] {
    		"X  X", 
    		"####", 
    		"####", 
    		"####", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemArmorPlate 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemPlateLeggings, 1 ), new Object[] {
    		"####", 
    		"X##X", 
    		"X  X", 
    		"X  X", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemArmorPlate 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemPlateBoots, 1 ), new Object[] {
    		" ## ", 
    		" ## ", 
    		"#XX#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemArmorPlate 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemBroadheadArrowhead, 6 ), new Object[] {
    		" # ", 
    		" # ", 
    		"###", 
    		" # ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemNuggetSteel, 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcBlockPressurePlateSoulforgedSteel, 2 ), new Object[] {
            "####", 
            " rr ", 
            Character.valueOf('#'), FCBetterThanWolves.fcItemSteel,
            Character.valueOf('r'), Item.redstone
        } );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemPolishedLapis, 2 ), new Object[] {
    		"###", 
    		"###", 
    		"GGG", 
    		" R ", 
    		Character.valueOf( '#' ), new ItemStack( Item.dyePowder, 1, 4 ), 
    		Character.valueOf( 'G' ), Item.goldNugget, 
    		Character.valueOf( 'R' ), Item.redstone 
		} );		
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcBlockDetector ), new Object[] {
    		"####", 
    		"XTTX", 
    		"#YY#", 
    		"#YY#", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
    		Character.valueOf( 'X' ), FCBetterThanWolves.fcItemPolishedLapis, 
    		Character.valueOf( 'Y' ), Item.redstone, 
    		Character.valueOf( 'T' ), Block.torchRedstoneActive 
		} );

		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcBlockDispenser ), new Object[] {
    		"####", 
    		"#ZZ#", 
    		"YTTY", 
    		"YXXY", 
    		Character.valueOf( '#' ), Block.cobblestoneMossy, 
    		Character.valueOf( 'X' ), Item.redstone,
    		Character.valueOf( 'Y' ), FCBetterThanWolves.fcItemStoneBrick, 
    		Character.valueOf( 'Z' ), FCBetterThanWolves.fcItemSoulUrn,
    		Character.valueOf( 'T' ), Block.torchRedstoneActive 
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcBuddyBlock, 1 ), new Object[] {
        	"##X#", 
        	"XYY#", 
        	"#YYX", 
        	"#X##", 
        	Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick, 
        	Character.valueOf( 'X' ), FCBetterThanWolves.fcItemPolishedLapis, 
    		Character.valueOf( 'Y' ), Block.torchRedstoneActive 
        } );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcSoulforgedSteelBlock, 1 ), new Object[] {
    		"####", 
    		"####", 
    		"####", 
    		"####", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemTuningFork, 6 ), new Object[] {
    		"# #", 
    		"# #", 
    		" # ", 
    		" # ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemSteel
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemCanvas ), new Object[] {
    		"MMMM", 
    		"MFFM", 
    		"MFFM", 
    		"MMMM", 
    		Character.valueOf( 'F' ), FCBetterThanWolves.fcItemHempCloth, 
    		Character.valueOf( 'M' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, m_iIgnoreMetadata )
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
			FCBlockAestheticOpaque.m_iSubtypeChoppingBlockClean ), new Object[] {
    		"#  #", 
    		"#  #", 
    		"####", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemStoneBrick
		} );

		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemMail, 2 ), new Object[] {
    		"# # ", 
    		" # #", 
    		"# # ", 
    		" # #", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemNuggetIron
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcItemMail, 2 ), new Object[] {
    		" # #", 
    		"# # ", 
    		" # #", 
    		"# # ", 
    		Character.valueOf( '#' ), FCBetterThanWolves.fcItemNuggetIron
		} );
		
		AddAnvilRecipe( new ItemStack( FCBetterThanWolves.fcBlockSoulforgeDormant ), new Object[] {
    		"####", 
    		" #  ", 
    		" #  ", 
    		"####", 
    		Character.valueOf( '#' ), Item.ingotGold
		} );		
	}
	
    private static void AddCauldronRecipes()
	{
        AddCauldronRecipe( 
    		new ItemStack( Item.gunpowder, 2 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBrimstone ), 
				new ItemStack( FCBetterThanWolves.fcItemNitre ), 
				new ItemStack( FCBetterThanWolves.fcItemCoalDust ) 
		} );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemFilament, 1 ), 
			new ItemStack[] {
    			new ItemStack( Item.lightStoneDust ), 
    			new ItemStack( Item.redstone ), 
    			new ItemStack( Item.silk )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemFilament, 1 ), 
			new ItemStack[] {
    			new ItemStack( Item.lightStoneDust ), 
    			new ItemStack( Item.redstone ), 
    			new ItemStack( FCBetterThanWolves.fcItemHempFibers )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemElement, 1 ), 
			new ItemStack[] {
    			new ItemStack( Item.blazePowder ), 
    			new ItemStack( Item.redstone ), 
    			new ItemStack( Item.silk )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemElement, 1 ), 
			new ItemStack[] {
    			new ItemStack( Item.blazePowder ), 
    			new ItemStack( Item.redstone ), 
    			new ItemStack( FCBetterThanWolves.fcItemHempFibers )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemFuse, 2 ), 
			new ItemStack[] {
    			new ItemStack( Item.gunpowder ), 
    			new ItemStack( Item.silk )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemFuse, 2 ), 
			new ItemStack[] {
    			new ItemStack( Item.gunpowder ), 
    			new ItemStack( FCBetterThanWolves.fcItemHempFibers )
        } );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemBlastingOil, 2 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemHellfireDust ), 
    			new ItemStack( FCBetterThanWolves.fcItemTallow )
        } );
        
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemNetherSludge, 8 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemPotash, 1, m_iIgnoreMetadata ), 
    			new ItemStack( FCBetterThanWolves.fcItemHellfireDust, 8, m_iIgnoreMetadata ) 
        } );

    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemNethercoal, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemHellfireDust, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemCoalDust, 1 )
		} );
        	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemConcentratedHellfire, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemHellfireDust, 8 )
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 5, 0 ) // oak
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 3, 1 ) // spruce
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 8, 2 ) // birch
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 2, 3 ) // jungle
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 8, 4 ) // blood wood
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 5, 0 ) // oak
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 3, 1 ) // spruce
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 8, 2 ) // birch
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 2, 3 ) // jungle
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemDung, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ),
				new ItemStack( FCBetterThanWolves.fcItemBark, 8, 4 ) // blood wood
		} );
    	
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemDonut, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemFlour, 1 ),
				new ItemStack( Item.sugar, 1 )
		} );
    	
    	// only up to 14 to avoid white on white conversion
    	
        for ( int i = 0; i < 15; i++ )
        {
        	AddCauldronRecipe( 
    			new ItemStack( Block.cloth, 8, BlockCloth.getBlockFromDye( i ) ), 
    			new ItemStack[] {
                    new ItemStack( Item.dyePowder, 1, i ), 
        			new ItemStack( Block.cloth, 8, 0 ), 
			} );
        	
        	AddCauldronRecipe( 
    			new ItemStack( FCBetterThanWolves.fcWoolSlab, 16, BlockCloth.getBlockFromDye( i ) ), 
    			new ItemStack[] {
                    new ItemStack( Item.dyePowder, 1, i ), 
        			new ItemStack( FCBetterThanWolves.fcWoolSlab, 16, 0 ), 
			} );
        	
        	AddCauldronRecipe( 
    			new ItemStack( FCBetterThanWolves.fcItemWool, 32, i ), 
    			new ItemStack[] {
                    new ItemStack( Item.dyePowder, 1, i ), 
        			new ItemStack( FCBetterThanWolves.fcItemWool, 32, 15 ), 
			} );        	
        }
		
        AddCauldronRecipe( 
    		new ItemStack( Block.cloth, 8, 12 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemDung, 1 ), 
    			new ItemStack( Item.itemsList[Block.cloth.blockID], 8, 0 )
        } );
        
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcWoolSlab, 16, 12 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemDung, 1 ), 
    			new ItemStack( Item.itemsList[FCBetterThanWolves.fcWoolSlab.blockID], 16, 0 )
        } );
        
    	AddCauldronRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemWool, 32, 3 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemDung, 1 ), 
    			new ItemStack( FCBetterThanWolves.fcItemWool, 32, 15 ), 
		} );
    	
        AddCauldronRecipe( new ItemStack( FCBetterThanWolves.fcAestheticVegetation, 1, FCBlockAestheticVegetation.m_iSubtypeBloodWoodSapling ),
			new ItemStack[] {
				new ItemStack( Block.sapling, 1, 0 ),
				new ItemStack( Block.sapling, 1, 1 ),
				new ItemStack( Block.sapling, 1, 2 ),
				new ItemStack( Block.sapling, 1, 3 ),
				new ItemStack( FCBetterThanWolves.fcItemSoulUrn, 8 ),
				new ItemStack( Item.netherStalkSeeds )
		} );
		
        AddCauldronRecipe( 
			new ItemStack[] {
        		new ItemStack( FCBetterThanWolves.fcBlockDirtLoose ),
        		new ItemStack( FCBetterThanWolves.fcItemBloodMossSpores ),
			},
			new ItemStack[] {
				new ItemStack( Block.mycelium ),
				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ),
				new ItemStack( FCBetterThanWolves.fcItemMushroomRed ),
				new ItemStack( FCBetterThanWolves.fcItemSoulUrn, 8 ),
				new ItemStack( FCBetterThanWolves.fcItemDung ),
				new ItemStack( Item.netherStalkSeeds )
		} );

        // bleeching
        
    	FCCraftingManagerCauldron.getInstance().AddRecipe( 
    		new ItemStack( Block.cloth, 8, 0 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemPotash, 1, m_iIgnoreMetadata ), 
    			new ItemStack( Block.cloth, 8, 0  ),
    		}, true );    	
            
    	FCCraftingManagerCauldron.getInstance().AddRecipe( 
    		new ItemStack( FCBetterThanWolves.fcWoolSlab, 16, 0 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemPotash, 1, m_iIgnoreMetadata ), 
    			new ItemStack( FCBetterThanWolves.fcWoolSlab, 16, 0 ),
    		}, true );
    	
    	FCCraftingManagerCauldron.getInstance().AddRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemWool, 32, 15 ), 
			new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemPotash, 1, m_iIgnoreMetadata ), 
    			new ItemStack( FCBetterThanWolves.fcItemWool, 32, 15 ),
    		}, true );

        AddCauldronRecipe( 
    		new ItemStack( Item.dyePowder, 1, 2 ), 
			new ItemStack[] {
    			new ItemStack( Block.cactus ) 
        } );
        
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemBucketCement, 1 ), 
    		new ItemStack[] {
				new ItemStack( Block.sand ), 
				new ItemStack( Block.gravel ), 
				new ItemStack( Item.bucketEmpty ), 
				new ItemStack( FCBetterThanWolves.fcItemSoulUrn ) 
		} );
        
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemHardBoiledEgg ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRawEgg ) 
		} );
        
        AddCauldronRecipe( 
    		new ItemStack( Block.pistonBase, 4 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemSoap ), 
				new ItemStack( Block.pistonStickyBase, 4 ) 
		} );
        
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
    		new ItemStack[] {
				new ItemStack( Item.potato ) 
		} );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
    		new ItemStack[] {
				new ItemStack( Item.bakedPotato ) 
		} );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
    		new ItemStack[] {
				new ItemStack( Item.carrot ) 
		} );
        
        AddCauldronRecipe( 
        	new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 4, FCBlockAestheticOpaque.m_iSubtypeChoppingBlockClean ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemSoap ), 
				new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 4, FCBlockAestheticOpaque.m_iSubtypeChoppingBlockDirty ) 
		} );
    
        AddCauldronRecipe( 
    		new ItemStack[] { 
    			new ItemStack( FCBetterThanWolves.fcItemFishSoup, 2 ),    			
    			new ItemStack( Item.bucketEmpty )
    		},
    		 
    		new ItemStack[] {
				new ItemStack( Item.bucketMilk ), 
				new ItemStack( Item.fishCooked ), 
				new ItemStack( Item.bowlEmpty, 2 )
		} );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemChickenSoup, 3 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
				new ItemStack( Item.chickenCooked ), 
				new ItemStack( Item.bowlEmpty, 3 )
		} );
    
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemHeartyStew, 5 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
				new ItemStack( FCBetterThanWolves.fcItemFlour ), 
				new ItemStack( Item.beefCooked ), 
				new ItemStack( Item.bowlEmpty, 5 )
		} );
        
      //AARON commented out, maybe a bad idea?
//        AddCauldronRecipe( 
//    		new ItemStack( FCBetterThanWolves.fcItemHeartyStew, 5 ), 
//    		new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
//				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
//				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
//				new ItemStack( FCBetterThanWolves.fcItemFlour ), 
//				new ItemStack( Item.porkCooked ), 
//				new ItemStack( Item.bowlEmpty, 5 )
//		} );
    
        //AARON changed mutton to produce less hearty stew than beef, only 2
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemHeartyStew, 2 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
				new ItemStack( FCBetterThanWolves.fcItemFlour ), 
				new ItemStack( FCBetterThanWolves.fcItemMuttonCooked ), 
				new ItemStack( Item.bowlEmpty, 2 ) //changed bowls too!
		} );
        
        //AARON changed wolf meat to only produce 3 servings of stew
        AddCauldronRecipe( 
    		new ItemStack( FCBetterThanWolves.fcItemHeartyStew, 3 ), 
    		new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
				new ItemStack( FCBetterThanWolves.fcItemFlour ), 
				new ItemStack( FCBetterThanWolves.fcItemWolfCooked ), 
				new ItemStack( Item.bowlEmpty, 3 ) //changed bowls too!
		} );
        
        //AARON commented out, maybe a bad idea?
//        AddCauldronRecipe( 
//    		new ItemStack( FCBetterThanWolves.fcItemHeartyStew, 5 ), 
//    		new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemBoiledPotato ), 
//				new ItemStack( FCBetterThanWolves.fcItemCookedCarrot ), 
//				new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
//				new ItemStack( FCBetterThanWolves.fcItemFlour ), 
//				new ItemStack( FCBetterThanWolves.fcItemCookedMysteryMeat ),
//				new ItemStack( Item.bowlEmpty, 5 )
//		} );                
    
        AddCauldronRecipe( 
    		new ItemStack[] { 
    			new ItemStack( Item.bowlSoup, 2 ),
    			new ItemStack( Item.bucketEmpty )
    		},
    		new ItemStack[] {
    			new ItemStack( FCBetterThanWolves.fcItemMushroomBrown, 3 ),
				new ItemStack( Item.bucketMilk ), 
				new ItemStack( Item.bowlEmpty, 2 )
		} );
    
        AddCauldronRecipe( 
    		new ItemStack[] { 
    			new ItemStack( FCBetterThanWolves.fcItemChocolate, 2 ),    			
    			new ItemStack( Item.bucketEmpty )
    		},    		 
    		new ItemStack[] {
				new ItemStack( Item.dyePowder, 1, 3 ), 
				new ItemStack( Item.sugar ), 
				new ItemStack( Item.bucketMilk )
		} );
    
        // Stoked Cauldron Recipes

        // glue recipes
        /* PRE-AARON CHANGES
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.leather, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ) 
		} );
            
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 2 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemLeatherCut, 2 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 2 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBelt, 2 ) 
		} );

        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemStrap, 8 ) 
		} );
		
		
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 4 ), 
			new ItemStack[] {
				new ItemStack( Item.plateLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.legsLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.saddle, 1 ) 
		} );
        */
        //AARON CHANGED glue rendering of certain leather items to match new values of cut leather
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.leather, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemTannedLeather, 1 ) 
		} );
            
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemScouredLeather, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemLeatherCut, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemTannedLeatherCut, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBelt, 1 ) 
		} );

        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemStrap, 8 ) 
		} );
		
		
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 4 ), 
			new ItemStack[] {
				new ItemStack( Item.plateLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.legsLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsLeather, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 4 ), //changed to 4 
			new ItemStack[] {
				new ItemStack( Item.saddle, 1 ) 
		} );
        //AARON END NEW GLUE
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpHelm, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpChest, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpLeggings, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpBoots, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBreedingHarness, 1, m_iIgnoreMetadata ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.book, 2, m_iIgnoreMetadata ) 
		} );
    
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.writableBook, 2, m_iIgnoreMetadata ) 
		} );
    
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.writtenBook, 2, m_iIgnoreMetadata ) 
		} );
    
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.enchantedBook, 2, m_iIgnoreMetadata ) 
		} );
        
        //AARON CHANGED tanned leather rendering to match new values
        
//        AddStokedCauldronRecipe(
//			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
//			new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemArmorTannedHelm, 1, m_iIgnoreMetadata ) 
//		} );
//        
//        AddStokedCauldronRecipe(
//			new ItemStack( FCBetterThanWolves.fcItemGlue, 4 ), 
//			new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemArmorTannedChest, 1, m_iIgnoreMetadata ) 
//		} );
//        
//        AddStokedCauldronRecipe(
//			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
//			new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemArmorTannedLeggings, 1, m_iIgnoreMetadata ) 
//		} );
//        
//        AddStokedCauldronRecipe(
//			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
//			new ItemStack[] {
//				new ItemStack( FCBetterThanWolves.fcItemArmorTannedBoots, 1, m_iIgnoreMetadata ) 
//		} );
        
        
      AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorTannedHelm, 1, m_iIgnoreMetadata ) 
		} );
      
      AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 4 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorTannedChest, 1, m_iIgnoreMetadata ) 
		} );
      
      AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorTannedLeggings, 1, m_iIgnoreMetadata ) 
		} );
      
      AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemGlue, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorTannedBoots, 1, m_iIgnoreMetadata ) 
		} );
      //AARON END NEW TANNED LEATHER
        
        // tallow recipes
        //AARON CHANGE!!! From 1 tallow per pork to 3
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 3 ), 
				new ItemStack[] {
					new ItemStack( Item.porkCooked, 1 ) 
			} ); 
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 3 ), 
				new ItemStack[] {
					new ItemStack( Item.porkRaw, 1 ) 
			} );
                
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcItemWolfCooked, 8 ) 
			} );
                
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcItemWolfRaw, 8 ) 
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
				new ItemStack[] {
					new ItemStack( Item.beefCooked, 1 ) 
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
				new ItemStack[] {
					new ItemStack( Item.beefRaw, 1 ) 
			} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemMuttonCooked, 4 ) 
		} );
    
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemMuttonRaw, 4 ) 
		} );
    
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRawMysteryMeat, 16 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemCookedMysteryMeat, 16 ) 
		} );
        
        // Potash Recipes
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( Block.wood, 1, m_iIgnoreMetadata ) 
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcBloodWood, 1, m_iIgnoreMetadata ) 
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( Block.planks, 6, m_iIgnoreMetadata ) 
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 12, m_iIgnoreMetadata ),
			} );

        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 24, m_iIgnoreMetadata ),
			} );

        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 48, m_iIgnoreMetadata ),
			} );

        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcItemSawDust, 16 )
			} );
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcItemSoulDust, 16 )
			} );
        
        // misc stoked recipes
        
        AddStokedCauldronRecipe(
				new ItemStack( FCBetterThanWolves.fcItemSoap, 1 ), 
				new ItemStack[] {
					new ItemStack( FCBetterThanWolves.fcItemPotash, 1 ), 
					new ItemStack( FCBetterThanWolves.fcItemTallow, 1 ) 
			} );
        
        AddStokedCauldronRecipe(
			new ItemStack[] {
				new ItemStack( Item.silk, 2 ),
				new ItemStack( Item.stick, 2 )
			},
			new ItemStack[] {
				new ItemStack( Item.bow, 1, m_iIgnoreMetadata ) 
			} 
		);
        
        AddStokedCauldronRecipe(
			new ItemStack[] {
				new ItemStack( Item.stick, 2 ),
				new ItemStack( Item.silk, 1 ),
				new ItemStack( Item.bone, 1 )    	    		 
			},
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemCompositeBow, 1, m_iIgnoreMetadata ) 
			} 
		);
        
        AddStokedCauldronRecipe(
			new ItemStack[] {
				new ItemStack( Item.flint, 1 ),
				new ItemStack( Item.stick, 1 ),
				new ItemStack( Item.feather, 1 )
			},
			new ItemStack[] {
				new ItemStack( Item.arrow, 1, m_iIgnoreMetadata ) 
			} 
		);
                
        AddStokedCauldronRecipe(
			new ItemStack[] {
				new ItemStack( Item.flint, 1 )
			},
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRottenArrow, 1, m_iIgnoreMetadata ) 
			} 
		);
            
        AddStokedCauldronRecipe(
			new ItemStack( FCBetterThanWolves.fcItemDogFood, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.rottenFlesh, 4 ), 
				new ItemStack( Item.dyePowder, 4, 15 ), 
				new ItemStack( Item.sugar, 1 ) 
		} );
        
        AddStokedCauldronRecipe(
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBrimstone, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemSoulFlux, 1 )
			},
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemEnderSlag, 1 ) 
			} 
		);
	}
    
	private static void AddCrucibleRecipes()
	{
		// stoked recipes
		
    	// gold melting
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 3 ), 
			new ItemStack( Item.ingotGold, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.pickaxeGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 2 ), 
			new ItemStack( Item.goldNugget, 12 ), 
			new ItemStack[] {
				new ItemStack( Item.axeGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 2 ), 
			new ItemStack( Item.goldNugget, 12 ), 
			new ItemStack[] {
				new ItemStack( Item.swordGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 2 ), 
			new ItemStack( Item.goldNugget, 6 ), 
			new ItemStack[] {
				new ItemStack( Item.hoeGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 1 ), 
			new ItemStack( Item.goldNugget, 6 ), 
			new ItemStack[] {
				new ItemStack( Item.shovelGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 5 ), 
			new ItemStack( Item.goldNugget, 30 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 8 ), 
			new ItemStack( Item.goldNugget, 48 ), 
			new ItemStack[] {
				new ItemStack( Item.plateGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 7 ), 
			new ItemStack( Item.goldNugget, 42 ), 
			new ItemStack[] {
				new ItemStack( Item.legsGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 4 ), 
			new ItemStack( Item.goldNugget, 24 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsGold, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 4 ), 
			new ItemStack( Item.goldNugget, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.pocketSundial )
			} );
		
		//AARON CHANGED to reflect new recipe for powered rails (you get almost all gold back in nuggets)
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotGold, 1 ), 
			new ItemStack( Item.goldNugget, 2 ), 
			new ItemStack[] {
				new ItemStack( Block.railPowered )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( Item.ingotGold, 9 ), 
			new ItemStack[] {
				new ItemStack( Block.blockGold )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 8 ), 
			new ItemStack( Item.goldNugget, 5 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemOcularOfEnder )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 16 ), 
			new ItemStack( Item.goldNugget, 11 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemEnderSpectacles, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 8 ), 
			new ItemStack( Item.goldNugget, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemGoldenDung )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 3 ), 
			new ItemStack( Item.goldNugget, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRedstoneLatch )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 3 ), 
			new ItemStack( Item.goldNugget, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockRedstoneClutch )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 3 ), 
			new ItemStack( Item.goldNugget, 2 ), 
			new ItemStack[] {
				new ItemStack( Block.music )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 90 ), 
			new ItemStack( Item.goldNugget, 60 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockSoulforgeDormant )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.goldNugget, 11 ), 
			new ItemStack( Item.goldNugget, 8 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockLightningRod )
		} );
		
		// iron melting recipes
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 4 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemMail )
			} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 5 ), 
			new ItemStack[] {
				new ItemStack( Item.bucketEmpty )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 5 ), 
			new ItemStack[] {
				new ItemStack( Item.bucketLava )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 5 ), 
			new ItemStack[] {
				new ItemStack( Item.bucketWater )
		} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 5 ), 
			new ItemStack[] {
				new ItemStack( Item.bucketMilk )
		} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 5 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBucketCement )
		} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 3 ), 
			new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.pickaxeIron, 1, m_iIgnoreMetadata )
		} );
				
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 12 ), 
			new ItemStack[] {
				new ItemStack( Item.axeIron, 1, m_iIgnoreMetadata )
		} );
				
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 12 ), 
			new ItemStack[] {
				new ItemStack( Item.swordIron, 1, m_iIgnoreMetadata )
		} );
					
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( Item.hoeIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( Item.shovelIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 5 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 30 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 8 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 48 ), 
			new ItemStack[] {
				new ItemStack( Item.plateIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 42 ), 
			new ItemStack[] {
				new ItemStack( Item.legsIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 4 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 24 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsIron, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 20 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 13 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetChain, 1, m_iIgnoreMetadata )
		} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 32 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 21 ), 
			new ItemStack[] {
				new ItemStack( Item.plateChain, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 28 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 19 ), 
			new ItemStack[] {
				new ItemStack( Item.legsChain, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 16 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 11 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsChain, 1, m_iIgnoreMetadata )
		} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 4 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.compass )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack[] {
				//new ItemStack( Item.ingotIron, 6 ),
				//new ItemStack( Item.goldNugget, 6 ),
				new ItemStack( Item.ingotIron, 4 ),
				new ItemStack( Item.goldNugget, 4 ),
			},
			new ItemStack[] {
				new ItemStack( Item.doorIron )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 4 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.map )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 12 ), 
			new ItemStack[] {
				new ItemStack( Item.shears, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( Block.railDetector )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcDetectorRailWood )
		} );
		
		AddStokedCrucibleRecipe(
			new ItemStack[] {
				//new ItemStack( Item.ingotIron, 1 ), 
				new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
				new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 3 ), 
			},
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockDetectorRailSoulforgedSteel, 1 )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcPulley )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 3 ), 
			new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcSaw )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( Item.ingotIron, 9 ), 
			new ItemStack[] {
				new ItemStack( Block.blockIron )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 5 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 30 ), 
			new ItemStack[] {
				new ItemStack( Item.minecartEmpty )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 5 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 30 ), 
			new ItemStack[] {
				new ItemStack( Item.minecartCrate )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 5 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 30 ), 
			new ItemStack[] {
				new ItemStack( Item.minecartPowered )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 3 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 18 ), 
			new ItemStack[] {
				new ItemStack( Block.rail, 8 )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 3 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 18 ), 
			new ItemStack[] {
				new ItemStack( Block.fenceIron, 8 ) // iron bars
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 42 ), 
			new ItemStack[] {
				new ItemStack( Item.cauldron )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 42 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcCauldron )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 6 ), 
			new ItemStack( Item.ingotIron, 4 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemScrew )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 6 ), 
			new ItemStack( Item.ingotIron, 4 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockScrewPump )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpHelm )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 12 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpChest )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpLeggings )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 2 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 12 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorGimpBoots )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 7 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 42 ), 
			new ItemStack[] {
				new ItemStack( Block.anvil )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 1 ), 
			new ItemStack[] {
				new ItemStack( Block.tripWireSource, 1 )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 4 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemChiselIron, 1, m_iIgnoreMetadata )
			} );
			
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 1 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 6 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemMetalFragment )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 54 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 36 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockShovel )
		} );
		
		AddStokedCrucibleRecipe( 
			//new ItemStack( Item.ingotIron, 11 ), 
			new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 8 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockSpikeIron )
		} );
		
		// diamond melting recipes
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 3 ), 
			new ItemStack[] {
				new ItemStack( Item.pickaxeDiamond, 1, m_iIgnoreMetadata )
			} );
				
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.axeDiamond, 1, m_iIgnoreMetadata )
			} );
				
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 2 ), 
			new ItemStack[] {
				new ItemStack( Item.swordDiamond, 1, m_iIgnoreMetadata )
			} );
					
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.hoeDiamond, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.shovelDiamond, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 5 ), 
			new ItemStack[] {
				new ItemStack( Item.helmetDiamond, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 8 ), 
			new ItemStack[] {
				new ItemStack( Item.plateDiamond, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 7 ), 
			new ItemStack[] {
				new ItemStack( Item.legsDiamond, 1, m_iIgnoreMetadata )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemIngotDiamond, 4 ), 
			new ItemStack[] {
				new ItemStack( Item.bootsDiamond, 1, m_iIgnoreMetadata )
			} );
		
    	// steel items
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 5 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBattleAxe, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRefinedAxe, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRefinedPickAxe, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 4 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemMattock, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 3 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRefinedSword, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRefinedHoe, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemRefinedShovel, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemArmorPlate )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 10 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemPlateHelm, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 14 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemPlateBreastPlate, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 12 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemPlateLeggings, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 8 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemPlateBoots, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBroadheadArrowhead, 1 )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemBroadheadArrow, 1 )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 16 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, 
						FCBlockAestheticOpaque.m_iSubtypeSteel )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 16 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcSoulforgedSteelBlock )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemTuningFork, 1, m_iIgnoreMetadata )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 2 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcBlockPressurePlateSoulforgedSteel, 1 )
		} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 12 ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 1, FCBlockAestheticNonOpaque.m_iSubtypeLightningRod )
		} );
		
		// non-melting recipes
		
		AddStokedCrucibleRecipe( 
			new ItemStack( Item.ingotGold, 1  ), 
			new ItemStack[] {
				new ItemStack( Item.goldNugget, 9 )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( Item.ingotIron, 1  ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemNuggetIron, 9 )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 1  ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcItemNuggetSteel, 9 )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcItemSteel, 1 ), 
			new ItemStack[] {
				new ItemStack( Item.ingotIron, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemCoalDust, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemSoulUrn, 1 ),
				new ItemStack( FCBetterThanWolves.fcItemSoulFlux, 1 )				
			} );
		
		// glass creation

		AddStokedCrucibleRecipe( 
			new ItemStack( Block.glass, 4 ), 
			new ItemStack[] {
				new ItemStack( Block.sand, 8 ),
				new ItemStack( Item.netherQuartz )
			} );
		
		AddStokedCrucibleRecipe( 
			new ItemStack( Block.glass, 3 ), 
			new ItemStack[] {
				new ItemStack( Block.thinGlass, 8 )
			} );
		
		// smoothstone creation
		
		AddStokedCrucibleRecipe( 
			new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeWhiteStone ), 
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeWhiteCobble )
			} );		
	}
	
	private static void AddMillStoneRecipes()
	{
		// red dye
		
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 2, 1 ), new ItemStack( Block.plantRed ) );
		
		// yellow dye
		
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 2, 11 ), new ItemStack( Block.plantYellow ) );
		
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 1, 3 ), // cocoa powder 
			new ItemStack( FCBetterThanWolves.fcItemCocoaBeans ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemFlour ), 
			new ItemStack( Item.wheat ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemFlour ), 
			new ItemStack( FCBetterThanWolves.fcItemWheat ) );
		
		AddMillStoneRecipe( new ItemStack( Item.sugar ), new ItemStack( Item.reed ) );

		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemHempFibers, 4, 0 ), new ItemStack( FCBetterThanWolves.fcItemHemp ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemScouredLeather ), new ItemStack( Item.leather ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemScouredLeatherCut ), new ItemStack( FCBetterThanWolves.fcItemLeatherCut ) );
		
		// the following output stacks are split so they eject separately from the Mill Stone
		
		AddMillStoneRecipe( 
			new ItemStack[] {
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.silk ), 
				new ItemStack( Item.dyePowder, 1, 1 ), // red dye 			
				new ItemStack( Item.dyePowder, 1, 1 ), 			
				new ItemStack( Item.dyePowder, 1, 1 ), 			
				new ItemStack( FCBetterThanWolves.fcItemWolfRaw, 1, 0 )			
			},
			new ItemStack[] {
				new ItemStack( FCBetterThanWolves.fcCompanionCube ) 
		} );
		
		// companion slab
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemWolfRaw, 1, 0 ), new ItemStack( FCBetterThanWolves.fcCompanionCube, 1, 1 ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemCoalDust, 2 ), new ItemStack( Item.coal, 1, m_iIgnoreMetadata )  );
		
		// bone meal		
		
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 3, 15 ), new ItemStack( Item.bone ) );
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 6, 15 ), new ItemStack( Item.skull.itemID, 1, 0 ) );
		AddMillStoneRecipe( new ItemStack( Item.dyePowder, 6, 15 ), new ItemStack( Item.skull.itemID, 1, 1 ) );
		
		AddMillStoneRecipe( new ItemStack( FCBetterThanWolves.fcItemGroundNetherrack ), new ItemStack( Block.netherrack ) );		
	}
	
	private static void AddTuningForkRecipes()
	{
		for ( int iTempDamage = 0; iTempDamage < 24; iTempDamage++ )
		{
			AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTuningFork, 1, iTempDamage + 1 ), new Object[] {	    		
	    		new ItemStack( FCBetterThanWolves.fcItemTuningFork, 1, iTempDamage ) 
			} );
		}
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemTuningFork, 1, 0 ), new Object[] {	    		
    		new ItemStack( FCBetterThanWolves.fcItemTuningFork, 1, 24 ) 
		} );
	}	
	    	
	private static void AddSubBlockRecipes()
	{
		AddWoodSubBlockRecipes();
		
		AddSubBlockRecipesOfType( Block.stone, 0, 
			FCBetterThanWolves.fcBlockSmoothStoneSidingAndCorner, 
			FCBetterThanWolves.fcBlockSmoothStoneMouldingAndDecorative, true );
		
		AddSubBlockRecipesOfType( Block.stoneBrick, 0, 
			FCBetterThanWolves.fcBlockStoneBrickSidingAndCorner, 
			FCBetterThanWolves.fcBlockStoneBrickMouldingAndDecorative, true );
		
		AddSubBlockRecipesOfType( FCBetterThanWolves.fcAestheticOpaque, FCBlockAestheticOpaque.m_iSubtypeWhiteStone, 
			FCBetterThanWolves.fcBlockWhiteStoneSidingAndCorner, 
			FCBetterThanWolves.fcBlockWhiteStoneMouldingAndDecorative, true );
		
		AddSubBlockRecipesOfType( Block.netherBrick, 0, 
			FCBetterThanWolves.fcBlockNetherBrickSidingAndCorner, 
			FCBetterThanWolves.fcBlockNetherBrickMouldingAndDecorative, false );
		
		// high effeciency for nether brick fences
		
		AddRecipe( new ItemStack( Block.netherFence, 2 ), new Object[] {
            "###", 
            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockNetherBrickMouldingAndDecorative, 1, 0 ) 
		} );
		
		AddSubBlockRecipesOfType( Block.brick, 0, 
			FCBetterThanWolves.fcBlockBrickSidingAndCorner, FCBetterThanWolves.fcBlockBrickMouldingAndDecorative, true );	
		
		AddSubBlockRecipesOfType( Block.sandStone, m_iIgnoreMetadata, 0, 
			FCBetterThanWolves.fcBlockSandstoneSidingAndCorner, FCBetterThanWolves.fcBlockSandstoneMouldingAndDecorative, true );
		
		AddSubBlockRecipesOfType( Block.blockNetherQuartz, 0, 
			FCBetterThanWolves.fcBlockSidingAndCornerBlackStone, FCBetterThanWolves.fcBlockMouldingAndDecorativeBlackStone, true );		
	}
	
	public static void AddSubBlockRecipesOfType( Block fullBlock, int iFullBlockMetadata, Block sidingAndCornerBlock, Block mouldingBlock, boolean bIncludeFence )
	{
		AddSubBlockRecipesOfType( fullBlock, iFullBlockMetadata, iFullBlockMetadata, sidingAndCornerBlock, mouldingBlock, bIncludeFence );
	}
	
	public static void AddSubBlockRecipesOfType( Block fullBlock, int iFullBlockInputMetadata, int iFullBlockOutputMetadata, Block sidingAndCornerBlock, Block mouldingBlock, boolean bIncludeFence )
	{
		// sub block creation recipes
		
		AddAnvilRecipe( new ItemStack( sidingAndCornerBlock, 8, 0 ), new Object[] {
    		"####", 
    		Character.valueOf( '#' ), new ItemStack( fullBlock, 1, iFullBlockInputMetadata )
		} );
		
		AddAnvilRecipe( new ItemStack( mouldingBlock, 8, 0 ), new Object[] {
    		"####", 
    		Character.valueOf( '#' ), new ItemStack( sidingAndCornerBlock, 1, 0 )
		} );
		
		AddAnvilRecipe( new ItemStack( sidingAndCornerBlock, 8, 1 ), new Object[] {
    		"####", 
    		Character.valueOf( '#' ), new ItemStack( mouldingBlock, 1, 0 )
		} );
		
		AddRecipe( new ItemStack( mouldingBlock, 1, FCBlockMouldingAndDecorative.m_iSubtypeColumn ), new Object[] {
    		"M", 
    		"M", 
    		"M", 
    		Character.valueOf( 'M' ), new ItemStack( mouldingBlock, 1, 0 )
		} );
		
		AddRecipe( new ItemStack( mouldingBlock, 6, FCBlockMouldingAndDecorative.m_iSubtypePedestalUp ), new Object[] {
    		" S ", 
    		"###", 
    		"###", 
    		Character.valueOf( '#' ), new ItemStack( fullBlock, 1, iFullBlockInputMetadata ), 
    		Character.valueOf( 'S' ), new ItemStack( sidingAndCornerBlock, 8, 0 )
		} );
		
		AddRecipe( new ItemStack( mouldingBlock, 4, FCBlockMouldingAndDecorative.m_iSubtypeTable ), new Object[] {
    		"###", 
    		" X ", 
    		" X ", 
    		Character.valueOf( '#' ), new ItemStack( sidingAndCornerBlock, 1, 0 ), 
    		Character.valueOf( 'X' ), new ItemStack( mouldingBlock, 1, 0 )
		} );
		
		AddRecipe( new ItemStack( sidingAndCornerBlock, 4, FCBlockSidingAndCornerAndDecorative.m_iSubtypeBench ), new Object[] {
    		"###", 
    		" X ", 
    		Character.valueOf( '#' ), new ItemStack( sidingAndCornerBlock, 1, 0 ), 
    		Character.valueOf( 'X' ), new ItemStack( mouldingBlock, 1, 0 )
		} );
		
		if ( bIncludeFence )
		{
			AddRecipe( new ItemStack( sidingAndCornerBlock, 6, FCBlockSidingAndCornerAndDecorative.m_iSubtypeFence ), new Object[] {
	            "###", 
	            "###", 
	            Character.valueOf('#'), new ItemStack( fullBlock, 1, iFullBlockInputMetadata ) 
			} );
			
			AddRecipe( new ItemStack( sidingAndCornerBlock, 2, FCBlockSidingAndCornerAndDecorative.m_iSubtypeFence ), new Object[] {
	            "###", 
	            Character.valueOf('#'), new ItemStack( mouldingBlock, 1, 0 ) 
			} );				
		}
		
		// sub block combine recipes
		
		AddShapelessRecipe( new ItemStack(  fullBlock, 1, iFullBlockOutputMetadata ), new Object[] { 
			new ItemStack( sidingAndCornerBlock, 1, 0 ),
			new ItemStack( sidingAndCornerBlock, 1, 0 ) 
		} );
		
		AddShapelessRecipe( new ItemStack(  sidingAndCornerBlock, 1, 0 ), new Object[] { 
			new ItemStack( mouldingBlock, 1, 0 ),
			new ItemStack( mouldingBlock, 1, 0 ) 
		} );
		
		AddShapelessRecipe( new ItemStack(  mouldingBlock, 1, 0 ), new Object[] { 
			new ItemStack( sidingAndCornerBlock, 1, 1 ),
			new ItemStack( sidingAndCornerBlock, 1, 1 ) 
		} );		
	}
	
	private static void AddWoodSubBlockRecipes()
	{
		// wood sub-blocks
	
		for ( int iWoodType = 0; iWoodType <= 4; iWoodType++ )
		{
			AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingDecorativeItemStubID, 6,
				FCItemBlockWoodMouldingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodMouldingDecorativeStub.m_iTypePedestal ) ), new Object[] {
	    		" S ", 
	    		"###", 
	    		"###", 
	    		Character.valueOf( '#' ), new ItemStack( Block.planks, 1, iWoodType ), 
	    		Character.valueOf( 'S' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ) 
			} );
			
			AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingDecorativeItemStubID, 1, 
				FCItemBlockWoodMouldingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodMouldingDecorativeStub.m_iTypeColumn ) ), new Object[] {
	    		"M", 
	    		"M", 
	    		"M", 
	    		Character.valueOf( 'M' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType )
			} );
			
			AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingDecorativeItemStubID, 4, 
				FCItemBlockWoodMouldingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodMouldingDecorativeStub.m_iTypeTable ) ), new Object[] {
	    		"###", 
	    		" X ", 
	    		" X ", 
	    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ), 
	    		Character.valueOf( 'X' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType )
			} );
			
			AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodSidingDecorativeItemStubID, 4, 
				FCItemBlockWoodSidingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodSidingDecorativeStub.m_iTypeBench ) ), new Object[] {
	    		"###", 
	    		" X ", 
	    		Character.valueOf( '#' ), new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ), 
	    		Character.valueOf( 'X' ), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType )
			} );
			
			if ( iWoodType == 0 )
			{
				// Recipes for regular vanilla fences
				
				AddRecipe( new ItemStack( Block.fence, 6 ), new Object[] {
		            "###", 
		            "###", 
		    		Character.valueOf( '#' ), new ItemStack( Block.planks, 1, iWoodType ), 
				} );
				
				AddRecipe( new ItemStack( Block.fence, 2 ), new Object[] {
		            "###", 
		            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType ) 
				} );				
			}
			else
			{
				AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodSidingDecorativeItemStubID, 6, 
					FCItemBlockWoodSidingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodSidingDecorativeStub.m_iTypeFence ) ), new Object[] {
		            "###", 
		            "###", 
		    		Character.valueOf( '#' ), new ItemStack( Block.planks, 1, iWoodType ), 
				} );
				
				AddRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodSidingDecorativeItemStubID, 2, 
					FCItemBlockWoodSidingDecorativeStub.GetItemDamageForType( iWoodType, FCItemBlockWoodSidingDecorativeStub.m_iTypeFence ) ), new Object[] {
		            "###", 
		            Character.valueOf('#'), new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType ) 
				} );				
			}
			
			// sub-block combine recipes
			
			AddShapelessRecipe( new ItemStack( Block.planks, 1, iWoodType ), new Object[] { 
				new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ),
				new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ) 
			} );
			
			AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, iWoodType ), new Object[] { 
				new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType ),
				new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType ) 
			} );
			
			AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, iWoodType ), new Object[] { 
				new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 1, iWoodType ),
				new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 1, iWoodType ) 
			} );			
		}
	}
	
	private static void AddLegacyConversionRecipes()
	{
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingDecorativeItemStubID, 1, 
			( FCItemBlockWoodMouldingDecorativeStub.m_iTypeTable << 2 ) ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 1, FCBlockAestheticNonOpaque.m_iSubtypeTable ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSmoothStoneMouldingAndDecorative, 1, FCBlockMouldingAndDecorative.m_iSubtypePedestalUp ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 1, FCBlockAestheticNonOpaque.m_iSubtypePedestalUp ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSmoothStoneMouldingAndDecorative, 1, FCBlockMouldingAndDecorative.m_iSubtypeColumn ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcAestheticNonOpaque, 1, FCBlockAestheticNonOpaque.m_iSubtypeColumn ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodMouldingItemStubID, 1, 0 ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcBlockWoodOakMouldingAndDecorative ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSmoothStoneSidingAndCorner, 1, 1 ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcBlockLegacySmoothstoneAndOakCorner, 1, 8 ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodCornerItemStubID, 1, 0 ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcBlockLegacySmoothstoneAndOakCorner, 1, 0 ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSmoothStoneSidingAndCorner, 1, 0 ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcBlockLegacySmoothstoneAndOakSiding, 1, 0 ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWoodSidingItemStubID, 1, 0 ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcBlockLegacySmoothstoneAndOakSiding, 1, 1 ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockAestheticOpaqueEarth, 1, FCBlockAestheticOpaqueEarth.m_iSubtypeDung ), new Object[] { 
			new ItemStack( FCBetterThanWolves.fcAestheticOpaque, 1, FCBlockAestheticOpaque.m_iSubtypeDung ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMushroomBrown ), new Object[] { 
			new ItemStack( Block.mushroomBrown ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcItemMushroomRed ), new Object[] { 
			new ItemStack( Block.mushroomRed ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWorkbench ), new Object[] {	    		
    		new ItemStack( Block.workbench )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockChest ), new Object[] {	    		
    		new ItemStack( Block.chest )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockWeb ), new Object[] {	    		
    		new ItemStack( Block.web )
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockUnfiredClay ), new Object[] { 
            new ItemStack( Block.blockClay ),
        } );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockLadder ), new Object[] { 
			new ItemStack( Block.ladder ) 
		} );
		
		AddShapelessRecipe( new ItemStack( FCBetterThanWolves.fcBlockSnowSolid ), new Object[] {	    		
    		new ItemStack( Block.blockSnow )
		} );
	}

	private static void AddCustomRecipeClasses()
	{
		CraftingManager.getInstance().getRecipeList().add( new FCRecipesFishingRodBaiting() );
		CraftingManager.getInstance().getRecipeList().add( new FCRecipesLogChopping() );
		CraftingManager.getInstance().getRecipeList().add( new FCRecipesKnitting() );
	}
	
	private static void addVillagerTrades() {
		//Aliased for readability
		int farmer = FCEntityVillager.professionIDFarmer;
		int librarian = FCEntityVillager.professionIDLibrarian;
		int priest = FCEntityVillager.professionIDPriest;
		int blacksmith = FCEntityVillager.professionIDBlacksmith;
		int butcher = FCEntityVillager.professionIDButcher;
		
		// TODO: Rebalance some of the outlier values in trades
		
		// ------ Farmer ------ //
		//Level 1
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcBlockDirtLoose.blockID, 48, 64, 1F, 1).setDefault(farmer);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.wood.blockID, 0, 32, 48, 0.15F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.wood.blockID, 1, 32, 48, 0.15F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.wood.blockID, 2, 32, 48, 0.15F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.wood.blockID, 3, 32, 48, 0.15F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemWool.itemID, 3, 16, 24, 1F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Item.dyePowder.itemID, 15, 32, 48, 1F, 1);
		
//		FCEntityVillager.addComplexTrade(
//				farmer,
//				Item.reed.itemID, 0, 4, 4,
//				Item.emerald.itemID, 0, 1, 1,
//				FCBetterThanWolves.fcItemWickerPiece.itemID, 0, 1, 1,
//				0.5F, 1
//			)
//			.setMandatory();

		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(farmer, Item.hoeIron.itemID, 1, 1, 1);
		
		//Level 2
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemFlour.itemID, 24, 32, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Item.sugar.itemID, 10, 20, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemCocoaBeans.itemID, 10, 16, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemMushroomBrown.itemID, 10, 16, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemHempSeeds.itemID, 24, 32, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Item.egg.itemID, 12, 12, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.thinGlass.blockID, 16, 32, 1F, 2);
		FCEntityVillager.addTradeToBuySingleItem(farmer, Item.bucketMilk.itemID, 1, 2, 0.25F, 2);
		
		FCEntityVillager.addTradeToSellMultipleItems(farmer, FCBetterThanWolves.fcItemWheat.itemID, 8, 16, 1F, 2);
		FCEntityVillager.addTradeToSellMultipleItems(farmer, Item.appleRed.itemID, 2, 4, 0.5F, 2);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(farmer, FCBetterThanWolves.fcMillStone.blockID, 2, 2, 2);
		
		//Level 3
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, Block.melon.blockID, 8, 10, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcBlockPumpkinFresh.blockID, 10, 16, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemStumpRemover.itemID, 8, 12, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcItemChocolate.itemID, 1, 2, 1F, 3);
		FCEntityVillager.addTradeToBuySingleItem(farmer, Item.shears.itemID, 1, 1, 0.5F, 3);
		FCEntityVillager.addTradeToBuySingleItem(farmer, Item.flintAndSteel.itemID, 1, 1, 0.5F, 3);
		FCEntityVillager.addComplexTrade(
				farmer,
				FCBetterThanWolves.fcItemStake.itemID, 0, 1, 1,
				Item.silk.itemID, 0, 16, 32,
				Item.emerald.itemID, 0, 1, 1,
				0.5F, 3
			);
		FCEntityVillager.addTradeToBuySingleItem(farmer, FCBetterThanWolves.fcItemSoap.itemID, 1, 2, 1F, 3)
			.registerEffectForTrade(FCEntityVillager.professionIDFarmer, new TradeEffect() {
				@Override
				public void playEffect(FCEntityVillager villager) {
					villager.worldObj.playSoundAtEntity(villager, "mob.slime.attack", 1.0F, (villager.rand.nextFloat() - villager.rand.nextFloat()) * 0.2F + 1.0F);
					
					villager.SetDirtyPeasant(0);
				}
			})
			.setConditional(new TradeConditional() {
				@Override
				public boolean shouldAddTrade(FCEntityVillager villager) {
					return villager.GetDirtyPeasant() > 0;
				}
			});
		
		FCEntityVillager.addTradeToSellMultipleItems(farmer, Item.bread.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(farmer, FCBetterThanWolves.fcItemCookedMushroomOmelet.itemID, 8, 12, 0.5F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(farmer, FCBetterThanWolves.fcItemCookedScrambledEggs.itemID, 8, 12, 0.5F, 3);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(farmer, FCBetterThanWolves.fcItemWaterWheel.itemID, 3, 3, 3);
		
		//Level 4
		FCEntityVillager.addTradeToBuySingleItem(farmer, FCBetterThanWolves.fcItemBucketCement.itemID, 2, 4, 1F, 4);
		FCEntityVillager.addTradeToBuyMultipleItems(farmer, FCBetterThanWolves.fcLightBulbOff.blockID, 2, 4, 1F, 4);
		
		FCEntityVillager.addTradeToSellMultipleItems(farmer, Item.cookie.itemID, 8, 16, 1F, 4);
		FCEntityVillager.addTradeToSellMultipleItems(farmer, Item.pumpkinPie.itemID, 1, 2, 1F, 4);
		FCEntityVillager.addTradeToSellSingleItem(farmer, Item.cake.itemID, 2, 4, 1F, 4);
		
		FCEntityVillager.addLevelUpTradeToBuy(farmer, FCBetterThanWolves.fcBlockPlanterSoil.blockID, 0, 8, 12, 4, 4, 4);
		
		//Level 5
		FCEntityVillager.addTradeToSellSingleItem(farmer, Block.mycelium.blockID, 10, 20, 1F, 5);
		FCEntityVillager.addArcaneScrollTrade(farmer, Enchantment.looting.effectId, 16, 32, 1F, 5);
		
		// ------ Librarian ------ //
		//Level 1
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.paper.itemID, 27, 38, 1F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.dyePowder.itemID, 0, 27, 38, 1F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.feather.itemID, 27, 38, 1F, 1);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(librarian, Item.enchantedBook.itemID, 2, 2, 1);
		
		//Level 2
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.book.itemID, 1, 3, 1F, 2);
		FCEntityVillager.addTradeToBuySingleItem(librarian, Item.writableBook.itemID, 1, 1, 1F, 2);
		FCEntityVillager.addTradeToBuySingleItem(librarian, Block.bookShelf.blockID, 1, 1, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.netherStalkSeeds.itemID, 16, 24, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.lightStoneDust.itemID, 24, 32, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcItemNitre.itemID, 32, 48, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcItemBatWing.itemID, 14, 16, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.spiderEye.itemID, 4, 8, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.redstone.itemID, 32, 48, 1F, 2);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(librarian, Item.brewingStand.itemID, 2, 2, 2);
		
		//Level 3
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcItemWitchWart.itemID, 6, 10, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcItemMysteriousGland.itemID, 14, 16, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.fermentedSpiderEye.itemID, 4, 8, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.ghastTear.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.magmaCream.itemID, 8, 12, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, Item.blazePowder.itemID, 4, 6, 1F, 3);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(librarian, FCBetterThanWolves.fcBlockDispenser.blockID, 4, 4, 3);
		
		//Level 4
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcBlockDetector.blockID, 2, 3, 1F, 4);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcBuddyBlock.blockID, 2, 3, 1F, 4);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcBlockDispenser.blockID, 2, 3, 1F, 4);
		FCEntityVillager.addTradeToBuySingleItem(librarian, FCBetterThanWolves.fcLens.blockID, 2, 3, 1F, 4);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(librarian, FCBetterThanWolves.fcItemEnderSpectacles.itemID, 3, 3, 4);
		
		//Level 5
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcItemBrimstone.itemID, 16, 32, 1F, 5);
		FCEntityVillager.addTradeToBuyMultipleItems(librarian, FCBetterThanWolves.fcAestheticVegetation.blockID, 
				FCBlockAestheticVegetation.m_iSubtypeBloodWoodSapling, 8, 16, 1F, 5);
		FCEntityVillager.addTradeToBuySingleItem(librarian, FCBetterThanWolves.fcItemBloodMossSpores.itemID, 2, 3, 1F, 5);
		
		FCEntityVillager.addArcaneScrollTrade(librarian, Enchantment.power.effectId, 32, 48, 1F, 5);
		
		//Mandatory trades
		FCEntityVillager.addItemConversionTrade(librarian, Item.enderPearl.itemID, 6, 8, Item.eyeOfEnder.itemID, 1F, 5).setMandatory();
		
		// ------ Priest ------ //
		//Level 1
		FCEntityVillager.addTradeToBuyMultipleItems(priest, FCBetterThanWolves.fcItemHemp.itemID, 18, 22, 1F, 1).setDefault(priest);
		FCEntityVillager.addTradeToBuyMultipleItems(priest, FCBetterThanWolves.fcItemMushroomRed.itemID, 10, 16, 1F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(priest, Block.cactus.blockID, 32, 64, 1F, 1);
		FCEntityVillager.addTradeToBuySingleItem(priest, Item.painting.itemID, 2, 3, 0.5F, 1);
		FCEntityVillager.addTradeToBuySingleItem(priest, Item.flintAndSteel.itemID, 1, 1, 1F, 1);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(priest, Block.enchantmentTable.blockID, 2, 2, 1);
		
		//Level 2
		FCEntityVillager.addEnchantmentTrade(priest, Item.swordIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.axeIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.pickaxeIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.helmetIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.plateIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.legsIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.bootsIron.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.swordDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.axeDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.pickaxeDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.helmetDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.plateDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.legsDiamond.itemID, 2, 4, 0.25F, 2);
		FCEntityVillager.addEnchantmentTrade(priest, Item.bootsDiamond.itemID, 2, 4, 0.25F, 2);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(priest, FCBetterThanWolves.fcBlockArcaneVessel.blockID, 2, 2, 2);
		
		//Level 3
		((FCEntityVillager.WeightedMerchantRecipeEntry) FCEntityVillager.addTradeToBuyMultipleItems(
				priest, 
				FCBetterThanWolves.fcItemCandle.itemID, 4, 8, 
				1F, 3))
				.setRandomMetas(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, 0);
		// TODO: Make skulls equal with other head trades
		FCEntityVillager.addTradeToBuyMultipleItems(priest, Item.skull.itemID, 0, 3, 5, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(priest, Item.skull.itemID, 2, 2, 4, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(priest, Item.skull.itemID, 4, 2, 4, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(priest, FCBetterThanWolves.fcAestheticOpaque.blockID, FCBlockAestheticOpaque.m_iSubtypeBone, 2, 3, 1F, 3);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(priest, Item.skull.itemID, 1, 3, 3, 3);
		
		//Level 4
		FCEntityVillager.addTradeToBuyMultipleItems(priest, FCBetterThanWolves.fcItemSoulUrn.itemID, 2, 3, 1F, 4);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(priest, FCBetterThanWolves.fcInfernalEnchanter.blockID, 4, 4, 4);
		
		//Mandatory trades
		FCEntityVillager.addSkullconversionTrade(priest, 1, 6, 8, 5, 1F, 4).setMandatory();
		FCEntityVillager.addComplexTrade(
				priest, 
				FCBetterThanWolves.fcBlockSoulforgeDormant.blockID, 0, 1, 1, 
				Item.netherStar.itemID, 0, 1, 1, 
				FCBetterThanWolves.fcAnvil.blockID, 0, 1, 1, 
				1F, 4
			)
			.setMandatory()
			.registerEffectForTrade(priest, new TradeEffect() {
				@Override
				public void playEffect(FCEntityVillager villager) {
					villager.worldObj.playSoundAtEntity(villager, "random.anvil_land", 0.3F, villager.rand.nextFloat() * 0.1F + 0.9F);
					villager.worldObj.playSoundAtEntity(villager, "ambient.cave.cave4", 0.5F, villager.rand.nextFloat() * 0.05F + 0.5F);
				}
			});
		
		//Level 5
		FCEntityVillager.addTradeToBuySingleItem(priest, FCBetterThanWolves.fcItemCanvas.itemID, 2, 3, 1F, 5);
		
		FCEntityVillager.addArcaneScrollTrade(priest, Enchantment.fortune.effectId, 48, 64, 1F, 5);
		
		// ------ Blacksmith ------ //
		//Level 1
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, Item.coal.itemID, 16, 24, 1F, 1).setDefault(blacksmith);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, Block.wood.blockID, 2, 32, 48, 1F, 1);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemNuggetIron.itemID, 18, 27, 1F, 1);
		FCEntityVillager.addTradeToBuySingleItem(blacksmith, FCBetterThanWolves.fcBlockFurnaceBrickIdle.blockID, 1, 1, 1F, 1);
		
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.swordIron.itemID, 4, 6, 1F, 1);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.axeIron.itemID, 4, 6, 1F, 1);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.pickaxeIron.itemID, 6, 9, 1F, 1);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.shovelIron.itemID, 2, 3, 1F, 1);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.hoeIron.itemID, 2, 3, 1F, 1);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(blacksmith, FCBetterThanWolves.fcBBQ.blockID, 1, 1, 1);
		
		//Level 2
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemNethercoal.itemID, 12, 20, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcBBQ.blockID, 2, 3, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemCreeperOysters.itemID, 14, 16, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, Item.goldNugget.itemID, 18, 27, 1F, 2);
		FCEntityVillager.addTradeToBuySingleItem(blacksmith, Item.diamond.itemID, 2, 3, 1F, 2);
		
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.bootsIron.itemID, 4, 6, 1F, 2);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.helmetIron.itemID, 10, 15, 1F, 2);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.plateIron.itemID, 16, 24, 1F, 2);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.legsIron.itemID, 14, 21, 1F, 2);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(blacksmith, FCBetterThanWolves.fcBellows.blockID, 2, 2, 2);
		
		//Level 3
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.swordDiamond.itemID, 8, 12, 1F, 3);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.axeDiamond.itemID, 8, 12, 1F, 3);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.pickaxeDiamond.itemID, 12, 18, 1F, 3);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.shovelDiamond.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.hoeDiamond.itemID, 4, 6, 1F, 3);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(blacksmith, FCBetterThanWolves.fcCrucible.blockID, 3, 3, 3);
		
		//Level 4
		// TODO: Feels weird to have soul urns and hafts traded earlier than steel
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemSoulUrn.itemID, 2, 3, 1F, 4);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemHaft.itemID, 6, 8, 1F, 4);
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcBlockMiningCharge.blockID, 4, 6, 1F, 4);
		
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.bootsDiamond.itemID, 8, 12, 1F, 4);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.helmetDiamond.itemID, 20, 30, 1F, 4);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.plateDiamond.itemID, 32, 48, 1F, 4);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.legsDiamond.itemID, 28, 42, 1F, 4);

		FCEntityVillager.addLevelUpTradeToBuy(blacksmith, FCBetterThanWolves.fcItemSteel.itemID, 0, 8, 8, 4, 4, 4);
		
		//Level 5
		FCEntityVillager.addTradeToBuyMultipleItems(blacksmith, FCBetterThanWolves.fcItemSoulFlux.itemID, 16, 24, 1F, 5);
		
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.bootsChain.itemID, 4, 6, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.helmetChain.itemID, 10, 15, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.plateChain.itemID, 16, 24, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, Item.legsChain.itemID, 14, 21, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, FCBetterThanWolves.fcItemRefinedSword.itemID, 16, 24, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, FCBetterThanWolves.fcItemRefinedAxe.itemID, 16, 24, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, FCBetterThanWolves.fcItemRefinedPickAxe.itemID, 24, 36, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, FCBetterThanWolves.fcItemRefinedShovel.itemID, 8, 16, 1F, 5);
		FCEntityVillager.addTradeToSellSingleItem(blacksmith, FCBetterThanWolves.fcItemRefinedHoe.itemID, 16, 24, 1F, 5);
		FCEntityVillager.addArcaneScrollTrade(blacksmith, Enchantment.unbreaking.effectId, 32, 48, 1F, 5);
		
		// ------ Butcher ------ //
		//Level 1
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, Item.arrow.itemID, 24, 32, 1F, 1);
		FCEntityVillager.addTradeToBuySingleItem(butcher, Item.shears.itemID, 1, 1, 0.5F, 1);
		FCEntityVillager.addTradeToBuySingleItem(butcher, Item.fishingRod.itemID, 1, 1, 0.5F, 1);
		
		// TODO: Weird inconsistent item counts for raw meat trade - not consistent with food values
		FCEntityVillager.addTradeToSellMultipleItems(butcher, Item.beefRaw.itemID, 7, 9, 1F, 1).setDefault(butcher);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, Item.porkRaw.itemID, 8, 11, 1F, 1);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, Item.chickenRaw.itemID, 9, 12, 1F, 1);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, Item.fishRaw.itemID, 10, 13, 1F, 1);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemMuttonRaw.itemID, 10, 13, 1F, 1);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, Item.leather.itemID, 7, 9, 1F, 1);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(butcher, FCBetterThanWolves.fcCauldron.blockID, 1, 1, 1);
		
		//Level 2
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemDung.itemID, 10, 16, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemWolfRaw.itemID, 6, 8, 1F, 2);
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemBark.itemID, 1, 48, 64, 1F, 2);
		
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemSteakAndPotatoes.itemID, 4, 8, 1F, 2);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemHamAndEggs.itemID, 4, 8, 1F, 2);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemTastySandwich.itemID, 4, 8, 1F, 2);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemFishSoup.itemID, 10, 12, 1F, 2);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemCookedKebab.itemID, 4, 8, 1F, 2);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(butcher, FCBetterThanWolves.fcSaw.blockID, 2, 2, 2);
		
		//Level 3
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, Item.carrot.itemID, 10, 16, 1F, 3);
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, Item.potato.itemID, 10, 16, 1F, 3);
		FCEntityVillager.addTradeToBuySingleItem(butcher, FCBetterThanWolves.fcItemBeastLiverRaw.itemID, 1, 2, 1F, 3);

		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemTannedLeather.itemID, 4, 8, 1F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemPorkDinner.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemSteakDinner.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemWolfDinner.itemID, 4, 6, 1F, 3);
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemChickenSoup.itemID, 4, 6, 1F, 3);
		// TODO: Price seems egregious
		FCEntityVillager.addTradeToSellSingleItem(butcher, Item.saddle.itemID, 6, 8, 1F, 3);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(butcher, FCBetterThanWolves.fcItemBreedingHarness.itemID, 3, 3, 3);
		
		//Level 4
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemRawMysteryMeat.itemID, 2, 4, 1F, 4);
		FCEntityVillager.addTradeToBuySingleItem(butcher, FCBetterThanWolves.fcItemScrew.itemID, 2, 3, 1F, 4);
		FCEntityVillager.addTradeToBuySingleItem(butcher, FCBetterThanWolves.fcItemCompositeBow.itemID, 2, 3, 1F, 4);
		
		FCEntityVillager.addTradeToSellMultipleItems(butcher, FCBetterThanWolves.fcItemHeartyStew.itemID, 3, 4, 1F, 4);
		FCEntityVillager.addTradeToSellSingleItem(butcher, FCBetterThanWolves.fcItemArmorTannedBoots.itemID, 2, 3, 0.5F, 4);
		FCEntityVillager.addTradeToSellSingleItem(butcher, FCBetterThanWolves.fcItemArmorTannedChest.itemID, 6, 8, 0.5F, 4);
		FCEntityVillager.addTradeToSellSingleItem(butcher, FCBetterThanWolves.fcItemArmorTannedHelm.itemID, 3, 4, 0.5F, 4);
		FCEntityVillager.addTradeToSellSingleItem(butcher, FCBetterThanWolves.fcItemArmorTannedLeggings.itemID, 4, 6, 0.5F, 4);
		
		FCEntityVillager.addLevelUpTradeToBuySingleItem(butcher, FCBetterThanWolves.fcAestheticOpaque.blockID, FCBlockAestheticOpaque.m_iSubtypeChoppingBlockDirty, 4, 4, 4);
		
		//Mandatory trades
		FCEntityVillager.addSkullconversionTrade(butcher, 0, 6, 8, 1, 1F, 4).setMandatory();
		
		//Level 5
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemDynamite.itemID, 4, 6, 1F, 5);
		FCEntityVillager.addTradeToBuySingleItem(butcher, FCBetterThanWolves.fcItemBattleAxe.itemID, 4, 5, 1F, 5);
		FCEntityVillager.addTradeToBuySingleItem(butcher, FCBetterThanWolves.fcCompanionCube.blockID, 1, 2, 1F, 5)
				.registerEffectForTrade(butcher, new TradeEffect() {
					@Override
					public void playEffect(FCEntityVillager villager) {
						villager.worldObj.playSoundAtEntity(villager, "mob.wolf.hurt", 5.0F, (villager.rand.nextFloat() - villager.rand.nextFloat()) * 0.2F + 1.0F);
					}
				});
		FCEntityVillager.addTradeToBuyMultipleItems(butcher, FCBetterThanWolves.fcItemBroadheadArrow.itemID, 6, 12, 1F, 5);
		FCEntityVillager.addComplexTrade(
				butcher,
				FCBetterThanWolves.fcBlockLightningRod.blockID, 0, 1, 1,
				FCBetterThanWolves.fcItemSoap.itemID, 0, 1, 1,
				Item.emerald.itemID, 0, 3, 5,
				0.5F, 5
			)
			.registerEffectForTrade(butcher, new TradeEffect() {
				@Override
				public void playEffect(FCEntityVillager villager) {
					villager.worldObj.playSoundAtEntity(villager, "random.classic_hurt", 1F, villager.getSoundPitch() * 2.0F);
				}
			});
			
		FCEntityVillager.addArcaneScrollTrade(butcher, Enchantment.sharpness.effectId, 32, 48, 1F, 5);
	}

	private static void RemoveVanillaRecipes()
	{
		RemoveVanillaRecipe( new ItemStack( Item.bread, 1 ), new Object[] {
            "###", 
            '#', Item.wheat
        } );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.dyePowder, 3, 15 ), new Object[] {
	        Item.bone
        } );
		
		RemoveVanillaRecipe( new ItemStack( Item.sugar, 1 ), new Object[] {
		    "#", '#', Item.reed
		} );

		RemoveVanillaRecipe( new ItemStack( Item.cake, 1 ), new Object[] {
			"AAA", 
			"BEB", 
			"CCC", 
			'A', Item.bucketMilk, 
			'B', Item.sugar, 
			'C', Item.wheat, 
			'E', Item.egg
		} );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.dyePowder, 2, 11 ), new Object[] {
            Block.plantYellow
        } );
        
		RemoveVanillaShapelessRecipe( new ItemStack( Item.dyePowder, 2, 1 ), new Object[] {
            Block.plantRed
        } );
		
		RemoveVanillaRecipe( new ItemStack( Block.tnt, 1 ), new Object[] {
			"X#X", 
			"#X#", 
			"X#X", 
			'X', Item.gunpowder, 
			'#', Block.sand
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.cookie, 8 ), new Object[] {
 			"#X#", 
 			'X', new ItemStack(Item.dyePowder, 1, 3), // cocoa beans 
 			'#', Item.wheat
 		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.anvil, 1 ), new Object[] {
			"III", 
			" i ", 
			"iii", 
			'I', Block.blockIron, 
			'i', Item.ingotIron
		} );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.bowlSoup ), new Object[] {
			Block.mushroomBrown, 
			Block.mushroomRed, 
			Item.bowlEmpty
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.melon ), new Object[] {
			"MMM", 
			"MMM", 
			"MMM", 
			'M', Item.melon 
		} );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.pumpkinPie ), new Object[] {
			Block.pumpkin, 
			Item.sugar, 
			Item.egg
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.pumpkinSeeds, 4 ), new Object[] {
			"M", 
			'M', Block.pumpkin
		} );		
		
		RemoveVanillaRecipe( new ItemStack( Item.compass, 1 ), new Object[] {
			" # ", 
			"#X#", 
			" # ", 
			'#', Item.ingotIron, 
			'X', Item.redstone
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.pocketSundial, 1 ), new Object[] {
			" # ", 
			"#X#", 
			" # ", 
			'#', Item.ingotGold, 
			'X', Item.redstone } );
		
		RemoveVanillaRecipe( new ItemStack( Item.flintAndSteel, 1 ), new Object[] {
			"A ", 
			" B", 
			'A', Item.ingotIron, 
			'B', Item.flint
		} );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.fermentedSpiderEye ), new Object[] {
			Item.spiderEye, 
			Block.mushroomBrown, 
			Item.sugar
		} );		
		
		RemoveVanillaRecipe( new ItemStack( Block.torchWood, 4 ), new Object[] {
			"X", 
			"#", 
			'X', Item.coal, 
			'#', Item.stick 
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.torchWood, 4 ), new Object[] { 
			"X", 
			"#", 
			'X', new ItemStack( Item.coal, 1, 1 ), 
			'#', Item.stick 
		} );
		
        RemoveVanillaRecipe( new ItemStack( Item.bucketEmpty, 1 ), new Object[] {
        	"# #", 
        	" # ", 
        	'#', Item.ingotIron
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.redstoneRepeater, 1 ), new Object[] {
        	"#X#", 
        	"III", 
        	'#', Block.torchRedstoneActive, 
        	'X', Item.redstone, 
        	'I', Block.stone } );
        
        RemoveVanillaRecipe( new ItemStack( Block.snow, 6 ), new Object[] {
        	"###", 
        	'#', Block.blockSnow
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.dropper, 1 ), new Object[] {
        	"###", 
        	"# #", 
        	"#R#", 
        	'#', Block.cobblestone, 
        	'R', Item.redstone
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.stoneButton, 1 ), new Object[] {
        	"#", 
        	'#', 
        	Block.stone} );
        
        RemoveVanillaRecipe( new ItemStack( Block.woodenButton, 1 ), new Object[] {
        	"#", 
        	'#', Block.planks
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.pressurePlateStone, 1 ), new Object[] {
        	"##", 
        	'#', Block.stone 
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.pressurePlatePlanks, 1 ), new Object[] {
        	"##", 
        	'#', Block.planks
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.pressurePlateIron, 1 ), new Object[] { 
    		"##", 
    		'#', Item.ingotIron
		} );
        
        RemoveVanillaRecipe( new ItemStack( Block.pressurePlateGold, 1 ), new Object[] {
        	"##", 
        	'#', Item.ingotGold
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.daylightSensor ), new Object[] {
        	"GGG", 
        	"QQQ", 
        	"WWW", 
        	'G', Block.glass, 
        	'Q', Item.netherQuartz, 
        	'W', Block.woodSingleSlab
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.hopperBlock ), new Object[] {
        	"I I", 
        	"ICI", 
        	" I ", 
        	'I', Item.ingotIron, 
        	'C', Block.chest
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.railActivator, 6 ), new Object[] {
        	"XSX", 
        	"X#X", 
        	"XSX", 
        	'X', Item.ingotIron, 
        	'#', Block.torchRedstoneActive, 
        	'S', Item.stick } );
        
        RemoveVanillaRecipe( new ItemStack( Item.comparator, 1 ), new Object[] {
        	" # ", 
        	"#X#", 
        	"III", 
        	'#', Block.torchRedstoneActive, 
        	'X', Item.netherQuartz, 
        	'I', Block.stone
    	} );

        RemoveVanillaRecipe( new ItemStack( Item.minecartTnt, 1 ), new Object[] {
        	"A", 
        	"B", 
        	'A', Block.tnt, 
        	'B', Item.minecartEmpty
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.minecartHopper, 1 ), new Object[] { 
        	"A", 
        	"B", 
        	'A', Block.hopperBlock, 
        	'B', Item.minecartEmpty
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Block.chestTrapped ), new Object[] {
        	"#-", 
        	'#', Block.chest, 
        	'-', Block.tripWireSource
    	} );

        // remove diamond tool & armor recipes
        
		RemoveVanillaRecipe( new ItemStack( Item.helmetDiamond ), new Object[] {
			"XXX", 
			"X X", 
			'X', Item.diamond
		} ); 
	   
		RemoveVanillaRecipe( new ItemStack( Item.plateDiamond ), new Object[] {
			"X X", 
			"XXX", 
			"XXX", 
			'X', Item.diamond
		} );
	   
		RemoveVanillaRecipe( new ItemStack( Item.legsDiamond ), new Object[] {
			"XXX", 
			"X X", 
			"X X", 
			'X', Item.diamond
		} );
	   
		RemoveVanillaRecipe( new ItemStack( Item.bootsDiamond ), new Object[] {
			"X X", 
			"X X", 
			'X', Item.diamond
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.swordDiamond ), new Object[] {
			"X", 
			"X", 
			"#",
			'#', Item.stick,
			'X', Item.diamond
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.pickaxeDiamond ), new Object[] {
			"XXX", 
			" # ", 
			" # ",
			'#', Item.stick,
			'X', Item.diamond			
		} ); 
		
		RemoveVanillaRecipe( new ItemStack( Item.shovelDiamond ), new Object[] {
			"X", 
			"#", 
			"#",
			'#', Item.stick,
			'X', Item.diamond			
		} ); 
		
		RemoveVanillaRecipe( new ItemStack( Item.hoeDiamond ), new Object[] {
			"XX", 
			" #", 
			" #",
			'#', Item.stick,
			'X', Item.diamond			
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.fishingRod, 1 ), new Object[] {
			"  #", 
			" #X", 
			"# X", 
			'#', Item.stick, 
			'X', Item.silk
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.cloth, 1 ), new Object[] {
			"##", 
			"##", 
			'#', Item.silk 
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.planks, 4, 0 ), new Object[] {
			"#", 
			'#', new ItemStack( Block.wood, 1, 0 )
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.planks, 4, 1 ), new Object[] {
			"#", 
			'#', new ItemStack( Block.wood, 1, 1 )
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.planks, 4, 2 ), new Object[] {
			"#", 
			'#', new ItemStack( Block.wood, 1, 2 ) 
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.planks, 4, 3 ), new Object[] {
			"#", 
			'#', new ItemStack( Block.wood, 1, 3 )
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.lever, 1 ), new Object[] {
			"X", 
			"#", 
			'#', Block.cobblestone, 
			'X', Item.stick } );
        
		RemoveVanillaRecipe( new ItemStack( Item.doorIron, 1 ), new Object[] {
			"##", 
			"##", 
			"##", 
			'#', Item.ingotIron
		} );
        
		RemoveVanillaRecipe( new ItemStack( Block.tripWireSource, 2 ), new Object[] {
			"I", 
			"S", 
			"#", 
			'#', Block.planks, 
			'S', Item.stick, 
			'I', Item.ingotIron 
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.dispenser, 1 ), new Object[] {
			"###", 
			"#X#", 
			"#R#", 
			'#', Block.cobblestone, 
			'X', Item.bow, 
			'R', Item.redstone
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.music, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Block.planks, 
			'X', Item.redstone
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.enchantmentTable, 1 ), new Object[] {
			" B ", 
			"D#D", 
			"###", 
			'#', Block.obsidian, 
			'B', Item.book, 
			'D', Item.diamond 
		} );
        
        RemoveVanillaRecipe( new ItemStack( Item.swordWood ), new Object[] {
        	"X", 
        	"X", 
        	"#", 
        	'#', Item.stick, 
        	'X', Block.planks
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.axeWood ), new Object[] {
        	"XX", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Block.planks
    	} );        
        
        RemoveVanillaRecipe( new ItemStack( Item.pickaxeWood ), new Object[] {
        	"XXX", 
        	" # ", 
        	" # ",         	
        	'#', Item.stick, 
        	'X', Block.planks
    	} );        
        
        RemoveVanillaRecipe( new ItemStack( Item.shovelWood ), new Object[] {
            "X", 
            "#", 
            "#",
        	'#', Item.stick, 
        	'X', Block.planks
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.hoeWood ), new Object[] {
            "XX", 
            " #", 
            " #",
        	'#', Item.stick, 
        	'X', Block.planks
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.swordStone ), new Object[] {
        	"X", 
        	"X", 
        	"#", 
        	'#', Item.stick, 
        	'X', Block.cobblestone
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.axeStone ), new Object[] {
        	"XX", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Block.cobblestone
    	} );        
        
        RemoveVanillaRecipe( new ItemStack( Item.pickaxeStone ), new Object[] {
        	"XXX", 
        	" # ", 
        	" # ",         	
        	'#', Item.stick, 
        	'X', Block.cobblestone 
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.shovelStone ), new Object[] {
            "X", 
            "#", 
            "#",
        	'#', Item.stick, 
        	'X', Block.cobblestone 
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.hoeStone ), new Object[] {
            "XX", 
            " #", 
            " #",
        	'#', Item.stick, 
        	'X', Block.cobblestone
    	} );
        
        RemoveVanillaRecipe( new ItemStack( Item.axeIron ), new Object[] {
        	"XX", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Item.ingotIron
    	} );        
        
		RemoveVanillaRecipe( new ItemStack( Item.hoeIron ), new Object[] {
			"XX", 
			" #", 
			" #",
			'#', Item.stick,
			'X', Item.ingotIron			
		} );
		
        RemoveVanillaRecipe( new ItemStack( Item.axeGold ), new Object[] {
        	"XX", 
        	"X#", 
        	" #",
        	'#', Item.stick, 
        	'X', Item.ingotGold
    	} );        
        
		RemoveVanillaRecipe( new ItemStack( Item.hoeGold ), new Object[] {
			"XX", 
			" #", 
			" #",
			'#', Item.stick,
			'X', Item.ingotGold			
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.axeDiamond ), new Object[] {
			"XX", 
			"X#", 
			" #", 
			'#', Item.stick,
			'X', Item.diamond			
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.arrow, 4 ), new Object[] {
			"X", 
			"#", 
			"Y", 
			'Y', Item.feather, 
			'X', Item.flint, 
			'#', Item.stick
		} );		
        
		RemoveVanillaRecipe( new ItemStack( Block.pistonBase, 1 ), new Object[] {
			"TTT", 
			"#X#", 
			"#R#", 
			'#', Block.cobblestone, 
			'X', Item.ingotIron, 
			'R', Item.redstone, 
			'T', Block.planks
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.brewingStand, 1 ), new Object[] {
			" B ", 
			"###", 
			'#', Block.cobblestone, 
			'B', Item.blazeRod
		} );
		
		RemoveVanillaRecipe( new ItemStack( Item.emptyMap, 1 ), new Object[] {
			"###", 
			"#X#", 
			"###", 
			'#', Item.paper, 
			'X', Item.compass
		} );
        
		RemoveVanillaShapelessRecipe( new ItemStack( Item.eyeOfEnder, 1 ), new Object[] {
			Item.enderPearl, 
			Item.blazePowder
		} );
        
		RemoveVanillaRecipe( new ItemStack( Item.bed, 1 ), new Object[] {
			"###", 
			"XXX", 
			'#', Block.cloth, 
			'X', Block.planks
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.fence, 2 ), new Object[] {
			"###", 
			"###", 
			'#', Item.stick
		} );

		RemoveVanillaRecipe( new ItemStack( Block.trapdoor, 2 ), new Object[] {
			"###", 
			"###", 
			'#', Block.planks
		} );		

		RemoveVanillaRecipe( new ItemStack( Block.pumpkinLantern, 1 ), new Object[] {
			"A", 
			"B", 
			'A', Block.pumpkin, 'B', Block.torchWood 
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.blockClay, 1 ), new Object[] {
			"##", 
			"##", 
			'#', Item.clay
		} );

		RemoveVanillaRecipe( new ItemStack( Block.brick, 1 ), new Object[] {
			"##", 
			"##", 
			'#', Item.brick
		} );
        
		RemoveVanillaRecipe( new ItemStack( Block.ladder, 3 ), new Object[] {
			"# #", 
			"###", 
			"# #", 
			'#', Item.stick
		} );

		RemoveVanillaRecipe( new ItemStack( Block.furnaceIdle ), new Object[] {
			"###", 
			"# #", 
			"###", 
			'#', Block.cobblestone
		} );

		RemoveVanillaRecipe( new ItemStack( Block.sandStone ), new Object[] {
			"##", 
			"##", 
			'#', Block.sand
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.blockSnow, 1 ), new Object[] {
			"##", 
			"##", 
			'#', Item.snowball
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.stairsWoodOak, 4 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 0)
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.stairsWoodBirch, 4 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 2)
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.stairsWoodSpruce, 4 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 1)
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.stairsWoodJungle, 4 ), new Object[] {
			"#  ", 
			"## ", 
			"###", 
			'#', new ItemStack(Block.planks, 1, 3)
		} );
		
		RemoveVanillaRecipe( new ItemStack( Block.workbench ), new Object[] {
			"##", 
			"##", 
			'#', Block.planks 
		} );		

		RemoveVanillaRecipe( new ItemStack( Block.chest ), new Object[] {
			"###", 
			"# #", 
			"###", 
			'#', Block.planks
		} );
		
		RemoveVanillaShapelessRecipe( new ItemStack( Item.book, 1 ), new Object[] {
			Item.paper, 
			Item.paper, 
			Item.paper, 
			Item.leather
		} );		
		
		RemoveVanillaRecipe( new ItemStack( Block.stoneBrick, 4 ), new Object[] {
			"##", 
			"##", 
			'#', Block.stone 
		} );
		
		// remove smelting. Must remove before adding replacement recipes as only one recipe can be associated with an itemID
		
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreIron.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreGold.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreDiamond.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.sand.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.cobblestone.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Item.clay.itemID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.wood.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreEmerald.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.netherrack.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreCoal.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreRedstone.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreLapis.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.oreNetherQuartz.blockID );
		FurnaceRecipes.smelting().getSmeltingList().remove( Block.glass.blockID );
	}
	
	private static void AddDebugRecipes()
    {
		// Debug Recipes (disable for release)

		/*
		AddVanillaRecipe( new ItemStack( Block.glass, 60, 0 ), new Object[] {
			"#",
			Character.valueOf( '#' ), Block.dirt 
		} );
		*/
    }	
}