package com.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cms.model.Blog;
import java.lang.String;

@Repository
public interface BlogDao extends JpaRepository<Blog, Long> {
	public final datasource datasource;

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BlogDao(DataSource datasource){
		this.jdbcTemplate = new JdbcTemplate(datasource)
	}
	
	Blog findByid(Long id);
	List<Blog> findByTitle(String title);

	@Query("SELECT b FROM Blog b where b.status!=2")
	 List<Blog> findAllNotDeleted();

	 public List<Map<String, Object>> getAllDAta(){
		return jdbcTemplate.qureyForList('select * from tb');
	 }
}



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory1",
        basePackages = "com.example.package1"
)
public interface BlogDao extends JpaRepository<Blog, Long> {
    // ...
}
