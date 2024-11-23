package com.ewflorencio.SpringRest.controler;

import com.ewflorencio.SpringRest.model.JobPost;
import com.ewflorencio.SpringRest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/jobPosts")
@RestController
public class JobControler {

    @Autowired
    private JobService service;

    @GetMapping
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/{postId}")
    public JobPost getJob(@PathVariable int postId){
        return service.getJob(postId);
    }

    @GetMapping("/keyword/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @PostMapping
    public JobPost addPost(@RequestBody JobPost jobPost){
       service.addJobPost(jobPost);
       return service.getJob(jobPost.getPostId());
    }

    @PutMapping
    public JobPost updateJob(@RequestBody JobPost jobPost){
        service.updateJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @DeleteMapping("/{postId}")
    public void deleteJob(@PathVariable int postId){
        service.deleteJob(postId);
    }

}
