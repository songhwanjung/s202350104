package com.oracle.s202350104.model;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int id;
	private int content_id;
	private int user_id;
	private int big_code;
	private int small_code;
	private String title;
	private String contnet;
	private String status;
	private int read_count;
	private int score;
	private String file_name;
	private String file_size;
	private String file_path;
	private int comment_group_id;
	private int comment_step;
	private int comment_indent;
	private Date created_at;
	private Date updated_at;
	private String is_deleted;
	
}
