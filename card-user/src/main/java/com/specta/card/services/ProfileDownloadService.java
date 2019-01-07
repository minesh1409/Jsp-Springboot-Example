package com.specta.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.specta.card.dao.IProfileDownloadDao;
import com.specta.card.model.ProfileDownloadModel;

@Service
public class ProfileDownloadService implements IProfileDownloadService {

	@Autowired
	IProfileDownloadDao iProfileDownloadDao;

	@Override
	public List<ProfileDownloadModel> getAllDownload() {
		return iProfileDownloadDao.getAllDownload();
	}

	@Override
	public List<ProfileDownloadModel> getAllDownloadByUserId(int userId) {
		return iProfileDownloadDao.getAllDownloadByUserId(userId);
	}

	@Override
	public ProfileDownloadModel getDownloadById(int downloadId) {
		return iProfileDownloadDao.getDownloadById(downloadId);
	}

	@Override
	public boolean addDownload(ProfileDownloadModel download) {
		iProfileDownloadDao.addDownload(download);
		return true;
	}

	@Override
	public void updateDownload(ProfileDownloadModel download) {
		iProfileDownloadDao.updateDownload(download);
	}

	@Override
	public void deleteDownload(int downloadId) {
		iProfileDownloadDao.deleteDownload(downloadId);
	}

}
