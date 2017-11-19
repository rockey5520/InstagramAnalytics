package com.rockey.instagram;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rockey.instagram.model.Datum;
import com.rockey.instagram.model.Example;

@RestController
public class TagsController {

	@RequestMapping("/tags")
	public Posts getTags(@RequestParam(value = "accesskey", defaultValue = "World") String accesskey) {
		RestTemplate restTemplate = new RestTemplate();
		Example posts = (Example) restTemplate.getForObject(
				"https://api.instagram.com/v1/users/self/media/recent?access_token="+accesskey,
				Example.class);

		Posts mining =  mining(posts);
	
		return mining;

	}
	
	public Posts mining(Example posts){
		List<Post> mining = new ArrayList<>();
		Posts output = new Posts();
		int totalnumberoflikes = 0;
		
		List<String> tagscollections = new ArrayList<>();
		for (Datum data : posts.getData()) {
			Post post = new Post();
			post.setNumberoftags(data.getTags().size());
			List<String> tagslist = data.getTags();
			likes likes = new likes();
			likes.setNumberoflikes(data.getLikes().getCount());
			totalnumberoflikes=totalnumberoflikes+data.getLikes().getCount();
			
			for(String tag: tagslist) {
				tagscollections.add(tag);
			}
			
			post.setTagslist(tagslist);
			post.setLikes(likes);
			mining.add(post);
		}
		
		output.setPost(mining);
		output.setTotalnumberoflikes(totalnumberoflikes);
		output.setTotaltagsused(tagscollections);
		
		return output;
		
	}


}
