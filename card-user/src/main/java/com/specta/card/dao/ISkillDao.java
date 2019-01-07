package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.SkillModel;

public interface ISkillDao {

	public List<SkillModel> getAllSkill();

	SkillModel getSkillById(int skillId);

	void addSkill(SkillModel skill);

	void updateSkill(SkillModel skill);

	public void deleteSkill(int skillId);

}
