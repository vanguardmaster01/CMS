package com.cms.model;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name="tbl_user")
@XmlRootElement(name="user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long userid;
	private String company;
	private String username;
	private String stripecustomerid;
	@JsonIgnore
	private String password;
	
	private String email;
	private String phone;
	
	private String phone2;
	private String address;
	private String country;
	private String state;
	private String city;
	private String latitude;
	private String longitude;
	private String zipcode;
	private String website;
	private String mcnumber;
	private String dotnumber;
	@ManyToOne
	@JoinColumn(name="createdby", nullable=true)
	private User createdby;
	@Builder.Default
	@Column(updatable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date createddatetime=new Date();
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date lastlogin;
	@ManyToOne
	@JoinColumn(name="modifiedby", nullable=true)
	private User modifiedby;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date modifieddatetime;
	@Builder.Default
	private String img = "public/img/defaultuser.png" ;
	@Builder.Default
	private int status=1;
	@Builder.Default
	private int availstatus=0;
	@Builder.Default
	private int planid=0;
	@Builder.Default
	private int emailverify=0;
	@Builder.Default
	private int phoneverify=0;
	private String token;
	@Builder.Default
	private String logintype="STANDARD";
	
	@Builder.Default
	private String customerstatus="NA";
	@ManyToOne
	@JoinColumn(name="customerstatusby")
	private User customerstatusby;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date customerstatusdatetime;
	
	@ManyToOne
	@JoinColumn(name="followedby")
	private User followedby;	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date followeddatetime;
	
	@ManyToOne
	@JoinColumn(name="salesmanid")
	private User salesmanid;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd hh:mm:ss")
	private Date notifydatetime;
	@Builder.Default
	private int notifystatus=0;
	@Builder.Default
	private int alertstatus=0;
	@Builder.Default
	private String source="Web-Portal";
	@Builder.Default
	private String customercategory="NA";
	@Builder.Default
	private String usertype="Customer";
	@Builder.Default
	private int verifystatus=0;
	
    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
