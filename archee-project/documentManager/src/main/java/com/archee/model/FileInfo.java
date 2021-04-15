package com.archee.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "file_info")
public class FileInfo implements Serializable {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1897880870174993120L;
	@Id
	  @GeneratedValue(generator = "uuid")
	  @GenericGenerator(name = "uuid", strategy = "uuid2")
	  private String id;
	  private String name;
	  private String url;
	  private String type;
	  private long profil_id;
	  private Date date;
  


  public FileInfo() {
		super();
	}


	public FileInfo(String name, String url) {
	    this.name = name;
	    this.url = url;
	  }
  

  public String getId() {
	return id;
}


public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public void setId(String id) {
	this.id = id;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public long getProfil_id() {
	return profil_id;
}


public void setProfil_id(long profil_id) {
	this.profil_id = profil_id;
}


public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


@Override
public String toString() {
	return "FileInfo [id=" + id + ", name=" + name + ", url=" + url + ", type=" + type + ", profil_id=" + profil_id
			+ ", date=" + date + "]";
}
  
}