package com.profile.developer.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.profile.developer.bean.Admin;
import com.profile.developer.bean.User;
import com.profile.developer.service.AdminRepository;
import com.profile.developer.service.FileUploadHelper;
import com.profile.developer.service.UserInterface;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginApiController {

	@Autowired
	UserInterface userRepository;

	@Autowired
	FileUploadHelper fileUploadHelper;

	@Autowired
	AdminRepository adminRepository;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> showAllUsers() {
		return this.userRepository.findAll();
	}

	// login user by userName and DOB
	@RequestMapping(value = "/users/nameanddob/{userName}&{dateOfBirth}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByUserNmAndDob(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateOfBirth) {

		User user1 = new User();
		int count = 0;
		List<User> userList = (List<User>) userRepository.findByUserNameAndDateOfBirth(userName, dateOfBirth);
		for (User user : userList) {
			user1 = user;
			count++;
		}
		if (count >= 1) {
			return new ResponseEntity<User>(user1, HttpStatus.OK);
		}
		return new ResponseEntity<User>(user1, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * @RequestMapping(value="/users", method = RequestMethod.GET) public List<User>
	 * featchcarrierobjectve(String userNm, Date dob){ User user = new User();
	 * if(user.getUserName() == userNm && user.getDateOfBirth() == dob) { int
	 * getlogid=user.getUserId(); User users=
	 * userRepository.findById(getlogid).orElseThrow(()-> new
	 * ResourceNotFoundException("Rsource not found for this id: "+userId));
	 * user.setUserName(userDetails.getUserName());
	 * 
	 * return ResponseEntity.ok(this.userRepository.save(users));
	 * 
	 * 
	 * } return this.userRepository.findAll(); }
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Rsource not found for this id: " + userId));
		return ResponseEntity.ok().body(user);
	}

	// user by id and name
	@RequestMapping(value = "/users/nameanddob/{userName}/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByIdNm(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "id") int userId) throws ResourceNotFoundException {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Rsource not found for this id: " + userId));
		return ResponseEntity.ok().body(user);
	}

	// create user
	@PostMapping("/save")
	public User createUsers(@RequestBody User user) {
		User user1 = userRepository.save(user);
		return user1;
	}

	// create admin
	@PostMapping("/saveAdmin")
	public Admin createAdmin(@RequestBody Admin admin) throws Exception {
		String adminName = admin.getUserName();
		Admin adminObj = adminRepository.findByUserName(adminName);
		if (adminObj != null) {

			throw new Exception("User Exist");
		}
		Admin admin1 = adminRepository.save(admin);
		return admin1;
	}

	// login admin new
	@GetMapping("/loginAdmin/{userName}&{userPassword}")
	public Admin loginAdmin(@PathVariable(value = "userName") String userName,
			@PathVariable(value = "userPassword") String userPassword) throws Exception {
		String adminName = userName;
		String adminPass = userPassword;
		Admin adminObj = null;
		if (adminName != null && adminPass != null) {

			adminObj = adminRepository.findByUserNameAndUserPassword(adminName, adminPass);
		}
		if (adminObj == null) {
			throw new Exception("bad credential");
		}
		return adminObj;
	}

	/*
	 * //login admin
	 * 
	 * @PostMapping("/loginAdmin") public Admin loginAdmin(@RequestBody Admin admin)
	 * throws Exception { String adminName = admin.getUserName(); String adminPass =
	 * admin.getUserPassword(); Admin adminObj = null; if(adminName != null &&
	 * adminPass != null) {
	 * 
	 * adminObj =
	 * adminRepository.findByUserNameAndUserPassword(adminName,adminPass); }
	 * if(adminObj == null) { throw new Exception("bad credential"); } return admin;
	 * }
	 */

	/*
	 * //fileUpload
	 * 
	 * @PostMapping("/uploadFile") public ResponseEntity<String>
	 * uploadFile(@RequestParam("file")MultipartFile multipartFile ,SignUp signUp) {
	 * try { if(multipartFile.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Request must contain a file!"); }
	 * if(!multipartFile.getContentType().equals("image/jpeg")) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Only Jpeg Content type are supported"); } //uploading file in directory
	 * boolean uploaded = fileUploadHelper.uploadFile(multipartFile); if(uploaded) {
	 * signUpService.signUpUser(signUp);
	 * //signUp.setPhotoPath(fileUploadHelper.UPLOAD_DIR+";"+multipartFile.
	 * getOriginalFilename()); //userRepository.save(user); return
	 * ResponseEntity.ok("Uploaded succesfully"); //userRepository.save(user); } }
	 * catch(Exception e) { e.printStackTrace(); }
	 * 
	 * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Something went wrong!!"); //User user1 = userRepository.save(user);
	 * //return user1; }
	 */

	/*
	 * @PutMapping("/users/{id}") public ResponseEntity<User>
	 * updateUser(@PathVariable(value="id") int userId, @Validated @RequestBody User
	 * userDetails) throws ResourceNotFoundException{ User user =
	 * userRepository.findById(userId).orElseThrow(()-> new
	 * ResourceNotFoundException("Rsource not found for this id: "+userId));
	 * user.setUserName(userDetails.getUserName());
	 * user.setDateOfBirth(userDetails.getDateOfBirth()); return
	 * ResponseEntity.ok(this.userRepository.save(user));
	 * 
	 * }
	 */

	/*
	 * @PutMapping("/users/{id}") public ResponseEntity<User>
	 * updateUserWithPhoto(@PathVariable(value="id") int
	 * userId, @Validated @RequestBody User userDetails, @RequestParam("file")
	 * MultipartFile file) throws ResourceNotFoundException{ try { User user =
	 * userRepository.findById(userId).orElseThrow(()-> new
	 * ResourceNotFoundException("Rsource not found for this id: "+userId));
	 * user.setUserName(userDetails.getUserName());
	 * user.setDateOfBirth(userDetails.getDateOfBirth());
	 * user.setProfilePic(file.getOriginalFilename()); //file uploading
	 * 
	 * fileUploadHelper.uploadFile(file); return
	 * ResponseEntity.ok(this.userRepository.save(user)); }catch (Exception e) {
	 * e.printStackTrace(); } return null;
	 * 
	 * }
	 */

	// user detail update
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable(value = "id") int userId,
			@Validated @RequestBody User userDetails) throws ResourceNotFoundException {
		try {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("Rsource not found for this id: " + userId));

			// user.setProfilePic(file.getOriginalFilename());
			// file uploading
				user.setUserName(userDetails.getUserName());
				user.setDateOfBirth(userDetails.getDateOfBirth());
			 user.setCarrierObjective(userDetails.getCarrierObjective());
			 user.setTechnicalSkill(userDetails.getTechnicalSkill());
			 user.setEducationDetails(userDetails.getEducationDetails());
			 user.setPersonalDetails(userDetails.getPersonalDetails());
			 
			 user.setExperiencedDetails(userDetails.getExperiencedDetails());
			 user.setProjectDetails(userDetails.getProjectDetails());
			
			 
			// fileUploadHelper.uploadFile(file);
			return ResponseEntity.ok(this.userRepository.save(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	// user profile pic update
	/*
	 * @PutMapping("/profilePic/{id}") public ResponseEntity<User>
	 * updateUserWithPhoto(@PathVariable(value="id") int
	 * userId, @RequestParam("profilePic") MultipartFile file) throws
	 * ResourceNotFoundException{ try { User user =
	 * userRepository.findById(userId).orElseThrow(()-> new
	 * ResourceNotFoundException("Rsource not found for this id: "+userId));
	 * 
	 * user.setProfilePic(file.getOriginalFilename()); //file uploading
	 * 
	 * user.setUserName(userDetails.getUserName());
	 * user.setDateOfBirth(userDetails.getDateOfBirth());
	 * 
	 * 
	 * fileUploadHelper.uploadFile(file); return
	 * ResponseEntity.ok(this.userRepository.save(user)); }catch (Exception e) {
	 * e.printStackTrace(); } return null;
	 * 
	 * }
	 */

	// new image upload
	// user profile pic update
	@PutMapping("/profilePic/{id}")
	public ResponseEntity<String> updateUserWithPhotoNew(@PathVariable(value = "id") int userId,
			@RequestParam("profilePic") MultipartFile file) throws ResourceNotFoundException {
		try {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("Resource not found for this id: " + userId));

			user.setProfilePic(file.getOriginalFilename());
			// file uploading
			/*
			 * user.setUserName(userDetails.getUserName());
			 * user.setDateOfBirth(userDetails.getDateOfBirth());
			 */

			fileUploadHelper.uploadFile(file);
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * @RequestMapping(value="/loginq", method = RequestMethod.POST) public String
	 * showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam Date
	 * dob){
	 * 
	 * boolean isValidUser = service.validateUser(name, dob);
	 * 
	 * if (!isValidUser) { model.put("errorMessage", "Invalid Credentials"); return
	 * "login"; }
	 * 
	 * model.put("name", name); //model.put("password", dob);
	 * 
	 * return "welcome"; }
	 */
}
