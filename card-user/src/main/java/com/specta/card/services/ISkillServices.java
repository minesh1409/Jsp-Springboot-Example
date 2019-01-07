package com.specta.card.services;

import java.util.List;

import com.specta.card.model.SkillModel;

public interface ISkillServices {
	
	List<SkillModel> getAllSkill();
	
	SkillModel getSkillById(int skillId);
	
	boolean addSkill(SkillModel skill);
	
	void updateSkill(SkillModel skill);

	public void deleteSkill(int skillId);


}
