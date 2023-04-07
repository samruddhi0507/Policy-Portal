package com.policy.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.policy.bean.Admin;
import com.policy.bean.Approvals;
import com.policy.bean.Approved;
import com.policy.bean.AuthenticationStatus;
import com.policy.bean.Category;
import com.policy.bean.Disapproved;
import com.policy.bean.Login;
import com.policy.bean.Policies;
import com.policy.bean.Queries;
import com.policy.bean.User;
import com.policy.services.AdminService;
import com.policy.services.ApprovalsService;
import com.policy.services.ApprovedService;
import com.policy.services.CategoryService;
import com.policy.services.DisapprovedService;
import com.policy.services.LoginService;
import com.policy.services.PoliciesService;
import com.policy.services.QueriesService;
import com.policy.services.UserService;



@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
@RestController
public class PolicyController {
	@Autowired
	AdminService adminService;
	@Autowired
	private ApprovalsService approvalsService;
	@Autowired
	private ApprovedService approvedService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	private DisapprovedService disapprovedService;
	@Autowired
	PoliciesService policiesService;
	@Autowired
	QueriesService queriesService;
	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;

	@PostMapping("/adminlogin")
	public ResponseEntity<AuthenticationStatus> validateAdminLogin(@RequestBody Admin adminlogin) {
		System.out.println(adminlogin.getUsername() + " " + adminlogin.getPassword());
		AuthenticationStatus status = adminService.validateAdminLogin(adminlogin.getUsername(),
				adminlogin.getPassword());
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);

	}

	@GetMapping("/approvals")
	public List<Approvals> getAllApprovals() {
		return approvalsService.getAllApprovals();
	}

	@GetMapping("/approvals/{userName}")
	public Optional<Approvals> getApproval(@PathVariable("userName") String userName) {
		return approvalsService.getApprovals(userName);
	}

	@PostMapping("/approvals")
	public String addApprovals(@RequestBody Approvals approvals) {
		approvalsService.addApproval(approvals);
		return "added";
	}

	@GetMapping("/approved")
	public List<Approved> getAllApproved() {
		return approvedService.getAllApproved();
	}

	@GetMapping("/approved/{userName}")
	public Optional<Approved> getApproved(@PathVariable("userName") String userName) {
		return approvedService.getApproved(userName);
	}

	@PostMapping("/approved")
	public String addApproved(@RequestBody Approved approved) {
		approvedService.addApproved(approved);
		return "added";
	}

	@GetMapping("/categories")
	public List<Category> getInsuranceCategory() {
		List<Category> list = categoryService.fetchCategory();
		return list;
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("category") String category) {
		Category iCategory = categoryService.getCategory(category);
		return ResponseEntity.ok().body(iCategory);
	}

	@PostMapping("/category")
	public String addInsuranceCategory(@RequestBody Category category) {
		categoryService.SaveCategory(category);
		return "saved";
	}

	@DeleteMapping(value = "/category/{category}")
	public ResponseEntity<Object> deleteCategory(@PathVariable("category") String category) {

		categoryService.deleteCategory(category);
		return new ResponseEntity<>("Insurance category deleted successsfully", HttpStatus.OK);
	}

	@GetMapping("/disapproved")
	public List<Disapproved> getAllDisapproved() {
		return disapprovedService.getAllDisapproved();
	}

	@GetMapping("/disapproved/{userName}")
	public Optional<Disapproved> getDisapproved(@PathVariable("userName") String userName) {
		return disapprovedService.getDisapproved(userName);
	}

	@PostMapping("/disapproved")
	public String addDisapproved(@RequestBody Disapproved disapproved) {
		disapprovedService.addDisapproved(disapproved);
		return "added";
	}

	@GetMapping("/policies")
	public List<Policies> getPolicies() {
		List<Policies> list = policiesService.fetchPolicies();
		return list;
	}

	@GetMapping("/policy/{PolicyId}")
	public ResponseEntity<Policies> getPolicyById(@PathVariable("policyId") int policyId) {
		Policies policy = policiesService.getPolicy(policyId);
		return ResponseEntity.ok().body(policy);
	}

	@PostMapping("/policy")
	public Policies addpolicy(@RequestBody Policies policies) {
		policiesService.savePolicy(policies);
		return policies;
	}

	@PutMapping("/policy/{id}")
	public ResponseEntity<Policies> updatePolicy(@PathVariable("id") int policyId,
			@RequestBody Policies policydategoryDetails) {
		Policies policy = policiesService.getPolicy(policyId);

		policy.setPolicyName(policydategoryDetails.getPolicyName());
		policy.setCategory(policydategoryDetails.getCategory());
		policy.setAmount(policydategoryDetails.getAmount());
		policy.setTenureInYears(policydategoryDetails.getTenureInYears());

		final Policies updatedPolicy = policiesService.savePolicy(policy);
		return ResponseEntity.ok(updatedPolicy);
	}

	@DeleteMapping(value = "/policy/{policyId}")
	public ResponseEntity<Object> deletePolicy(@PathVariable("policyId") int policyId) {
		policiesService.deletePolicy(policyId);
		return new ResponseEntity<>("policy deleted successsfully", HttpStatus.OK);
	}

	@GetMapping("/query")
	public List<Queries> getQueries() {
		List<Queries> list = queriesService.fetchQueries();

		return list;

	}

	@GetMapping("/query/{userName}")
	public ResponseEntity<Queries> getQueriesById(@PathVariable("userName") String userName) {
		Queries queries = queriesService.getQuery(userName);
		return ResponseEntity.ok().body(queries);
	}

	@PostMapping("/query")
	public Queries addQueries(@RequestBody Queries queries) {
		queries = queriesService.saveQuery(queries);
		return queries;
	}

	@PutMapping("/query/{userName}")
	public ResponseEntity<Queries> updateQueries(@PathVariable("userName") String userName,
			@RequestBody Queries queries) {
		Queries queries1 = queriesService.getQuery(userName);
		queries1.setQuestion(queries.getQuestion());
		queries1.setAnswer(queries.getAnswer());

		final Queries updatedQueries = queriesService.saveQuery(queries1);
		return ResponseEntity.ok(updatedQueries);
	}

	@DeleteMapping(value = "/query/{userName}")
	public ResponseEntity<Object> deleteQueries(@PathVariable("userName") String userName) {
		queriesService.deleteQuery(userName);
		return new ResponseEntity<>("Query deleted successsfully", HttpStatus.OK);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> userList = userService.fetchUser();
		return userList;
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") String userId) {
		User user = userService.getUser(userId);
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user")
	public User addUser(@Validated @RequestBody User user) {
		user = userService.saveUser(user);
		return user;
	}

	@PutMapping("/user/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable("userId") String userId, @RequestBody User userDetails) {
		User user = userService.getUser(userId);
		user.setEmail(userDetails.getEmail());
		user.setMobile(userDetails.getMobile());
		user.setPassword(userDetails.getPassword());
		final User updatedUser = userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<Object> deleteUser(@PathVariable("userId") String userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User deleted successsfully", HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationStatus> validateLogin(@RequestBody Login login, HttpServletRequest request) {

		AuthenticationStatus status = loginService.validateLogin(login.getUserName(), login.getPassword());
		if (status.getUserName() != null && status.getPassword() != null && status.isAuthenticated() == true) {
			request.getSession().setAttribute("userName", status.getUserName());
		}
		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);

	}

	@GetMapping("/logout")
	public void Logout(HttpServletRequest request) {
		System.out.println("logged out");
		request.getSession().invalidate();

	}

	@DeleteMapping("/approvals/{userName}")
	public void deleteApproval(@PathVariable("userName") String userName) {
		approvalsService.deleteApproval(userName);
	}

	@SuppressWarnings({ "unchecked", "null" })
	@GetMapping("/userpolicies")
	public List<Approved> getAllUserpolicies() {

		@SuppressWarnings("rawtypes")
		List list = null;
		list.add(approvedService.getAllApproved());
		list.add(disapprovedService.getAllDisapproved());
		return list;
	}
}

