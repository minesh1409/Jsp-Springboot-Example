package com.specta.card.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.specta.card.model.ProfileDownloadModel;

@Repository
@Transactional
public class ProfileDownloadDao implements IProfileDownloadDao {

	@Autowired
	private EntityManager entitymanager;
	
	@Autowired
	private HttpSession session;
	
	int uid;
	String gcardId;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileDownloadModel> getAllDownload() { 
		String hql= "FROM ProfileDownloadModel";
		return entitymanager.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProfileDownloadModel> getAllDownloadByUserId(int userId) {
		String hql = "FROM ProfileDownloadModel where userId="+userId ;
		return entitymanager.createQuery(hql).getResultList();
	}

	@Override
	public ProfileDownloadModel getDownloadById(int downloadId) {
		return entitymanager.find(ProfileDownloadModel.class, downloadId);
	}

	@Override
	public void addDownload(ProfileDownloadModel download) {
	
		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		uid = (int) session.getAttribute("gid");
		gcardId = (String) session.getAttribute("gcardid");
		
		download.setCardId(gcardId);
		download.setUserId(uid);
		download.setCreatedAt(dateformate.format(date));
		
		System.out.println("Download: "+download);
		
		entitymanager.persist(download);
	}

	@Override
	public void updateDownload(ProfileDownloadModel download) {
		
	}

	@Override
	public void deleteDownload(int downloadId) {
		ProfileDownloadModel profileDownloadModel =  getDownloadById(downloadId);
		entitymanager.remove(profileDownloadModel);
	}

}
