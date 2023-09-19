package com.cms.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cms.model.User;
import java.lang.String;

@Repository
public interface UserDao extends JpaRepository<User, Long>, CrudRepository<User, Long> {
	
	List<User> findByPhoneAndPassword(String phone,String password);
    Optional<User> findByEmailOrPhone(String email,String phone);
    User findByPhone(String phone);
    User findByPhoneAndPhoneverifyAndRolesIn(String phone, int phoneVerify, Collection<String> roles);
	List<User> findByUseridNotIn(final long uid);
	User findByUserid(final long userid);	
	List<User> findByUseridNotIn(List<User> uid);
	@SuppressWarnings("rawtypes")
	List<User> findByRoles(List roles);
	
	 List<User> findByStateContainsAndRolesInAndStatus(String state, Collection<String> roles, int status);
	 List<User> findByCompanyContainsAndStateContainsAndRolesInAndStatus(String company, String state, Collection<String> roles, int status);
		
	User findByPhoneOrEmail(String phone,String email);
	User findOneByToken(String token);
	
	@Query("SELECT DISTINCT u.company FROM User u")
	List<String> findTotalCompany();
	
	@Query("SELECT DISTINCT u.source FROM User u")
	List<String> findsource();
	
	 @Query("SELECT DISTINCT u.country FROM User u where u.country is not Null")
	 List<String> findcountry();
	
	 @Query("SELECT DISTINCT u.state FROM User u where u.country=?1 and u.state is not Null")
	 List<String> findstate(String country);
	
	 @Query("SELECT DISTINCT u.city FROM User u where u.country=?1 and u.state=?2 and u.city is not Null")
	 List<String> findcity(String country, String state);
	
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.state=?2 and u.city=?3 and u.source=?4 and u.salesmanid is Null")
	 int getcountbycityandsource(String country, String state, String city, String source);
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.state=?2 and u.source=?3 and u.city is Not Null and u.salesmanid is Null")
	 int getcountbystateandsource(String country, String state, String source);
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.source=?2 and u.state is Not Null and u.city is Not Null and u.salesmanid is Null")
	 int getcountbycountryandsource(String country, String source);	
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.state=?2 and u.city=?3 and u.salesmanid is Null")
	 int getcountbycity(String country, String state, String city);
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.state=?2 and u.city is Not Null and u.salesmanid is Null")
	 int getcountbystate(String country, String state);
	 @Query("SELECT count(*) FROM User u where u.country=?1 and u.state is Not Null and u.city is Not Null and u.salesmanid is Null")
	 int getcountbycountry(String country);
	 @Query("SELECT count(*) FROM User u where u.country is Not Null and u.state is Not Null and u.city is Not Null and u.salesmanid is Null")
	 int getcount();
	
	 List<User> findByCountryAndStateAndCityAndSourceAndSalesmanidIsNull(String country, String state, String city, String source, Pageable pageable);
	 List<User> findByCountryAndStateAndCityAndSalesmanidIsNull(String country, String state, String city, Pageable pageable);
		
	User findByEmail(String email);
	
	List<User> findByEmailAndPassword(String email,String password);
	
	List<User> findByRolesInOrderByCreateddatetimeDesc(Collection<String> roles);	
	List<User> findByEmailStartsWithAndRolesInOrderByCreateddatetimeDesc(String email, Collection<String> roles);
	List<User> findByPhoneStartsWithAndRolesInOrderByCreateddatetimeDesc(String phone, Collection<String> roles);
	List<User> findByCompanyStartsWithAndRolesInOrderByCreateddatetimeDesc(String username, Collection<String> roles);
	 List<User> findByAddressContainsAndRolesInOrderByCreateddatetimeDesc(String address, Collection<String> roles);
	 List<User> findByCityContainsAndRolesInOrderByCreateddatetimeDesc(String city, Collection<String> roles);
	List<User> findByStateContainsAndRolesInOrderByCreateddatetimeDesc(String state, Collection<String> roles);
	 List<User> findByCountryContainsAndRolesInOrderByCreateddatetimeDesc(String country, Collection<String> roles);
	List<User> findBySourceContainsAndRolesInOrderByCreateddatetimeDesc(String source, Collection<String> roles);
	
	List<User> findByRolesInOrderByCreateddatetimeDesc(Collection<String> roles, Pageable pageable);	
	List<User> findByEmailStartsWithAndRolesInOrderByCreateddatetimeDesc(String email, Collection<String> roles, Pageable pageable);
	List<User> findByPhoneStartsWithAndRolesInOrderByCreateddatetimeDesc(String phone, Collection<String> roles, Pageable pageable);
	List<User> findByCompanyStartsWithAndRolesInOrderByCreateddatetimeDesc(String username, Collection<String> roles, Pageable pageable);
	List<User> findByAddressContainsAndRolesInOrderByCreateddatetimeDesc(String address, Collection<String> roles, Pageable pageable);
	 List<User> findByCityContainsAndRolesInOrderByCreateddatetimeDesc(String city, Collection<String> roles, Pageable pageable);
	List<User> findByStateContainsAndRolesInOrderByCreateddatetimeDesc(String state, Collection<String> roles, Pageable pageable);
	 List<User> findByCountryContainsAndRolesInOrderByCreateddatetimeDesc(String country, Collection<String> roles, Pageable pageable);
	List<User> findBySourceContainsAndRolesInOrderByCreateddatetimeDesc(String source, Collection<String> roles, Pageable pageable);
	
	List<User> findByCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String customerstatus, Collection<String> roles);
	List<User> findByEmailContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String email, String customerstatus, Collection<String> roles);
	List<User> findByPhoneContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String phone, String customerstatus, Collection<String> roles);
	List<User> findByUsernameContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String username, String customerstatus, Collection<String> roles);
	List<User> findByAddressContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String address, String customerstatus, Collection<String> roles);
	 List<User> findByCityContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String city, String customerstatus, Collection<String> roles);
	List<User> findByStateContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String state, String customerstatus, Collection<String> roles);
	 List<User> findByCountryContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String country, String customerstatus, Collection<String> roles);
	List<User> findBySourceContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String source, String customerstatus, Collection<String> roles);
	
	List<User> findByCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String customerstatus, Collection<String> roles, Pageable pageable);
	List<User> findByEmailContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String email, String customerstatus, Collection<String> roles, Pageable pageable);
	List<User> findByPhoneContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String phone, String customerstatus, Collection<String> roles, Pageable pageable);
	List<User> findByUsernameContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String username, String customerstatus, Collection<String> roles, Pageable pageable);
	 List<User> findByAddressContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String address, String customerstatus, Collection<String> roles, Pageable pageable);
	 List<User> findByCityContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String city, String customerstatus, Collection<String> roles, Pageable pageable);
	 List<User> findByStateContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String state, String customerstatus, Collection<String> roles, Pageable pageable);
	 List<User> findByCountryContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String country, String customerstatus, Collection<String> roles, Pageable pageable);
	List<User> findBySourceContainsAndCustomerstatusAndRolesInOrderByCreateddatetimeDesc(String source, String customerstatus, Collection<String> roles, Pageable pageable);

}
