package iit.me.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long requestId;
	private String name;
	private String comment;
	private Boolean isForwarded;
	private Boolean isAccepted;
	private long ownerId;

	
	public long getRequestId() {
		return requestId;
	}
	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getIsForwarded() {
		return isForwarded;
	}
	public void setIsForwarded(Boolean isForwarded) {
		this.isForwarded = isForwarded;
	}
	public Boolean getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

}
