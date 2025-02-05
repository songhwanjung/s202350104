package com.oracle.s202350104.model;

import lombok.Data;

@Data
public class Course {
	
	private int		id;
	private int		big_code;
	private int		small_code;
	private String  distance;
	private String  course_info;
	private String  time;
	private String  schedule;
	private String  course_title;
	
	// CourseContent
	private int 	content_id;
	private int 	course_id;
	private int 	order_num;
}
