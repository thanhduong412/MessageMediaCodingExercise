package com.messagemedia.messagesenderapp.model;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String destinationNumber;
	@Column
	private String content;
	@Column
	private String timestamp;
	@Column
	private String status;

	protected Message() {
	}

	public Message(Long id, String destinationNumber, String content, String timestamp, String status) {
		super();
		this.id = id;
		this.destinationNumber = destinationNumber;
		this.content = content;
		this.timestamp = timestamp;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(String destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, destinationNumber, id, status, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(content, other.content) && Objects.equals(destinationNumber, other.destinationNumber)
				&& Objects.equals(id, other.id) && Objects.equals(status, other.status)
				&& Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", destinationNumber=" + destinationNumber + ", content=" + content
				+ ", timestamp=" + timestamp + ", status=" + status + "]";
	}
}
