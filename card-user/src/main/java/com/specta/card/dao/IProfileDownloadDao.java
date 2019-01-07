package com.specta.card.dao;

import java.util.List;

import com.specta.card.model.ProfileDownloadModel;

public interface IProfileDownloadDao {

	public List<ProfileDownloadModel> getAllDownload();

	public List<ProfileDownloadModel> getAllDownloadByUserId(int userId);

	ProfileDownloadModel getDownloadById(int downloadId);

	void addDownload(ProfileDownloadModel download);

	void updateDownload(ProfileDownloadModel download);

	public void deleteDownload(int downloadId);

}
