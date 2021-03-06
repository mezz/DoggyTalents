package doggytalents.tileentity;

import java.util.List;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import doggytalents.entity.EntityDTDoggy;
import doggytalents.network.packet.PacketDogBedUpdate;

/**
 * @author ProPercivalalb
 */
public class TileEntityDogBed extends TileEntity {

	private String woolId;
	private String woodId;
	
	public TileEntityDogBed() {
		this.woolId = "";
		this.woodId = "";
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		this.woolId = tag.getString("bedWoolId");
		this.woodId = tag.getString("bedWoodId");
    }

	@Override
    public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		tag.setString("bedWoolId", this.woolId);
		tag.setString("bedWoodId", this.woodId);
	}
	
	@Override
	public void updateEntity() {
		List dogsClose = this.worldObj.getEntitiesWithinAABB(EntityDTDoggy.class, AxisAlignedBB.getBoundingBox(this.xCoord, this.yCoord, this.zCoord, this.xCoord + 1.0D, this.yCoord + 1.0D, this.zCoord + 1.0D).expand(3D, 2D, 3D));
		 
	    if (dogsClose != null && dogsClose.size() > 0) {
	    	for (int index = 0; index < dogsClose.size(); index++) {
	            EntityDTDoggy dog = (EntityDTDoggy)dogsClose.get(index);
	            
	            if(dog.getMaxHealth() / 2 >= dog.getHealth()) {
	            	if(dog.bedHealTick <= 0) {
	            		dog.heal(0.5F);
	            		dog.bedHealTick = 20 * 20;
	            	}
	            	dog.bedHealTick--;
        		}
	        }
	    }

	}
	
	@Override
    public Packet getDescriptionPacket() {
        return new PacketDogBedUpdate(this.xCoord, this.yCoord, this.zCoord, this.woolId, this.woodId).getPacket();
    }
	
	public void setWoolId(String newId) {
		this.woolId = newId;
	}
	
	public void setWoodId(String newId) {
		this.woodId = newId;
	}
	
	public String getWoolId() {
		return this.woolId;
	}
	
	public String getWoodId() {
		return this.woodId;
	}
}
