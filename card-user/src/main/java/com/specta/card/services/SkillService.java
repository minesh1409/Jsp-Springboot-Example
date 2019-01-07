package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.ISkillDao;
import com.specta.card.model.SkillModel;

@Service
public class SkillService  implements ISkillServices {

	@Autowired
	ISkillDao iSkillDao;

	@Override
	public List<SkillModel> getAllSkill() {
		return iSkillDao.getAllSkill();
	}

	@Override
	public SkillModel getSkillById(int skillId) {
		return iSkillDao.getSkillById(skillId);
	}

	@Override
	public boolean addSkill(SkillModel skill) {
		iSkillDao.addSkill(skill);
		return true;
	}

	@Override
	public void updateSkill(SkillModel skill) {
		iSkillDao.updateSkill(skill);
	}

	@Override
	public void deleteSkill(int skillId) {
		iSkillDao.deleteSkill(skillId);		
	}
	
	
	
}
