package com.std.springbootmvc.payload;

//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter

public class TaskDto {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	
	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", taskname=" + taskname + "]";
	}

	private Long id;
	private String taskname; 
}
