package com.specta.card.services;

import java.util.List;

import com.specta.card.model.ProfileDownloadModel;

public interface IProfileDownloadService {

	public List<ProfileDownloadModel> getAllDownload();

	public List<ProfileDownloadModel> getAllDownloadByUserId(int userId);

	ProfileDownloadModel getDownloadById(int downloadId);

	boolean addDownload(ProfileDownloadModel download);

	void updateDownload(ProfileDownloadModel download);

	public void deleteDownload(int downloadId);

}
