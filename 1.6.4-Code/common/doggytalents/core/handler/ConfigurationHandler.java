package doggytalents.core.handler;

import doggytalents.lib.BlockIds;
import doggytalents.lib.Constants;
import doggytalents.lib.ItemIds;
import net.minecraftforge.common.Configuration;

/**
 * @author ProPercivalalb
 */
public class ConfigurationHandler {

	public static Configuration configuration;
	
	public static void loadConfig(Configuration config) {
		config.load();
		configuration = config;
		
		ItemIds.ID_DOG_OWNERS_MANUEL = config.getItem("dogOwnersManuel", 12550).getInt(12550);
		ItemIds.ID_THROW_BONE = config.getItem("throwBone", 12551).getInt(12551);
		ItemIds.ID_COMMAND_EMBLEM = config.getItem("commandEmblem", 12552).getInt(12552);
		ItemIds.ID_TRAINING_TREAT = config.getItem("trainingTreat", 12553).getInt(12553);
		ItemIds.ID_SUPER_TREAT = config.getItem("superTreat", 12554).getInt(12554);
		ItemIds.ID_MASTER_TREAT = config.getItem("masterTreat", 12555).getInt(12555);
		ItemIds.ID_DIRE_TREAT = config.getItem("direTreat", 12556).getInt(12556);
		ItemIds.ID_BREEDING_BONE = config.getItem("breedingBone", 12557).getInt(12557);
		ItemIds.ID_COLLAR_SHEARS = config.getItem("collarShears", 12558).getInt(12558);
		ItemIds.ID_DOGGY_CHARM = config.getItem("doggyCharm", 12559).getInt(12559);
		
		BlockIds.ID_DOG_BED = config.getBlock("dogBed", 3550).getInt(3550);
		BlockIds.ID_DOG_BOWL = config.getBlock("bogBowl", 3551).getInt(3551);
		
		config.addCustomCategoryComment("doggySettings", "Here you can change details about your dog.");
		Constants.allowPermaDeath = config.get("doggySettings", "allowPermaDeath", false, "If set to false it means you dog can never die and will be in incpasitated mode. If set to true you dogs will die one there health = 0.").getBoolean(false);
		Constants.tenDayPuppies = config.get("doggySettings", "tenDayPuppies", true, "Do you pups take 10 days the grow.").getBoolean(true);
		Constants.isHungerOn = config.get("doggySettings", "isHungerOn", true).getBoolean(true);
		Constants.barkRate = config.get("doggySettings", "barkRate", 10, "Default is 10, higher the number the slow the dogs bark. Lower the number the faster the dogs bark.").getInt(10);
		Constants.direParticalsOff = config.get("doggySettings", "direParticalsOff", false, "When false there will be portal particles if your dog is dire level 30, otherwise no dire particals.").getBoolean(false);
		Constants.isStartingItemEnabled = config.get("doggySettings", "isStartingItemsEnabled", true, "When enabled you will spawn with a guide, Doggy Charm and Command Emblem.").getBoolean(true);
		Constants.bloodWhenIncapacitated = config.get("doggySettings", "bloodWhenIncapacitated", true, "If true then a dog is Incapacitated they will have blood on them").getBoolean(true);
		
		config.save();
	 }
}
