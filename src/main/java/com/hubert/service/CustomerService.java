package com.hubert.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hubert.model.Customer;
import com.hubert.repository.CustomerRepository;

@Service
public class CustomerService implements UserDetailsService {

	private CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Customer> customersList = customerRepository.findByUsername(username);

		if (customersList.size() == 0) {
			throw new UsernameNotFoundException("Username not found in the database!!");
		}

		return new CustomerDetails(customersList.get(0));
	}

}
