package com.scaler.blogger.articles;

import com.scaler.blogger.common.BaseEntity;
import com.scaler.blogger.users.UserEntity;
import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "articles")
public class ArticleEntity extends BaseEntity {

	@Column(nullable = false)
	@NonNull
	private String heading;

	@Column(nullable = false)
	@NonNull
	private String subheading;

	@Column(nullable = false)
	@NonNull
	private String slug;

	@Column(nullable = false)
	@NonNull
	private String content;

	@ManyToOne
	@JoinColumn(name = "author_id")
	private UserEntity author;

//	private List<String> tags;
}