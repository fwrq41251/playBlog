package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Base {
	
	@Column(name="CREATE_OPID", insertable = true, updatable = false)
    private String creatorOpId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TS", insertable = true, updatable = false)
    private Date createTs;
    
    @Column(name="CREATE_OPID", insertable = true, updatable = false)
    private String modifyedOpId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TS", insertable = true, updatable = false)
    private Date modifyedTs;

	public String getCreatorOpId() {
		return creatorOpId;
	}

	public void setCreatorOpId(String creatorOpId) {
		this.creatorOpId = creatorOpId;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	public String getModifyedOpId() {
		return modifyedOpId;
	}

	public void setModifyedOpId(String modifyedOpId) {
		this.modifyedOpId = modifyedOpId;
	}

	public Date getModifyedTs() {
		return modifyedTs;
	}

	public void setModifyedTs(Date modifyedTs) {
		this.modifyedTs = modifyedTs;
	}
    
}
