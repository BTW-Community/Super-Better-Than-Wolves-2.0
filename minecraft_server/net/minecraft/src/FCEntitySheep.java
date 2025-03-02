// FCMOD

package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class FCEntitySheep extends EntitySheep
{
    private static final int m_iFullWoolAccumulationCount = FCUtilsMisc.m_iTicksPerGameDay;
    
    private int m_iOriginalFleeceColor = 0;
    private int m_iWoolAccumulationCount = 0;
    
    public FCEntitySheep( World world )
    {
        super( world );
        
        tasks.RemoveAllTasks();
        
        tasks.addTask( 0, new EntityAISwimming( this ) );
        tasks.addTask( 1, new FCEntityAIAnimalFlee( this, 0.38F ) );
        tasks.addTask( 2, new EntityAIMate( this, 0.23F ) );
        tasks.addTask( 3, new FCEntityAIMultiTempt( this, 0.25F ) );
        tasks.addTask( 4, new FCEntityAIGraze( this ) );        
        tasks.addTask( 5, new FCEntityAIMoveToLooseFood( this, 0.23F ) );
        tasks.addTask( 6, new FCEntityAIMoveToGraze( this, 0.23F ) );
        tasks.addTask( 7, new EntityAIFollowParent( this, 0.25F ) );
        tasks.addTask( 8, new FCEntityAIWanderSimple( this, 0.25F ) );
        tasks.addTask( 9, new EntityAIWatchClosest( this, EntityPlayer.class, 6F ) );
        tasks.addTask( 10, new EntityAILookIdle( this ) );
    }
    
    @Override
    public boolean isAIEnabled()
    {
    	return !getWearingBreedingHarness();
    }

    @Override
    protected void dropFewItems( boolean bKilledByPlayer, int iLootingModifier )
    {
        if ( !getSheared() && IsFullyFed() )
        {
            entityDropItem( new ItemStack( FCBetterThanWolves.fcItemWool.itemID, 1, 
            	BlockCloth.getDyeFromBlock( getFleeceColor() ) ), 0.0F);
        }
        
        DropMutton( iLootingModifier );
    }
    
    @Override
    public boolean interact( EntityPlayer player )
    {
        ItemStack stack = player.inventory.getCurrentItem();

        if ( stack != null && stack.itemID == Item.shears.itemID && !getSheared() && !isChild() )
        {
            if ( !worldObj.isRemote )
            {
                setSheared( true );
                
                int iNumItems = 1 + rand.nextInt( 3 );

                for ( int iTempCount = 0; iTempCount < iNumItems; ++iTempCount )
                {
                    EntityItem tempItem = entityDropItem( new ItemStack( 
                    	FCBetterThanWolves.fcItemWool.itemID, 1, 
                    	BlockCloth.getDyeFromBlock( getFleeceColor() ) ), 1.0F);
                    
                    tempItem.motionY += rand.nextFloat() * 0.05F;
                    tempItem.motionX += ( rand.nextFloat() - rand.nextFloat() ) * 0.1F;
                    tempItem.motionZ += ( rand.nextFloat() - rand.nextFloat() ) * 0.1F;
                }
            }

            stack.damageItem( 1, player );
            
            playSound( "mob.sheep.shear", 1F, 1F );
            
            attackEntityFrom( DamageSource.generic, 0 );
            
            if ( stack.stackSize <= 0 )
            {
            	player.inventory.mainInventory[player.inventory.currentItem] = null;
            }
        }

        return EntityAnimalInteract( player ); // skip super function
    }
    
    @Override
    protected int getDropItemId()
    {
        return FCBetterThanWolves.fcItemWool.itemID;
    }
    
    @Override
    public void writeEntityToNBT( NBTTagCompound tag )
    {
        super.writeEntityToNBT( tag );
        
        tag.setByte( "fcOrgClr", (byte)m_iOriginalFleeceColor );
        tag.setInteger( "fcWoolCount", m_iWoolAccumulationCount ); 
    }

    @Override
    public void readEntityFromNBT( NBTTagCompound tag )
    {
        super.readEntityFromNBT( tag );
        
        if ( tag.hasKey( "fcOrgClr" ) )
        {
        	m_iOriginalFleeceColor = tag.getByte( "fcOrgClr" );
        }
        
        if ( tag.hasKey( "fcWoolCount" ) )
    	{
        	m_iWoolAccumulationCount = tag.getInteger( "fcWoolCount" );
    	}
    }

    @Override
    protected boolean GetCanCreatureTypeBePossessed()
    {
    	return true;
    }
    
    @Override
    protected void ModSpecificOnLivingUpdate()
    {
    	super.ModSpecificOnLivingUpdate();
    	
    	if ( !isLivingDead && IsFullyPossessed() && !getSheared() )
    	{
    		if ( !isInWater() && ! handleLavaMovement() )
    		{
    			if ( this.posY < 125F )
    			{
					this.motionY += 0.08341D; // gravity is 0.08
    			}
    			else
    			{
    				motionY += 0.0725D;
    			}
    			
    			if ( !onGround && !isCollidedHorizontally && worldObj.provider.dimensionId == 0 )
    			{
	    			if ( posY > 100F )
	    			{
	    				if ( !CheckForWolfBomb() )
	    				{
		    				// drift with the clouds
		    				
		    				if ( !getSheared() && motionX > -0.012F )
		    				{
		    					motionX -= 0.005;
		    				}
	    				}
	    			}
    			}
    		}
    	}
    }

    @Override
    protected void fall(float par1)
    {
    	// override to prevent fall damage on possessed sheep
    	
    	if ( !IsFullyPossessed() || getSheared() )
    	{
    		super.fall( par1 );    	
		}
    }
    
    @Override
    public double getMountedYOffset()
    {
		return (double)height;
    }
    
    @Override
    public boolean isBreedingItem( ItemStack stack )
    {
        return stack.itemID == Item.pumpkinPie.itemID;
    }

    @Override
    public boolean IsValidZombieSecondaryTarget( EntityZombie zombie )
    {
    	return true;
    }
    
    @Override
    public void initCreature()
    {
    	InitHungerWithVariance();
    	
    	int iFleeceColor = getRandomFleeceColor( worldObj.rand );
    	
        if ( iFleeceColor == 0 )
        {
        	int iDiceRoll = worldObj.rand.nextInt( 500 );
        	
	        if ( iDiceRoll == 0 )
	        {
	        	iFleeceColor = 3; // light blue
	        }
	        else if ( iDiceRoll == 1 )
	        {
	        	iFleeceColor = 5; // lime green
	        }
        }
        
        setFleeceColor( iFleeceColor );
    }

    @Override
    public void setFleeceColor( int iColor )
    {
    	super.setFleeceColor( iColor );
    	
        m_iOriginalFleeceColor = iColor;
    }

    @Override
    public EntityAgeable createChild( EntityAgeable parent )
    {
		return SpawnHardcoreBaby( parent );
    }

    @Override
    public boolean IsSubjectToHunger()
    {
    	return true;
    }
    
    @Override
    protected int GetFoodValueMultiplier()
    {
    	return 3;
    }
    
    @Override
    public void OnBecomeFamished()
    {
    	super.OnBecomeFamished();
    	
    	if ( !getSheared() )
    	{
        	setSheared( true );
    	}
    	
    	m_iWoolAccumulationCount = 0;
    }
    
    @Override
    protected void UpdateHungerState()
    {
		if ( getSheared() && IsFullyFed() && !isChild() && !getWearingBreedingHarness() )
		{
			// producing wool consumes extra food. Hunger will be validated in super method
			
			m_iHungerCountdown--;
			
        	m_iWoolAccumulationCount++;
        	
        	if ( m_iWoolAccumulationCount >= m_iFullWoolAccumulationCount )
        	{
        		setFleeceColor( m_iOriginalFleeceColor );
	    	
	        	setSheared( false );	        	
	        	m_iWoolAccumulationCount = 0;
	        	
		        worldObj.playAuxSFX( FCBetterThanWolves.m_iSheepWoolRegrowAuxFXID, 
		        	MathHelper.floor_double( posX ), (int)posY + 1, 
		        	MathHelper.floor_double( posZ ), 0 );
        	}
		}
        
    	// must call super method after extra hunger consumed above to validate
    	
    	super.UpdateHungerState();
    }
    
	//------------- Class Specific Methods ------------//
    
    public void setSuperficialFleeceColor(int par1)
    {
        byte byte0 = dataWatcher.getWatchableObjectByte(16);
        dataWatcher.updateObject(16, Byte.valueOf((byte)(byte0 & 0xf0 | par1 & 0xf)));
    }

    public FCEntitySheep SpawnHardcoreBaby( EntityAgeable parentAnimal )
    {
        FCEntitySheep parentSheep = (FCEntitySheep)parentAnimal;
        FCEntitySheep babySheep = new FCEntitySheep(this.worldObj);

		int iMutationChance = rand.nextInt( 100 );
		
		if ( iMutationChance == 0  )
		{
			// outright mutation
			
			int iBabyColor = getMutantColor( this, parentSheep );
			
			babySheep.setFleeceColor( iBabyColor );			
		}
		else if ( iMutationChance <= 3  )
		{			
			// The proverbial black sheep
			
			int iBabyColor = 15;  
			
			babySheep.setFleeceColor( iBabyColor );			
		}
		else if ( iMutationChance <= 23  )
		{
			// blend the colors of the adults
			
			int iBabyColor = blendParentColors( this, parentSheep );
			
			babySheep.setFleeceColor( iBabyColor );
			
		}		
		else if (this.rand.nextBoolean())
        {
    		babySheep.setFleeceColor( m_iOriginalFleeceColor );
        }
        else
        {
    		babySheep.setFleeceColor( parentSheep.m_iOriginalFleeceColor );
        }

        return babySheep;
    }
    
    public int blendParentColors( FCEntitySheep papa, FCEntitySheep mama )
    {
    	int iPapaItemColor = BlockCloth.getBlockFromDye( papa.m_iOriginalFleeceColor );  
    	int iMamaItemColor = BlockCloth.getBlockFromDye( mama.m_iOriginalFleeceColor );
    	int iBlendedItemColor = iPapaItemColor;
    	
        switch ( iPapaItemColor )
        {
	    	case 0: // black
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 7: // silver
	    	    		
	    	    		iBlendedItemColor = 8;
	    	    		
	    	    		break;
	    	    		
	    	    	case 9: // pink
	    	    		
	    	    		iBlendedItemColor = 1;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 10: // lime
	    	    		
	    	    		iBlendedItemColor = 2;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 12: // light blue
	    	    		
	    	    		iBlendedItemColor = 4;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 13: // magenta
	    	    		
	    	    		iBlendedItemColor = 5;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 7;	    	    		
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 1: // red
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 2: // green
	    	    		
	    	    		iBlendedItemColor = 11;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 3: // brown
	    	    		
	    	    		iBlendedItemColor = 14;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 4: // blue
	    	    		
	    	    		iBlendedItemColor = 5;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 6: // cyan
	    	    		
	    	    		iBlendedItemColor = 3;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 11: // yellow
	    	    		
	    	    		iBlendedItemColor = 14;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 12: // light blue
	    	    		
	    	    		iBlendedItemColor = 13;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 9;	    	    		
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 2: // green
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 11;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 4: // blue
	    	    		
	    	    		iBlendedItemColor = 6;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 14: // orange
	    	    		
	    	    		iBlendedItemColor = 11;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 10;	    	    		
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 3: // brown
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 14;
	    	    		
	    	    		break;	    	    		
	    		}
	    		
	    		break;
	    		
	    	case 4: // blue
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 5;
	    	    		
	    	    		break;
	    	    		
	    	    	case 2: // green
	    	    		
	    	    		iBlendedItemColor = 6;
	    	    		
	    	    		break;
	    	    		
	    	    	case 9: // pink
	    	    		
	    	    		iBlendedItemColor = 13;
	    	    		
	    	    		break;
	    	    		
	    	    	case 11: // yellow
	    	    		
	    	    		iBlendedItemColor = 2;
	    	    		
	    	    		break;
	    	    		
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 12;
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 5: // purple
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 13;
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 6: // cyan
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 3;
	    	    		
	    	    		break;
	    		}
	    	    		
	    		break;
	    		
	    	case 7: // silver
	    		
	    		switch ( iMamaItemColor )
	    		{
		    		case 0: // black
	    	    		
	    	    		iBlendedItemColor = 8;
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 8: // gray
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 15: // white
	    	    		
	    	    		iBlendedItemColor = 7;
	    	    		
	    	    		break;    		
	    		}
	    		
	    		break;
	    		
	    	case 9: // pink
	    		
	    		switch ( iMamaItemColor )
	    		{
		    		case 0: // black
	    	    		
	    	    		iBlendedItemColor = 1;
	    	    		
	    	    		break;
	    	    		
			    	case 4: // blue
			    		
	    	    		iBlendedItemColor = 13;
	    	    		
	    	    		break;
	    	    		
	    		}
	    		
	    		break;
	    		
	    	case 10: // lime
	    		
	    		switch ( iMamaItemColor )
	    		{
		    		case 0: // black
	    	    		
	    	    		iBlendedItemColor = 2;
	    	    		
	    	    		break;
	    		}
	    	    		
	    		break;
	    		
	    	case 11: // yellow
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 14;
	    	    		
	    	    		break;
	    	    		
	    	    	case 4: // blue
	    	    		
	    	    		iBlendedItemColor = 2;
	    	    		
	    	    		break;
	    	    		
	    	    	case 12: // light blue
	    	    		
	    	    		iBlendedItemColor = 10;
	    	    		
	    	    		break;	    	    		
	    		}
	    		
	    		break;
	    		
	    	case 12: // light blue
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 0: // black
	    	    		
	    	    		iBlendedItemColor = 4;
	    	    		
	    	    		break;
	    	    		
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 13;
	    	    		
	    	    		break;
	    	    		
	    	    	case 9: // pink
	    	    		
	    	    		iBlendedItemColor = 13;
	    	    		
	    	    		break;
	    	    		
	    	    	case 11: // yellow
	    	    		
	    	    		iBlendedItemColor = 13;	    	    		
	    	    		
	    	    		break;	    	    		
	    		}
	    		
	    		break;
	    		
	    	case 13: // magenta
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 0: // black
	    	    		
	    	    		iBlendedItemColor = 5;	    	    		
	    	    		
	    	    		break;	    	    		
	    		}
	    		
	    		break;
	    		
	    	case 14: // orange
	    		
	    		break;
	    		
	    	case 15: // white
	    		
	    		switch ( iMamaItemColor )
	    		{
	    	    	case 0: // black
	    	    		
	    	    		iBlendedItemColor = 8;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 1: // red
	    	    		
	    	    		iBlendedItemColor = 9;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 2: // green
	    	    		
	    	    		iBlendedItemColor = 10;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 4: // blue
	    	    		
	    	    		iBlendedItemColor = 12;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 5: // purple
	    	    		
	    	    		iBlendedItemColor = 13;	    	    		
	    	    		
	    	    		break;
	    	    		
	    	    	case 8: // gray
	    	    		
	    	    		iBlendedItemColor = 7;	    	    		
	    	    		
	    	    		break;	    	    		
	    		}
	    		
	    		break;    		
        }

        if ( iBlendedItemColor == iPapaItemColor )
        {
        	if ( rand.nextBoolean() )
        	{
        		iBlendedItemColor = iMamaItemColor;
        	}
        }
        
    	return BlockCloth.getBlockFromDye( iBlendedItemColor );
    }
    
    public int getMutantColor( FCEntitySheep papa, FCEntitySheep mama )
    {
    	// spawn lightened shades of primary colors for use in cross-breeding
    	
    	int iRandomFactor = rand.nextInt( 3 );
    	
    	switch ( iRandomFactor )
    	{
    		case 0:
    			
    	        return 3; // light blue
    	        
    		case 1:
    			
    	        return 5; // lime green
    	        
	        default: // 2
    			
	            return 6; // pink
    	}    	
    }
    
    private void DropMutton( int iLootingModifier )
    {
        if ( !HasHeadCrabbedSquid() && !IsStarving() )
        {
        	//AARON CHANGED to always drop 2 mutton
	        int iNumDropped = 2 + rand.nextInt( 1 + iLootingModifier );
	
	        if ( IsFamished() )
	        {
	        	iNumDropped = iNumDropped / 2;
	        }
	        
	        for ( int iTempCount = 0; iTempCount < iNumDropped; ++iTempCount )
	        {
	            if ( isBurning() )
	            {
	                dropItem( FCBetterThanWolves.fcItemMeatBurned.itemID, 1 );
	            }
	            else
	            {
	                dropItem( FCBetterThanWolves.fcItemMuttonRaw.itemID, 1 );
	            }
	        }
        }
    }
    
    private boolean CheckForWolfBomb()
    {
		if ( !worldObj.isRemote && worldObj.worldInfo.getWorldTime() % 20 == 0 )
		{
			int iSheepI = MathHelper.floor_double( posX );
			int iSheepJ = MathHelper.floor_double( posY );
			int iSheepK = MathHelper.floor_double( posZ );
			
		    // Despite name, actually returns the block ABOVE the top one, and does not count liquids
			int iTopBlockJ = worldObj.getPrecipitationHeight( iSheepI, iSheepK ) - 1;
			
			// ensure sufficient drop onto hard surface to kill the sheep
			if ( iSheepJ - iTopBlockJ >= 16 )
			{
	            int iTopBlockID = worldObj.getBlockId( iSheepI, iTopBlockJ, iSheepK );
	            
            	Block topBlock = Block.blocksList[iTopBlockID];
            	
            	if ( topBlock != null && !topBlock.blockMaterial.isLiquid() )
            	{            		
            		if ( IsPossessableWolfWithinRangeOfBlock( iSheepI, iTopBlockJ, iSheepK, 8 ) )
            		{
            			InitiateWolfBomb();
            			
            	        worldObj.playSoundAtEntity( this, getDeathSound(), getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F );
            	        worldObj.playSoundAtEntity( this, "mob.slime.attack", getSoundVolume(), ( rand.nextFloat() - rand.nextFloat()) * 0.2F + 0.6F );
            			
            			return true;
            		}
            	}
			}
		}
		
		return false;		
    }
    
    private boolean IsPossessableWolfWithinRangeOfBlock( int i, int j, int k, int iRange )
    {
		AxisAlignedBB possessionBox = AxisAlignedBB.getAABBPool().getAABB( 
			(double)( i - iRange ), (double)( j - iRange ), (double)( k - iRange ),
			(double)( i + 1 + iRange ), (double)( j + 1 + iRange ), (double)( k + 1 + iRange ) );
		
        List wolvesInBox = worldObj.getEntitiesWithinAABB( FCEntityWolf.class, possessionBox );
        
        Iterator itemIterator = wolvesInBox.iterator();
    	
        while ( itemIterator.hasNext())
        {
    		FCEntityWolf tempWolf = (FCEntityWolf)itemIterator.next();
    		
	        if ( !tempWolf.isLivingDead && !tempWolf.IsPossessed() )
	        {
        		return true;
	        }	        
        }
        
        return false;
    }
    
    private void InitiateWolfBomb()
    {
    	// eject the sheep's wool so it drops out of the sky
    	
        setSheared( true );
        
        int iItemCount = 1 + this.rand.nextInt(3);

        for ( int iTempCount = 0; iTempCount < iItemCount; ++iTempCount )
        {
            EntityItem tempStack = entityDropItem( new ItemStack( FCBetterThanWolves.fcItemWool.itemID, 1, 
            	BlockCloth.getDyeFromBlock( getFleeceColor() ) ), 1.0F );
            
            tempStack.motionY += rand.nextFloat() * 0.05F;
            tempStack.motionX += ( rand.nextFloat() - rand.nextFloat() ) * 0.1F;
            tempStack.motionZ += ( rand.nextFloat() - rand.nextFloat() ) * 0.1F;
        }
    }
    
    protected boolean IsTooHungryToProduceWool()
    {
    	return m_iHungerCountdown < ( m_iFullHungerCount * 3 ) / 4;    	
    }
    
	//----------- Client Side Functionality -----------//
    
//    @Override
//    public void handleHealthUpdate( byte bUpdateType )
//    {
//    	// must override super or else EntitySheep will intercept update type 10 and
//    	// set the wrong variable
//    	
//        if ( bUpdateType == 10 )
//        {
//        	m_iGrazeProgressCounter = GetGrazeDuration();
//        }
//        else
//        {
//            super.handleHealthUpdate( bUpdateType );
//        }
//    }
//    
//	@Override	
//    public String getTexture()
//    {
//    	if ( getWearingBreedingHarness() )
//    	{
//			return "/btwmodtex/fc_mr_sheep.png";
//    	}
//    	
//    	int iHungerLevel = GetHungerLevel();
//    	
//    	if ( iHungerLevel == 1 )
//    	{
//			return "/btwmodtex/fcSheepFamished.png";
//    	}
//    	else if ( iHungerLevel == 2 )
//    	{
//			return "/btwmodtex/fcSheepStarving.png";
//    	}
//
//        return super.getTexture();
//    }    
//	
//	@Override	
//    public float func_70894_j( float fPartialTick )
//    {
//		return GetGrazeHeadVerticalOffset( fPartialTick );
//    }
//    
//	@Override	
//    public float func_70890_k( float fPartialTick )
//    {
//		return GetGrazeHeadRotation( fPartialTick );
//    }
}
