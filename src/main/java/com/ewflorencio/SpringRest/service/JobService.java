package com.ewflorencio.SpringRest.service;

import com.ewflorencio.SpringRest.model.JobPost;
import com.ewflorencio.SpringRest.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository repository;


    //method to return all JobPosts
    public List<JobPost> getAllJobs() {
        return repository.findAll();
    }

    public void addJobPost(JobPost jobPost) {
        repository.save(jobPost);

    }

    public JobPost getJob(int id) {
        return repository.findById(id).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repository.save(jobPost);
    }

    public void deleteJob(int postId) {
        repository.deleteById(postId);
    }

    public List<JobPost> search(String keyword){
        return repository.findByPostProfileContainingOrPostDescContaining(keyword, keyword);
    }

}
