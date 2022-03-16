package com.dls.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dls.accounts.config.AccountsServiceConfig;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountsController {
	
	@Autowired
	AccountsServiceConfig accountConfig;
	
	@Value("${accounts.pw}")
	private String pw;
	
	@GetMapping("/users")
	public ResponseEntity<String> getUserAccounts(){
		
		String version = accountConfig.getUsers();
		return ResponseEntity.ok(version);
	}
	
	@GetMapping("/version")
	public ResponseEntity<String> getVersion(){
		
		return ResponseEntity.ok(accountConfig.getBuildVersion());
	}
	
	@GetMapping("/metainfo")
	public ResponseEntity<?> getMetaData(){
		
		return ResponseEntity.ok(pw);
	}

}
