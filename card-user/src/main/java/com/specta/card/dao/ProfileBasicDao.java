package com.specta.card.dao;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.specta.card.model.ProfileBasicModel;
import com.specta.card.model.User;

@Transactional
@Repository
public class ProfileBasicDao implements IProfileBasicDao {

	@Autowired
	private EntityManager entitymanager;

	@Autowired
	private HttpSession session;

	@Autowired
	ServletContext servletContext;

	@Override
	public boolean existUserByUserId(int userId) {
		String hql = "FROM ProfileBasicModel as up WHERE up.profile_user_id = ? ";
		System.out.println("HQL ::: " + hql);
		int count = entitymanager.createQuery(hql).setParameter(0, userId).getResultList().size();
		return count > 0 ? true : false;
	}

	/*
	 * public String getCartId() { User results = null; String uname = (String)
	 * session.getAttribute("uname"); TypedQuery<User> qry =
	 * entitymanager.createQuery("FROM User as u where u.userName = '" + uname +
	 * "'", User.class); results = qry.getSingleResult(); return
	 * results.getCardId(); }
	 */

	public String checkCardId(String shareId) {
		String hql = "FROM ProfileBasicModel as bm WHERE bm.shareId = ? ";
		int count = entitymanager.createQuery(hql).setParameter(0, shareId).getResultList().size();
		if (count > 0) {// if alredy generate list Generate again
			RandomString gen1 = new RandomString(8, ThreadLocalRandom.current());
			shareId = String.valueOf(gen1);
			return checkCardId(shareId);
		} else {
			return shareId;
		}
	}

	@Override
	public void addBasicInfo(ProfileBasicModel profileBasicModel) {

		int uid = (int) session.getAttribute("uid"); // set in user dao if success login
		String uCardId = (String) session.getAttribute("ucardid");

		boolean userExist = existUserByUserId(uid);

		if (userExist) {
			System.out.println("::: USER EXIST :::");
		} else {
			DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			
			// shareId Generate
			RandomString gen = new RandomString(8, ThreadLocalRandom.current());
			String shareId = String.valueOf(gen);

			profileBasicModel.setCard_id(uCardId);
			profileBasicModel.setShareId(checkCardId(shareId));
			profileBasicModel.setProfile_user_id(uid);
			profileBasicModel.setCreated_at(dateformate.format(date));
			profileBasicModel.setUser_pic("assets/images/photo.png");

			profileBasicModel.setFirst_name("");
			profileBasicModel.setLast_name("");
			profileBasicModel.setMobile("");
			profileBasicModel.setEmail("");
			profileBasicModel.setWeb("");
			profileBasicModel.setBirthday("");
			profileBasicModel.setGender("");
			profileBasicModel.setProfession("");
			profileBasicModel.setHome_address("");
			profileBasicModel.setWork_address("");
			profileBasicModel.setUpdate_at("");

			System.out.println("\n\nprofileBasicModel : " + profileBasicModel);
			System.out.println("\n\n");
			 entitymanager.persist(profileBasicModel);
		}

	}

	@Override
	public ProfileBasicModel getUserByUserId(int userId) {
		System.out.println("\nUser DAO ID IS ::: " + userId);

		return entitymanager.find(ProfileBasicModel.class, userId);

	}

	@Override
	public ProfileBasicModel updateBasicInfo(ProfileBasicModel profileBasicModel, MultipartFile file) {

		int uid = (int) session.getAttribute("uid");
		ProfileBasicModel user = getUserByUserId(uid);

		String userPic = ImageUpload(file);

		userPic = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/images/users/profile/" + uid + "/" + uid + ".jpg").toUriString();
		System.out.println(":::" + userPic + "");
		user.setUser_pic(userPic);

		System.out.println("\nUser Update ID IS ::: " + user.getId());
		System.out.println("\nUser Update USER ID IS ::: " + user.getProfile_user_id());

		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		user.setFirst_name(profileBasicModel.getFirst_name());
		user.setLast_name(profileBasicModel.getLast_name());
		user.setBirthday(profileBasicModel.getBirthday());
		user.setGender(profileBasicModel.getGender());

		user.setUpdate_at(dateformate.format(date));

		System.out.println("first name : " + user.getFirst_name());
		System.out.println("Last Name : " + user.getLast_name());
		System.out.println("B-day : " + user.getBirthday());
		System.out.println("Gender : " + user.getGender());
		System.out.println("user pic : " + user.getUser_pic());

		entitymanager.flush();

		return user;
	}

	@Override
	public ProfileBasicModel updateContactInfo(ProfileBasicModel profileBasicmodel) {

		int uid = (int) session.getAttribute("uid");
		ProfileBasicModel user = getUserByUserId(uid);

		System.out.println("\nUser Update USER ID IS ::: " + user.getProfile_user_id());

		DateFormat dateformate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();

		user.setHome_address(profileBasicmodel.getHome_address());
		user.setState(profileBasicmodel.getState());
		user.setCountry(profileBasicmodel.getCountry());
		user.setCity(profileBasicmodel.getCity());
		user.setMobile(profileBasicmodel.getMobile());
		user.setEmail(profileBasicmodel.getEmail());
		user.setWeb(profileBasicmodel.getWeb());

		user.setUpdate_at(dateformate.format(date));

		System.out.println("address : " + user.getHome_address());
		System.out.println("state : " + user.getState());
		System.out.println("country : " + user.getCountry());
		System.out.println("city : " + user.getCity());
		System.out.println("user contact : " + user.getMobile());
		System.out.println("user email : " + user.getEmail());
		System.out.println("user web : " + user.getWeb());

		entitymanager.flush();

		return user;
	}

	@Override
	public void deleteBasicInfo(Integer userid) {

	}

	@Override
	public ProfileBasicModel getBasicInfo(int userId) {

		return entitymanager.find(ProfileBasicModel.class, userId);
	}

	public String ImageUpload(MultipartFile file) {

		// String UPLOAD_FOLDER = "C:/test/user/profile/";
		int uid = (int) session.getAttribute("uid");

		String UPLOAD_FOLDER = servletContext.getRealPath("/images/users/profile/" + uid + "/");

		// for directory create
		File destinationPath = new File(UPLOAD_FOLDER);
		if (!destinationPath.exists()) {

			if (destinationPath.mkdirs()) {
				System.out.println("Directory is created!");
			} else {
				System.out.println("Failed to create directory!");
			}
		} // directory create end

		try {

			if (!file.isEmpty()) {

				// file write
				byte[] bytes = file.getBytes();
				Path path = Paths.get(UPLOAD_FOLDER + uid + ".jpg");
				Files.write(path, bytes); // file write end
				System.out.println("Image is stored at " + path);

			}
		} catch (Exception e) {
			System.out.println("Exception occured : " + e.getMessage());
		}
		return UPLOAD_FOLDER + uid + ".jpg";
	}

}
